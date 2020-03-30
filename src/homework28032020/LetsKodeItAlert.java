package homework28032020;

import Utility.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;


public class LetsKodeItAlert extends Util {

    private String baseUrl = "https://learn.letskodeit.com/";

    @Before
    public void openBrowser() {
        chromeBrowserDriver();
        implicitlyWaitSeconds(10);
        maximizeWindow();
        getMethod(baseUrl);
    }

    /*
    TEST - Select Practice link, scroll down and select Alert and accept alert.
        */
    @Test
    public void tackleAlert() throws InterruptedException {

        clickOnElement(By.linkText("Practice"));

        //to scroll the page down
        windowScrollUpOrDown(0,-1800);
        sleepMethod(2000);

        clickOnElement(By.id("alertbtn"));
        sleepMethod(2000);

        sleepMethod(2000);
        alertAccept();

    }

    @After
    public void closeBrowser() {
        quitMethod();
    }
}
