package com.targetMarket.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InarAcademyHomePage extends BasePage {

@FindBy(xpath = "//a[normalize-space()='Target Market']")
    WebElement targetMarketButton;

public void clickOnTargetMarketButton(){
    targetMarketButton.click();
}
}
