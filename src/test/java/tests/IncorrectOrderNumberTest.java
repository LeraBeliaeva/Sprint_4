package tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class IncorrectOrderNumberTest extends WebTestBase {

    @Test
    public void testIncorrectOrderNumberShowsNotFound() {
        homePage.clickStatusButton()
                .enterOrderNumber("999999")
                .clickGoButton();
        assertTrue("Заказ не найден!", homePage.isNotFoundImageDisplayed());
    }
}