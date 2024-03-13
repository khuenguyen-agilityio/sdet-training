package steps;

import actions.BoardPageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import java.util.List;

public class BoardPageSteps {
    @Steps
    private BoardPageActions boardPageActions;

    @Given("The user click on the card {string} on the list")
    public void the_user_click_on_the_card_on_the_list(String title) {
        boardPageActions.clickCardWithTitle(title);
    }

    @When("The user create new label with {string} title")
    public void the_user_create_new_label_with_title(String label) {
        boardPageActions.createNewCardLabel(label);
    }

    @Then("Verify user is able to see the card has label with given title")
    public void verify_user_is_able_to_see_the_card_has_label_with_given_title() {
        boardPageActions.verifyCardLabelTitle();
    }

    @Given("The user click on label button on the right sidebar")
    public void the_user_click_on_label_button_on_the_right_sidebar() {
        boardPageActions.clickLabelButton();
    }

    @Given("The user click on button with title {string}")
    public void the_user_click_on_button_with_title(String title) {
        boardPageActions.clickButtonLabelAction(title);
    }

    @When("The user click on remove color button of a label")
    public void the_user_click_on_remove_color_button_of_a_label() {
        boardPageActions.clickButtonRemoveColor();
    }

    @Then("Verify the user is not able to click {string} button")
    public void verify_the_user_is_not_able_to_click_button(String title) {
        boardPageActions.verifyButtonLabelsActionIsDisabled(title);
    }

    @Given("The user click on checklist button on the right sidebar")
    public void the_user_click_on_checklist_button_on_the_right_sidebar() {
        boardPageActions.clickChecklistButton();
    }

    @Given("The user create new checklist with title {string}")
    public void the_user_create_new_checklist_with_title(String title) {
        boardPageActions.createNewChecklist(title);
    }

    @When("The user create checklist item")
    public void the_user_create_checklist_item(List<String> items) {
        boardPageActions.createNewChecklistItem(items);
    }

    @Then("Verify user is able to see the checklist item has been created")
    public void verify_user_is_able_to_see_the_checklist_item_has_been_created() {
        boardPageActions.verifyChecklist();
    }

    @When("The user tick {int} first item of the checklist")
    public void the_user_tick_first_item_of_the_checklist(Integer count) {
        boardPageActions.tickCheckboxItems(count);
    }

    @Then("Verify user is able to see progress bar of checklist has {int} percentage")
    public void verify_user_is_able_to_see_progress_bar_of_checklist_has_percentage(Integer percent) {
        boardPageActions.verifyChecklistProgress(percent);
    }

    @Then("Verify the user is able to see empty checklist")
    public void verify_the_user_is_able_to_see_empty_checklist() {
        boardPageActions.verifyChecklistItemsIsEmpty();
    }

    @Given("The user click on the Attachment button on the right sidebar")
    public void the_user_click_on_the_attachment_button_on_the_right_sidebar() {
        boardPageActions.clickButtonAttachment();
    }

    @When("The user upload file with path {string}")
    public void the_user_upload_file_with_path(String path) {
        boardPageActions.uploadAttachment(path);
    }

    @Then("Verify the user is able to see the file has been uploaded")
    public void verify_the_user_is_able_to_see_the_file_has_been_uploaded() {
        boardPageActions.verifyAttachmentName();
    }

    @Then("Verify the user is able to see {string} toast with message {string}")
    public void verify_the_user_is_able_to_see_toast_with_message(String type, String message) {
        boardPageActions.verifyToastDisplayed(type, message);
    }

    @When("The user move the card {string} from {string} column to {string} column")
    public void the_user_move_the_card_from_column_to_column(String cardTitle, String startColumn, String endColumn) {
        boardPageActions.dragCardThroughColumns(cardTitle, startColumn, endColumn);
    }

    @Then("Verify the user is able to see the card in the column moved")
    public void verify_the_user_is_able_to_see_the_card_in_the_column_moved() {
        boardPageActions.verifyCardHasBeenMoved();
    }
}
