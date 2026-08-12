package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By orderButtonTop = By.xpath(".//div[contains(@class,'Header_Nav')]//button[text()='Заказать']");
    private By orderButtonBottom = By.xpath(".//div[contains(@class,'Home_FinishButton')]//button[text()='Заказать']");
    private By cookieButton = By.id("rcc-confirm-button");
    private By scooterLogo = By.xpath(".//img[@alt='Scooter']/parent::a");
    private By yandexLogo = By.xpath(".//img[@alt='Yandex']/parent::a");
    private By statusButton = By.xpath(".//button[text()='Статус заказа']");
    private By orderNumberInput = By.xpath(".//input[@placeholder='Введите номер заказа']");
    private By goButton = By.xpath(".//button[text()='Go!']");
    private By notFoundImage = By.xpath(".//img[@alt='Not found']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By questionHeading(int index) {
        return By.xpath("(//div[contains(@class,'accordion__item')]//div[@role='button'])[" + (index + 1) + "]");
    }

    private By answerPanel(int index) {
        return By.xpath("(//div[contains(@class,'accordion__item')]//p)[" + (index + 1) + "]");
    }

    public HomePage open() {
        driver.get("https://qa-scooter.praktikum-services.ru");
        return this;
    }

    public HomePage acceptCookies() {
        try {
            WebElement cookie = wait.until(ExpectedConditions.presenceOfElementLocated(cookieButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cookie);
        } catch (Exception e) {
            // куки не появились
        }
        return this;
    }

    public HomePage clickQuestion(int index) {
        wait.until(ExpectedConditions.elementToBeClickable(questionHeading(index))).click();
        return this;
    }

    public String getAnswerText(int index) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(answerPanel(index)));
        return driver.findElement(answerPanel(index)).getText();
    }

    public OrderPage clickOrderButtonTop() {
        wait.until(ExpectedConditions.elementToBeClickable(orderButtonTop)).click();
        return new OrderPage(driver);
    }

    public OrderPage clickOrderButtonBottom() {
        wait.until(ExpectedConditions.elementToBeClickable(orderButtonBottom)).click();
        return new OrderPage(driver);
    }

    public HomePage clickScooterLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(scooterLogo)).click();
        return this;
    }

    public void clickYandexLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(yandexLogo)).click();
    }

    public HomePage clickStatusButton() {
        wait.until(ExpectedConditions.elementToBeClickable(statusButton)).click();
        return this;
    }

    public HomePage enterOrderNumber(String number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderNumberInput)).sendKeys(number);
        return this;
    }

    public HomePage clickGoButton() {
        wait.until(ExpectedConditions.elementToBeClickable(goButton)).click();
        return this;
    }

    public String getAnswerAfterClick(int index) {
        clickQuestion(index);
        return getAnswerText(index);
    }

    public boolean isNotFoundImageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(notFoundImage)).isDisplayed();
    }
}