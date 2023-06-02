package tests.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider
    public Object[][] dataProviderEmployee() {
            return new Object[][] {
                    {"Vladislav Olaru"},
                    {"Andrei Poleacov"},
                    {"Dima Socolovschi"},
                    {"Andrei Buzdugan"}
            };
    }
    @DataProvider
    public Object[][] dataProviderSearchIntranet() {
        return new Object[][] {
                {"JUMP"},
                {"GB"},
                {"SMS"}
        };
    }

    @DataProvider
    public Object[][] dataProviderSkills() {
        return new Object[][] {
                {"SALES"},
                {"JIRA"},
                {"MARKETING"}
        };
    }
}
