package common;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.DefaultElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public class SearchContextElementLocatorFactory implements ElementLocatorFactory {
    SearchContext searchContext;

    public SearchContextElementLocatorFactory(SearchContext context) {
        this.searchContext = context;
    }

    @Override
    public ElementLocator createLocator(Field field) {
        return new DefaultElementLocator(searchContext, field);
    }
}
