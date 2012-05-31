package com.hrzafer.javanta;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Bu sınıf temel Matematik işlemleri için gerekli bazı metodlar içerir. Zamanla ihtiyaca göre 
 * yeni metodlar eklenebilir. 
 * @author hrzafer
 */
public class MAT {
    
    /**
     * Bir sayının (n) faktoriyelini hesaplar. Bu sayı çok büyük olabileceği
     * için BigInteger türünde döndürür. <br/>
     * Uyarı: 20! = 2,432,902,008,176,640,000
     */
    public static BigInteger factorial(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = n; i > 1; i--) {
            fact = fact.multiply(new BigInteger(Integer.toString(i)));
        }
        return fact;
    }
    
    /**
     * "sieve of Eratosthenes", Eratostenes'in kalburu yöntemine dayanarak,
     * n'e kadar olan tüm asal sayıları döndürür.
     * @param n 2'den küçük olamaz.
     * @return n'e kadar tüm asal sayıların listesi
     */
    public static List<Integer> primes(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        if (n < 2) {
            throw new IllegalArgumentException("n must be an integer that n > 1");
        }
        for (int i = 2; i <= n; i++) {
            primes.add(i);
        }
        int count=0;
        for (int i = 0; i*i < n; i++) {
            int prime = primes.get(i);
            for (int j = primes.size() - 1; j > i + 1; j--) {
                if (j < i*i){
                    continue;
                }
                count++;
                if (primes.get(j) % prime == 0) {
                    primes.remove(j);
                }
            }
        }
        return primes;
    }
    
    /**
     * gcd: greatest common divisor (obeb: ortak bölenlerin en büyüğü)<br/>
     * Euclid'in gcd(m,n) = gcd(n, m mod n) yöntemine dayanarak m ile n'in 
     * obeb'ini döndürür.
     * @param m birinci tamsayı
     * @param n ikinci tamsayı
     * @return m ile n'in obeb'ini döndürürür.
     */
    public int gcd(int m, int n) {
        int r;
        while(n!=0){
            r = m % n;
            m=n;
            n=r;
        }
        return m;
    }    
}
