package org.myframeworks.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.myframeworks.driver.DriverManager.getDriver;

public final class GoogleHomePageTest extends BaseTest {

	@Test
	public void test1() {
		getDriver().findElement(By.name("q")).sendKeys("test", Keys.ENTER);
	}

	@Test
	public void test2() {
		getDriver().findElement(By.name("q")).sendKeys("automation", Keys.ENTER);
	}

}
