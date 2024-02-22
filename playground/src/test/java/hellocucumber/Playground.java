package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Playground {
    private int cakes;

    @Given("I have {int} cakes")
    public void i_have_cakes(Integer amount) {
        cakes = amount;
    }

    @When("I give my girlfriend {int} cakes")
    public void i_give_my_girlfriend_cakes(Integer amount) {
        cakes -= amount;
    }

    @Then("I have {int} cakes left")
    public void i_have_cakes_left(Integer amount) {
        assertEquals(cakes, amount);
    }

    @Given("the following animals:")
    public void the_following_animal(List<String> animals) {
        System.out.println(animals);
    }
}
