package com.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by PC on 03.03.2017.
 */
public abstract class AbstractPage {
    protected WebDriver driver;

//    public abstract void openPage();

    public AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }

    protected void wait(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
