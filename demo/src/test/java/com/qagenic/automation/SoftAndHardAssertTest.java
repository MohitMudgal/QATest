package com.qagenic.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAndHardAssertTest {

    private WebDriver driver;
    private SoftAssert softassert;

    @BeforeClass
    public void setupSeleneiumTest() {
        driver = WebDriverManager.chromedriver().create();
        softassert = new SoftAssert();
    }

    @Test
    public void testWikipediaSelenium() {

        driver.get("https://www.wikipedia.com");

        String englishtext = driver.findElement(By.cssSelector("#js-link-box-en")).getText();

        softassert.assertTrue(englishtext.contains("French"));

        driver.findElement(By.name("search")).sendKeys("Selenium");

        driver.findElement(By.cssSelector("button.pure-button")).click();

        String headingText = driver.findElement(By.id("firstHeading")).getText();

        softassert.assertEquals("Silver", headingText);

    }

    @AfterClass
    public void closeSeleniumTest() {
        softassert.assertAll();

        driver.close();
    }

}
