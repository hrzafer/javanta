
import com.hrzafer.javanta.GUI;
import com.hrzafer.javanta.IO;
import com.hrzafer.javanta.STR;
import java.io.File;
import java.util.Locale;

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
        String str = IO.read("test.txt");
        System.out.println(STR.toNonTurkishLowerCase(str));
        
    }

    public static void main(String[] args) {

        testSTR();
    }

}
