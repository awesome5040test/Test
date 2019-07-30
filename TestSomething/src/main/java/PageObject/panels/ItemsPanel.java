package PageObject.panels;

import PageObject.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ItemsPanel extends AbstractPanel{
    @FindBy(xpath = ".//a[@title='Главная']")
    private WebElement mainIcon;
    @FindBy(xpath = ".//a")
    private List<WebElement> panelLinks;
    @FindBy(xpath = "//a")
    private List<WebElement> pageLinks;


    public ItemsPanel(WebElement element, AbstractPage page){
        super(element,page);
    }

    public String getMainIconText(){
        return mainIcon.getText();
    }

    public int getQtyPanelLinks(){
        return panelLinks.size();
    }

    public int getQtyPageLinks() {
        return pageLinks.size();
    }
}
