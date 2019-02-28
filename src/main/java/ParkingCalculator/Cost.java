package ParkingCalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Cost {
    WebDriver webDriver;

    By text;
    By price = By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/span[1]");


    public Cost(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void checkPrice() {
        WebElement priceNum = webDriver.findElement(price);
        Assert.assertEquals(priceNum.getText(),"$ 2.00","One hour of parking for \"Long-Term Surface Parking\" lot type does not costs 2$.");
    }
}
