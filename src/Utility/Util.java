package Utility;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toList;

public class Util {

    public WebDriver driver;
    private JavascriptExecutor js;


    public void chromeBrowserDriver() {
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            driver = new ChromeDriver();
    }


    public void fireFoxBrowserDriver() {
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
            driver = new FirefoxDriver();
    }


    public void operaBrowserDriver() {
            System.setProperty("webdriver.opera.driver","drivers/operadriver.exe");
            driver = new OperaDriver();
    }


    public void implicitlyWaitSeconds(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }


    public void maximizeWindow() {
        driver.manage().window().maximize();
    }


    public void getMethod(String string) {
        driver.get(string);
    }


    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }
    public void clickOnElement(WebElement element) {
        element.click();
    }


    public void sendTextToElement(By by, String string) {
        driver.findElement(by).sendKeys(string);
    }
    public void sendTextToElement(WebElement element, String string) {
        element.sendKeys();
    }


    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
    public String getTextFromElement(WebElement element) {
        return element.getText();
    }


    public void getSizeFromElement(By by) {
        driver.findElement(by).getSize();
    }
    public void getSizeFromElement(WebElement element) {
        element.getSize();
    }


    public void mouseHover(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }
    public void mouseHover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    public void mouseHoverClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().perform();
    }
    public void mouseHoverClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }


    public void selectByIndexFromDropDown(By by, int index) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }
    public void selectByIndexFromDropDown(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }


    public void selectByVisibleTextFromDropDown(By by, String string) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(string);
    }
    public void selectByVisibleTextFromDropDown(WebElement element, String string) {
        Select select = new Select(element);
        select.selectByVisibleText(string);
    }


    public void selectByValueFromDropDown(By by, String string) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(string);
    }
    public void selectByValueFromDropDown(WebElement element, String string) {
        Select select = new Select(element);
        select.selectByValue(string);
    }


    public void radioButtonClick(By by) {
        driver.findElement(by).click();
    }
    public void radioButtonClick(WebElement element){
        element.click();
    }
    public void radioButtonIsSelected(By by) {
        driver.findElement(by).isSelected();
    }
    public void radioButtonIsSelected(WebElement element) {
        element.isSelected();
    }
    public void radioButtonIsDisplayed(By by) {
        driver.findElement(by).isDisplayed();
    }
    public void radioButtonIsDisplayed(WebElement element) {
        element.isDisplayed();
    }
    public void radioButtonIsEnabled(By by){
        driver.findElement(by).isEnabled();
    }
    public void radioButtonIsEnabled(WebElement element){
        element.isEnabled();
    }


    public void checkBoxClick(By by) {
        driver.findElement(by).click();
    }
    public void checkBoxClick(WebElement element) {
        element.click();
    }
    public void checkBoxIsSelected(By by) {
        driver.findElement(by).isSelected();
    }
    public void checkBoxIsSelected(WebElement element) {
        element.isSelected();
    }
    public void checkBoxIsEnabled(By by) {
        driver.findElement(by).isEnabled();
    }
    public void checkBoxIsEnabled(WebElement element) {
        element.isEnabled();
    }
    public void checkBoxIsDisplayed(By by) {
        driver.findElement(by).isDisplayed();
    }
    public void checkBoxIsDisplayed(WebElement element) {
        element.isDisplayed();
    }


    public void alertAccept() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void alertDismiss() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public void alertGetText() {
        Alert alert = driver.switchTo().alert();
        alert.getText();
    }
    public void alertSendText(String string) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(string);
    }

    public void arrayListForEachLoopAssertEqualsForString(By by) {

        List<String> originalList = new ArrayList<>();

        List<WebElement> storedList = driver.findElements(by);

        for (WebElement element : storedList) {
            originalList.add(element.getText());
        }

        List<String> tempList = new ArrayList<>();
        tempList.addAll(originalList);
        System.out.println("Expected result: "+originalList);
        Collections.sort(tempList);
        System.out.println("Actual result: "+tempList);
        Assert.assertEquals(originalList, tempList);
    }


    public void arrayListForEachLoopAssertEqualsForInt(By by){

        List<WebElement> elements = driver.findElements(by);
        // "elements" is a WebElement so sout will print all the Html text from console from the webpage
        // System.out.println(elements);

        List<String> webSortedPrices = elements.stream().map(WebElement::getText).collect(toList());
        System.out.println("Expected result: "+webSortedPrices);

        List<String> mySortedPrices = new ArrayList<>();
        for (WebElement element : elements) {
            String text = element.getText();
            mySortedPrices.add(text);
        }
        System.out.println("Actual result: "+mySortedPrices);

        //mySortedPrices.sort(Comparator.comparingInt(s -> Integer.valueOf(s)));
        Assert.assertEquals(webSortedPrices,mySortedPrices);
    }

    public void sleepMethod(int millisec) throws InterruptedException {
        Thread.sleep(millisec);
    }

    public void windowScrollUpOrDown(int x, int y){
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+","+y+");");
    }

    public void closeMethod() {
        driver.close();
    }


    public void quitMethod() {
        driver.quit();
    }


}
