package pages.search;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver){
        super(driver);
    }

    private final By searchInfoText = By.xpath("//span[@class='text-info']");
    private final By cardCautaPeSait = By.xpath("//div[@class='search-result well']");
    private final By findCautaPeSait = By.xpath("//*[@href='#profile']");
    private final By inputCautaPeSait = By.id("searchtext");
    private final By alertingInfo = By.xpath("//div[@id='echipe']/div/span");
    private final By searchBtn = By.xpath("//i[@class='myicon25 myicon-search']");
    private final By inputAngajat = By.xpath("//*[@id='searchtext-ang']");
    private final By findEchipa = By.xpath("//*[@href='#echipe']");
    private final By inputEchipe = By.id("searchtext-div");
    private final By cardEchipe = By.xpath("//a[@class='dep-link']");
    private final By findAngajatBtn = By.xpath("//i[@class='glyphicon glyphicon-search']");
    private final By angajatCard = By.xpath("//div[@class='profile_hold ']");
    private final By checkStrangeCard = By.xpath("//div[@class='display-results']/tr/td");
    private final By cautaSkills = By.xpath("//*[@href='#skills']");
    private final By inputSkills = By.id("searchtext-skills");
    private final By angajatNameSkills = By.xpath("//div[@class='inside-profile pull-left']/p[1]/a");
    private final By skillsTab = By.xpath("//*[@href='#skills-tab']/i");
    private final By skillsGroup = By.xpath("//div[@id='skills-tab']/div/div/div");


    public SearchPage checkIfAtOnLessCardWithSkillsIsPresent(){

        waitElementIsVisible(driver.findElement(skillsGroup));

        boolean cardExist;
        int countCard = driver.findElements(skillsGroup).size();
        System.out.println("Number of founds cards is " + countCard);
        cardExist = countCard >= 1;

        Assert.assertTrue(cardExist,"The card after search is not present");

        return this;

    }

    public SearchPage checkIfAnySkillsHaveNecessaryKeyword(String str){

        waitElementIsVisible(driver.findElement(skillsGroup));

        boolean found = false;
        List<WebElement> elements = driver.findElements(skillsGroup);

        for (WebElement element : elements) {
            String elementText = element.getText();
            if (elementText.toLowerCase().contains(str.toLowerCase())) {
                found = true;
            }
        }

        Assert.assertTrue(found,"No card contains necessary keyword");

        return this;

    }

    public SearchPage clickSkillsTab(){

        waitElementIsVisible(driver.findElement(skillsTab));
        driver.findElement(skillsTab).click();

        return this;
    }

    public SearchPage clickSkillsAngajat(){

        waitElementIsVisible(driver.findElement(angajatNameSkills));

        driver.findElement(angajatNameSkills).click();

        return this;
    }

    public SearchPage sendSkills(String skill){

        waitElementIsVisible(driver.findElement(inputSkills));
        driver.findElement(inputSkills).sendKeys(skill);
        driver.findElement(inputSkills).sendKeys(Keys.ENTER);
        try {
            TimeUnit.SECONDS.sleep(3);//I used it because the element is visible,but it loads later
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return this;
    }

    public SearchPage clickSkillsBtn(){

        waitElementIsVisible(driver.findElement(cautaSkills));
        driver.findElement(cautaSkills).click();

        return this;
    }


    public SearchPage checkIfAnyCardHaveSentKeyword(String str){

        waitElementIsVisible(driver.findElement(cardCautaPeSait));

        boolean found = false;
        List<WebElement> elements = driver.findElements(cardCautaPeSait);

        for (WebElement element : elements) {
            String elementText = element.getText();
            if (elementText.toLowerCase().contains(str.toLowerCase())) {
                found = true;
                System.out.println("The element contains the keyword: " + elementText);
            }
        }

        Assert.assertTrue(found,"No card contains necessary keyword");

        return this;

    }

    public SearchPage checkIfSearchResultHaveSearchSentWord(String str){

    waitElementIsVisible(driver.findElement(searchInfoText));

    String cardText = driver.findElement(searchInfoText).getText();
    Assert.assertTrue(cardText.toLowerCase().contains(str.toLowerCase()), "The angajat name is not present in the founds card");

    return this;

    }

    public SearchPage checkIfNumberOfCautaPeSaitCardIsCorrect(){

        waitElementIsVisible(driver.findElement(cardCautaPeSait));

        int countCard = driver.findElements(cardCautaPeSait).size();
        System.out.println("Number of founds cards is " + countCard);
        Assert.assertEquals(countCard,12, "The card after search is not present");

        return this;

    }

    public SearchPage sendCautaPeSait(String str){

        waitElementIsVisible(driver.findElement(inputCautaPeSait));
        driver.findElement(inputCautaPeSait).sendKeys(str);
        driver.findElement(inputCautaPeSait).sendKeys(Keys.ENTER);

        return this;
    }

    public SearchPage clickCautaPeSaitBtn(){

        waitElementIsVisible(driver.findElement(findCautaPeSait));
        driver.findElement(findCautaPeSait).click();

        return this;
    }

    public  SearchPage checkIfNonExistentEchipeIsPresent(){

        waitElementIsVisible(driver.findElement(alertingInfo));

        String elementText = driver.findElement(alertingInfo).getText();
        Assert.assertEquals(elementText,"Nu au fost gasite rezultate dupa criteriile specificate");

        //Assert.assertTrue(elementText.toLowerCase().contains("Nu au fost gasite rezultate dupa criteriile specificate"), "The name of non existent teams is displayed");

        return this;
    }

    public SearchPage checkIfCardContainsEchipeName(String ech){

        waitElementIsVisible(driver.findElement(cardEchipe));

        String elementText = driver.findElement(cardEchipe).getText();
        Assert.assertTrue(elementText.toLowerCase().contains(ech.toLowerCase()), "The name of necessary team is not foundss in displayed card");

        return this;
    }

    public SearchPage checkCountEchipe(){

        waitElementIsVisible(driver.findElement(cardEchipe));

        boolean isElementDisplayed = driver.findElement(cardEchipe).isDisplayed();
        Assert.assertTrue(isElementDisplayed,"The card with any team is not display");

        return this;

    }

    public SearchPage clickEchipeBtn(){

        waitElementIsVisible(driver.findElement(findEchipa));
        driver.findElement(findEchipa).click();

        return this;
    }

    public SearchPage sendEchipeName(String ech){

        waitElementIsVisible(driver.findElement(inputEchipe));
        driver.findElement(inputEchipe).sendKeys(ech);
        driver.findElement(inputEchipe).sendKeys(Keys.chord(Keys.CONTROL, "e"));
        //driver.findElement(inputEchipe).sendKeys(Keys.chord(Keys.CONTROL, "e"));
        try {
            TimeUnit.SECONDS.sleep(3);  //I used it because the element is visible,but it loads later
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return this;
    }

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

    public  SearchPage clickFindAngajatBtn(){

        waitElementIsVisible(driver.findElement(findAngajatBtn));
        driver.findElement(findAngajatBtn).click();

        return this;
    }

    public SearchPage checkCountCard(){

        waitElementIsVisible(driver.findElement(angajatCard));

        int countCard = driver.findElements(angajatCard).size();
        System.out.println("Number of founds cards is " + countCard);
        Assert.assertEquals(countCard,1, "The card with angajat name is not present");

        return this;

    }

    public SearchPage checkIfTrueAngajatName(String ang){

        waitElementIsVisible(driver.findElement(angajatCard));

        String cardText = driver.findElement(angajatCard).getText();
        Assert.assertTrue(cardText.toLowerCase().contains(ang.toLowerCase()), "The angajat name is not present in the founds card");

        return this;
    }

    public SearchPage checkIfFindStrangerAngajat(){

        boolean isElementDisplayed = driver.findElement(checkStrangeCard).isDisplayed();

        Assert.assertTrue(isElementDisplayed,"The card with stranger angajat is displayed");

        return this;
    }

}
