package ParkingCalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChooseEntryDateAndTime {
    WebDriver webDriver;

    By entryDate = By.id("EntryDate");
    By entryTime = By.id("EntryTime");
    By meridian;

    public ChooseEntryDateAndTime(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setDate(String value) {
        WebElement setDate = webDriver.findElement(entryDate);
        setDate.clear();
        setDate.sendKeys(value);
    }

    public void setTime(String value) {
        WebElement setTime = webDriver.findElement(entryTime);
        setTime.clear();
        setTime.sendKeys(value);
    }

}
