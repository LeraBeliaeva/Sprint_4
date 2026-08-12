package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By nameInput = By.xpath(".//input[@placeholder='* Имя']");
    private By surnameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroStationInput = By.xpath(".//input[@placeholder='* Станция метро']");
    private By phoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[text()='Далее']");

    private By deliveryDateInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By rentalPeriodDropdown = By.xpath(".//div[@class='Dropdown-placeholder']");
    private By blackColorCheckbox = By.id("black");
    private By greyColorCheckbox = By.id("grey");
    private By commentInput = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By orderButton = By.xpath(".//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']");

    private By confirmYesButton = By.xpath(".//div[contains(@class,'Order_Modal')]//button[text()='Да']");
    private By orderCreatedHeader = By.xpath(".//div[contains(@class,'Order_ModalHeader') and contains(text(),'Заказ оформлен')]");

    private By nameError = By.xpath(".//div[contains(@class,'Input_ErrorMessage') and text()='Введите корректное имя']");
    private By surnameError = By.xpath(".//div[contains(@class,'Input_ErrorMessage') and text()='Введите корректную фамилию']");
    private By addressError = By.xpath(".//div[contains(@class,'Input_ErrorMessage') and text()='Введите корректный адрес']");
    private By phoneError = By.xpath(".//div[contains(@class,'Input_ErrorMessage') and text()='Введите корректный номер']");


    public boolean isNameErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nameError)).isDisplayed();
    }

    public boolean isSurnameErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(surnameError)).isDisplayed();
    }

    public boolean isAddressErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addressError)).isDisplayed();
    }

    public boolean isPhoneErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneError)).isDisplayed();
    }

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public OrderPage enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput)).sendKeys(name);
        return this;
    }

    public OrderPage enterSurname(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
        return this;
    }

    public OrderPage enterAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
        return this;
    }

    public OrderPage selectMetroStation(String stationName) {
        driver.findElement(metroStationInput).click();
        driver.findElement(metroStationInput).sendKeys(stationName);
        By stationOption = By.xpath(".//li[contains(@class,'select-search__row')]//*[text()='" + stationName + "']");
        wait.until(ExpectedConditions.elementToBeClickable(stationOption)).click();
        return this;
    }

    public OrderPage enterPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
        return this;
    }

    public OrderPage clickNextButton() {
        driver.findElement(nextButton).click();
        return this;
    }

    public OrderPage enterDeliveryDate(String date) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryDateInput));
        driver.findElement(deliveryDateInput).sendKeys(date);
        driver.findElement(deliveryDateInput).sendKeys(Keys.ENTER);
        return this;
    }

    public OrderPage selectRentalPeriod(String period) {
        driver.findElement(rentalPeriodDropdown).click();
        By periodOption = By.xpath(".//div[contains(@class,'Dropdown-option') and text()='" + period + "']");
        wait.until(ExpectedConditions.elementToBeClickable(periodOption)).click();
        return this;
    }

    public OrderPage selectBlackColor() {
        driver.findElement(blackColorCheckbox).click();
        return this;
    }

    public OrderPage selectGreyColor() {
        driver.findElement(greyColorCheckbox).click();
        return this;
    }

    public OrderPage enterComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
        return this;
    }

    public OrderPage clickOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(orderButton)).click();
        return this;
    }

    public OrderPage confirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton)).click();
        return this;
    }

    public boolean isOrderCreated() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderCreatedHeader)).isDisplayed();
    }
}