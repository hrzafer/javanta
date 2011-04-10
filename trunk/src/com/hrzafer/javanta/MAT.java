package com.hrzafer.javanta;

import java.math.BigInteger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
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
