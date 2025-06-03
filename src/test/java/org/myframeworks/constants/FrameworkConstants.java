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
    private static final int EXPLICIT_WAIT = 10;
    private static final String TEST_DATA = RESOURCE_PATH + "testdata/testdata.xlsx";
    private static final String TEST_DATA_JSON = RESOURCE_PATH + "testdata/testData.json";
    private static final String TEST_DATA_PROPERTIES = RESOURCE_PATH + "testdata/testData.properties";

    public static String getConfigFilePath() {
        return CONFIG_FILE_PATH;
    }

    public static int getExplicitWait() {
        return EXPLICIT_WAIT;
    }

    public static String getTestData() {
        return TEST_DATA;
    }

    public static String getTestDataJson() {
        return TEST_DATA_JSON;
    }

    public static String getTestDataProperties() {
        return TEST_DATA_PROPERTIES;
    }
}