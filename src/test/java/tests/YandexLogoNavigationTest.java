package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.HomePage;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class YandexLogoNavigationTest {
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
    public void testYandexLogoOpensNewTab() {
        homePage.clickYandexLogo();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("ya.ru"));
        assertTrue("Не перешли на главную страницу Яндекса!", driver.getCurrentUrl().contains("ya.ru"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}