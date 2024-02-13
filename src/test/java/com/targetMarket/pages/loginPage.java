package com.targetMarket.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage{
    @FindBy(id = "login-username-input")
    WebElement userNameBox;

    @FindBy(id="login-password-input")
    WebElement passwordBox;

    @FindBy(id = "login-button")
    WebElement loginButton;

    public void sendNameToUserNameBox(String name){
        userNameBox.sendKeys(name);
    }

public void sendPasswordToPasswordBox(String password){
        passwordBox.sendKeys(password);
}
public void clickOnLoginButton(){
        loginButton.click();
    }

}
