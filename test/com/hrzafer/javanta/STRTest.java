/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrzafer.javanta;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author test
 */
public class STRTest {
    
    /**
     * Test of toNonTurkish method, of class STR.
     */
    @Test
    public void testToNonTurkish() {
        System.out.println("toNonTurkish");
        String str = "";
        String expResult = "";
        String result = STR.toNonTurkish(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeVowels method, of class STR.
     */
    @Test
    public void testRemoveVowels() {
        System.out.println("removeVowels");
        String str = "";
        String expResult = "";
        String result = STR.removeVowels(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeDuplicateSpaces method, of class STR.
     */
    @Test
    public void testRemoveDuplicateSpaces() {
        System.out.println("removeDuplicateSpaces");
        String str = "";
        String expResult = "";
        String result = STR.removeDuplicateSpaces(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeParantheses method, of class STR.
     */
    @Test
    public void testRemoveParantheses() {
        System.out.println("removeParantheses");
        String str = "";
        String expResult = "";
        String result = STR.removeParantheses(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAllSpaces method, of class STR.
     */
    @Test
    public void testRemoveAllSpaces() {
        System.out.println("removeAllSpaces");
        String str = "";
        String expResult = "";
        String result = STR.removeAllSpaces(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of escapeSquareBrackets method, of class STR.
     */
    @Test
    public void testEscapeSquareBrackets() {
        System.out.println("escapeSquareBrackets");
        String str = "";
        String expResult = "";
        String result = STR.escapeSquareBrackets(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNullOrEmpty method, of class STR.
     */
    @Test
    public void testIsNullOrEmpty() {
        System.out.println("isNullOrEmpty");
        String str = "";
        boolean expResult = true;
        boolean result = STR.isNullOrEmpty(str);
        assertEquals(expResult, result);
        
        str = null;
        expResult = true;
        result = STR.isNullOrEmpty(str);
        assertEquals(expResult, result);
        
        str = "abcdef";
        expResult = false;
        result = STR.isNullOrEmpty(str);
        assertEquals(expResult, result);
        
    }
}

