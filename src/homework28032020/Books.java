package homework28032020;

import Utility.Util;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class Books extends Util {

    private String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {
        chromeBrowserDriver();
        implicitlyWaitSeconds(10);
        maximizeWindow();
        getMethod(baseUrl);
    }

    /*
    TEST - User to navigate to Books page and Assert text "Books"
        */
    @Test
    public void userNavigateToBookPageSuccessfully() throws InterruptedException {

        mouseHoverClick(By.xpath("//ul[@class='top-menu notmobile']//li[5]/a"));
        sleepMethod(2000);

        String actualTxt = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        String expectedTxt = "Books";
        Assert.assertEquals(actualTxt, expectedTxt);
    }

    /*
    TEST - Navigate to Books page, select sortBy Name AtoZ, Assert the list of all products to verify
    if products are sortedBy AtoZ or not
     */
    @Test
    public void booksArrangedInAscendingOrderAtoZ() throws InterruptedException {

        //WebElement Books Link
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//li[5]/a"));

        //WebElement Position dropdown box
        selectByIndexFromDropDown(By.cssSelector("select#products-orderby"),1);
        sleepMethod(2000);

        //Scroll down page
        windowScrollUpOrDown(0,500);
        sleepMethod(2000);

        arrayListForEachLoopAssertEqualsForString(By.xpath("//div[@class='product-grid']//h2/a"));

    }

    /*
    TEST - Select Books link, add the first book listed when results on page are sortBy AtoZ
    to wishlist and Assert message displayed to verify the action
    "The product has been added to your wishlist"
     */
    @Test
    public void bookAddedToWishlistSuccessfully() throws InterruptedException {
        //WebElement Books Link
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//li[5]/a"));

        //WebElement Position dropdown box
        selectByIndexFromDropDown(By.cssSelector("select#products-orderby"),1);

        //Scroll down page
        windowScrollUpOrDown(0,500);
        sleepMethod(2000);

        //WebElement for wishlist button
        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[3]"));

        String expectedTxt = "The product has been added to your wishlist";
        String actualTxt = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedTxt, actualTxt);
    }

    @After
    public void closeBrowser() {
        quitMethod();
    }
}
