/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hrzafer.javanta;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Dosya işlemleri edevatı
 * Yazar: Harun Reşit Zafer - hrzafer@gmail.com hrzafer.com
 *
 */
public class IO {

    /**
     * Bir dosyayı okuyup bütünüyle string olarak döndürür.
     */
    public static String read(String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append("\n");
            }
            scanner.close();
            return stringBuilder.toString();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Bir String'i bütünüyle dosyaya yazar.
     */
    public static void write(String filePath, String content) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            closeQuietly(writer);
        }
    }

    /**
     * Bir dosyadaki kelimeleri liste (ArrayList) olarak döndürür.
     */
    public static ArrayList<String> getWords(String filePath) {
        Scanner scanner = null;
        ArrayList<String> words = new ArrayList<String>();
        scanner = new Scanner(read(filePath));
        String token;
        while (scanner.hasNext()) {
            words.add(scanner.next());
        }
        scanner.close();
        return words;
    }

    /**
     * Bir dosyadaki satırları liste (ArrayList) olarak döndürür.
     */
    public static ArrayList<String> getLines(String filePath) {
        Scanner scanner = null;
        ArrayList<String> lines = new ArrayList<String>();
        try {
            scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();
            return lines;
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Bir listedeki (ArrayList) satırları dosyaya yazar.
     */
    public static void writeLines(String filePath, ArrayList<String> lines) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            for (String line : lines) {
                writer.write(line + "\n");
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            closeQuietly(writer);
        }
    }

    /**
     * Okunan dosyayı exception handling ile uğraşmadan kapatmak için.
     */
    private static void closeQuietly(Reader file) {
        try {
            if (file != null) {
                file.close();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

    /**
     * Yazılan dosyayı exception handling ile uğraşmadan kapatmak için.
     */
    private static void closeQuietly(Writer file) {
        try {
            if (file != null) {
                file.close();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
