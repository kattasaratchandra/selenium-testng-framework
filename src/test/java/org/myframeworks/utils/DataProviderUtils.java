package org.myframeworks.utils;

import org.myframeworks.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.myframeworks.utils.ReadExcelUtils.getDataFromExcel;

public class DataProviderUtils {

    public static List<HashMap<String, String>> testDataList;

    @DataProvider(name = "testData", parallel = false)
    public static  Object[] testData() throws IOException {
        if(testDataList.isEmpty()) {
            testDataList = getDataFromExcel(FrameworkConstants.getTestData(), "Sheet1");
        }
        return testDataList.toArray();
    }
}
