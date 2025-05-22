package org.myframeworks.test;

import org.assertj.core.api.Assertions;
import org.myframeworks.pages.OrangeHRMLoginPage;
import org.testng.annotations.Test;

public final class OrangeHRMTests extends BaseTest{

    @Test
    public void loginLogoutTest() {
        String username = "Admin";
        String password = "admin123";

        // Create an instance of the login page
        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage();

        // Perform the login action
        String actualTitle = loginPage.enterUsername(username)
                .enterPassword(password)
                .clickLoginButton()
                .clickUserDropdownIcon()
                .clickLogoutButton()
                .getPageTitle();
        String expectedTitle = "OrangeHRM";
        // Validate the title after logout
        Assertions.assertThat(actualTitle)
                .isEqualTo(expectedTitle)
                .isNotNull();
    }
}
