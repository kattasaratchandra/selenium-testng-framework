package org.myframeworks.utils;

import org.myframeworks.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Utility class for reading properties from a configuration file.
 * <p>
 * Properties are loaded once at class initialization and can be accessed
 * using the provided static methods.
 * </p>
 */
public final class ReadPropertyFileUtils {

    /**
     * Private constructor to prevent instantiation.
     */
    private ReadPropertyFileUtils() {
    }

    /**
     * Map to store properties as key-value pairs for quick access.
     */
    private static final Map<String, String> propertiesMap = new HashMap<>();

    /**
     * Properties object to hold loaded properties.
     */
    private static final Properties properties = new Properties();

    // Static block to load properties from the configuration file at class initialization.
    static {
        try (FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file: " + FrameworkConstants.getConfigFilePath(), e.getCause());
        }

        // Populate the propertiesMap with entries from the Properties object.
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            propertiesMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
    }


    /**
     * Retrieves the value of the specified property key from the properties map.
     *
     * @param key the property key to retrieve
     * @return the value associated with the key, or null if not found
     * @throws IllegalArgumentException if the key is null or empty
     */
    public static String getProperty(String key) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Property key cannot be null or empty");
        }
        String value = propertiesMap.get(key);
        if (value == null) {
            throw new IllegalArgumentException("Property key '" + key + "' not found in config file");
        }
        return value;
    }
}