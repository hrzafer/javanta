
import com.hrzafer.javanta.GUI;
import com.hrzafer.javanta.IO;
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
        String[] files = directory.list();

        for(String file : files){
            IO.copy(src + "/" + file, dest + "/"+ file);
        }
    }

    public static void testGUI(){

        GUI.messageBox("deneme", "Bu bir denemedir");
    }

    public static void main(String[] args) {

        //testGUI();

        copy("C:/Documents and Settings/Administrator/Desktop/src", "C:/Documents and Settings/Administrator/Desktop/dest");
        
    }

}
