package com.hrzafer.javanta;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Kronometre vazifesi gören bu sınıf geçen süreyi nanosaniye, milisaniye ya da saniye cinsinden hesaplar.
 *
 * @author hrzafer
 */
public class Timer {

    private static long START;
    private static long END;
    private static boolean IS_RUNNING;
    private static double MILLION = 1000000.0;
    private static double BILLION = 1000000000.0;

    /**
     * Kronometreyi başlatır. Eğer zaten başlamış durumda ise RunTimeException hatası atar.
     */
    public static void start() {
        if (!IS_RUNNING) {
            startTimer();
        } else {
            throw new RuntimeException("Hata: Kronometre (Timer) zaten başlatılmış durumda!!!\n");
        }
    }

    private static void startTimer() {
        START = System.nanoTime();
        IS_RUNNING = true;
    }

    /**
     * Kronometreyi durdurur. Eğer zaten başlamamış ise RunTimeException hatası atar.
     */
    public static void stop() {
        if (IS_RUNNING) {
            stopTimer();
        } else {
            throw new RuntimeException("Hata: Kronometre (Timer) başlatılmadı!!!\n");
        }
    }

    private static void stopTimer() {
        END = System.nanoTime();
        IS_RUNNING = false;
    }

    /**
     * Timer.start() ile Timer.stop() arasında geçen süreyi nanosaniye olarak döndürür.
     */
    public static long getElapsedTime() {
        if (!IS_RUNNING) {
            return END - START;
        } else {
            throw new RuntimeException("Hata: Kronometre (Timer) durdurulmadı!!!\n");
        }
    }

    /**
     * Timer.start() ile Timer.stop() arasında geçen süreyi milisaniye cinsinden döndürür.
     */
    public static double getElapsedMilliseconds() {
        double seconds = (double) getElapsedTime() / MILLION;
        return seconds;
    }

    /**
     * Timer.start() ile Timer.stop() arasında geçen süreyi saniye cinsinden döndürür.
     */
    public static double getElapsedSeconds() {
        double seconds = (double) getElapsedTime() / BILLION;
        return seconds;
    }

//    public static void main(String args[]) {
//        Timer.start();
//        System.out.println("deneme");
//        Timer.stop();
//        double seconds = Timer.getElapsedSeconds();
//
//        double number = 10.0/3;
//        System.out.println(number);
//        DecimalFormat df = new DecimalFormat("0.00####");
//        System.out.println(df.format(number));
//        df.setRoundingMode(RoundingMode.UP);
//
//        System.out.println("Geçen süre " + df.format(seconds) + " saniyedir" + Timer.getElapsedMilliseconds() + " " + seconds);
//    }
}
