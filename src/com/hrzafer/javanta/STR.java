package com.hrzafer.javanta;

/**
 * Bu sınıf her zaman ihtiyaç duyulabilecek bir takım String işlemlerini 
 * gerçekleştiren metodları içerir. İhtiyaca göre genişletilebilir.
 * @author hrzafer.com
 */
public class STR {

    /**
     * Bir string'deki standart ASCII olmayan karakterleri (ç,ı,ğ,ö,ş,ü,İ, 
     * vb. Türkçe karakterleri) ASCII eşdeğerleri ile değiştirir.<br/>
     * Mesela toNonTurkish("türkçe") metodu "turkce" string'ini döndürecektir.
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
     * Mesela removeVowels("deneme") ifadesi "dnm" String'ini döndürür.
     */
    public static String removeVowels(String str) {
        return str.replaceAll("[aeıouüiö]", "");
    }

    /**
     * Bir String'de iki ve daha fazla sayıdaki yan yana boşlukları teke 
     * indirir.<br/>
     * Mesela removeDuplicateSpaces("bu    bir      denemedir") ifadesi 
     * "bu bir denemedir" String'ini döndürür.
     */
    public static String removeDuplicateSpaces(String str) {
        return str.replaceAll(" +", " ");
    }

    /**
     * Bir String'deki tüm parantezleri yani '(' ve ')' karakterlerini siler.<br/>
     * Mesela "(a)*(b+c)" ifadesi "a*b+c" ifadesine dönüşür.
     */
    public static String removeParantheses(String str) {
        return str.replaceAll("(\\(|\\))", "");
    }

    /**
     * Düzenli ifadelerde (regex) '[' ve ']' karakterlerini '\[' '\]' şekline
     * dönüştürür. 
     */
    public static String escapeSquareBrackets(String str) {
        return str.replaceAll("\\[", "\\\\[").replaceAll("\\]", "\\\\]");
    }

    /**
     * Bir String'deki tüm whitespace (boşluk, tab, newline) karakterleri siler. <br/>
     * Mesela removeAllSpaces("üs   satır\nalt satır") ifadesi "üssatıraltsatır"
     * String'ini döndürür.
     */
    public static String removeAllSpaces(String str) {
        return str.replaceAll("\\s", "");
    }

    /**
     * Bir String'in null veya boş olması halinde true değerini döndürür.
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * String'deki Türkçe karakterleri HTML kodları ile değiştirerek %100 HTML
     * uyumlu hale getirir. Bu sayede karakter kodu ne olursa olsun Türkçe 
     * karakterler doğru görüntülenir. 
     */
    public static String escapeHtml(String str) {
        str = str.replace("ç", "&#231;");
        str = str.replace("Ç", "&#199;");
        str = str.replace("ı", "&#305;");
        str = str.replace("İ", "&#304;");
        str = str.replace("ğ", "&#287;");
        str = str.replace("Ğ", "&#286;");
        str = str.replace("ö", "&#246;");
        str = str.replace("Ö", "&#214;");
        str = str.replace("ş", "&#351;");
        str = str.replace("Ş", "&#350;");
        str = str.replace("ü", "&#252;");
        str = str.replace("Ü", "&#220;");
        return str;
    }

    /**
     * Bir string'i çift tırnak içerisine almak için kullanılır.<br/>
     * Mesela str isiminde bir String değişkeni çift tırnak içerisinde 
     * almak için "\"" + str +"\"" yerine  STR.addDoubleQuote(str) yazmak daha
     * kolaydır. Birincisinde hata yapma riski de oldukça yüksektir.
     */
    public static String addDoubleQuote(String str) {
        return "\"" + str + "\"";
    }
}
