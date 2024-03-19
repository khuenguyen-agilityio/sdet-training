package actions;

import helpers.Storage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.interactions.Actions;
import pages.BoardPage;

import java.time.Duration;
import java.util.List;

import static contants.StorageKey.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardPageActions {
    private BoardPage boardPage;

    /**
     * Click on the card with given title and column
     *
     * @param title  title of the card
     * @param column column contains the card
     */
    public void clickCardWithTitleAndColumn(String title, String column) {
        boardPage.taskCard(column, title).waitUntilVisible(Duration.ofSeconds(30)).click();
    }

    /**
     * Click on Label button in the right label sidebar
     */
    public void clickLabelButton() {
        boardPage.buttonLabels().click();
    }

    /**
     * Click on button label action with given text
     *
     * @param text the text in the action button
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
     * @param title the title of the label
     */
    public void createNewCardLabel(String title) {
        boardPage.inputLabelTitle().type(title);
        boardPage.buttonLabelsAction("Create").click();

        Storage.getStorage().saveObjectValue(TEST_LABEL, title);
    }

    /**
     * Verify new card label title by compare it with data form Storage
     */
    public void verifyCardLabelTitle() {
        String label = (String) Storage.getStorage().getObject(TEST_LABEL);
        assertThat(boardPage.cardLabel().getText()).isEqualTo(label);
    }

    /**
     * Verify the card with given title is disabled
     *
     * @param title the title of the button
     */
    public void verifyButtonLabelsActionIsDisabled(String title) {
        assertThat(boardPage.buttonLabelsAction(title).isDisabled()).isTrue();
    }

    /**
     * Delete test card with title form Storage
     */
    public void deleteTestLabel() {
        // get label from storage
        String label = (String) Storage.getStorage().getObject(TEST_LABEL);

        // wait for button edit visible and click delete button twice
        boardPage.buttonEditLabel(label).click();
        boardPage.buttonLabelsAction("Delete").click();
        boardPage.buttonLabelsAction("Delete").click();
        boardPage.labelSection().waitUntilNotVisible(Duration.ofSeconds(30));
    }

    /**
     * Click on the Checklist button to open checklist menu
     */
    public void clickChecklistButton() {
        boardPage.buttonChecklist().click();
    }

    /**
     * Create new checklist with given title
     *
     * @param title
     */
    public void createNewChecklist(String title) {
        boardPage.inputChecklistTitle().clearAndType(title);
        boardPage.buttonSubmit("Add").click();

        Storage.getStorage().saveObjectValue(TEST_CHECKLIST_HEADING, title);
    }

    /**
     * Create checklist items with following items
     * Browsing through item in the items list to create it
     * Waiting for item has been created
     *
     * @param items the list of item will be created
     */
    public void createNewChecklistItem(List<String> items) {
        for (String item : items) {
            boardPage.inputChecklistItem().type(item);
            boardPage.buttonAddChecklistItem().click();
            if (item != null)
                boardPage.textChecklistItems().waitUntilContainElementWithTextVisible(Duration.ofSeconds(30), Duration.ofSeconds(1), item);
        }
        Storage.getStorage().saveObjectValue(TEST_CHECKLIST_ITEMS, items);
    }

    /**
     * Verify the checklist
     * Verify the heading has been created with value from Storage
     * Verify the items has been created with the value from Storage
     */
    public void verifyChecklist() {
        List<String> items = (List<String>) Storage.getStorage().getObject(TEST_CHECKLIST_ITEMS);
        SoftAssertions assertions = new SoftAssertions();

        // Browse all item from Storage and verify it contains in Web list
        items.forEach(item -> {
            assertions.assertThat(boardPage.textChecklistItems().isContainElementWithText(item)).isTrue();
        });
        assertions.assertAll();
    }

    /**
     * Delete the checklist created
     */
    public void deleteChecklist() {
        boardPage.buttonDeleteChecklist().click();
        boardPage.buttonConfirmDelete().click();
        boardPage.checklistSection().waitUntilNotVisible(Duration.ofSeconds(30));
    }

    /**
     * Tick the checkbox of checklist item with the index smaller than given count
     *
     * @param count the number of checkbox will be ticked
     */
    public void tickCheckboxItems(int count) {
        boardPage.checkboxChecklistItems().selectElements(count);
    }

    /**
     * Verify the checklist progress percent displayed the given percent
     *
     * @param percent percentage display
     */
    public void verifyChecklistProgress(int percent) {
        assertThat(boardPage.checklistProgressPercent(percent).isVisible()).isTrue();
    }

    /**
     * Verify the checklist items is empty (no item in the list)
     */
    public void verifyChecklistItemsIsEmpty() {
        assertThat(boardPage.checklistItemContainer().getText().isEmpty()).isTrue();
    }

    /**
     * Click on button Attachment to open Attachment menu
     */
    public void clickButtonAttachment() {
        boardPage.buttonAttachment().click();
    }

    /**
     * Upload file from path and save it to Storage
     *
     * @param path path of file uploaded
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
        String displayName = boardPage.attachmentName().getText();
        assertThat(filePath).contains(displayName);
    }

    /**
     * Delete the attachment uploaded
     */
    public void deleteAttachment() {
        boardPage.buttonDeleteAttachment().click();
        boardPage.buttonConfirmDelete().click();

        // wait for heading Attachments invisible
        boardPage.headingCardItem("Attachments").waitUntilNotVisible(Duration.ofSeconds(30));
    }

    /**
     * Verify the toast with given type and message has been displayed
     *
     * @param type    the type of the toast
     * @param message the message displayed
     */
    public void verifyToastDisplayed(String type, String message) {
        assertThat(boardPage.toast(type, message).isVisible()).isTrue();
    }

    /**
     * Drag the card from start column to end column
     *
     * @param title       the title of the card
     * @param startColumn the heading of the start column
     * @param endColumn   the heading of the end column
     */
    public void dragCardThroughColumns(String title, String startColumn, String endColumn) {
        new Actions(boardPage.getDriver()).dragAndDrop(boardPage.taskCard(startColumn, title).waitUntilVisible(Duration.ofSeconds(30)), boardPage.cardColumn(endColumn).waitUntilVisible(Duration.ofSeconds(30))).perform();
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
        assertThat(boardPage.taskCard(column, title).waitUntilVisible(Duration.ofSeconds(30)).isVisible()).isTrue();
    }

    /**
     * Move back card from end column to the start column
     */
    public void moveBackCard() {
        String title = (String) Storage.getStorage().getObject(CARD_TITLE);
        String startColumn = (String) Storage.getStorage().getObject(START_COLUMN);
        String endColumn = (String) Storage.getStorage().getObject(END_COLUMN);
        new Actions(boardPage.getDriver()).dragAndDrop(boardPage.taskCard(endColumn, title).waitUntilVisible(Duration.ofSeconds(30)), boardPage.cardColumn(startColumn).waitUntilVisible(Duration.ofSeconds(30))).perform();
        boardPage.taskCard(startColumn, title).waitUntilVisible(Duration.ofSeconds(30));
    }

    /**
     * Verify the card has not been moved and stay in start column
     */
    public void verifyCardHasNotBeenMoved() {
        String title = (String) Storage.getStorage().getObject(CARD_TITLE);
        String column = (String) Storage.getStorage().getObject(START_COLUMN);
        assertThat(boardPage.taskCard(column, title).waitUntilVisible(Duration.ofSeconds(30)).isVisible()).isTrue();
    }

    /**
     * Drag the card from column to Trello logo
     *
     * @param title  the title of the card
     * @param column the column of the card
     */
    public void dragCardToTrelloLogo(String title, String column) {
        new Actions(boardPage.getDriver()).dragAndDrop(boardPage.taskCard(column, title).waitUntilVisible(Duration.ofSeconds(30)), boardPage.trelloLogo().waitUntilVisible(Duration.ofSeconds(30))).perform();
        Storage.getStorage().saveObjectValue(CARD_TITLE, title);
        Storage.getStorage().saveObjectValue(START_COLUMN, column);
    }
}
