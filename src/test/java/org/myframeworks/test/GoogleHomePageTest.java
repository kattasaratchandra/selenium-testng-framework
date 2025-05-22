package org.myframeworks.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

import static org.myframeworks.driver.DriverManager.getDriver;

public final class GoogleHomePageTest extends BaseTest {

	@Test
	public void test1() {
		getDriver().findElement(By.name("q")).sendKeys("test", Keys.ENTER);
	}

	// I will update below test step by step and build framework
	@Test
	public void shouldValidateTitle() {
		getDriver().findElement(By.name("q")).sendKeys("testing mini bytes youtube", Keys.ENTER);
		String title = getDriver().getTitle();
		Assert.assertTrue(Objects.nonNull(title), "Title is null");
		Assert.assertTrue(title.toLowerCase().contains("google search"), "Title does not contain 'google search'");
		Assert.assertTrue(title.length() > 15, "Title length is less than 15");
		Assert.assertTrue(title.length() < 100, "Title length is greater than 100");
		List<WebElement> elements = getDriver().findElements(By.xpath("//h3"));
        Assert.assertEquals(elements.size(), 10, "Number of elements is not 10");
	}

}
