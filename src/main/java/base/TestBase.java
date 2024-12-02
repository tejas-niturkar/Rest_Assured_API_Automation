package base;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public Properties prop ;

    public TestBase(){

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("E:\\Tejas\\Projects\\Rest_Assured_By_Naveen\\src\\main\\java\\config\\config.properties"));
            prop.load(ip);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }


    }



}
