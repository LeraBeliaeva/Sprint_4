package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.HomePage;

import static org.junit.Assert.assertEquals;

public class ScooterLogoNavigationTest {
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
        homePage.open().acceptCookies();
    }

    @Test
    public void testScooterLogoGoesToHomePage() {
        homePage.clickOrderButtonTop();
        homePage.clickScooterLogo();
        assertEquals("Не перешли на главную страницу!",
                "https://qa-scooter.praktikum-services.ru/", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}