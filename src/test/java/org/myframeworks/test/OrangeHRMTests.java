package org.myframeworks.test;

import org.assertj.core.api.Assertions;
import org.myframeworks.pages.OrangeHRMLoginPage;
import org.myframeworks.utils.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

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
    @Test(dataProvider = "testData", dataProviderClass = DataProviderUtils.class)
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


    @Test
    public void homePageTitleTest() {
        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage();
        String actualTitle = loginPage.enterUsername("admin123")
                .enterPassword("Admin")
                .clickLoginButton()
                .getPageTitle();
        String expectedTitle = "OrangeHRM";
        Assertions.assertThat(actualTitle)
                .isEqualTo(expectedTitle)
                .isNotNull();
        Assert.fail();
    }
}