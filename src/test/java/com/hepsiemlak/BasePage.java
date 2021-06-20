package com.hepsiemlak;

import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;


public class BasePage extends Base {
    WebElement webElement = null;

    public void switchToWindow() {
        webDriver.switchTo().window("https://www.hepsiemlak.com/");
    }

    public WebElement webElementiBul(String value) {
        WebElement element = webDriver.findElement(By.xpath(value));
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", element);
        return webElement;
    }

    public String webElementTextAl(String value) {
        webElement = webElementiBul(value);
        return webElement.getText();
    }


    public void webElementineGonder(String value, String sendingValue) {
        WebElement element = webDriver.findElement(By.xpath(value));
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", element);
        List<MobileElement> els5 = webDriver.findElementsByXPath(value);
        els5.get(0).sendKeys(sendingValue);
    }

    public void webElementControl(String expected, String actual) {
        Assert.assertEquals(expected, actual);
    }

    public void webelementiBekle(int i) throws InterruptedException {
        Thread.sleep(i * 1000);
    }

    public void webElementiBuluncaTikla(String webelement) {
        WebElement element = webDriver.findElement(By.xpath(webelement));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void webElementDropDown(String value, int key) {
        Select dropdown = new Select(webDriver.findElement(By.xpath(value)));
        dropdown.selectByIndex(key);
    }

    public void moveToElement(String value) {
        webElement = (new WebDriverWait(webDriver, 30))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
        webElement.click();
        Actions move = new Actions(webDriver);
        move.moveToElement(webElement).clickAndHold();
        move.moveByOffset(-250, 0);
        move.release();
        move.build();
        move.perform();

    }

    public void isValidPhoneNumb(String number) {
        Pattern pattern = Pattern.compile("(([\\+]90?)|([0]?))([ ]?)((\\([0-9]{3}\\))|([0-9]{3}))([ ]?)([0-9]{3})(\\s*[\\-]?)([0-9]{2})(\\s*[\\-]?)([0-9]{2})");
        Matcher matcher = pattern.matcher(number);
        assertTrue(matcher.matches());
        System.out.println("Phone number is valid.");
    }
}
