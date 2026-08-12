package tests;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class YandexLogoNavigationTest extends WebTestBase {

    @Test
    public void testYandexLogoOpensNewTab() {
        homePage.clickYandexLogo();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertTrue("Не перешли на главную страницу Яндекса!",
                driver.getCurrentUrl().contains("yandex"));
    }
}