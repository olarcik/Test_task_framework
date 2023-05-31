package pages.seat;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;


public class SeatPage extends BasePage {

    String formattedDate;

    public SeatPage(WebDriver driver){
        super(driver);
    }
    private final By openBookings = By.xpath("//a[contains(text(),'OPEN BOOKINGS')]");
    private final By openZTower = By.xpath("//span[contains(text(),'ZTower')]");
    private final By openOrangeKitchen = By.xpath("//b[contains(text(),'Orange')]");
    private final By bookingPlace = By.cssSelector(".alias-K7\\.100 > g:nth-child(1) > g:nth-child(1) > rect");
    private final By bookBtn = By.xpath("//button[contains(text(), 'book')]");
    //private final By cancelBtn = By.xpath("//button[contains(text(), 'cancel')]");
    private final By btnNext = By.xpath("//span[@class='icon next']");
    //private final By btnWithNextSaturday = By.xpath("//*[contains(@class, 'flatpickr-day active day-off') and contains(text(), '"+formattedDate+"')]");
    private final By checkedBox = By.xpath("//*[@title='Vladislav Olaru']");
    public SeatPage clickOpenBookingsBtn(){

        waitElementIsVisible(driver.findElement(openBookings));
        driver.findElement(openBookings).click();

        return this;
    }

    public SeatPage clickOpenZTowerBtn(){

        waitElementIsVisible(driver.findElement(openZTower));
        driver.findElement(openZTower).click();

        return this;
    }

    public SeatPage clickOpenOrangeKitchenBtn(){

        waitElementIsVisible(driver.findElement(openOrangeKitchen));
        driver.findElement(openOrangeKitchen).click();

        return this;
    }

    public SeatPage clickToNextWeekBtn(){

        waitElementIsVisible(driver.findElement(btnNext));
        driver.findElement(btnNext).click();

        return this;
    }
    public SeatPage clickToNeccesaryDate(String book){

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
           formattedDate = dateFormat.format(calendar.getTime());

           if (formattedDate.startsWith("0")) {
            formattedDate = formattedDate.substring(1);
        }


           waitElementIsVisible(driver.findElement(By.xpath("//*[contains(@class, 'flatpickr-day "+ book +"active day-off') and contains(text(), '"+formattedDate+"')]")));
           driver.findElement(By.xpath("//*[contains(@class, 'flatpickr-day "+ book +"active day-off') and contains(text(), '"+formattedDate+"')]")).click();

        return this;
    }

    public SeatPage clickToGetPlaceBtn(){

        waitElementIsVisible(driver.findElement(bookingPlace));
        driver.findElement(bookingPlace).click();

        return this;
    }


    public SeatPage clickToBookBtn(){

        waitElementIsClickable(driver.findElement(bookBtn));
        driver.findElement(bookBtn).click();

        driver.navigate().refresh();

        return this;
    }

    public SeatPage assertResultAfterBookingPlace(){

        waitElementIsVisible(driver.findElement(bookingPlace));
        WebElement element = driver.findElement(checkedBox);
        boolean isVisible = element.isDisplayed();

        Assert.assertTrue(isVisible,"The booking failed");

        /*int countCancelBtn = driver.findElements(cancelBtn).size();
        Assert.assertEquals(countCancelBtn,1, "The booking failed")*/

        return this;
    }


}
