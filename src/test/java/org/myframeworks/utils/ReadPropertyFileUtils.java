package org.myframeworks.utils;

import org.myframeworks.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Utility class for reading properties from a configuration file.
 * This class loads properties from a specified file and provides methods to retrieve property values by key.
 * It ensures that the properties are loaded only once to optimize performance.
 * <p>
 * Usage:
 * - Call `getProperty(String key)` to retrieve the value associated with the specified key.
 * - If the key does not exist, an exception is thrown.
 * - If the properties file cannot be loaded, an exception is thrown.
 */
public final class ReadPropertyFileUtils {

    private static final Map<String, String> propertiesMap = new HashMap<>();
    private static boolean loaded = false;
    private static final Properties properties = new Properties();

    private ReadPropertyFileUtils() {
    }

    private static void loadProperties() {
        if (!loaded) {
            try (FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
                properties.load(fileInputStream);
                for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                    propertiesMap.put(entry.getKey().toString(), entry.getValue().toString());
                }
                loaded = true;
            } catch (IOException e) {
                throw new RuntimeException("Error loading properties file: " + FrameworkConstants.getConfigFilePath(), e);
            }
        }
    }

    public static String getProperty(String key) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Property key cannot be null or empty");
        }
        loadProperties();
        String value = propertiesMap.get(key);
        if (value == null) {
            throw new IllegalArgumentException("Property key '" + key + "' not found in config file");
        }
        return value;
    }
}