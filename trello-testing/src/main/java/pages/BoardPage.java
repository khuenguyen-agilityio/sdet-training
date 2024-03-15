package pages;

import net.serenitybdd.core.pages.PageObject;
import object_behaviors.implementation.ButtonImpl;
import object_behaviors.implementation.TextInputImpl;
import object_behaviors.implementation.WebElementImpl;
import object_behaviors.rules.Button;
import object_behaviors.rules.TextInput;
import object_behaviors.rules.WebElement;
import org.openqa.selenium.By;

public class BoardPage extends PageObject {
    private final By button_labels = By.xpath("//a[@class='button-link js-edit-labels']"),
            button_attachment = By.xpath("//div[@class='js-new-card-attachment-picker-react-root-for-sidebar']"),
            button_checklist = By.xpath("//div[@class='js-add-checklist-menu']"),
            input_label_title = By.xpath("//section[@data-testid='labels-popover-create-label-screen']/descendant::input[@type='text']"),
            card_label = By.xpath("//span[@data-testid='card-label']"),
            button_remove_color = By.xpath("//button[@type='button' and contains(text(), 'Remove color')]"),
            input_checklist_title = By.id("id-checklist"),
            input_checklist_item = By.xpath("//textarea[@class='edit field checklist-new-item-text js-new-checklist-item-input']"),
            button_add_checklist_item = By.xpath("//input[@class='nch-button nch-button--primary confirm mod-submit-edit js-add-checklist-item']"),
            checklist_section = By.xpath("//div[@data-testid='checklist-section']"),
            checklist_heading = By.xpath("//h3[@class='current hide-on-edit']"),
            button_delete_checklist = By.xpath("//a[@class='nch-button hide-on-edit js-confirm-delete']"),
            button_confirm_delete = By.xpath("//input[@class='js-confirm full nch-button nch-button--danger']"),
            checklist_item_container = By.xpath("//div[@class='checklist-items-list js-checklist-items-list js-no-higher-edits ui-sortable']"),
            input_file_upload = By.id("card-attachment-file-picker"),
            attachment_name = By.xpath("//span[@class='attachment-thumbnail-name']"),
            button_delete_attachment = By.xpath("//a[@class='attachment-thumbnail-details-title-options-item dark-hover js-confirm-delete']"),
            trello_logo = By.xpath("//nav[@id='header']/a");

    private final String
            task_card = "//h2[@data-testid='list-name' and text() = '%s']/ancestor::div[@data-testid='list']/descendant::a[text()='%s']/ancestor::li[@data-testid='list-card']",
            heading_card_item = "//div[@class='window-module-title window-module-title-no-divider card-detail-activity']/descendant::h3[text()='%s']",
            button_labels_action = "//button[@type='button' and text() = '%s']",
            button_submit = "//button[@type='submit' and text() = '%s']",
            button_edit_label = "//section[@data-testid='labels-popover-labels-screen']/descendant::span[@data-testid='card-label' and text()='%s']/following-sibling::button",
            card_checklist_item = "//span[@class='checklist-item-details-text markeddown js-checkitem-name' and text()='%s']/ancestor::div[@class='checklist-item no-assignee no-due']",
            checkbox_checklist_item = "//span[@class='checklist-item-details-text markeddown js-checkitem-name' and text()='%s']/ancestor::div[@class='checklist-item no-assignee no-due']/descendant::input[@type='checkbox']",
            checklist_progress_bar = "//span[@class='checklist-progress-percentage js-checklist-progress-percent' and text()='%s']",
            toast = "//div[@role='%s']/descendant::span[text()='%s']",
            card_column = "//h2[@data-testid='list-name' and text() = '%s']/ancestor::div[@data-testid='list']";

    public Button buttonLabels() {
        return new ButtonImpl($(button_labels));
    }

    public Button buttonAttachment() {
        return new ButtonImpl($(button_attachment));
    }

    public Button buttonChecklist() {
        return new ButtonImpl($(button_checklist));
    }

    public TextInput inputLabelTitle() {
        return new TextInputImpl($(input_label_title));
    }

    public WebElement cardLabel() {
        return new WebElementImpl($(card_label));
    }

    public Button buttonRemoveColor() {
        return new ButtonImpl($(button_remove_color));
    }

    public TextInput inputChecklistTitle() {
        return new TextInputImpl($(input_checklist_title));
    }

    public TextInput inputChecklistItem() {
        return new TextInputImpl($(input_checklist_item));
    }

    public Button buttonAddChecklistItem() {
        return new ButtonImpl($(button_add_checklist_item));
    }

    public WebElement checklistSection() {
        return new WebElementImpl($(checklist_section));
    }

    public WebElement checklistHeading() {
        return new WebElementImpl($(checklist_heading));
    }

    public Button buttonDeleteChecklist() {
        return new ButtonImpl($(button_delete_checklist));
    }

    public Button buttonConfirmDelete() {
        return new ButtonImpl($(button_confirm_delete));
    }

    public WebElement checklistItemContainer() {
        return new WebElementImpl($(checklist_item_container));
    }

    public void uploadAttachment(String path) {
        upload(path).to($(input_file_upload));
    }

    public WebElement attachmentName() {
        return new WebElementImpl($(attachment_name));
    }

    public Button buttonDeleteAttachment() {
        return new ButtonImpl($(button_delete_attachment));
    }

    public WebElement trelloLogo() {
        return new WebElementImpl($(trello_logo));
    }

    public WebElement taskCard(String column, String title) {
        String formattedElement = String.format(task_card, column, title);
        return new WebElementImpl($(formattedElement));
    }

    public WebElement headingCardItem(String heading) {
        String formattedElement = String.format(heading_card_item, heading);
        return new WebElementImpl($(formattedElement));
    }

    public Button buttonLabelsAction(String name) {
        String formattedElement = String.format(button_labels_action, name);
        return new ButtonImpl($(formattedElement));
    }

    public Button buttonEditLabel(String label) {
        String formattedElement = String.format(button_edit_label, label);
        return new ButtonImpl($(formattedElement));
    }

    public Button buttonSubmit(String text) {
        String formattedElement = String.format(button_submit, text);
        return new ButtonImpl($(formattedElement));
    }

    public WebElement cardChecklistItem(String title) {
        String formattedElement = String.format(card_checklist_item, title);
        return new WebElementImpl($(formattedElement));
    }

    public WebElement checkboxChecklistItem(String title) {
        String formattedElement = String.format(checkbox_checklist_item, title);
        return new WebElementImpl($(formattedElement));
    }

    public WebElement checklistProgressPercent(int percent) {
        String percentText = percent + "%";
        String formattedElement = String.format(checklist_progress_bar, percentText);
        return new WebElementImpl($(formattedElement));
    }

    public WebElement toast(String type, String message) {
        String formattedElement = String.format(toast, type, message);
        return new WebElementImpl($(formattedElement));
    }


    public WebElement cardColumn(String heading) {
        String formattedElement = String.format(card_column, heading);
        return new WebElementImpl($(formattedElement));
    }
}
