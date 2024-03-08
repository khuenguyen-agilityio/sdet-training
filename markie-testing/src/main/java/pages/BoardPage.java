package pages;

import net.serenitybdd.core.pages.PageObject;
import object_behaviors.implementation.WebElementImpl;
import object_behaviors.rules.WebElement;
import org.openqa.selenium.By;

public class BoardPage extends PageObject {
    private final String test_card = "//a[text() = '%s']/ancestor::div[@data-testid='trello-card']";
    private final By button_labels = By.xpath("//a[@class='button-link js-edit-labels']"),
            button_attachment = By.xpath("//div[@class='js-new-card-attachment-picker-react-root-for-sidebar']"),
            button_checklist = By.xpath("//div[@class='js-add-checklist-menu']");

    public WebElement testCard(String name) {
        String formattedElement = String.format(test_card, name);
        return new WebElementImpl($(formattedElement));
    }

    public WebElement buttonLabels() {
        return new WebElementImpl($(button_labels));
    }

    public WebElement buttonAttachment() {
        return new WebElementImpl($(button_attachment));
    }

    public WebElement buttonChecklist() {
        return new WebElementImpl($(button_checklist));
    }1
}
