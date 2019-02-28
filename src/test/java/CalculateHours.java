import ParkingCalculator.ChooseALot;
import ParkingCalculator.ChooseEntryDateAndTime;
import ParkingCalculator.ChooseLeavingDateAndTime;
import ParkingCalculator.Cost;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculateHours {
    private static final String BASE_URL = "http://adam.goucher.ca/parkcalc/index.php";
    // drop down choices
    private static final String SHORT_TERM_PARKING = "STP";
    private static final String ECONOMY_PARKING = "EP";
    private static final String LONG_TERM_STATE_PARKING = "LTS";
    private static final String LONG_TERM_GARAGE_PARKING = "LTG";
    private static final String VALET_PARKING = "VP";


    WebDriver webDriver;

    ChooseALot lot;
    ChooseEntryDateAndTime entryDateAndTime;
    ChooseLeavingDateAndTime leavingDateAndTime;
    Cost cost;

    @BeforeSuite
    public void setup() {
        // sets environment for selenium web-driver
        System.setProperty("webdriver.chrome.driver", "C:\\Projects\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @BeforeTest
    public void init() {
        // opens the specified url
        webDriver.get(BASE_URL);
        lot = new ChooseALot(webDriver);
        cost = new Cost(webDriver);
        entryDateAndTime = new ChooseEntryDateAndTime(webDriver);
        leavingDateAndTime = new ChooseLeavingDateAndTime(webDriver);

    }

    @Test (groups = "positive")
    public void validatePrice_OneHourParking_ForLongTermSurfaceParking() {

        // filling fields
        lot.chooseLotFromDropDown(LONG_TERM_STATE_PARKING);
        entryDateAndTime.setTime("15:00");
        entryDateAndTime.setDate("2/28/2019");
        leavingDateAndTime.setTime("16:00");
        leavingDateAndTime.setDate("2/28/2019");

        lot.pressCalculate();
        cost.checkPrice();
    }

    @AfterSuite
    public void closeBrowser() {
        webDriver.close();
    }

}
