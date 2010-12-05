/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hrzafer.javanta;

import java.util.Locale;

/**
 *
 * @author Administrator
 */
public class STR {

    public static String toNonTurkish(String str){
        str = str.replace("ç", "c");
        str = str.replace("ö", "o");
        str = str.replace("ş", "s");
        str = str.replace("ğ", "g");
        str = str.replace("ü", "u");
        str = str.replace("ı","i");
        str = str.replace("Ç", "C");
        str = str.replace("Ö", "O");
        str = str.replace("Ş", "S");
        str = str.replace("Ğ", "G");
        str = str.replace("Ü", "U");
        str = str.replace("İ","ı");
        return str;
    }
    
    public static String toNonTurkishLowerCase(String str){        
        str = str.toLowerCase();
        str = toNonTurkish(str);        
        return str;
    }





}
