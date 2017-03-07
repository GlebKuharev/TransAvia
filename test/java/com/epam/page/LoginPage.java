package com.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.bean.BusinessObject;

public class LoginPage extends AbstractPage {
	
//	private BusinessObject businessObject;


	public LoginPage(WebDriver driver, BusinessObject bo)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
//		this.businessObject=bo;
	}
	
	@FindBy(id = "retrieveBookingByLastname_RecordLocator")
    private WebElement bookingNoFld;
	
	@FindBy(id = "retrieveBookingByLastname_LastName")
    private WebElement lastNameFld;
	
	@FindBy(id = "retrieveBookingByLastname_FlightDate-datepicker")
    private WebElement flightDateFld;

	@FindBy(css = ".datepicker-trigger")
	private WebElement calendar;
	
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[5]/a")
    private WebElement calendarChoose;
	
	@FindBy(xpath = "//button[text()='View booking']")
    private WebElement viewBookingBtn;
	
	@FindBy(id="access-booking")
	private WebElement form;
	
	
	public void login(BusinessObject bo)
	{
		wait(bookingNoFld);
		bookingNoFld.sendKeys(bo.getBookingNo());
		wait(lastNameFld);
		lastNameFld.sendKeys(bo.getLastName());
		wait(flightDateFld);
		flightDateFld.sendKeys(bo.getFlightDate());
		
		calendar.click();
		wait(calendarChoose);
		calendarChoose.click();
		
		form.submit();
	}


/*	@Override
	public void openPage() {
		// TODO Auto-generated method stub
		
	}*/

}
