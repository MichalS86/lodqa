package com.lodqa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Created by stelmasz on 18/10/2016.
 */
public class PropertiesHelper {
    private static final Logger LOG = LoggerFactory.getLogger("PropertiesHelper");

    private final String filename;

    public PropertiesHelper(String filename){
        this.filename = filename;
    }

    public String getPropValue(String key){
        String result = "";
        InputStream inputStream;
        try {
            Properties prop = new Properties();

            inputStream = getClass().getClassLoader().getResourceAsStream(filename);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + filename + "' not found in the classpath");
            }
            result = prop.getProperty(key);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        return result;
    }

//    public BasicDataSource getDataSource(String driverClassName, String username, String password, String url) {
//
//        BasicDataSource dataSource = new BasicDataSource();
//
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        dataSource.setUrl(url);
//        dataSource.setMaxActive(10);
//        dataSource.setMaxIdle(5);
//        dataSource.setInitialSize(5);
//        dataSource.setValidationQuery("SELECT 1");
//
//        return dataSource;
//    }

}
