package homework28032020;

import Utility.Util;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class Electronics extends Util {

    private String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {
        chromeBrowserDriver();
        implicitlyWaitSeconds(10);
        maximizeWindow();
        getMethod(baseUrl);
    }

    /*
    TEST - Mousehover on Electronics, then on Camera & Photo, select Camera & Photo
     and Assert text "Camera & Photo"
     */
    @Test
    public void UserShouldNavigateToElectronicsPage() {

        mouseHover(By.linkText("Electronics"));

        mouseHoverClick(By.linkText("Camera & photo"));

        String expectedTxt = "Camera & photo";
        String actualTxt = getTextFromElement(By.linkText("Camera & photo"));
        Assert.assertEquals(expectedTxt, actualTxt);
    }

    /*
    TEST - Mousehover on Electronics, MouseHover and then select Camera & Photo, sortBy
    Low To High, Assert if the Products displayed after sortBy has products
     arranged in Ascending price order.
     */
    @Test
    public void sortPriceLowToHigh() throws InterruptedException {

        mouseHover(By.linkText("Electronics"));

        mouseHoverClick(By.linkText("Camera & photo"));

        selectByIndexFromDropDown(By.id("products-orderby"),3);
        sleepMethod(2000);

        windowScrollUpOrDown(0,500);
        sleepMethod(2000);

        arrayListForEachLoopAssertEqualsForInt(By.className("prices"));
        sleepMethod(2000);
    }

    @After
    public void closeBrowser() {
        quitMethod();
    }
}

