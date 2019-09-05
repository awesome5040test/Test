package tests;

import PageObject.pages.MainPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Text Tests Epic")
@Feature("Text Login Features")
public class SecondTest extends Settings{


    @Test
    public void checkSearchFieldPlaceholderText() {
        driver.get(baseUrl);
        assertEquals(new MainPage(driver).getSearchFieldPlaceholderText(), "Введите запрос");
    }
}
