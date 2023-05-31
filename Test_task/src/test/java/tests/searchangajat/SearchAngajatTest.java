package tests.searchangajat;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static common.Config.ANGAJAT_NAME;
import static common.Config.PAGE_LINK;

public class SearchAngajatTest extends BaseTest {

    @Test
    public void checkSearchNameOfAngajat(){

        basePage.open(PAGE_LINK);

        searchPage
                .clickSearchBtn()
                .sendAngajatName(ANGAJAT_NAME)
                .clickFintAngajatBtn()
                .checkCountCard()
                .checkIfTrueAngajatName(ANGAJAT_NAME);
    }

}
