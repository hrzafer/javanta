package com.hrzafer.javanta;

import java.sql.*;
import java.util.Properties;

/**
 * Bu sınıf temel veritabanı işlemleri için tasarlanmıştır.
 * 
 * Projenize db.properties isimli bir properties dosyası ekleyip
 * bağlantı değerlerinizi bu dosyaya yazmanız gerekir.
 * 
 * @author hrzafer
 */
public class DB {

    private static Connection conn = null;
    private static Statement statement = null;
    private static final Properties properties = IO.readProperties("db.properties");
    private static String url = properties.getProperty("DB.url");
    private static String name = properties.getProperty("DB.name");
    private static String driver = properties.getProperty("DB.driver");
    private static String charset = properties.getProperty("DB.charset");
    private static String username = properties.getProperty("DB.username");
    private static String password = properties.getProperty("DB.password");
    

    private static Connection openConnection() {

        if (conn == null) {
            conn = getNewConnection();
        }
        return conn;
    }

    /**
     * Yeni bir veritabanı bağlantısı açar ve Connection nesnesi olarak döndürür.
     * @return
     */
    private static Connection getNewConnection() {
        try {
            Class.forName(driver).newInstance();            
            System.out.println(url + name + charset);
            return DriverManager.getConnection(url + name + charset, username, password);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * SQL sorgularını çalıştırabilmek için yeni bir Statement nesnesi döndürür.
     * @return
     */
    private static Statement getNewStatement() {
        try {
            return openConnection().createStatement();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static Statement getStatement() {
        if (statement == null) {
            statement = getNewStatement();
        }
        return statement;
    }

    /**
     * String olarak verilen SQL sorgusunu çalıştırır ve sonucu ResultSet nesnesi olarak döndürür.
     */
    public static ResultSet executeQuery(String sqlQuery) {
        ResultSet rs;
        Statement st = getStatement();
        try {
            st.execute(sqlQuery);
            return st.getResultSet();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * insert/update/delete sorgularını çalıştırı ve etkilenen satırların sayısını döndürür.
     */
    public static int executeUpdate(String sqlUpdate) {

        Statement st = getStatement();
        try {
            int affectedRows = st.executeUpdate(sqlUpdate);
            return affectedRows;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Veritabanı bağlantısının bir Transaction'ı olup olmadığını kontrol eder.
     */
    public static Boolean IsTransactionExist() throws SQLException {
        if (openConnection().getAutoCommit() == true) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Veritabanı bağlantısı için bir transaction başlatır
     */
    public static void BeginTransaction() {
        try {
            if (!IsTransactionExist()) {
                openConnection().setAutoCommit(false);
            } else {
                throw new SQLException("Nested Transaction is not allowed");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Commits a transaction
     */
    public static void CommitTransaction() {
        try {
            if (IsTransactionExist()) {
                openConnection().commit();
            } else {
                throw new SQLException("Method is not allowed");
            }
            openConnection().setAutoCommit(true);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Rolls back a transaction if it is failed
     * @throws SQLException
     */
    public static void RollBackTransaction() {
        try {
            if (IsTransactionExist()) {
                openConnection().rollback();
            } else {
                throw new SQLException("Transaction rollback failed");
            }
            openConnection().setAutoCommit(true);
            //Logger.Instance().LogItem("Rolling Back Completed");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
