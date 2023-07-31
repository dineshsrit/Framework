package org.selenium.pom.tests;

import org.selenium.pages.StorePage;
import org.selenium.pom.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchWithPartialMatch()
    {
        String search="blue";
        StorePage storePage= new StorePage(getDriver()).load().search(search);
        Assert.assertEquals(storePage.getTitle(), "Search results: “blue”" );
    }
}
