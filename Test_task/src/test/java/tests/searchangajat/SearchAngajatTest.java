package tests.searchangajat;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.dataprovider.DataProviderClass;
import static common.Config.*;

public class SearchAngajatTest extends BaseTest {

    @Test(dataProvider = "dataProviderSkills", dataProviderClass = DataProviderClass.class)
    public void checkIfAtOnLessCardWithSkillsIsPresent(String skill){

        basePage.open(PAGE_LINK);

        searchPage
                .clickSearchBtn()
                .clickSkillsBtn()
                .sendSkills(skill)//KEY_WORD_FOR_CAUTA_PE_SAIT
                .clickSkillsAngajat()
                .clickSkillsTab()
                .checkIfAtOnLessCardWithSkillsIsPresent();
    }
    @Test(dataProvider = "dataProviderSkills", dataProviderClass = DataProviderClass.class)
    public void checkIfFoundAngajatAndIfContainsNecessarySkill(String skill){

        basePage.open(PAGE_LINK);

        searchPage
                .clickSearchBtn()
                .clickSkillsBtn()
                .sendSkills(skill)//KEY_WORD_FOR_CAUTA_PE_SAIT
                .clickSkillsAngajat()
                .clickSkillsTab()
                .checkIfAnySkillsHaveNecessaryKeyword(skill);//KEY_WORD_FOR_CAUTA_PE_SAIT
    }
    @Test(dataProvider = "dataProviderSearchIntranet", dataProviderClass = DataProviderClass.class)
    public void checkIfAnyCardHaveNecessaryKeyword(String keyword){

        basePage.open(PAGE_LINK);

        searchPage
                .clickSearchBtn()
                .clickCautaPeSaitBtn()
                .sendCautaPeSait(keyword) //SECOND_KEY_WORD_FOR_CAUTA_PE_SAIT
                .checkIfAnyCardHaveSentKeyword(keyword);//SECOND_KEY_WORD_FOR_CAUTA_PE_SAIT
    }
    @Test(dataProvider = "dataProviderSearchIntranet", dataProviderClass = DataProviderClass.class)
    public void checkIfSearchResultIsCorrect(String keyword){

        basePage.open(PAGE_LINK);

        searchPage
                .clickSearchBtn()
                .clickCautaPeSaitBtn()
                .sendCautaPeSait(keyword)
                .checkIfSearchResultHaveSearchSentWord(keyword);
    }
    @Test
    public void checkIfAppearTrueNumberOfCards(){

        basePage.open(PAGE_LINK);

        searchPage
                .clickSearchBtn()
                .clickCautaPeSaitBtn()
                .sendCautaPeSait(KEY_WORD_FOR_CAUTA_PE_SAIT)
                .checkIfNumberOfCautaPeSaitCardIsCorrect();
    }
    @Test(dataProvider = "dataProviderEmployee", dataProviderClass = DataProviderClass.class)
    public void checkSearchNameOfAngajat(String name){

        basePage.open(PAGE_LINK);

        searchPage
                .clickSearchBtn()
                .sendAngajatName(name)
                .clickFindAngajatBtn()
                .checkCountCard()
                .checkIfTrueAngajatName(name); //ANGAJAT_NAME
    }
    @Test
    public void checkSearchStrangerAngajat(){

        basePage.open(PAGE_LINK);

        searchPage
                .clickSearchBtn()
                .sendAngajatName(ANGAJAT_STRANGER)
                .clickFindAngajatBtn()
                .checkIfFindStrangerAngajat();
    }
    @Test
    public void checkSearchAnyEchipe(){

        basePage.open(PAGE_LINK);

        searchPage
                .clickSearchBtn()
                .clickEchipeBtn()
                .sendEchipeName(ECHIPA_NAME)
                .checkCountEchipe();
    }
    @Test
    public void checkSearchNecessaryEchipe(){

        basePage.open(PAGE_LINK);

        searchPage
                .clickSearchBtn()
                .clickEchipeBtn()
                .sendEchipeName(ECHIPA_NAME)
                .checkIfCardContainsEchipeName(ECHIPA_NAME);
    }
    @Test
    public void checkIfNonExistentEchipeIsDisplayed(){

        basePage.open(PAGE_LINK);

        searchPage
                .clickSearchBtn()
                .clickEchipeBtn()
                .sendEchipeName(ECHIPA_NAME_SECOND)
                .checkIfNonExistentEchipeIsPresent();
    }

}
