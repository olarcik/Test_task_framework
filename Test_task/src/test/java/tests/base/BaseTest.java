package tests.base;

import common.CommonAction;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import pages.base.BasePage;
import pages.search.SearchPage;
import pages.seat.SeatPage;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected SearchPage searchPage = new SearchPage(driver);
    protected SeatPage seatPage = new SeatPage(driver);


    @AfterSuite(alwaysRun = true)
    public void quite(){
        if(driver != null)
        driver.quit();}
}
