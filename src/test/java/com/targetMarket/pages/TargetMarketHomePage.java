package com.targetMarket.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TargetMarketHomePage extends BasePage{

    @FindBy(css = "#splide02-list > li")
    private List<WebElement> productCategorySlide;

    public void clickOnCategory(int index) throws InterruptedException {
        executeJavaScript("window.scroll(0,500)");
        productCategorySlide.get(index - 1).click();
    }

}
