package com.hrzafer.javanta;

import java.math.BigInteger;

/**
 * Bu sınıf temel Matematik işlemleri için gerekli bazı metodlar içerir.
 * @author hrzafer
 */
public class MAT {
    
    /**
     * Bir sayının (n) faktoriyelini hesaplar. Bu sayı çok büyük olabileceği için BigInteger <br>
     * türünde döndürür.
     * Uyarı: 20! = 2,432,902,008,176,640,000
     */
    public static BigInteger factorial(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = n; i > 1; i--) {
            fact = fact.multiply(new BigInteger(Integer.toString(i)));
        }
        return fact;
    }

  
}
