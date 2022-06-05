package Mentoring;

public class PropertiesReaderTest {

    public static void main(String[] args) {
        System.out.println(PropertiesReader.getProperty(PropertiesReader.URLS, "google"));
        System.out.println(PropertiesReader.getProperty(PropertiesReader.URLS, "amazon"));
        System.out.println(PropertiesReader.getProperty(PropertiesReader.DATA, "password"));
        System.out.println(PropertiesReader.getProperty(PropertiesReader.ENDPOINTS, "petstoreGetPet", "5"));
        System.out.println(PropertiesReader.getProperty(PropertiesReader.ENDPOINTS, "petstoreGetPet", "1"));
        System.out.println(PropertiesReader.getProperty(PropertiesReader.CREDENTIALS, "firstName"));
        System.out.println(PropertiesReader.getProperty(PropertiesReader.CONFIGURATION, "searchValue"));
        System.out.println(PropertiesReader.getProperty(PropertiesReader.CONFIGURATION, "browser", " WebBrowser"));
    }
}
