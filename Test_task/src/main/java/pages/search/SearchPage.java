package pages.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver){
        super(driver);
    }
    private final By searchBtn = By.xpath("//i[@class='myicon25 myicon-search']");
    private final By inputAngajat = By.xpath("//*[@id='searchtext-ang']");
    private final By findAngajatBtn = By.xpath("//i[@class='glyphicon glyphicon-search']");
    private final  By angajatCard = By.xpath("//div[@class='profile_hold ']");

    public SearchPage clickSearchBtn(){

        waitElementIsVisible(driver.findElement(searchBtn));
        driver.findElement(searchBtn).click();

        return this;
    }

    public SearchPage sendAngajatName(String ang){

        waitElementIsVisible(driver.findElement(inputAngajat));
        driver.findElement(inputAngajat).sendKeys(ang);

        return this;
    }

    public  SearchPage clickFintAngajatBtn(){

        waitElementIsVisible(driver.findElement(findAngajatBtn));
        driver.findElement(findAngajatBtn).click();

        return this;
    }

    public SearchPage checkCountCard(){

        waitElementIsVisible(driver.findElement(angajatCard));

        int countCard = driver.findElements(angajatCard).size();
        System.out.println("Number of finded cards is " + countCard);
        Assert.assertEquals(countCard,1, "The card with angajat name is not present");

        return this;

    }

    public SearchPage checkIfTrueAngajatName(String ang){

        waitElementIsVisible(driver.findElement(angajatCard));

        String cardText = driver.findElement(angajatCard).getText();
        Assert.assertTrue(cardText.toLowerCase().contains(ang.toLowerCase()), "The angajat name is not present in the finded card");

        return this;
    }

}
