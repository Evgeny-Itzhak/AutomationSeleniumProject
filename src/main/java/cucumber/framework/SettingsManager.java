package cucumber.framework;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

@Slf4j
public class SettingsManager {

    private static String host;
    private static String url;

    public void initialization(){
        // declare filestream variables and property
        FileInputStream fileStream;
        Properties property = new Properties();

        try{
            // set variables from automation.properties file
            fileStream = new FileInputStream("src/test/resources/automation.properties");
            property.load(fileStream);

            if (System.getProperty("tad.base.fqdn") != null) {
                host = System.getProperty("automation.base.url");
            } else {
                host = property.getProperty("automation.base.url");
            }

            url = "http://" + host;

            log.info("Url was initialized: ", url);


        } catch (IOException e) {
            log.error(Arrays.toString(e.getStackTrace()));
        }
    }

    public String getHost() {
        return host;
    }

    public String getUrl() {
        return url;
    }
}
