package tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScooterLogoNavigationTest extends WebTestBase {

    @Test
    public void testScooterLogoGoesToHomePage() {
        homePage.clickOrderButtonTop();
        homePage.clickScooterLogo();
        assertEquals("Не перешли на главную страницу!",
                "https://qa-scooter.praktikum-services.ru/", driver.getCurrentUrl());
    }
}