package PageObject.panels;

import PageObject.pages.AbstractPage;
import common.SearchContextElementLocatorFactory;
import common.WebDriverAdaptor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class AbstractPanel {
    AbstractPage page;
    WebDriverAdaptor webDriverAdaptor;

    AbstractPanel(WebElement element, AbstractPage page){
        initPanel(element, page);
    }

    private void initPanel(WebElement element, AbstractPage page) {
        this.page = page;
        this.webDriverAdaptor = new WebDriverAdaptor(page.getDriver(), element);
        ElementLocatorFactory searchContextElementLocatorFactory = new SearchContextElementLocatorFactory(webDriverAdaptor);
        PageFactory.initElements(searchContextElementLocatorFactory, this);
    }
}
