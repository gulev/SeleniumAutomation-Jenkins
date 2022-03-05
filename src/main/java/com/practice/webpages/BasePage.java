package com.practice.webpages;

import managers.DriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

public class BasePage {
    static final Logger logger = Logger.getLogger(BasePage.class);
    protected static WebDriver driver;

    @FindBy(className = "search_query")
    protected WebElement searchTextBox;

    @FindBy(className = "login")
    protected WebElement loginLink;

    @FindBy(name = "submit_search")
    protected WebElement submitSearchButton;

    @FindBy(className = "ac_results")
    protected WebElement autoCompleteResults;

    @FindBy(css = ".ac_even:first-child")
    protected WebElement firstAutoCompleteElement;

    @FindBy(css = ".ac_even:nth-child(2)")
    protected WebElement secondAutoCompleteElement;

    @FindBy(css = ".ac_even:nth-child(3)")
    protected WebElement thirdAutoCompleteElement;

    @FindBy(css = ".ac_even:nth-child(4)")
    protected WebElement fourthAutoCompleteElement;

    @FindBy(css = ".ac_even:nth-child(5)")
    protected WebElement fifthAutoCompleteElement;

    @FindBy(css = ".ac_even:nth-child(6)")
    protected WebElement sixthAutoCompleteElement;



    public BasePage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void searchAndPressEnter(String query) {
        logger.info("searching....");
        searchTextBox.sendKeys(query + Keys.ENTER);
    }

    public void emptySearchField() {
        logger.info("emptying....");
        searchTextBox.clear();
    }

    public void enterTextInSearchField(String query) {
        logger.info("entering text in search field....");
        searchTextBox.sendKeys(query);
    }

    public void clickSearchButton() {
        logger.info("clicking search button....");
        submitSearchButton.click();
    }

    public boolean isUserLogged() {
        String loginText = loginLink.getText();
        logger.info("IS USER LOGGED" + loginText);
        return (loginText.contains("Sign in")) ? false : true;
    }

    public void enterValueInSearchField(String query) {
        logger.info("entering value is the search field....");
        searchTextBox.sendKeys(query);
    }

    public boolean isAutoCompleteDisplayed() {
        logger.info("autocomplete is...");
        return autoCompleteResults.isDisplayed();
    }

    public void clickElementFromAutoComplete(int elementSeqNumber) {
        logger.info("clicking first element..." + firstAutoCompleteElement.getText());
        if(elementSeqNumber == 1){
            firstAutoCompleteElement.click();
        }else if(elementSeqNumber == 2){
            secondAutoCompleteElement.click();
        }else if(elementSeqNumber == 3){
            thirdAutoCompleteElement.click();
        }else if(elementSeqNumber == 4){
            fourthAutoCompleteElement.click();
        }else if(elementSeqNumber == 5){
            fifthAutoCompleteElement.click();
        }else if(elementSeqNumber == 6){
            sixthAutoCompleteElement.click();
        }
    }
}
