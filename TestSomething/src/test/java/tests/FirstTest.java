package tests;

import PageObject.pages.MainPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.assertTrue;
@Epic("Login Tests Epic")
@Feature("Invalid Login Features")
public class FirstTest extends Settings {

    @Story("User tries to login the system with empty username and invalid password.")
    @Description("Invalid Login Test with Empty Username and Invalid Password.")
    @ParameterizedTest
    @ValueSource(ints = {3,5})
    public void checkQty(int expectedQty) {
        driver.get(baseUrl);
        assertTrue(new MainPage(driver).getItemsPanel().getQtyPanelLinks()==expectedQty);
    }

}
