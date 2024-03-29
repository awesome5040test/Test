package tests;

import PageObject.pages.MainPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class SecondTest extends Settings{


    @Test
    public void checkSearchFieldPlaceholderText() {
        driver.get(baseUrl);
        assertEquals(new MainPage(driver).getSearchFieldPlaceholderText(), "Введите запрос");
    }
}
