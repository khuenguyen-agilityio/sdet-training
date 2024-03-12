package pages;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
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
            button_remove_color = By.xpath("//button[@type='button' and contains(text(), 'Remove color')]"),
            input_checklist_title = By.id("id-checklist"),
            input_checklist_item = By.xpath("//textarea[@class='edit field checklist-new-item-text js-new-checklist-item-input']"),
            button_add_checklist_item = By.xpath("//input[@class='nch-button nch-button--primary confirm mod-submit-edit js-add-checklist-item']"),
            checklist_heading = By.xpath("//h3[@class='current hide-on-edit']"),
            checklist_items = By.xpath("//span[@class='checklist-item-details-text markeddown js-checkitem-name']"),
            button_delete_checklist = By.xpath("//a[@class='nch-button hide-on-edit js-confirm-delete']"),
            button_confirm_delete_checklist = By.xpath("//input[@class='js-confirm full nch-button nch-button--danger']"),
            checkbox_checklist_items = By.xpath("//div[@class='checklist-items-list js-checklist-items-list js-no-higher-edits ui-sortable']//descendant::input[@type='checkbox']"),
            checklist_progress_bar = By.xpath("//span[@class='checklist-progress-percentage js-checklist-progress-percent']"),
            checklist_item_container = By.xpath("//div[@class='checklist-items-list js-checklist-items-list js-no-higher-edits ui-sortable']");

    private final String button_labels_action = "//button[@type='button' and text() = '%s']",
            button_submit = "//button[@type='submit' and text() = '%s']",
            button_edit_label = "//section[@data-testid='labels-popover-labels-screen']/descendant::span[@data-testid='card-label' and text()='%s']/following-sibling::button",
            card_checklist_item = "//span[@class='checklist-item-details-text markeddown js-checkitem-name' and text()='%s']/ancestor::div[@class='checklist-item no-assignee no-due']";

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

    public WebElement buttonRemoveColor() {
        return new WebElementImpl($(button_remove_color));
    }

    public WebElement inputChecklistTitle() {
        return new WebElementImpl($(input_checklist_title));
    }

    public WebElement inputChecklistItem() {
        return new WebElementImpl($(input_checklist_item));
    }

    public WebElement buttonAddChecklistItem() {
        return new WebElementImpl($(button_add_checklist_item));
    }

    public ListOfWebElementFacades checklistItems() {
        return ($$(checklist_items));
    }

    public WebElement checklistHeading() {
        return new WebElementImpl($(checklist_heading));
    }

    public WebElement buttonDeleteChecklist() {
        return new WebElementImpl($(button_delete_checklist));
    }

    public WebElement buttonConfirmDeleteChecklist() {
        return new WebElementImpl($(button_confirm_delete_checklist));
    }

    public ListOfWebElementFacades checkboxChecklist() {
        return ($$(checkbox_checklist_items));
    }

    public WebElement checklistProgressPercent() {
        return new WebElementImpl($(checklist_progress_bar));
    }

    public WebElement checklistItemContainer() {
        return new WebElementImpl($(checklist_item_container));
    }

    public WebElement buttonLabelsAction(String name) {
        String formattedElement = String.format(button_labels_action, name);
        return new WebElementImpl($(formattedElement));
    }

    public WebElement buttonEditLabel(String label) {
        String formattedElement = String.format(button_edit_label, label);
        return new WebElementImpl($(formattedElement));
    }

    public WebElement buttonSubmit(String text) {
        String formattedElement = String.format(button_submit, text);
        return new WebElementImpl($(formattedElement));
    }

    public WebElement cardChecklistItem(String title) {
        String formattedElement = String.format(card_checklist_item, title);
        return new WebElementImpl($(formattedElement));
    }
}
