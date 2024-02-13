package com.targetMarket.utilities;

import com.targetMarket.pages.*;

public class Pages {

    private InarAcademyHomePage inarAcademyHomePage;

    private loginPage loginPage;

    private SmartPhonesPages smartPhonesPages;

    private TargetMarketHomePage targetMarketHomePage;

    private LaptopsPage laptopsPage;

    public Pages(){
        this.inarAcademyHomePage=new InarAcademyHomePage();
        this.loginPage=new loginPage();
        this.smartPhonesPages=new SmartPhonesPages();
        this.targetMarketHomePage=new TargetMarketHomePage();
        this.laptopsPage=new LaptopsPage();
    }

    public InarAcademyHomePage inarAcademyHomePage(){
        return inarAcademyHomePage;
    }
    public loginPage loginPage(){
        return loginPage;
    }
   public SmartPhonesPages smartPhonesPages(){
        return smartPhonesPages;
   }

   public TargetMarketHomePage targetMarketHomePage(){
        return targetMarketHomePage;
   }

   public LaptopsPage laptopsPage(){
        return laptopsPage;
   }

}
