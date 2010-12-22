
import com.hrzafer.javanta.GUI;
import com.hrzafer.javanta.IO;
import com.hrzafer.javanta.STR;
import java.io.File;

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

            String str = IO.read("test_UTF8.txt");
            IO.write("test_UTF8.txt", str.toUpperCase());


//        System.out.println(IO.read2("test_UTF8.txt"));
//        System.out.println(IO.read2("test_ISO.txt","ISO-8859-9"));
//        System.out.println(IO.read2("test_ANSI.txt"));
    }

}
