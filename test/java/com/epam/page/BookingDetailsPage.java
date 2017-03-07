package com.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingDetailsPage extends AbstractPage {

	public BookingDetailsPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(css = ".front")
    private WebElement totalAmountSum;
	
	@FindBy(css = ".details-list--header > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")
    private WebElement paymentAmountSum;

	
	public String getTotalAmountSum() {
		wait(totalAmountSum);
		return (totalAmountSum.getText());
	}
	
	
	public String getPaymentAmountSum() {
		wait(paymentAmountSum);
		return (paymentAmountSum.getText());
	}
	
	
/*	@Override
	public void openPage() {
		// TODO Auto-generated method stub
		
	}*/
}
