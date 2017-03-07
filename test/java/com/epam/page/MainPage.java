package com.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
	
	private final String BASE_URL = "https://www.transavia.com/en-NL/home/";
	
	@FindBy(xpath = "//a[text()='Log in']")
    private WebElement loginBtn;
	
	
	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnLoginBtn()
	{
		wait(loginBtn);
		loginBtn.click();
	}

	public void openPage()
	{
		driver.navigate().to(BASE_URL);
	}
	
}
