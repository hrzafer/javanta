/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrzafer.javanta;

import org.junit.Ignore;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author test
 */
public class IOTest {
    
    private static final String ansi_file = "test/com/hrzafer/javanta/test_ansi.txt";
    private static final String unicode_file = "test/com/hrzafer/javanta/test_utf8.txt";
       
    /**
     * Test of exists method, of class IO.
     */
    @Test
    public void testExists() {
        System.out.println("exists");
        String file = "doesnt_exist.txt";
        boolean expResult = false;
        boolean result = IO.exists(file);
        assertEquals(expResult, result);
        
        file = ansi_file;
        expResult = true;
        result = IO.exists(file);
        assertEquals(expResult, result);
    }

    /**
     * Test of read method, of class IO.
     */
    @Test
    public void testRead_String() {
        
        System.out.println("read unicode file");
        String file = unicode_file;
        String expResult = "Bu bir denemedir\nÇİĞÖŞÜ\nçığöşü";
        String result = IO.read(file);
        assertEquals(expResult, result);
    }

    /**
     * Test of read method, of class IO.
     */
    @Test
    public void testRead_String_String() {
        System.out.println("read ansi file");
        String file = ansi_file;
        String expResult = "Bu bir denemedir\nÇİĞÖŞÜ\nçığöşü";
        String result = IO.read(file,IO.ISO_TR);
        assertEquals(expResult, result);
    }
    
    /**
     * 
     */
    @Test
    public void testReadResource_String(){
        System.out.println("read resource file");
        String resourcePath = "/com/hrzafer/javanta/resources/test_file";
        String expResult = "Bu bir denemedir\r\nÇİĞÖŞÜ\r\nçığöşü";
        String result = IO.readResource(resourcePath);
        assertEquals(expResult, result);
    }

  

    /**
     * Test of readWords method, of class IO.
     */
    @Ignore
    @Test
    public void testReadWords_String() {
        System.out.println("readWords");
        String filePath = "";
        List expResult = new ArrayList();
        List result = IO.readWords(filePath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readWords method, of class IO.
     */
    @Ignore
    @Test
    public void testReadWords_String_String() {
        System.out.println("readWords");
        String filePath = "";
        String encoding = "";
        List expResult = null;
        List result = IO.readWords(filePath, encoding);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readLines method, of class IO.
     */
    @Ignore
    @Test
    public void testReadLines_String() {
        System.out.println("readLines");
        String filePath = "";
        List expResult = null;
        List result = IO.readLines(filePath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readLines method, of class IO.
     */
    @Ignore
    @Test
    public void testReadLines_String_String() {
        System.out.println("readLines");
        String filePath = "";
        String encoding = "";
        List expResult = null;
        List result = IO.readLines(filePath, encoding);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeLines method, of class IO.
     */
    @Ignore
    @Test
    public void testWriteLines() {
        System.out.println("writeLines");
        String filePath = "";
        ArrayList<String> lines = null;
        IO.writeLines(filePath, lines);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toInputStream method, of class IO.
     */
    @Ignore
    @Test
    public void testToInputStream() {
        System.out.println("toInputStream");
        String source = "";
        InputStream expResult = null;
        InputStream result = IO.toInputStream(source);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

 

    /**
     * Test of readProperties method, of class IO.
     */
    @Test
    public void testReadProperties() {
        System.out.println("readProperties");
        String filepath = "/com/hrzafer/javanta/resources/test.properties";
        Properties expResult = new Properties();
        expResult.setProperty("this", "is a test");
        expResult.setProperty("bu", "çığöşü ve ÇİĞÖŞÜ");
        Properties result = IO.readProperties(filepath);
        assertEquals(result.getProperty("this"), expResult.getProperty("this"));
        assertEquals(result.getProperty("bu"), expResult.getProperty("bu"));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
