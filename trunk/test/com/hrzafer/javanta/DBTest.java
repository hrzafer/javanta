/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrzafer.javanta;

import java.sql.ResultSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hrzafer
 */
public class DBTest {
    
    public DBTest() {
    }
  
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of executeQuery method, of class DB.
     */
    @Test
    public void testExecuteQuery() {
        System.out.println("executeQuery");
        String sqlQuery = "SELECT * FROM  kisiler";
        ResultSet result = DB.executeQuery(sqlQuery);
        assertNotNull(result);
        
    }

    /**
     * Test of executeUpdate method, of class DB.
     */
    @Test
    public void testExecuteUpdate() {
        System.out.println("executeUpdate");
        String sqlUpdate = "";
        int expResult = 0;
        int result = DB.executeUpdate(sqlUpdate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of IsTransactionExist method, of class DB.
     */
    @Test
    public void testIsTransactionExist() throws Exception {
        System.out.println("IsTransactionExist");
        Boolean expResult = null;
        Boolean result = DB.IsTransactionExist();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BeginTransaction method, of class DB.
     */
    @Test
    public void testBeginTransaction() {
        System.out.println("BeginTransaction");
        DB.BeginTransaction();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CommitTransaction method, of class DB.
     */
    @Test
    public void testCommitTransaction() {
        System.out.println("CommitTransaction");
        DB.CommitTransaction();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RollBackTransaction method, of class DB.
     */
    @Test
    public void testRollBackTransaction() {
        System.out.println("RollBackTransaction");
        DB.RollBackTransaction();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
