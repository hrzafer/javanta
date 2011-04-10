

import com.hrzafer.javanta.GUI;
import com.hrzafer.javanta.IO;
import com.hrzafer.javanta.STR;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hrzafer
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void testIO() {
        IO.write("örnek.txt", "Bu dosya \n\n"
                + "IO.write(\"örnek.txt\", \"Bu dosya ... \"); "
                + "\n\ngibi bir komut ile oluşturulmuştur."
                + "\n test/Main.java dosyasında örnek kodları görebilirsiniz.");
    }

    public static void copy(String src, String dest) {
        File directory = new File(src);
        File[] files = directory.listFiles();

        for (File file : files) {
            IO.copy(file, new File(dest + "/" + file.getName()));
        }
    }

    public static void testGUI() {
        GUI.messageBox("deneme", "Bu bir denemedir");
    }

    public static void testSTR() {
        String str = STR.removeDuplicateSpaces("verip karşılığında      haftalık\n\ntemin ettiği fonlara ödediklneri faize çevrildi ve o da bugün ");
        System.out.println(str);
    }

    public static void speedTest() {
        int test_count = 100000;
        for (int i = 0; i < test_count; i++) {
            IO.read("test_UTF8.txt");
            //System.out.println(".");
        }
    }

    public static void main(String[] args) {

            //speedTest();
            //System.out.println(IO.read("test_UTF8.txt"));
            //System.out.println(IO.read("test_ISO.txt",IO.ISO_TR));
            //System.out.println(IO.readLines("test_UTF8.txt"));
            //System.out.println(IO.readLines("test_ISO.txt",IO.ISO_TR));
            //System.out.println(IO.readWords("test_UTF8.txt"));
            //System.out.println(IO.readWords("test_ISO.txt",IO.ISO_TR));
            //        ResultSet rs = DB.executeQuery("SELECT * FROM `admin`");
            //        try {
            //            rs.next();
            //            System.out.println(rs.getString("username"));
            //            rs.next();
            //            System.out.println(rs.getString("username"));
            //        } catch (SQLException ex) {
            //            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            //        }
            //
            //Set up some lists
            List<String> empty = new ArrayList<String>();
            List<String> one = new ArrayList<String>();
            one.add("A");
            List<String> two = new ArrayList<String>();
            two.add("A");
            two.add("B");
            List<String> three = new ArrayList<String>();
            three.add("A");
            three.add("B");
            three.add("C");
            List<String> four = new ArrayList<String>();
            four.add("A");
            four.add("B");
            four.add("C");
            four.add("D");
            //        ll = MAT.combinate(ll);
            //
            //        for (List<String> list : ll) {
            //            for (String string : list) {
            //                System.out.print(string + ",");
            //            }
            //            System.out.println("");
            //        }
            //

             DataOutputStream os = null;
        try {
            int i = 42;
            double d = Math.PI;
            String FILENAME = "binary.dat";
            os = new DataOutputStream(new FileOutputStream(FILENAME));
            os.writeInt(i);
            os.writeDouble(d);
            os.writeBytes("deneme\r\n");
            os.close();
            System.out.println("Wrote " + i + ", " + d + " to file " + FILENAME);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                os.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

      

    }
}
