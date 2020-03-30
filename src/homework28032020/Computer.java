package homework28032020;

import Utility.Util;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;


public class Computer extends Util {

    private String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {
        chromeBrowserDriver();
        implicitlyWaitSeconds(10);
        maximizeWindow();
        getMethod(baseUrl);
    }

    /*
    TEST - User should navigate to Computers page & Assert text "Computers"
     */
    @Test
    public void UserShouldNavigateToComputerPage() {

        clickOnElement(By.linkText("Computers"));

        String expectedTxt = "Computers";
        String actualTxt =  getTextFromElement(By.xpath("//div[@class='page-title']/h1 "));
        Assert.assertEquals(actualTxt, expectedTxt);

    }
    /*
    TEST - User should navigate to Computers page, select Build your own computer,
    select 400gb HDD option radio button, select Add to cart & Assert message "The product has been added to your shopping cart"
     */
    @Test
    public void addProductToShoppingCart() throws InterruptedException {

        clickOnElement(By.linkText("Computers"));

        //element for desktop
        clickOnElement(By.xpath("//li[@class='inactive']//a[@href='/desktops']"));
        sleepMethod(2000);

        //to scrool the page down
        windowScrollUpOrDown(0,-1800);
        sleepMethod(2000);

        //element for build your own computer
        clickOnElement(By.xpath("//h2[@class='product-title']/a[contains(text(),'Build your own computer')]"));

        //to scroll the page down
        windowScrollUpOrDown(0,-1800);
        sleepMethod(2000);

        //element for 400gb hdd hardriver radio button
        radioButtonClick(By.id("product_attribute_3_7"));

        //element for add to cart button
        clickOnElement(By.id("add-to-cart-button-1"));

        //element for message for add to cart
        String expectedMsg = "The product has been added to your shopping cart";
        String actualMsg = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(actualMsg, expectedMsg);
        sleepMethod(2000);
    }

    @After
    public void closeBrowser() throws InterruptedException {
        quitMethod();
    }

}
