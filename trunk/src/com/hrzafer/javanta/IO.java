/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrzafer.javanta;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Dosya işlemleri edevatı
 * Yazar: Harun Reşit Zafer - hrzafer@gmail.com hrzafer.com
 *
 */
public class IO {

    private static final int BUFFER = 8192;

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

    public static void copy(String from, String to) {


        File source = new File(from);
        File target = new File(to);
        FileChannel in = null;
        FileChannel out = null;

        try {
            in = new FileInputStream(source).getChannel();
            out = new FileOutputStream(target).getChannel();

            ByteBuffer buffer = ByteBuffer.allocateDirect(BUFFER);
            while (in.read(buffer) != -1) {
                buffer.flip();

                while (buffer.hasRemaining()) {
                    out.write(buffer);
                }

                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(in);
            close(out);
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
            close(writer);
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
            close(writer);
        }
    }

    /**
     * String'i dosya gibi okuyabilmek için kullanılabilecek bir metod.
     */
    public static InputStream toInputStream(String source) {
        InputStream stream;
        try {
            stream = new ByteArrayInputStream(source.getBytes("UTF-8"));
            return stream;
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Dosyayı exception handling ile uğraşmadan kapatmak için.
     */
    private static void close(Closeable closable) {
        if (closable != null) {
            try {
                closable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
