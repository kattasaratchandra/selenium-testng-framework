package org.myframeworks.constants;

import org.myframeworks.enums.ConfigProperties;
import org.myframeworks.utils.ReadPropertyFileUtils;

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
    private static final String JSON_CONFIG_FILE_PATH = RESOURCE_PATH + "config/config.json";
    private static final String TEST_DATA = RESOURCE_PATH + "testdata/testdata.xlsx";
    private static final String TEST_DATA_JSON = RESOURCE_PATH + "testdata/testData.json";
    private static final String TEST_DATA_PROPERTIES = RESOURCE_PATH + "testdata/testData.properties";
    private static final String TEST_DATA_CSV = RESOURCE_PATH + "testdata/testData.csv";
    private static final String EXTENT_REPORTS_FOLDER_PATH = System.getProperty("user.dir") + "/Extent-output/";
    private static String extentReportPath = "";


    public static String getExtentReportPath() {
        if (extentReportPath.isEmpty()) {
            extentReportPath = createExtentReport();
        }
        return extentReportPath;
    }

    private static String createExtentReport(){
        if (ReadPropertyFileUtils.getProperty(ConfigProperties.OVERRIDE_REPORTS.name().toLowerCase()).equalsIgnoreCase("no")){
            extentReportPath = EXTENT_REPORTS_FOLDER_PATH + "ExtentReport.html";
        }
        else {
            extentReportPath = EXTENT_REPORTS_FOLDER_PATH + "ExtentReport_" + System.currentTimeMillis() + ".html";
        }
        return extentReportPath;
    }



    public static String getConfigFilePath() {
        return CONFIG_FILE_PATH;
    }

    public static int getExplicitWait() {
        String waitValue = ReadPropertyFileUtils.getProperty(ConfigProperties.WAIT.name());
        return Integer.parseInt(waitValue);
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

    public static String getJsonConfigFilePath() {
        return JSON_CONFIG_FILE_PATH;
    }
    public static String getTestDataCsv() {
        return TEST_DATA_CSV;
    }
}