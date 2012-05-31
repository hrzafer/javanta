/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrzafer.javanta;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author hrzafer
 */
public class DBTest {
    
    /**
     * Kitap tablosu kullanılarak bağlantı ve verilerin doğru alınıp alınmadığı test ediliyor.
     * Bu test fonksiyon üzerine sağ tıklayıp -> Run Focused Test seçilerek çalıştırılabilir.
     */
    @Test
    public void testExecuteQuery() throws SQLException {
        System.out.println("executeQuery");
        String sqlQuery = "SELECT * FROM  kitap";
        DB db = new DB("db.properties");
        ResultSet result = db.executeQuery(sqlQuery);
        assertNotNull(result);
        assertTrue(result.next());
        assertEquals(result.getString(2), "Bir Diğer Veritabanı Kitabı");       
        
        
    }
   
}
