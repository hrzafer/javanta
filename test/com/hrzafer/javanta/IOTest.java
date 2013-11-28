/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrzafer.javanta;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author test
 */
public class IOTest {
    
    private static final String ansi_file = "test/com/hrzafer/javanta/test_ansi.txt";
    private static final String unicode_file = "test/com/hrzafer/javanta/test_utf8.txt";
    private static final String test_dir = "test/com/hrzafer/javanta/";
    
       
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
        String expResult = "Bu, bir denemedir.\r\nÇİĞÖŞÜ, çığöşü?";
        String result = IO.readResource(resourcePath);
        assertEquals(expResult, result);
    }

  
    /**
     * Test of readLines method, of class IO.
     */
    
    @Test
    public void testReadLines() {
        System.out.println("readLines");
        String filePath = test_dir + "readLines.txt";
        String[] expResult = {"1st line" , "2nd line" , "3rd line" , "6th line","8th line çığöşü?"};
        //String[] expResult = {"1st line\n" , "2nd line\n" , "3rd line\n" , "\n" , "\n" , "6th line\n" , "\n" ,"8th line çığöşü?\n", "\n"};
        List<String> result = IO.readLines(filePath);
        for (String line : result) {
            System.out.println(line);
        }
        assertEquals(Arrays.asList(expResult), result);
        
    }
    
    /**
     * Test of readLines method, of class IO.
     */
    
    @Test
    public void testReadLinesIncludingEmptyLines() {
        System.out.println("readLines");
        String filePath = test_dir + "readLines.txt";
        
        String[] expResult = {"1st line\r\n" , "2nd line\r\n" , "3rd line\r\n" , "\r\n" , "\r\n" , "6th line\r\n" , "\r\n" ,"8th line çığöşü?\r\n", "\r\n"};
        List<String> result = IO.readLinesIncludingEmptyLines(filePath);
        for (String line : result) {
            System.out.println(line);
        }
        assertEquals(Arrays.asList(expResult), result);        
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
        IO.write(filePath, lines);
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
        String filepath = "resources/test.properties";
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
