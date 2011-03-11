package com.hrzafer.javanta;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Bu sınıf temel database işlemleri için tasarlanmıştır.
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
     * Opens a new connection and returns it
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
     * Creates a  new Statement object to be able to execute SQL
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
     * Executes the sql query and returns the resultset
     * @param sqlQuery
     * @return
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
     * Executes the insert/update/delete query and returns the number of affected rows.
     * @param sqlUpdate
     * @return
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
     * Checks if a transaction exists
     * @return
     * @throws SQLException
     */
    public static Boolean IsTransactionExist() throws SQLException {
        if (getConnection().getAutoCommit() == true) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Begins a transaction
     * @throws SQLException
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
     * @throws SQLException
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
