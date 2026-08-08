package pageobjects;

import org.openqa.selenium.By;

public class ElementsReference {

    public static final By SCOOTER_LOGO = By.xpath(".//img[@alt='Scooter']/parent::a");
    public static final By YANDEX_LOGO = By.xpath(".//img[@alt='Yandex']/parent::a");
    public static final By ORDER_BUTTON_TOP = By.xpath(".//div[contains(@class,'Header_Nav')]//button[text()='Заказать']");
    public static final By ORDER_BUTTON_BOTTOM = By.xpath(".//div[contains(@class,'Home_FinishButton')]//button[text()='Заказать']");
    public static final By STATUS_BUTTON = By.xpath(".//button[text()='Статус заказа']");
    public static final By ORDER_NUMBER_INPUT = By.xpath(".//input[@placeholder='Введите номер заказа']");
    public static final By GO_BUTTON = By.xpath(".//button[text()='Go!']");
    public static final By COOKIE_BUTTON = By.id("rcc-confirm-button");
    public static final By NAME_INPUT = By.xpath(".//input[@placeholder='* Имя']");
    public static final By SURNAME_INPUT = By.xpath(".//input[@placeholder='* Фамилия']");
    public static final By ADDRESS_INPUT = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    public static final By METRO_STATION_INPUT = By.xpath(".//input[@placeholder='* Станция метро']");
    public static final By PHONE_INPUT = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    public static final By NEXT_BUTTON = By.xpath(".//button[text()='Далее']");
    public static final By DELIVERY_DATE_INPUT = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    public static final By RENTAL_PERIOD_DROPDOWN = By.xpath(".//div[@class='Dropdown-placeholder']");
    public static final By BLACK_COLOR_CHECKBOX = By.id("black");
    public static final By GREY_COLOR_CHECKBOX = By.id("grey");
    public static final By COMMENT_INPUT = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    public static final By ORDER_BUTTON_FORM = By.xpath(".//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']");
    public static final By CONFIRM_YES_BUTTON = By.xpath(".//div[contains(@class,'Order_Modal')]//button[text()='Да']");
    public static final By ORDER_CREATED_HEADER = By.xpath(".//div[contains(@class,'Order_ModalHeader') and contains(text(),'Заказ оформлен')]");
    public static final By NAME_ERROR = By.xpath(".//div[contains(@class,'Input_ErrorMessage') and text()='Введите корректное имя']");
    public static final By SURNAME_ERROR = By.xpath(".//div[contains(@class,'Input_ErrorMessage') and text()='Введите корректную фамилию']");
    public static final By ADDRESS_ERROR = By.xpath(".//div[contains(@class,'Input_ErrorMessage') and text()='Введите корректный адрес']");
    public static final By PHONE_ERROR = By.xpath(".//div[contains(@class,'Input_ErrorMessage') and text()='Введите корректный номер']");
    public static final By NOT_FOUND_IMAGE = By.xpath(".//img[@alt='Not found']");
}