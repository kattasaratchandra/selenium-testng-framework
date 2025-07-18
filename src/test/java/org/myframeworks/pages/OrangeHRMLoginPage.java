package org.myframeworks.pages;

import org.myframeworks.enums.WaitStrategy;
import org.openqa.selenium.By;

/**
 * This class represents the login page of the OrangeHRM application.
 */
public class OrangeHRMLoginPage extends BasePage {

    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit']");

    public OrangeHRMLoginPage enterUsername(String username) {
        enterText(usernameField, username, WaitStrategy.PRESENCE, "Username Field");
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password) {
        enterText(passwordField, password, WaitStrategy.PRESENCE, "Password Field");
        return this;
    }

    public OrangeHRMHomePage clickLoginButton() {
        clickElement(loginButton, WaitStrategy.CLICKABLE, "Login Button");
        return new OrangeHRMHomePage();
    }

}
