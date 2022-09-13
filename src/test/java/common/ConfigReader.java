package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public Properties init_prop() {
        Properties prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config_properties/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

}
