package com.hrzafer.javanta;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Bu sınıf temel veritabanı işlemleri için tasarlanmıştır.
 * @author hrzafer
 */
public class DB {

    private static Connection conn = null;
    private static Statement statement = null;
    private static Properties dbConfig = loadConfig("src/javanta.properties");;
    private static String DBurl = dbConfig.getProperty("DB.url");
    private static String DBusername = dbConfig.getProperty("DB.username");
    private static String DBpassword = dbConfig.getProperty("DB.password");

    private static Connection getConnection() {

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
            Class.forName("com.mysql.jdbc.Driver").newInstance();            
            return DriverManager.getConnection(DBurl, DBusername, DBpassword);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static Properties loadConfig(String propsFile) {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(propsFile);
            properties.load(fis);
            fis.close();
            return properties;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * SQL sorgularını çalıştırabilmek için yeni bir Statement nesnesi döndürür.
     * @return
     */
    private static Statement getNewStatement() {
        try {
            return getConnection().createStatement();
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
        if (getConnection().getAutoCommit() == true) {
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
                getConnection().setAutoCommit(false);
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
                getConnection().commit();
            } else {
                throw new SQLException("Method is not allowed");
            }
            getConnection().setAutoCommit(true);
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
                getConnection().rollback();
            } else {
                throw new SQLException("Transaction rollback failed");
            }
            getConnection().setAutoCommit(true);
            //Logger.Instance().LogItem("Rolling Back Completed");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}