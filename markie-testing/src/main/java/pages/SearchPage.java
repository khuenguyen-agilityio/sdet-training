package pages;

import net.serenitybdd.core.pages.PageObject;
import object_behaviors.implementation.WebElement;
import object_behaviors.rules.IWebElement;
import org.openqa.selenium.By;

public class SearchPage extends PageObject {
    private final By search_input = By.id("searchbox_input"),
        search_result = By.xpath("//article"),
        search_form_input = By.id("search_form_input");

    public IWebElement searchInput() {
        return new WebElement($(search_input));
    }

    public IWebElement searchResult() {
        return new WebElement($(search_result));
    }

    public IWebElement searchFormInput() {
        return new WebElement($(search_form_input));
    }
}
