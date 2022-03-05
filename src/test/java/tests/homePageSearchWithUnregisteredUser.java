package tests;

import com.practice.webpages.BasePage;
import com.practice.webpages.ProductDetailsPage;
import org.junit.Assert;
import org.junit.Test;
import com.practice.webpages.SearchResultPage;

public class homePageSearchWithUnregisteredUser extends BaseTest {

    @Test
    public void UsingEnter(){
        String searchCriteria = "Printed";
        String returnedItems = "5";
        BasePage basePage = new BasePage();
        SearchResultPage searchResultPage = new SearchResultPage();
        basePage.emptySearchField();
        basePage.searchAndPressEnter(searchCriteria);
        Assert.assertEquals(returnedItems, searchResultPage.getReturnedItems());
    }

    @Test
    public  void UsingSearchButton(){
        String searchCriteria = "Printed";
        String returnedItems = "5";
        BasePage basePage = new BasePage();
        SearchResultPage searchResultPage = new SearchResultPage();
        basePage.emptySearchField();
        basePage.enterTextInSearchField(searchCriteria);
        basePage.clickSearchButton();
        Assert.assertEquals(returnedItems, searchResultPage.getReturnedItems());
    }

    @Test
    public  void ForNonExistingItem(){
        String searchCriteria = "Pats";
        String returnedItems = "0";
        BasePage basePage = new BasePage();
        SearchResultPage searchResultPage = new SearchResultPage();
        basePage.emptySearchField();
        basePage.searchAndPressEnter(searchCriteria);
        Assert.assertEquals(returnedItems, searchResultPage.getReturnedItems());
        Assert.assertTrue(searchResultPage.isSearchResultEmpty(searchCriteria));
    }

    @Test
    public  void WithEmptyCriteria(){
        String resultsNumber  = "0";
        BasePage basePage = new BasePage();
        SearchResultPage searchResultPage = new SearchResultPage();
        basePage.emptySearchField();
        basePage.searchAndPressEnter(""); //String.EMPTY
        Assert.assertEquals(resultsNumber, searchResultPage.getReturnedItems());
        Assert.assertTrue(searchResultPage.isSearchInvalid());
    }

    @Test
    public  void ForElementsThatAppearInAutoCompleteAndClickOnOne(){
        String searchCriteria = "dress";
        BasePage basePage = new BasePage();
        basePage.emptySearchField();
        basePage.enterValueInSearchField(searchCriteria);
        Assert.assertTrue(basePage.isAutoCompleteDisplayed ());
        basePage.clickElementFromAutoComplete(1);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        Assert.assertTrue(productDetailsPage.isShortDescriptionExists());
        Assert.assertTrue(productDetailsPage.isAddToCardButtonExist());
    }
}