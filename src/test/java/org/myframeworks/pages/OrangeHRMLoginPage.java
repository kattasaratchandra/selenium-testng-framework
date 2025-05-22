package org.myframeworks.pages;

import org.myframeworks.enums.WaitStrategy;
import org.openqa.selenium.By;

public class OrangeHRMLoginPage extends BasePage{

    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit']");

    public OrangeHRMLoginPage enterUsername(String username) {
        enterText(usernameField, username, WaitStrategy.PRESENCE);
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password) {
        enterText(passwordField, password, WaitStrategy.PRESENCE);
        return this;
    }

    public OrangeHRMHomePage clickLoginButton() {
        clickElement(loginButton, WaitStrategy.CLICKABLE);
        return new OrangeHRMHomePage();
    }

}
