package org.myframeworks.test;

import org.myframworks.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class GoogleHomePageTest extends BaseTest {

	@Test
	public void test1() {
		Driver.driver.findElement(By.name("q")).sendKeys("test", Keys.ENTER);
	}

	@Test
	public void test2() {
		Driver.driver.findElement(By.name("q")).sendKeys("automation", Keys.ENTER);
	}

}
