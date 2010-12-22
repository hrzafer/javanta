/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrzafer.javanta;

/**
 *
 * @author Administrator
 */
public class STR {

    /**
     * Bir string'deki standart ASCII olmayan karakterleri (ç,ı,ğ,ö,ş,ü,İ, vb.) ASCII eşdeğerleri ile değiştirir.
     * Ör: toNonTurkish("türkçe") metodu "turkce" string'ini döndürecektir.
     */
    public static String toNonTurkish(String str) {
        str = str.replace("ç", "c");
        str = str.replace("ö", "o");
        str = str.replace("ş", "s");
        str = str.replace("ğ", "g");
        str = str.replace("ü", "u");
        str = str.replace("ı", "i");
        str = str.replace("Ç", "C");
        str = str.replace("Ö", "O");
        str = str.replace("Ş", "S");
        str = str.replace("Ğ", "G");
        str = str.replace("Ü", "U");
        str = str.replace("İ", "I");
        return str;
    }

    /**
     * Bir stringdeki sesli harfleri siler.
     * Ör: removeVowels("deneme") ifadesi "dnm" String'ini döndürür.
     */
    public static String removeVowels(String str) {
        return str.replaceAll("[aeıouüiö]", "");
    }

    /**
     * Bir String'de iki ve daha fazla sayıdaki yan yana boşlukları teke indirir.
     * Ör: removeDuplicateSpaces("bu    bir      denemedir") ifadesi "bu bir denemedir" String'ini döndürür.
     */
    public static String removeDuplicateSpaces(String str) {
        return str.replaceAll(" +", " ");
    }

    /**
     * Bir String'deki tüm whitespace (boşluk, tab, newline) karakterleri siler
     * Ör: removeDuplicateSpaces("üs   satır\nalt satır") ifadesi "üssatıraltsatır" String'ini döndürür.
     */
    public static String removeAllSpaces(String str) {
        return str.replaceAll("\\s", "");
    }
}
