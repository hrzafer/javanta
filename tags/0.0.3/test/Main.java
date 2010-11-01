
import com.hrzafer.javanta.GUI;
import com.hrzafer.javanta.IO;

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

    public static void testGUI(){
        GUI.setLookandFeel("deneme", null);
    }

    public static void main(String[] args) {

        testGUI();
        
    }

}
