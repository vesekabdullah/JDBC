package com.targetMarket.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LaptopsPage extends BasePage{

    ArrayList<String> laptopsPrices =new ArrayList<>();
    ArrayList<String> laptopsDiscounts =new ArrayList<>();

    ArrayList<String>justDiscount=new ArrayList<>();
    ArrayList<String>justPrices=new ArrayList<>();
    int totalDiscountOfLaptops = 0;
    int totalPriceOfLaptops = 0;
   

    @FindBy(css=".text-danger > i")
    List<WebElement>priceList;

    @FindBy(css = ".d-inline-flex.badge.bg-success.w-auto")
    List<WebElement>discountList;


    public List<String> getLaptopsPriceList(){
        for ( WebElement e : priceList)
            laptopsPrices.add(e.getText());
        return laptopsPrices;
    }
    public List<String> getLaptopsDiscountList(){
        for ( WebElement e : discountList)
            laptopsDiscounts.add(e.getText());
        return laptopsDiscounts;
    }

    public int getTotalDiscountAmountOfLaptops(){
        getLaptopsDiscountList();

        for (String e : laptopsDiscounts)
            if (e.length()==8) {
                justDiscount.add(e.substring(2, 4));
            }
        else {
                justDiscount.add(e.substring(2, 3));
            }
        for (String e :justDiscount)
            totalDiscountOfLaptops+=Integer.parseInt(e);

           return totalDiscountOfLaptops;

    }


public int getTotalPriceAmountOfLaptops(){
getLaptopsPriceList();

    for (String e : laptopsPrices)
        justPrices.add(e.substring(1));

    for (String e :justPrices)
        totalPriceOfLaptops+=Integer.parseInt(e);

    return totalPriceOfLaptops;

}

}
