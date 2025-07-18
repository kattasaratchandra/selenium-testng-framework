package org.myframeworks.pages;

import org.myframeworks.enums.WaitStrategy;
import org.openqa.selenium.By;

/**
 * This class represents the home page of the OrangeHRM application.
 */
public class OrangeHRMHomePage extends BasePage {

    private final By userDropdownIcon = By.xpath("//i[contains(@class, 'userdropdown-icon')]");
    private final By logoutLink = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickUserDropdownIcon() {
        clickElement(userDropdownIcon, WaitStrategy.CLICKABLE, "User Dropdown Icon");
        return this;
    }

    public OrangeHRMLoginPage clickLogoutButton() {
        clickElement(logoutLink, WaitStrategy.CLICKABLE, "Logout Link");
        return new OrangeHRMLoginPage();
    }

}
