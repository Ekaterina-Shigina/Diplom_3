package ru.yandex.practicum.handlers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {
    public static String getProperties(String propertyName){

        String property = "";
        File file = new File("src/main/resources/value.properties");

        //создаем объект Properties и загружаем в него данные из файла.
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(file));
            property = properties.getProperty(propertyName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }
}
