package com.qagenic.automation;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {

    private WebDriver driver;

    @Before
    public void setupSeleneiumTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testWikipedia(){

        driver.get("https://www.wikipedia.com");

        driver.findElement(By.name("search")).sendKeys("Selenium");

        driver.findElement(By.cssSelector("button.pure-button")).click();

        String headingText = driver.findElement(By.id("firstHeading")).getText();

        assertEquals("Selenium", headingText);

    }

    @Test
    public void testMainPageLink(){
        
    }

    @After
    public void closeSeleniumTest(){
        driver.close();
    }

}
