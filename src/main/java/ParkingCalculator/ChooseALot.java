package ParkingCalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class ChooseALot{

    WebDriver webDriver;
    Select chooseLot;
    By submit = By.name("Submit");

    public ChooseALot(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void chooseLotFromDropDown(String index) {
        chooseLot = new Select(webDriver.findElement(By.id("Lot")));
        chooseLot.selectByValue(index);
    }

    public void pressCalculate() {
        webDriver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        WebElement calculate = webDriver.findElement(submit);
        calculate.click();

    }

}
