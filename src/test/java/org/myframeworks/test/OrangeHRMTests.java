package org.myframeworks.test;

import org.assertj.core.api.Assertions;
import org.myframeworks.annotations.FrameWorkAnnotation;
import org.myframeworks.enums.CategoryType;
import org.myframeworks.pages.OrangeHRMLoginPage;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Test class for OrangeHRM application.
 * Contains tests for login/logout functionality and home page title verification.
 * Uses TestNG framework for test execution and assertions.
 * Tests are annotated with @FrameWorkAnnotation for categorization and author tracking.
 * Tests are parameterized with test data from an Excel file.
 */
public final class OrangeHRMTests extends BaseTest {

    @FrameWorkAnnotation(author = {"sharath"}, category = {CategoryType.SMOKE})
    @Test()
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

    @FrameWorkAnnotation(author = {"sharath"}, category = {CategoryType.SMOKE})
    @Test()
    public void homePageTitleTest(HashMap<String, String> testData) {
        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage();
        String actualTitle = loginPage.enterUsername(testData.get("username"))
                .enterPassword(testData.get("password"))
                .clickLoginButton()
                .getPageTitle();
        String expectedTitle = "OrangeHRM";
        Assertions.assertThat(actualTitle)
                .isEqualTo(expectedTitle)
                .isNotNull();
    }
}