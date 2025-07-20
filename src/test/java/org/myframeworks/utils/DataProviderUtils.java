package org.myframeworks.utils;

import org.myframeworks.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.myframeworks.utils.ReadExcelUtils.getDataFromExcel;

/**
 * Utility class for providing test data from an Excel file.
 * This class uses TestNG's DataProvider to supply test data for tests.
 * It reads the test data from an Excel file and filters it based on the test case name and execution flag.
 */
public class DataProviderUtils {

    private static List<HashMap<String, String>> testDataList = new ArrayList<>();

    @DataProvider(name = "testData", parallel = true)
    public static Object[] testData(Method method) throws IOException {
        String testName = method.getName();
        if (testDataList.isEmpty()) {
            // Load test data from Excel only once
            testDataList = getDataFromExcel(FrameworkConstants.getTestData(), "TestsRunner");
        }
        List<HashMap<String, String>> actualList = new ArrayList<>();
        // Only include rows where Execute is "yes"
        for (HashMap<String, String> row : testDataList) {
            if (row != null && row.get("TestCase") != null && row.get("Execute") != null) {
                String testCase = row.get("TestCase");
                String execute = row.get("Execute");
                if (testCase.equalsIgnoreCase(testName) && execute.equalsIgnoreCase("yes")) {
                    actualList.add(row);
                }
            }
        }
        return actualList.toArray();
    }
}