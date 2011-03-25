
import com.hrzafer.javanta.GUI;
import com.hrzafer.javanta.IO;
import com.hrzafer.javanta.MAT;
import com.hrzafer.javanta.STR;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

        System.out.println(STR.toNonTurkish("Bu nedenlerle, geliştirilecek Beyan Akıllı Yazım Desteği yazılımının ülkemizde büyük bir ihtiyacı gidereceği düşünülmektedir. Yazılımın Türk kullanıcıların büyük çoğunluğu tarafından kullanılan MS Word metin editörüne entegre bir biçimde çalışması planlanmaktadır. Bu şekilde yazılımın çok daha fazla kullanıcıya hitap edeceği düşünülmektedir. Böyle bir yazılıma başta eğitim kurumları ve resmi kurumlar olmak üzere pek çok sektörden talep geleceği öngörülmektedir."));


        //Set up some lists
        List<String> l1 = new ArrayList<String>();
        l1.add("A1");
        l1.add("A2");

        List<String> l2 = new ArrayList<String>();
        l2.add("B1");
        l2.add("B2");
        l2.add("B3");

        List<String> l3 = new ArrayList<String>();
        l3.add("C1");

        List<String> l4 = new ArrayList<String>();
        l4.add("D1");
        l4.add("D2");
        
        List<List<String>> ll = new ArrayList<List<String>>();

        ll.add(l1);
        ll.add(l2);
        ll.add(l3);
        ll.add(l4);

        for (List<String> list : ll) {
            for (String string : list) {
                System.out.print(string + ",");
            }
            System.out.println("");
        }


        ll = MAT.combinate(ll);

        for (List<String> list : ll) {
            for (String string : list) {
                System.out.print(string + ",");
            }
            System.out.println("");
        }

    }

}
