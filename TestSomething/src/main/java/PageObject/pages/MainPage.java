package PageObject.pages;

import PageObject.panels.ItemsPanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    @FindBy(xpath = "//input[@id='search']")
    private WebElement searchField;
    @FindBy(xpath = "//div[@id='items' and @class='style-scope ytd-mini-guide-renderer']")
    private WebElement itemsPanel;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchFieldPlaceholderText() {
        return searchField.getAttribute("placeholder");
    }

    public ItemsPanel getItemsPanel(){
        return new ItemsPanel(itemsPanel, this);
    }
}
