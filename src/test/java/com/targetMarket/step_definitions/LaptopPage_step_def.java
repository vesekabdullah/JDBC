package com.targetMarket.step_definitions;

import com.targetMarket.utilities.ConfigurationReader;
import com.targetMarket.utilities.DBUtils;
import com.targetMarket.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;


public class LaptopPage_step_def extends BaseStep{


public ResultSet resultSetForTotalDiscountOfLaptops;
public ResultSet resultSetForTotalPriceOfLaptops;


    @Given("user lands on Inar Academy home page")
    public void userLandsOnHomePage() {
        String URL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
        System.out.println("Open ::" + URL);

    }

    @When("user clicks on Target Market button")
    public void userClicksOnTargetMarketButton() {
    pages.inarAcademyHomePage().clickOnTargetMarketButton();
    }

    @When("user clicks on laptops button")
    public void userClicksOnLaptopsButton() throws InterruptedException {
        pages.targetMarketHomePage().clickOnCategory(3);
    }

    @When("create connection with database")
    public void createConnectionWithDatabase() {
        DBUtils.createConnection();
    }

    @When("execute query for total price for laptops")
    public void executeQueryForTotalPriceForLaptops() throws SQLException {

        resultSetForTotalPriceOfLaptops=DBUtils.executeQuery("select SUM(Price) as TotalPrice from Laptops");
    }



    @When("execute query for total discount amount of laptops")
    public void executeQueryForTotalDiscountAmountOfLaptops() throws SQLException {
        resultSetForTotalDiscountOfLaptops=DBUtils.executeQuery("select SUM(Discount) as TotalDiscount from Laptops");

    }
    @When("user checks total discount amount of laptops")
    public void userChecksTotalDiscountAmountOfLaptops() throws SQLException {
        while (resultSetForTotalDiscountOfLaptops.next()) {
            Assert.assertEquals(Integer.parseInt(resultSetForTotalDiscountOfLaptops.getString("totaldiscount")), pages.laptopsPage().getTotalDiscountAmountOfLaptops());
        }
    }

    @When("destroy the connection")
    public void destroyTheConnection() throws SQLException {
        DBUtils.destroy();
    }

    @Then("user checks the total price of laptops")
    public void userChecksTheTotalPriceOfLaptops() throws SQLException {
        while (resultSetForTotalPriceOfLaptops.next()) {
            Assert.assertEquals(Integer.parseInt(resultSetForTotalPriceOfLaptops.getString("totalprice")), pages.laptopsPage().getTotalPriceAmountOfLaptops());
        }
    }

    @Then("user close window")
    public void userCloseWindow() {

        Driver.getDriver().close();
    }


    @When("user enter name to nameBox")
    public void userEnterNameToNameBox() {
        pages.loginPage().sendNameToUserNameBox("standard_user");

    }

    @When("user enter password to passwordBox")
    public void userEnterPasswordToPasswordBox() {
        pages.loginPage().sendPasswordToPasswordBox("secret_password");
    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() throws InterruptedException {
        pages.loginPage().clickOnLoginButton();
        Thread.sleep(3000);
    }
}

