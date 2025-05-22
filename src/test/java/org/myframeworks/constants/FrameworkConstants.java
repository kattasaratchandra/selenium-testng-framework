package org.myframeworks.constants;

/**
 * Utility class that holds constant values used throughout the framework.
 * <p>
 * This class is not meant to be instantiated.
 * </p>
 */
public final class FrameworkConstants {

    /**
     * Private constructor to prevent instantiation.
     */
    private FrameworkConstants(){}


    private static final String RESOURCE_PATH = System.getProperty("user.dir") + "/src/test/resources/";
    private static final String CONFIG_FILE_PATH = RESOURCE_PATH + "config/config.properties";


    public static String getConfigFilePath() {
        return CONFIG_FILE_PATH;
    }
}