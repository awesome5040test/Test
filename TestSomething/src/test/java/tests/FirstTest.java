package tests;

import PageObject.pages.MainPage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.assertTrue;


@Execution(ExecutionMode.CONCURRENT)
public class FirstTest extends Settings {

    @ParameterizedTest
    @ValueSource(ints = { 3, 5, 6, 7})
    public void checkQty(int expectedQty) {
        driver.get(baseUrl);
        assertTrue(new MainPage(driver).getItemsPanel().getQtyPanelLinks() == expectedQty);
    }

}
