package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


public class ProjectProperties {
    private final static String ENV = System.getProperty("env");
    private final static String PROJECT_PROPERTIES_FILE = "src/test/resources/project.properties";
    private final static String COMMON_PROPERTIES_FILE = "src/test/resources/common.properties";
    private static Properties properties = new Properties();

    private ProjectProperties(){
    }

    public static void load() {
        loadPropertiesFromFiles(Arrays.asList(PROJECT_PROPERTIES_FILE, COMMON_PROPERTIES_FILE));
        properties.entrySet().forEach(entry -> {
            System.setProperty((String) entry.getKey(), (String) entry.getValue());
        });
    }

    private static void loadPropertiesFromFiles(final List<String> propertyFiles){
        propertyFiles.forEach(file -> {
            try (InputStream input = new FileInputStream(file)) {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
