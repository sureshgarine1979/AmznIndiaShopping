package amazon.shopping.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties prop;

    public ReadConfig() {
        File src = new File("./config/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is Unalbe to read file"+ e.getMessage());
        }

    }

    public String getApplicationURL(){
        String url = prop.getProperty("baseURL");
        return url;
    }
}
