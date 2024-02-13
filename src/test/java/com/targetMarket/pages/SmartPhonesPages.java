package com.targetMarket.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SmartPhonesPages extends BasePage{

    ArrayList<String> smartPhonesPrices =new ArrayList<>();
    ArrayList<String> smartPhonesDiscounts =new ArrayList<>();

    ArrayList<String>justDiscount=new ArrayList<>();
    ArrayList<String>justPrices=new ArrayList<>();



    int totalPriceOfSmartPhones=0;

    int totalDiscountOfSmartPhones;


    @FindBy(css=".text-danger > i")
    List<WebElement>priceList;

    @FindBy(css = ".d-inline-flex.badge.bg-success.w-auto")
    List<WebElement>discountList;

    public List<String> getSmartPhonesPriceList(){
        for ( WebElement e : priceList)
            smartPhonesPrices.add(e.getText());
        return smartPhonesPrices;
    }
    public List<String> getSmartPhonesDiscountList(){
        for ( WebElement e : discountList)
            smartPhonesDiscounts.add(e.getText());
        return smartPhonesDiscounts;
    }

    public int getTotalDiscountAmountOfSmartPhones(){
        getSmartPhonesDiscountList();

        for (String e : smartPhonesDiscounts)
            justDiscount.add(e.substring(2,4));

        for (String e :justDiscount)
            totalDiscountOfSmartPhones+=Integer.parseInt(e);

        return totalDiscountOfSmartPhones;

    }

    public int getTotalPriceAmountOfSmartPhones(){
        getSmartPhonesPriceList();
        for (String e : smartPhonesPrices)
            justPrices.add(e.substring(1));

        for (String e :justPrices)
            totalPriceOfSmartPhones+=Integer.parseInt(e);

        return totalPriceOfSmartPhones;

    }
}
