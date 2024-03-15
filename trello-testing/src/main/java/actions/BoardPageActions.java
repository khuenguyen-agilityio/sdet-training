package actions;

import helpers.Storage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.interactions.Actions;
import pages.BoardPage;

import java.util.List;

import static contants.StorageKey.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardPageActions {
    private BoardPage boardPage;

    /**
     * Click on a card with given title
     *
     * @param title
     */
    public void clickCardWithTitleAndColumn(String title, String column) {
        boardPage.taskCard(column, title).getWrappedElement().waitUntilVisible().click();
    }

    /**
     * Click on Label button in the right label sidebar
     */
    public void clickLabelButton() {
        boardPage.buttonLabels().getWrappedElement().waitUntilVisible().click();
    }

    /**
     * Click on button label action with given text
     *
     * @param text
     */
    public void clickButtonLabelAction(String text) {
        boardPage.buttonLabelsAction(text).click();
    }

    /**
     * Click on button remove color
     */
    public void clickButtonRemoveColor() {
        boardPage.buttonRemoveColor().click();
    }

    /**
     * Create new card with given label and save label to Storage
     *
     * @param label
     */
    public void createNewCardLabel(String label) {
        boardPage.inputLabelTitle().getWrappedElement().sendKeys(label);
        boardPage.buttonLabelsAction("Create").click();

        Storage.getStorage().saveObjectValue(TEST_LABEL, label);
    }

    /**
     * Verify new card label title by compare it with data form Storage
     */
    public void verifyCardLabelTitle() {
        String label = (String) Storage.getStorage().getObject(TEST_LABEL);
        assertThat(boardPage.cardLabel().getWrappedElement().getText()).isEqualTo(label);
    }

    /**
     * Verify the card with given title is disabled
     *
     * @param title
     */
    public void verifyButtonLabelsActionIsDisabled(String title) {
        assertThat(boardPage.buttonLabelsAction(title).getWrappedElement().waitUntilVisible().isDisabled()).isTrue();
    }

    /**
     * Delete test card with title form Storage
     */
    public void deleteTestLabel() {
        // get label from storage
        String label = (String) Storage.getStorage().getObject(TEST_LABEL);

        // wait for button edit visible and click delete button twice
        boardPage.buttonEditLabel(label).getWrappedElement().waitUntilVisible().click();
        boardPage.buttonLabelsAction("Delete").click();
        boardPage.buttonLabelsAction("Delete").click();
    }

    /**
     * Click on the Checklist button to open checklist menu
     */
    public void clickChecklistButton() {
        boardPage.buttonChecklist().getWrappedElement().waitUntilVisible().click();
    }

    /**
     * Create new checklist with given title
     *
     * @param title
     */
    public void createNewChecklist(String title) {
        boardPage.inputChecklistTitle().getWrappedElement().waitUntilVisible().sendKeys(title);
        boardPage.buttonSubmit("Add").click();

        Storage.getStorage().saveObjectValue(TEST_CHECKLIST_HEADING, title);
    }

    /**
     * Create checklist items with following items
     * Browsing through item in the items list to create it
     *
     * @param items the list of item will be created
     */
    public void createNewChecklistItem(List<String> items) {
        for (String item : items) {
            boardPage.inputChecklistItem().getWrappedElement().waitUntilVisible().sendKeys(item);
            boardPage.buttonAddChecklistItem().click();
            if (item != null) {
                boardPage.cardChecklistItem(item).getWrappedElement().waitUntilVisible();
            }
        }
        Storage.getStorage().saveObjectValue(TEST_CHECKLIST_ITEMS, items);
    }

    /**
     * Verify the checklist
     * Verify the heading has been created with value from Storage
     * Verify the items has been created with the value from Storage
     */
    public void verifyChecklist() {
        // wait for heading visible
        boardPage.checklistHeading().getWrappedElement().waitUntilVisible();
        String heading = (String) Storage.getStorage().getObject(TEST_CHECKLIST_HEADING);

        // create compare list
        List<String> items = (List<String>) Storage.getStorage().getObject(TEST_CHECKLIST_ITEMS);

        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(boardPage.checklistHeading().getWrappedElement().getText()).isEqualTo(heading);
        for (String item : items) {
            assertions.assertThat(boardPage.cardChecklistItem(item).getWrappedElement().waitUntilVisible().isDisplayed()).isTrue();
        }
        assertions.assertAll();
    }

    /**
     * Delete the checklist created
     */
    public void deleteChecklist() {
        boardPage.buttonDeleteChecklist().getWrappedElement().waitUntilVisible().click();
        boardPage.buttonConfirmDelete().getWrappedElement().waitUntilVisible().click();
        boardPage.checklistSection().getWrappedElement().waitUntilNotVisible();
    }

    /**
     * Tick the checkbox of checklist item with the index smaller than given count
     *
     * @param count the number of checkbox will be ticked
     */
    public void tickCheckboxItems(int count) {
        int index = 0;
        List<String> items = (List<String>) Storage.getStorage().getObject(TEST_CHECKLIST_ITEMS);

        for (String item : items) {
            if (index < count) {
                boardPage.checkboxChecklistItem(item).getWrappedElement().waitUntilVisible().click();
            }
            index++;
        }
    }

    /**
     * Verify the checklist progress percent displayed the given percent
     *
     * @param percent
     */
    public void verifyChecklistProgress(int percent) {
        assertThat(boardPage.checklistProgressPercent(percent).getWrappedElement().waitUntilVisible().isDisplayed()).isTrue();
    }

    /**
     * Verify the checklist items is empty (no item in the list)
     */
    public void verifyChecklistItemsIsEmpty() {
        assertThat(boardPage.checklistItemContainer().getWrappedElement().getText().isEmpty()).isTrue();
    }

    /**
     * Click on button Attachment to open Attachment menu
     */
    public void clickButtonAttachment() {
        boardPage.buttonAttachment().getWrappedElement().waitUntilVisible().click();
    }

    /**
     * Upload file from path and save it to Storage
     *
     * @param path
     */
    public void uploadAttachment(String path) {
        boardPage.uploadAttachment(path);
        Storage.getStorage().saveObjectValue(ATTACHMENT_PATH, path);
    }

    /**
     * Verify the file path from Storage contain the file displayed
     */
    public void verifyAttachmentName() {
        String filePath = (String) Storage.getStorage().getObject(ATTACHMENT_PATH);
        String displayName = boardPage.attachmentName().getWrappedElement().waitUntilVisible().getText();
        assertThat(filePath).contains(displayName);
    }

    /**
     * Delete the attachment uploaded
     */
    public void deleteAttachment() {
        boardPage.buttonDeleteAttachment().getWrappedElement().waitUntilVisible().click();
        boardPage.buttonConfirmDelete().getWrappedElement().waitUntilVisible().click();

        // wait for heading Attachments invisible
        boardPage.headingCardItem("Attachments").getWrappedElement().waitUntilNotVisible();
    }

    /**
     * Verify the toast with given type and message has been displayed
     *
     * @param type    the type of the toast
     * @param message the message displayed
     */
    public void verifyToastDisplayed(String type, String message) {
        assertThat(boardPage.toast(type, message).getWrappedElement().waitUntilVisible().isDisplayed()).isTrue();
    }

    /**
     * Drag the card from start column to end column
     *
     * @param title       the title of the card
     * @param startColumn the heading of the start column
     * @param endColumn   the heading of the end column
     */
    public void dragCardThroughColumns(String title, String startColumn, String endColumn) {
        new Actions(boardPage.getDriver()).dragAndDrop(boardPage.taskCard(startColumn, title).getWrappedElement(), boardPage.cardColumn(endColumn).getWrappedElement()).perform();
        Storage.getStorage().saveObjectValue(CARD_TITLE, title);
        Storage.getStorage().saveObjectValue(START_COLUMN, startColumn);
        Storage.getStorage().saveObjectValue(END_COLUMN, endColumn);
    }

    /**
     * Verify the card has been move to the end column
     */
    public void verifyCardHasBeenMoved() {
        String title = (String) Storage.getStorage().getObject(CARD_TITLE);
        String column = (String) Storage.getStorage().getObject(END_COLUMN);
        assertThat(boardPage.taskCard(column, title).getWrappedElement().waitUntilVisible().isDisplayed()).isTrue();
    }

    /**
     * Move back card from end column to the start column
     */
    public void moveBackCard() {
        String title = (String) Storage.getStorage().getObject(CARD_TITLE);
        String startColumn = (String) Storage.getStorage().getObject(START_COLUMN);
        String endColumn = (String) Storage.getStorage().getObject(END_COLUMN);
        new Actions(boardPage.getDriver()).dragAndDrop(boardPage.taskCard(endColumn, title).getWrappedElement(), boardPage.cardColumn(startColumn).getWrappedElement()).perform();
        boardPage.taskCard(startColumn, title).getWrappedElement().waitUntilVisible();
    }

    /**
     * Verify the card has not been moved and stay in start column
     */
    public void verifyCardHasNotBeenMoved() {
        String title = (String) Storage.getStorage().getObject(CARD_TITLE);
        String column = (String) Storage.getStorage().getObject(START_COLUMN);
        assertThat(boardPage.taskCard(column, title).getWrappedElement().waitUntilVisible().isDisplayed()).isTrue();
    }

    /**
     * Drag the card from column to Trello logo
     *
     * @param title  the title of the card
     * @param column the column of the card
     */
    public void dragCardToTrelloLogo(String title, String column) {
        new Actions(boardPage.getDriver()).dragAndDrop(boardPage.taskCard(column, title).getWrappedElement(), boardPage.trelloLogo().getWrappedElement()).perform();
        Storage.getStorage().saveObjectValue(CARD_TITLE, title);
        Storage.getStorage().saveObjectValue(START_COLUMN, column);
    }
}
