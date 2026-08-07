package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.HomePage;
import pageobjects.OrderPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class PositiveOrderTest {
    private WebDriver driver;
    private HomePage homePage;

    @Parameterized.Parameter(0) public String name;
    @Parameterized.Parameter(1) public String surname;
    @Parameterized.Parameter(2) public String address;
    @Parameterized.Parameter(3) public String metroStation;
    @Parameterized.Parameter(4) public String phone;
    @Parameterized.Parameter(5) public String deliveryDate;
    @Parameterized.Parameter(6) public String rentalPeriod;
    @Parameterized.Parameter(7) public String color;
    @Parameterized.Parameter(8) public String comment;
    @Parameterized.Parameter(9) public String buttonType;

    @Parameterized.Parameters(name = "Заказ: {0} {1}, кнопка: {9}, цвет: {7}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Иван", "Петров", "ул. Ленина, 1", "Сокольники", "+79161234567",
                        "10.08.2026", "трое суток", "black", "Позвоните за час", "top"},
                {"Мария", "Смирнова", "ул. Пушкина, 10", "Университет", "89031234567",
                        "12.08.2026", "пятеро суток", "grey", "", "bottom"},
        };
    }

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
    public void testPositiveOrderScenario() {
        OrderPage orderPage;
        if ("top".equals(buttonType)) {
            orderPage = homePage.clickOrderButtonTop();
        } else {
            orderPage = homePage.clickOrderButtonBottom();
        }

        orderPage.enterName(name).enterSurname(surname).enterAddress(address)
                .selectMetroStation(metroStation).enterPhone(phone).clickNextButton();

        orderPage.enterDeliveryDate(deliveryDate);
        orderPage.selectRentalPeriod(rentalPeriod);

        if ("black".equals(color)) {
            orderPage.selectBlackColor();
        } else {
            orderPage.selectGreyColor();
        }

        if (comment != null && !comment.isEmpty()) {
            orderPage.enterComment(comment);
        }

        orderPage.clickOrderButton();
        orderPage.confirmOrder();

        assertTrue("Заказ не был оформлен!", orderPage.isOrderCreated());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
