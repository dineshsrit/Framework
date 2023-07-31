package org.selenium.pom.tests;

import org.selenium.pages.HomePage;
import org.selenium.pages.StorePage;
import org.selenium.pom.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void NavigateFromHometoStoreUsingMainMenu()
    {
        StorePage storePage= new HomePage(getDriver()).load().clickStoreMenuLink();

        Assert.assertEquals(storePage.getStoreTitle(), "Store" );


    }
}
