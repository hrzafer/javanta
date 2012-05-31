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
        String str = "türkçe";
        String expResult = "turkce";
        String result = STR.toNonTurkish(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeVowels method, of class STR.
     */
    @Test
    public void testRemoveVowels() {
        System.out.println("removeVowels");
        String str = "deneme";
        String expResult = "dnm";
        String result = STR.removeVowels(str);
        assertEquals(expResult, result);       
    }

    /**
     * Test of removeDuplicateSpaces method, of class STR.
     */
    @Test
    public void testRemoveDuplicateSpaces() {
        System.out.println("removeDuplicateSpaces");
        String str = "bu    bir      denemedir";
        String expResult = "bu bir denemedir";
        String result = STR.removeDuplicateSpaces(str);
        assertEquals(expResult, result);        
    }

    /**
     * Test of removeParantheses method, of class STR.
     */
    @Test
    public void testRemoveParantheses() {
        System.out.println("removeParantheses");
        String str = "(a)*(b+c)";
        String expResult = "a*b+c";
        String result = STR.removeParantheses(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeAllSpaces method, of class STR.
     */
    @Test
    public void testRemoveAllSpaces() {
        System.out.println("removeAllSpaces");
        String str = "üs   satır\nalt satır";
        String expResult = "üssatıraltsatır";
        String result = STR.removeAllSpaces(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of escapeSquareBrackets method, of class STR.
     */
    @Test
    public void testEscapeSquareBrackets() {
        System.out.println("escapeSquareBrackets");
        String str = "[deneme]";
        String expResult = "\\[deneme\\]";
        String result = STR.escapeSquareBrackets(str);
        assertEquals(expResult, result);
        
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

    /**
     * Test of escapeHtml method, of class STR.
     */
    @Test
    public void testEscapeHtml() {
        System.out.println("escapeHtml");
        String str = "Türkçe";
        String expResult = "T&#252;rk&#231;e";
        String result = STR.escapeHtml(str);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addDoubleQuote method, of class STR.
     */
    @Test
    public void testAddDoubleQuote() {
        System.out.println("addDoubleQuote");
        String str = "deneme";
        String expResult = "\"deneme\"";
        String result = STR.addDoubleQuote(str);
        assertEquals(expResult, result);
    }

}

