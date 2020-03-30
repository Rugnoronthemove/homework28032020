package homework28032020;

import Utility.Util;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RegistrationTestClass extends Util {

    private String baseUrl = "https://demo.nopcommerce.com/";


    @Before
    public void openBrowser() {
        chromeBrowserDriver();
        implicitlyWaitSeconds(10);
        maximizeWindow();
        getMethod(baseUrl);
    }

/*
Test Case 1 User should navigate to register page successfully.
Click on Register Link
Message   “Your Personal Details“
Assert above message.
*/

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        clickOnElement(By.xpath("//div[@class='header-links-wrapper']//a[contains(text(),'Register')]"));
        sleepMethod(2000);

        String expectedText = "Your Personal Details";
        String actualText = getTextFromElement(By.xpath("//div[@class='page-body']//strong[text()='Your Personal Details']"));
        Assert.assertEquals(expectedText, actualText);
    }

/*
Test Case 2 User should register successfully.
Click on Register
Enter correct details in field
Click on register  button.
Expected Result:
Success Message  “Your registration completed”
Assert above message.
*/

    @Test
    public void userShouldRegisterSuccessfully() throws InterruptedException {

        clickOnElement(By.xpath("//div[@class='header-links-wrapper']//a[contains(text(),'Register')]"));
        sleepMethod(2000);

        radioButtonClick(By.xpath("//input[@id='gender-male']"));

        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Hemal");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Sheth");
        sleepMethod(2000);

        selectByValueFromDropDown(By.xpath("//select[@name='DateOfBirthDay']"), "5");
        sleepMethod(2000);

        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"), "February");
        sleepMethod(2000);

        selectByIndexFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"), 85);

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        sendTextToElement(By.xpath("//input[@id='Email']"), "xyz" + randomInt + "@gmail.com");
        sleepMethod(2000);

        sendTextToElement(By.xpath("//input[@id='Company'] "), "Square1");
        sleepMethod(2000);

        checkBoxIsEnabled(By.cssSelector("input#Newsletter"));
        sleepMethod(2000);

        sendTextToElement(By.xpath("//input[@id='Password']"), "abc123");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "abc123");
        sleepMethod(2000);

        clickOnElement(By.xpath("//input[@id='register-button']"));

        String expectedText = "Your registration completed";
        String actualText = getTextFromElement(By.xpath("//div[@class='master-wrapper-content']//div[text()='Your registration completed']"));
        Assert.assertEquals(expectedText, actualText);
        sleepMethod(2000);
    }

    @After
    public void closeBrowser() throws InterruptedException {
        quitMethod();
    }

}




