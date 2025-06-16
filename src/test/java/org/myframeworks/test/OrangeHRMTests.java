package org.myframeworks.test;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.api.Assertions;
import org.myframeworks.constants.FrameworkConstants;
import org.myframeworks.pages.OrangeHRMLoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Test class for OrangeHRM login and logout functionality.
 * Uses data-driven testing with data provided from an Excel sheet.
 */
public final class OrangeHRMTests extends BaseTest{

    /**
     * Test method for login and logout functionality in OrangeHRM.
     * Uses data from the DataProvider 'testData'.
     *
     * @param testData HashMap containing test data with keys 'username' and 'password'
     */
    @Test(dataProvider = "testData")
    public void loginLogoutTest(HashMap<String, String> testData) {
        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage();
        String actualTitle = loginPage.enterUsername(testData.get("username"))
                .enterPassword(testData.get("password"))
                .clickLoginButton()
                .clickUserDropdownIcon()
                .clickLogoutButton()
                .getPageTitle();
        String expectedTitle = "OrangeHRM";
        Assertions.assertThat(actualTitle)
                .isEqualTo(expectedTitle)
                .isNotNull();
    }

    /**
     * DataProvider method that reads test data from an Excel file.
     * Each row (except the header) is converted into a HashMap of column name to value.
     * The data is provided in parallel for test execution.
     *
     * @return Object[] array where each element is a HashMap<String, String> representing a row of test data
     * @throws IOException if there is an error reading the Excel file
     * @throws InvalidFormatException if the Excel file format is invalid
     */
    @DataProvider(name = "testData", parallel = true)
    public Object[] testData() throws IOException, InvalidFormatException {
        try (XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new File(FrameworkConstants.getTestData()))){
            XSSFSheet sheet = xssfWorkbook.getSheet("sheet1");
            int rowNum = sheet.getPhysicalNumberOfRows();
            int colNum = sheet.getRow(0).getPhysicalNumberOfCells();
            Object[] objects = new Object[rowNum - 1];
            for(int i=1; i< rowNum; i++){
                HashMap<String, String> dataMap = new HashMap<>();
                for(int j=0; j<colNum; j++){
                    String key = sheet.getRow(0).getCell(j).toString();
                    String value = sheet.getRow(i).getCell(j).toString();
                    dataMap.put(key, value);
                }
                objects[i-1] = dataMap;
            }
            return objects;
        }
    }

}