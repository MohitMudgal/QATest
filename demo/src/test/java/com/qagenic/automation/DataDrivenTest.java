package com.qagenic.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTest {

    private WebDriver driver;

    @BeforeClass
    public void setupSeleneiumTest(){
        driver = WebDriverManager.firefoxdriver().create();
    }

    @Test(dataProvider = "getMetals")
    public void testWikipediaSelenium(String serachTerm, String expectedResult){

        driver.get("https://www.wikipedia.com");

        driver.findElement(By.name("search")).sendKeys(serachTerm);

        driver.findElement(By.cssSelector("button.pure-button")).click();

        String headingText = driver.findElement(By.id("firstHeading")).getText();

        Assert.assertEquals(headingText, expectedResult, "The heading text is not correct");

        Reporter.log("The heading text is correct. Checked for " + serachTerm);

    }


    @DataProvider(name = "getMetals")
    public Object[][] fillDataForTest(){
        Object dataObj[][] = new Object[4][2];
        dataObj[0][0] = "Selenium";
        dataObj[0][1] = "Selenium";

        dataObj[1][0] = "Gold";
        dataObj[1][1] = "Diamond";

        dataObj[2][0] = "Silver";
        dataObj[2][1] = "Silver";

        dataObj[3][0] = "RRR";
        dataObj[3][1] = "RRR";

        return dataObj;

    }

    @AfterClass
    public void closeSeleniumTest(){
        driver.close();
    }

}
