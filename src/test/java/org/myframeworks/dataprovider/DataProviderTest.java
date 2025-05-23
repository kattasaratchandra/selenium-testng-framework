package org.myframeworks.dataprovider;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.myframeworks.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * DataProviderTest demonstrates how to use a single TestNG @DataProvider method
 * to supply different data sets to multiple test methods based on the method name.
 * - testMethod1 receives two parameters per test run.
 * - testMethod2 receives one parameter per test run.
 * The dataProviderMethod inspects the test method name and returns the appropriate
 * data structure for each test, enabling flexible and reusable data-driven tests.
 */
public class DataProviderTest {

    @Test(dataProvider = "dataProviderMethod")
    public void testMethod1(String data1, String data2) {
        System.out.println(data1 + " " + data2);
    }

    @Test(dataProvider = "dataProviderMethod")
    public void testMethod2(String data1) {
        System.out.println(data1);
    }

    /**
     * Data provider that supplies hardcoded data based on the test method name.
     * <p>
     * - For testMethod1, returns two String parameters per test.
     * - For testMethod2, returns one String parameter per test.
     * <p>
     * This approach allows a single data provider to serve multiple test methods
     * with different data shapes, using the Method parameter to distinguish them.
     *
     * @param m the test method requesting data
     * @return Object[][] data for the test method
     */
    @DataProvider
    public Object[][] dataProviderMethod(Method m) {
        if(m.getName().equals("testMethod1")) {
            return new Object[][] {
                {"data1", "data2"},
                {"data3", "data4"}
            };
        } else if(m.getName().equals("testMethod2")) {
            return new Object[][] {
                {"data5"},
                {"data7"}
            };
        }
        // Return an empty array for unknown method names. Log a warning to help catch misconfigurations early.
        System.out.println("Warning: No data provided for method: " + m.getName());
        return new Object[0][];
    }

    /**
     * Data provider that reads test data from an Excel file and returns it as a two-dimensional array.
     * <p>
     * Each row in the Excel sheet (excluding the header) becomes a test case, and each cell in the row
     * becomes a parameter for the test method. The Excel file path is obtained from FrameworkConstants.getTestData(),
     * and the sheet name is hardcoded as "Sheet1".
     *
     * @return Object[][] where each row is a set of parameters for a test method
     * @throws IOException if the Excel file cannot be read
     */
    @DataProvider(name = "excelDataProvider")
    public Object[][] excelDataProvider() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getTestData());
             XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)) {
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rowNum = sheet.getPhysicalNumberOfRows();
            int colNum = sheet.getRow(0).getPhysicalNumberOfCells();
            Object[][] data = new Object[rowNum - 1][colNum];
            for (int i = 1; i < rowNum; i++) {
                for (int j = 0; j < colNum; j++) {
                    data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
                }
            }
            return data;
        }
    }

    @Test(dataProvider = "excelDataProvider")
    public void testMethodFromExcel(String username, String password, String firstName, String lastName) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(firstName);
        System.out.println(lastName);
    }

    /**
     * Data provider that reads test data from an Excel file and returns it as an array of HashMaps.
     * <p>
     * Each map represents a row with column headers as keys and cell values as values. This is useful
     * for tests that require key-value access to test data. The Excel file path is obtained from
     * FrameworkConstants.getTestData(), and the sheet name is hardcoded as "Sheet1".
     * Example Excel structure:
     * | username | password | firstname | lastname |
     * |----------|----------|-----------|----------|
     * | user1    | pass1    | John      | Doe      |
     * | user2    | pass2    | Jane      | Smith    |
     *
     *  @return Object[] where each element is a HashMap<String, String> representing a row of test data
     * @throws IOException if the Excel file cannot be read
     */
    @DataProvider(name = "excelDataProviderMap")
    public Object[] excelDataProviderMap() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getTestData());
             XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)) {
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rowNum = sheet.getPhysicalNumberOfRows();
            int colNum = sheet.getRow(0).getPhysicalNumberOfCells();
            Object[] objects = new Object[rowNum - 1];
            for (int i = 1; i < rowNum; i++) {
                HashMap<String, String> data = new HashMap<>();
                for (int j = 0; j < colNum; j++) {
                    String key = sheet.getRow(0).getCell(j).toString();
                    String value = sheet.getRow(i).getCell(j).toString();
                    data.put(key, value);
                }
                objects[i - 1] = data;
            }
            return objects;
        }
    }

    @Test(dataProvider = "excelDataProviderMap")
    public void testMethodFromExcelMap(HashMap<String, String> data) {
        System.out.println(data.get("username"));
        System.out.println(data.get("password"));
        System.out.println(data.get("firstname"));
        System.out.println(data.get("lastname"));
    }
}

