/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrzafer.javanta;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hrzafer
 */
public class STRTest {

    /**
     * Test of toNonTurkish method, of class STR.
     */
    @Test
    public void testToNonTurkish() {
        System.out.println("toNonTurkish");
        String str = "çığöşüÇİĞÖŞÜ";
        String expResult = "cigosuCIGOSU";
        String result = STR.toNonTurkish(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeVowels method, of class STR.
     */
    @Test
    public void testRemoveVowels() {
        System.out.println("removeVowels");
        String str = "aeıiöouüxxx";
        String expResult = "xxx";
        String result = STR.removeVowels(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeDuplicateSpaces method, of class STR.
     */
    @Test
    public void testRemoveDuplicateSpaces() {
        System.out.println("removeDuplicateSpaces");
        String str = "Bu  bir    denemedir  ";
        String expResult = "Bu bir denemedir ";
        String result = STR.removeDuplicateSpaces(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeParantheses method, of class STR.
     */
    @Test
    public void testRemoveParantheses() {
        System.out.println("removeParantheses");
        String str = "bu (bir) denemedir";
        String expResult = "bu bir denemedir";
        String result = STR.removeParantheses(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeAllSpaces method, of class STR.
     */
    @Test
    public void testRemoveAllSpaces() {
        System.out.println("removeAllSpaces");
        String str = "    Bu     Bir Denemedir ";
        String expResult = "BuBirDenemedir";
        String result = STR.removeAllSpaces(str);
        assertEquals(expResult, result);
    }
}