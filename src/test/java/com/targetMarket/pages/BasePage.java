package com.targetMarket.pages;

import com.targetMarket.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20) );
    public Actions actions = new Actions(Driver.getDriver());
    private JavascriptExecutor js = (JavascriptExecutor) driver;

    public void executeJavaScript(String script) {
        js.executeScript(script);
    }

    public void scrollDownWithPageDown() throws InterruptedException {
        actions.keyDown(Keys.PAGE_DOWN).release().build().perform();
        wait(1);
    }

    public void scrollUpWithPageUp() throws InterruptedException {
        actions.keyDown(Keys.PAGE_UP).release().build().perform();
        wait(1);
    }

    public BasePage(){
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

}
