package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.OrderPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderValidationErrorsTest extends WebTestBase {

    @Parameterized.Parameter(0) public String name;
    @Parameterized.Parameter(1) public String surname;
    @Parameterized.Parameter(2) public String address;
    @Parameterized.Parameter(3) public String phone;
    @Parameterized.Parameter(4) public String errorType;

    @Parameterized.Parameters(name = "Ошибка: {4}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"", "Петров", "ул. Ленина, 1", "+79161234567", "name"},
                {"Иван", "", "ул. Ленина, 1", "+79161234567", "surname"},
                {"Иван", "Петров", "+", "+79161234567", "address"},
                {"Иван", "Петров", "ул. Ленина, 1", "", "phone"},
        };
    }

    @Test
    public void testFieldValidationError() {
        homePage.clickOrderButtonTop();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.enterName(name).enterSurname(surname).enterAddress(address)
                .selectMetroStation("Сокольники").enterPhone(phone).clickNextButton();

        switch (errorType) {
            case "name":
                assertTrue("Ошибка валидации имени не появилась!", orderPage.isNameErrorDisplayed());
                break;
            case "surname":
                assertTrue("Ошибка валидации фамилии не появилась!", orderPage.isSurnameErrorDisplayed());
                break;
            case "address":
                assertTrue("Ошибка валидации адреса не появилась!", orderPage.isAddressErrorDisplayed());
                break;
            case "phone":
                assertTrue("Ошибка валидации телефона не появилась!", orderPage.isPhoneErrorDisplayed());
                break;
        }
    }
}