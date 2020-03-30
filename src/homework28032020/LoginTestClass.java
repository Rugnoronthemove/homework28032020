package homework28032020;


import Utility.Util;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class LoginTestClass extends Util {

    private String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {
        chromeBrowserDriver();
        implicitlyWaitSeconds(10);
        maximizeWindow();
        getMethod(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfully() throws InterruptedException {
        clickOnElement(By.xpath("//a[@class='ico-login']"));
        sleepMethod(2000);

        String expectedMsg = "Returning Customer";
        String actualMsg = getTextFromElement(By.xpath("//Strong[text()='Returning Customer']"));
        Assert.assertEquals(expectedMsg, actualMsg);
        sleepMethod(2000);

        sendTextToElement(By.id("Email"), "xyz@gmail.com");
        sleepMethod(2000);

        sendTextToElement(By.name("Password"), "abc123");
        sleepMethod(2000);

        clickOnElement(By.id("RememberMe"));
        sleepMethod(2000);

        clickOnElement(By.xpath("//div[@class='buttons']//input[@class='button-1 login-button']"));
        sleepMethod(2000);

        String expectedTxt = "My account";
        String actualTxt = getTextFromElement(By.linkText("My account"));
        Assert.assertEquals(expectedTxt, actualTxt);
        sleepMethod(2000);
    }

    @After
    public void closeBrowser() {
        quitMethod();
    }
}





