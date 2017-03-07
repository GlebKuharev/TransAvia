package com.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingOverviewPage extends AbstractPage {
	
	public BookingOverviewPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(css = "div.HV-gu--bp0--x3-3:nth-child(3) > a:nth-child(1)")
    private WebElement bookingDetailsBtn;
	
	
	
	
	public void openBookingDetailsPage() {
		wait(bookingDetailsBtn);
		bookingDetailsBtn.click();
	}


/*	@Override
	public void openPage() {
		// TODO Auto-generated method stub
		
	}
*/
}
