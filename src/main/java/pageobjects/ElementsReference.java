package pageobjects;

public class ElementsReference {

    // Логотип "Самокат"
    // By.xpath(".//img[@alt='Scooter']/parent::a")

    // Логотип Яндекса
    // By.xpath(".//img[@alt='Yandex']/parent::a")

    // Кнопка "Заказать" (верхняя)
    // By.xpath(".//div[contains(@class,'Header_Nav')]//button[text()='Заказать']")

    // Кнопка "Заказать" (нижняя)
    // By.xpath(".//div[contains(@class,'Home_FinishButton')]//button[text()='Заказать']")

    // Кнопка "Статус заказа"
    // By.xpath(".//button[text()='Статус заказа']")

    // Поле ввода номера заказа
    // By.xpath(".//input[@placeholder='Введите номер заказа']")

    // Кнопка "Go!"
    // By.xpath(".//button[text()='Go!']")

    // Кнопка принятия куки
    // By.id("rcc-confirm-button")

    // Вопрос FAQ (index 0-7, поиск по порядку)
    // By.xpath("(//div[contains(@class,'accordion__item')]//div[@role='button'])[index+1]")

    // Ответ FAQ (index 0-7, поиск по порядку)
    // By.xpath("(//div[contains(@class,'accordion__item')]//p)[index+1]")

    // Поле "Имя"
    // By.xpath(".//input[@placeholder='* Имя']")

    // Поле "Фамилия"
    // By.xpath(".//input[@placeholder='* Фамилия']")

    // Поле "Адрес"
    // By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']")

    // Поле "Станция метро"
    // By.xpath(".//input[@placeholder='* Станция метро']")

    // Элемент выпадающего списка станций
    // By.xpath(".//li[contains(@class,'select-search__row')]//*[text()='СТАНЦИЯ']")

    // Поле "Телефон"
    // By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']")

    // Кнопка "Далее"
    // By.xpath(".//button[text()='Далее']")

    // Поле "Когда привезти самокат"
    // By.xpath(".//input[@placeholder='* Когда привезти самокат']")

    // Выпадающий список "Срок аренды"
    // By.xpath(".//div[@class='Dropdown-placeholder']")

    // Элемент списка "Срок аренды"
    // By.xpath(".//div[contains(@class,'Dropdown-option') and text()='ВАРИАНТ']")

    // Чекбокс "чёрный жемчуг"
    // By.id("black")

    // Чекбокс "серая безысходность"
    // By.id("grey")

    // Поле "Комментарий для курьера"
    // By.xpath(".//input[@placeholder='Комментарий для курьера']")

    // Кнопка "Заказать" (в форме)
    // By.xpath(".//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']")

    // Кнопка "Да" (подтвердить)
    // By.xpath(".//div[contains(@class,'Order_Modal')]//button[text()='Да']")

    // Заголовок "Заказ оформлен"
    // By.xpath(".//div[contains(@class,'Order_ModalHeader') and contains(text(),'Заказ оформлен')]")

    // Ошибка поля "Имя"
    // By.xpath(".//div[contains(@class,'Input_ErrorMessage') and text()='Введите корректное имя']")

    // Ошибка поля "Фамилия"
    // By.xpath(".//div[contains(@class,'Input_ErrorMessage') and text()='Введите корректную фамилию']")

    // Ошибка поля "Адрес"
    // By.xpath(".//div[contains(@class,'Input_ErrorMessage') and text()='Введите корректный адрес']")

    // Ошибка поля "Телефон"
    // By.xpath(".//div[contains(@class,'Input_ErrorMessage') and text()='Введите корректный номер']")

    // Изображение "Заказ не найден"
    // By.xpath(".//img[@alt='Not found']")
}