package com.epam.step;

import com.epam.bean.BusinessObject;
import com.epam.page.BookSingleFlightPage;
import com.epam.page.BookingDetailsPage;
import com.epam.page.BookingOverviewPage;
import com.epam.page.LoginPage;
import com.epam.page.MainPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.epam.driver.DriverSingleton;

public class Steps
{
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver()
	{
		driver.quit();
	}
	
	public void openMainPage() {

		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		
	}
	
	public void loginTransavia(BusinessObject bo) {

		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnLoginBtn();
		
		LoginPage loginPage = new LoginPage(driver, bo);
		loginPage.login(bo);
	}
	
	
	
	public boolean findSingleFlight(BusinessObject businessObject){
		BookSingleFlightPage findSingleFlight = new BookSingleFlightPage(driver,businessObject);
		findSingleFlight.openPage();
		findSingleFlight.fillBookForm();
		return findSingleFlight.checkTotalPrice();
	}
	
	public boolean checkTotalTicketsSum(){
		return false;
	}
	
	public boolean checkArrivalTime(){
		return false;		
	}
	
	public boolean checkPaymentAmount(){
		
		BookingOverviewPage bookingOverviewPage = new BookingOverviewPage(driver);
		bookingOverviewPage.openBookingDetailsPage();
		
		BookingDetailsPage bookingDetailsPage = new BookingDetailsPage(driver);
		String paymentAmountSum = bookingDetailsPage.getPaymentAmountSum();
		String totalAmountSum = bookingDetailsPage.getTotalAmountSum();
		return paymentAmountSum.equals(totalAmountSum);
	}
	
	public boolean checkNonExistentFlight(){
		return false;		
	}
	
	public boolean checkConnectionFlight(){
		return false;		
	}
	
	
}