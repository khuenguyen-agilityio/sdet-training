package pages;

import net.serenitybdd.core.pages.PageObject;
import object_behaviors.implementation.WebElementImpl;
import object_behaviors.rules.WebElement;

public class MainPage extends PageObject {
    private final String board = "//div[text() = '%s']";

    public WebElement board(String boardName) {
        String formattedElement = String.format(board, boardName);
        return new WebElementImpl($(formattedElement));
    }
}
