package com.hrzafer.javanta;

import java.sql.*;
import java.util.Properties;

/**
 * Bu sınıf temel veritabanı işlemleri için tasarlanmıştır.<br/>
 * Bağlantı parametrelerini içeren aşağıdaki gibi .properties uzantılı<br/>
 * bir dosyayı sınıfa constructor method ile sağlamanız gerekmektedir.<br/><br/>
 * <i>db.properties:</i><br/><br/>
 *  DB.url = jdbc:mysql://localhost:3306/<br/>
 *  DB.name = hrzafer_kitap_01<br/>
 *  DB.driver = com.mysql.jdbc.Driver<br/>
 *  DB.charset = ?characterEncoding=UTF-8<br/>
 *  DB.username = root<br/>
 *  DB.password = gizli<br/>
 * @author hrzafer.com 
 * 
 */
public class DB {

    private Connection conn = null;
    private Statement statement = null;
    private final Properties properties;
    private final String url;
    private final String name;
    private final String driver;
    private final String charset;
    private final String username;
    private final String password;

    /**
     * Yeni bir Mysql veritabanı bağlantısı oluşturur. 
     * @param propertiesFile bağlantı değerlerini içeren dosyanın tam paket konumu.
     * Dosyanın paketler içerisindeki tam konumu verilmelidir. Mesela 
     * db.properties dosyası default pakette ise "/db.properties" şeklinde,
     * com.hrzafer.resources gibi bir konumda ise 
     * "/com/hrzafer/resources/db.properties" şeklinde.
     */
    public DB(String propertiesFile) {
        properties = IO.readProperties(propertiesFile);
        url = properties.getProperty("DB.url");
        name = properties.getProperty("DB.name");
        driver = properties.getProperty("DB.driver");
        charset = properties.getProperty("DB.charset");
        username = properties.getProperty("DB.username");
        password = properties.getProperty("DB.password");
    }

    /**
     * Bağlantı varsa mevcut bağlantıyı döndürür. Yoksa yeni bağlantı açar.
     */
    private Connection getConnection() {

        if (conn == null) {
            conn = getNewConnection();
        }
        return conn;
    }

    /**
     * Yeni bir veritabanı bağlantısı açar ve Connection nesnesi olarak döndürür.
     */
    private Connection getNewConnection() {
        try {
            Class.forName(driver).newInstance();
            System.out.println(url + name + charset);
            return DriverManager.getConnection(url + name + charset, username, password);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Statement varsa döndürür. Yoksa yeni Statement oluşturup onu döndürür.
     */
    private Statement getStatement() {
        if (statement == null) {
            statement = getNewStatement();
        }
        return statement;
    }

    /**
     * SQL sorgularını çalıştırabilmek için yeni bir Statement nesnesi döndürür.
     */
    private Statement getNewStatement() {
        try {
            return getConnection().createStatement();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * String olarak verilen SQL Select sorgusunu çalıştırır ve sonucu ResultSet
     * nesnesi olarak döndürür.
     */
    public ResultSet executeQuery(String sqlQuery) {

        Statement st = getStatement();
        try {
            st.execute(sqlQuery);
            return st.getResultSet();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * insert/update/delete sorgularını çalıştırır ve sorgudan etkilenen
     * satırların sayısını döndürür.
     */
    public int executeUpdate(String sqlUpdate) {

        Statement st = getStatement();
        try {
            int affectedRows = st.executeUpdate(sqlUpdate);
            return affectedRows;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Veritabanı bağlantısının o anda bir Çoklu işlem (Transaction)
     * yürütmekte olup olmadığını döndürür.
     */
    public Boolean IsTransactionExist() throws SQLException {
        if (getConnection().getAutoCommit() == true) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Veritabanı bağlantısı için bir Çoklu işlem ( transaction ) başlatır.
     */
    public void BeginTransaction() {
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
     * Çoklu işlemin (Transaction) başarılı bir şekilde sona erdiğini bildirir.
     */
    public void CommitTransaction() {
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
     * Çoklu işlemin (Transaction) başarısız olması durumunda o ana kadar
     * yapılan işlem adımlarını geri alarak veritabanının bütünlüğünü korur.
     */
    public void RollBackTransaction() {
        try {
            if (IsTransactionExist()) {
                getConnection().rollback();
            } else {
                throw new SQLException("Transaction rollback failed");
            }
            getConnection().setAutoCommit(true);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
