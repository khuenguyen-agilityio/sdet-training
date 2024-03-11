package pages;

import net.serenitybdd.core.pages.PageObject;
import object_behaviors.implementation.WebElementImpl;
import object_behaviors.rules.WebElement;
import org.openqa.selenium.By;

public class BoardPage extends PageObject {
    private final String test_card = "//a[text() = '%s']/ancestor::div[@data-testid='trello-card']";
    private final By button_labels = By.xpath("//a[@class='button-link js-edit-labels']"),
            button_attachment = By.xpath("//div[@class='js-new-card-attachment-picker-react-root-for-sidebar']"),
            button_checklist = By.xpath("//div[@class='js-add-checklist-menu']"),
            input_label_title = By.xpath("//section[@data-testid='labels-popover-create-label-screen']/descendant::input[@type='text']"),
            card_label = By.xpath("//span[@data-testid='card-label']"),
            button_remove_color = By.xpath("//button[@type='button' and contains(text(), 'Remove color')]");

    private final String button_labels_action = "//button[@type='button' and text() = '%s']",
            button_edit_label = "//section[@data-testid='labels-popover-labels-screen']/descendant::span[@data-testid='card-label' and text()='%s']/following-sibling::button";

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
    }

    public WebElement inputLabelTitle() {
        return new WebElementImpl($(input_label_title));
    }

    public WebElement cardLabel() {
        return new WebElementImpl($(card_label));
    }

    public WebElement buttonLabelsAction(String name) {
        String formattedElement = String.format(button_labels_action, name);
        return new WebElementImpl($(formattedElement));
    }

    public WebElement buttonEditLabel(String label) {
        String formattedElement = String.format(button_edit_label, label);
        return new WebElementImpl($(formattedElement));
    }

    public WebElement buttonRemoveColor() {
        return new WebElementImpl($(button_remove_color));
    }
}
