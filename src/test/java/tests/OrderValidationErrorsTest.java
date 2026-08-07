package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.HomePage;
import pageobjects.OrderPage;

import static org.junit.Assert.assertTrue;

public class OrderValidationErrorsTest {
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
        homePage.clickOrderButtonTop();
    }

    @Test
    public void testNameFieldValidationError() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.enterName("").enterSurname("Петров").enterAddress("ул. Ленина, 1")
                .selectMetroStation("Сокольники").enterPhone("+79161234567").clickNextButton();
        assertTrue("Ошибка валидации имени не появилась!", orderPage.isNameErrorDisplayed());
    }

    @Test
    public void testSurnameFieldValidationError() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.enterName("Иван").enterSurname("").enterAddress("ул. Ленина, 1")
                .selectMetroStation("Сокольники").enterPhone("+79161234567").clickNextButton();
        assertTrue("Ошибка валидации фамилии не появилась!", orderPage.isSurnameErrorDisplayed());
    }

    @Test
    public void testAddressFieldValidationError() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.enterName("Иван").enterSurname("Петров").enterAddress("+")
                .selectMetroStation("Сокольники").enterPhone("+79161234567").clickNextButton();
        assertTrue("Ошибка валидации адреса не появилась!", orderPage.isAddressErrorDisplayed());
    }

    @Test
    public void testPhoneFieldValidationError() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.enterName("Иван").enterSurname("Петров").enterAddress("ул. Ленина, 1")
                .selectMetroStation("Сокольники").enterPhone("").clickNextButton();
        assertTrue("Ошибка валидации телефона не появилась!", orderPage.isPhoneErrorDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}