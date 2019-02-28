package ParkingCalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChooseLeavingDateAndTime {
    WebDriver webDriver;

    By exitDate = By.id("ExitDate");
    By exitTime = By.id("ExitTime");
    By meridian;


    public ChooseLeavingDateAndTime(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setDate(String value) {
        WebElement setDate = webDriver.findElement(exitDate);
        setDate.clear();
        setDate.sendKeys(value);
    }

    public void setTime(String value) {
        WebElement setTime = webDriver.findElement(exitTime);
        setTime.clear();
        setTime.sendKeys(value);
    }
}
