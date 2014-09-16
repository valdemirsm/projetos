/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Properties.Classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author stevan t
 */
public class ManipulaPropriedades {

    public ManipulaPropriedades() {
    }

    public static String LerAliquota() {
        Properties properties = new Properties();
        try {
            //Setamos o arquivo que será lido
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/Properties/PLookAndFeel.properties");
            //método load faz a leitura através do objeto fis
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Captura o valor da propriedade, através do nome da propriedade(Key)
        String p1 = properties.getProperty("LookAndFeel");
        return p1;
    }

    public static void gravaAliquota(String LookAndFeel) {
        Properties properties = new Properties();
        try {
            //Setamos o arquivo que será lido
            FileOutputStream fis = new FileOutputStream(System.getProperty("user.dir") + "/src/Properties/PLookAndFeel.properties");
            //método load faz a leitura através do objeto fis
            properties.put("LookAndFeel", LookAndFeel);
            properties.store(fis, null);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static String LerDataBalcao() {
//        Properties properties = new Properties();
//        try {
//            //Setamos o arquivo que será lido
//            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/Classes/bematech/InfImpressao.properties");
//            //método load faz a leitura através do objeto fis
//            properties.load(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //Captura o valor da propriedade, através do nome da propriedade(Key)
//        String p = properties.getProperty("Data_Balcao");
//        return p;
//    }
//
//    public static void GravarDataBalcao(String id_balcao) {
//        Properties properties = new Properties();
//        try {
//            //Setamos o arquivo que será lido
//            FileOutputStream fis = new FileOutputStream(System.getProperty("user.dir") + "/src/Classes/bematech/InfImpressao.properties");
//            //método load faz a leitura através do objeto fis
//            properties.setProperty("Data_Balcao", id_balcao);
//            properties.store(fis, null);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
