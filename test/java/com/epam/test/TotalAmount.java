package com.epam.test;

import com.epam.bean.BusinessObject;
import com.epam.step.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by PC on 01.03.2017.
 */
public class TotalAmount {

    private Steps steps;


    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

/*    @Test
    public void checkTotalAmount()
    {
        BusinessObject businessObject = new BusinessObject();
        businessObject.setAirportDep("London (Luton), United Kingdom");
        businessObject.setAirporyArriv("Paris (Orly), France");

        Assert.assertTrue(steps.findSingleFlight(businessObject));
    }
*/    
    @Test
    public void checkPaymentAmount() {
    	
    	BusinessObject businessObject = new BusinessObject();
    	businessObject.setBookingNo("MF8C9R");
    	businessObject.setLastName("kukharau");
    	businessObject.setFlightDate("9 June 2016");
    	
    	steps.openMainPage();
    	steps.loginTransavia(businessObject);
    	
    	Assert.assertTrue(steps.checkPaymentAmount());
    }


    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
