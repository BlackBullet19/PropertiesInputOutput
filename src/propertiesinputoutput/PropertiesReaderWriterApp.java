package propertiesinputoutput;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class PropertiesReaderWriterApp {

    public static void main(String[] args) throws IOException {

        Scanner scannerForPropertiesPath = new Scanner(System.in);
        System.out.println("Write path to your properties file :");
        String pathToProperties = scannerForPropertiesPath.nextLine();

        FileReader propertiesReader = new FileReader(pathToProperties);
        BufferedReader bufferedPropertiesReader = new BufferedReader(propertiesReader);

        Properties properties = new Properties();
        properties.load(bufferedPropertiesReader);
        properties.keySet().stream().map(key -> key + " : " + properties.getProperty(key.toString())).forEach(System.out::println);

        Scanner scannerForPropertiesPathXml = new Scanner(System.in);
        System.out.println("Write path to save properties file in XML format :");
        String pathToPropertiesXml = scannerForPropertiesPath.nextLine();

        FileOutputStream outputStream = new FileOutputStream(pathToPropertiesXml);
        properties.storeToXML(outputStream, "xml");
        outputStream.close();
        scannerForPropertiesPathXml.close();
    }
}
