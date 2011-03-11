
import com.hrzafer.javanta.DB;
import com.hrzafer.javanta.GUI;
import com.hrzafer.javanta.IO;
import com.hrzafer.javanta.STR;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public static void testIO(){
        IO.write("örnek.txt", "Bu dosya \n\n"
                + "IO.write(\"örnek.txt\", \"Bu dosya ... \"); "
                + "\n\ngibi bir komut ile oluşturulmuştur."
                + "\n test/Main.java dosyasında örnek kodları görebilirsiniz.");
    }

    public static void copy(String src, String dest){
        File directory = new File(src);
        File[] files = directory.listFiles();

        for(File file : files){
            IO.copy(file, new File(dest + "/" + file.getName()));
        }
    }

    public static void testGUI(){
        GUI.messageBox("deneme", "Bu bir denemedir");
    }

    public static void testSTR(){
        String str = STR.removeDuplicateSpaces("verip karşılığında      haftalık\n\ntemin ettiği fonlara ödediklneri faize çevrildi ve o da bugün ");
        System.out.println(str);
    }

    public static void speedTest(){
        int test_count = 100000;
        for(int i=0; i<test_count;i++){
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

        ResultSet rs = DB.executeQuery("SELECT * FROM `admin`");
        try {
            rs.next();
            System.out.println(rs.getString("username"));
            rs.next();
            System.out.println(rs.getString("username"));
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
