package Mentoring;

import java.io.FileInputStream;
import java.util.Properties;

public enum PropertiesReader {

    //Path is costume, you may need to change it
    URLS("src/test/resources/Mentoring/urls.properties"),
    DATA("src/test/resources/Mentoring/data.properties"),
    ENDPOINTS("src/test/resources/Mentoring/endpoints.properties"),
    CREDENTIALS("src/test/resources/Mentoring/credentials.properties"),
    CONFIGURATION("configuration.properties");

    private Properties properties;

    private PropertiesReader(String path) {
        try{
            FileInputStream input=new FileInputStream(path);
            properties=new java.util.Properties();
            properties.load(input);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String getProperty(String key){
        return properties.getProperty(key);
    }

    public static String getProperty(PropertiesReader propertiesReader, String key) {
        return propertiesReader.getProperty(key);
    }

    public static String getProperty(PropertiesReader propertiesReader, String key, String param) {
        return propertiesReader.getProperty(key)+param;
    }
}
