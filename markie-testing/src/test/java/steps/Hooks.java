package steps;

import helpers.Storage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;

@Slf4j
public class Hooks {

    @Before
    public static void initialization() {
        Storage.instantiateStorage();
    }

    @After(order = -1)
    public static void closeBrowser() {
        Serenity.getDriver().close();
        Serenity.getDriver().quit();
    }
}
