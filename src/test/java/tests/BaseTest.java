package tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import dataProviders.ConfigFileReader;
import managers.*;

public class BaseTest {
    private static WebDriver driver = DriverManager.getDriver();

    @Before
    public void launchApplication(){
        ConfigFileReader configFileReader = new ConfigFileReader();
        driver.get(configFileReader.getApplicationUrl());
    }

    @AfterClass
    public static void closeBrowser(){
        driver.close();
        driver.quit();
    }
}