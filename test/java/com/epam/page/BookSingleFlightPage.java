package com.epam.page;

import com.epam.bean.BusinessObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class BookSingleFlightPage extends AbstractPage {

    private final String BASE_URL = "https://www.transavia.com/en-NL/home/";
    private String priceForOnePersonDep;
    private String priceForOnePersonArriv;
    private String addPriceForTicket;
    private String totalPrice;
    private BusinessObject businessObject;

    @FindBy(id = "routeSelection_DepartureStation-input")
    private WebElement departureInput;

    @FindBy(id = "routeSelection_ArrivalStation-input")
    private WebElement arrivalInput;

    @FindBy(id = "booking-passengers-input")
    private WebElement passengersInput;

    @FindBy(css = ".adults > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > button:nth-child(4)")
    private WebElement adultsAddButton;

    @FindBy(css = ".children > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > button:nth-child(4)")
    private WebElement childrenAddButton;

    @FindBy(css = "section.panel:nth-child(2) > div:nth-child(3) > div:nth-child(1) > button:nth-child(1)")
    private WebElement searchButton;

    @FindBy(id = "desktop")
    private WebElement form;

    @FindBy(css = ".close")
    private WebElement saveButton;

    @FindBy(css = "section.outbound > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(4) > button:nth-child(1)")
    private WebElement selectDepartureFlightButton;

    @FindBy(css = "section.inbound > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(4) > button:nth-child(1)")
    private WebElement selectArrivalFlightButton;

    @FindBy(css = "div.flight-result:nth-child(1) > button:nth-child(1) > div:nth-child(3) > div:nth-child(1)")
    private WebElement priceDepartureForOnePerson;

    @FindBy(css = "section.inbound > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > form:nth-child(1) > div:nth-child(4) > div:nth-child(1) > button:nth-child(1) > div:nth-child(3) > div:nth-child(1)")
    private WebElement priceArrivalForOnePerson;

    @FindBy(css = "button.button-primary:nth-child(3)")
    private WebElement nextButton;

    @FindBy(css = "th.th:nth-child(3)")
    private WebElement selectPlusTicket;

    @FindBy(css = "th.th:nth-child(3) > span:nth-child(2)")
    private WebElement priceForPlusTicketForOnePerson;

    @FindBy(css = ".back")
    private WebElement totalAmount;

//    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }


    public BookSingleFlightPage(WebDriver driver,BusinessObject businessObject) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        this.businessObject=businessObject;
    }

    public void fillBookForm() {
        wait(form);

        ((JavascriptExecutor) driver).executeScript("scroll(0,250)");

        wait(departureInput);

        departureInput.clear();
        departureInput.sendKeys(businessObject.getAirportDep());

        wait(arrivalInput);
        arrivalInput.clear();
        arrivalInput.sendKeys(businessObject.getAirporyArriv());

        wait(passengersInput);
        passengersInput.click();

        wait(adultsAddButton);
        adultsAddButton.click();

        childrenAddButton.click();

        saveButton.click();

        form.submit();

        wait(selectDepartureFlightButton);
        selectDepartureFlightButton.click();
        priceForOnePersonDep = priceDepartureForOnePerson.getText();
        ((JavascriptExecutor) driver).executeScript("scroll(0,550)");

        wait(selectArrivalFlightButton);
        selectArrivalFlightButton.click();


        priceForOnePersonArriv = priceArrivalForOnePerson.getText();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        nextButton.click();

        wait(selectPlusTicket);
        ((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
        wait(selectPlusTicket);
        selectPlusTicket.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addPriceForTicket = priceForPlusTicketForOnePerson.getText();
        totalPrice = totalAmount.getText();
    }

    private double parseStringPrice(String price) {
        StringBuilder sb = new StringBuilder(price);
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(sb);
        while (m.find()) {
            sb = new StringBuilder(sb.substring(m.start(), m.end()));
            break;
        }
        double number = Double.parseDouble(sb.toString());
        return number;
    }

    public boolean checkTotalPrice() {
        double priceDep = parseStringPrice(priceForOnePersonDep);
        double priceArriv = parseStringPrice(priceForOnePersonArriv);
        double extraAmount = parseStringPrice(addPriceForTicket);
        double expectTotAmount = parseStringPrice(totalPrice);
        double realTotalAmount = (priceDep + priceArriv) * 3 + extraAmount * 3;
        if (realTotalAmount == expectTotAmount) {
            return true;
        }
        return false;
    }
}
