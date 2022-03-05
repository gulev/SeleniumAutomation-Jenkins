package com.practice.webpages;

import managers.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ProductDetailsPage {
    static final Logger logger = Logger.getLogger(SearchResultPage.class);
    protected WebDriver driver;

    @FindBy(id = "short_description_block")
    protected WebElement productShortDescription;

    @FindBy(id = "add_to_cart")
    protected WebElement addToCardButton;

    public ProductDetailsPage(){
        driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    public boolean isShortDescriptionExists() {
        logger.info("getting description....");
        return productShortDescription.getText().length() > 0;
    }

    public boolean isAddToCardButtonExist(){
        return addToCardButton.isDisplayed();
    }
}