package steps;

import actions.BoardPageActions;
import helpers.Storage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.annotations.Shared;

public class Hooks {
    @Shared
    private BoardPageActions boardPageActions;

    @Before
    public static void initialization() {
        Storage.instantiateStorage();
    }

    @After(value = "@delete_test_label")
    public void deleteTestLabel() {
        boardPageActions.deleteTestLabel();
    }
    
    @After(value = "@delete_checklist")
    public void deleteChecklist() {
        boardPageActions.deleteChecklist();
    }
}
