package com.hrzafer.javanta;

import java.sql.*;

/**
 * Bu sınıf temel veritabanı işlemleri için tasarlanmıştır.
 * @author hrzafer
 */
public class DB {

    private static Connection conn = null;
    private static Statement statement = null;
    private static String url;
    private static String username;
    private static String password;

    public static void setUrl(String DBurl) {
        DB.url = DBurl;
    }

    public static void setUsername(String DBusername) {
        DB.username = DBusername;
    }

    public static void setPassword(String DBpassword) {
        DB.password = DBpassword;
    }
    
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
            return DriverManager.getConnection(url, username, password);
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
