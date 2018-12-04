package com.company;

import org.junit.jupiter.api.*;

public class StandardTest extends BaseTest {
    private final String COMPANY_NAME = "QA Ground";
    private final String EMAIL = "karamfilovs@gmail.com";
    private final String PASSWORD = "123456";

    @BeforeEach
    public void login() {
        //Move all login steps here to avoid duplication
    }


    @Test
    @DisplayName("Can login successfully")
    @Tag("high")
    public void canLoginSuccessfullyWithValidCredentials() {
        inv.loginPage().gotoPage();
        Assertions.assertEquals(inv.loginPage().getCompanyName(), COMPANY_NAME);
        inv.loginPage().enterEmail(EMAIL);
        inv.loginPage().enterPassword(PASSWORD);
        inv.loginPage().clickLoginButton();
        Assertions.assertEquals(inv.homePage().getUserPanelText(), EMAIL);
    }

    @Test
    @DisplayName("Can logout successfully")
    @Tag("high")
    public void canLogoutSuccessfully() {
        inv.loginPage().gotoPage();
        Assertions.assertEquals(inv.loginPage().getCompanyName(), COMPANY_NAME);
        inv.loginPage().enterEmail(EMAIL);
        inv.loginPage().enterPassword(PASSWORD);
        inv.loginPage().clickLoginButton();
        Assertions.assertEquals(inv.homePage().getUserPanelText(), EMAIL);
        inv.homePage().clickLogoutLink();
        Assertions.assertEquals(inv.loginPage().getCompanyName(), COMPANY_NAME);
    }

    @Test
    public void canNavigateToHomePageViaHeader() {
        inv.loginPage().gotoPage();
        Assertions.assertEquals(inv.loginPage().getCompanyName(), COMPANY_NAME);
        inv.loginPage().enterEmail(EMAIL);
        inv.loginPage().enterPassword(PASSWORD);
        inv.loginPage().clickLoginButton();
        Assertions.assertEquals(inv.homePage().getUserPanelText(), EMAIL);
        inv.homePage().clickCompanyLogo();
        Assertions.assertEquals(inv.homePage().getUserPanelText(), EMAIL);
    }


    @Test
    public void canNavigateToItemsPage() {
        inv.loginPage().gotoPage();
        Assertions.assertEquals(inv.loginPage().getCompanyName(), COMPANY_NAME);
        inv.loginPage().enterEmail(EMAIL);
        inv.loginPage().enterPassword(PASSWORD);
        inv.loginPage().clickLoginButton();
        Assertions.assertEquals(inv.homePage().getUserPanelText(), EMAIL);
        inv.itemsPage().clickItemsLink();
        Assertions.assertEquals(inv.itemsPage().getHeadlineText(), "Артикули");
    }
}
