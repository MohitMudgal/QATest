package com.qagenic.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {

    private WebDriver driver;

    @BeforeClass
    public void setupSeleneiumTest(){
        driver = WebDriverManager.firefoxdriver().create();
    }

    @Test
    public void testWikipedia(){

        driver.get("https://www.wikipedia.com");

        driver.findElement(By.name("search")).sendKeys("Selenium");

        driver.findElement(By.cssSelector("button.pure-button")).click();

        String headingText = driver.findElement(By.id("firstHeading")).getText();

        Assert.assertEquals("Selenium", headingText);

    }

    @Test
    public void testMainPageLink(){
        driver.get("https://www.wikipedia.com");

        driver.findElement(By.name("search")).sendKeys("Gold");

        driver.findElement(By.cssSelector("button.pure-button")).click();

        String headingText = driver.findElement(By.id("firstHeading")).getText();

        Assert.assertEquals("Gold", headingText);
    }

    @AfterClass
    public void closeSeleniumTest(){
        driver.close();
    }

}
