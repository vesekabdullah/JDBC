package com.targetMarket.step_definitions;

import com.targetMarket.utilities.DBUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SmartPhones_step_defs extends BaseStep{
    public ResultSet resultSetForTotalDiscountOfSmartPhones;
    public ResultSet resultSetForTotalPriceOfSmartPhones;
    @When("user clicks on smartPhones button")
    public void userClicksOnLaptopsButton() throws InterruptedException {
        pages.targetMarketHomePage().clickOnCategory(2);
    }
    @When("execute query for total price for smartPhones")
    public void executeQueryForTotalPriceForSmartPhones() throws SQLException {
        resultSetForTotalPriceOfSmartPhones= DBUtils.executeQuery("select SUM(Price) as TotalPrice from SmartPhones");
    }

    @Then("user checks the total price of smartPhones")
    public void userChecksTheTotalPriceOfSmartPhones() throws SQLException {
        while (resultSetForTotalPriceOfSmartPhones.next()) {
            Assert.assertEquals(Integer.parseInt(resultSetForTotalPriceOfSmartPhones.getString("totalprice")), pages.smartPhonesPages().getTotalPriceAmountOfSmartPhones());
        }
    }

    @When("execute query for total discount amount of smartPhones")
    public void executeQueryForTotalDiscountAmountOfSmartPhones() throws SQLException {
        resultSetForTotalDiscountOfSmartPhones=DBUtils.executeQuery("select SUM(Discount) as TotalDiscount from SmartPhones");

    }
    @When("user checks total discount amount of smartPhones")
    public void userChecksTotalDiscountAmountOfSmartPhones() throws SQLException {
        while (resultSetForTotalDiscountOfSmartPhones.next()) {
            Assert.assertEquals(Integer.parseInt(resultSetForTotalDiscountOfSmartPhones.getString("totaldiscount")), pages.smartPhonesPages().getTotalDiscountAmountOfSmartPhones());
        }
    }











}
