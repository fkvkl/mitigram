package com.mitigram.stepDefinitions;

import com.mitigram.pages.CareersPage;
import com.mitigram.pages.HomePage;
import com.mitigram.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CareersStepDefinitions {
    @Given("user navigates to Careers page")
    public void user_navigates_to_careers_page() {
        new HomePage().navigateToPage("Careers");
    }

    @When("user clicks Open positions")
    public void user_clicks_open_positions() {
        new CareersPage().openPositions.click();
    }

    @Then("user should be able to display Open positions")
    public void user_should_be_able_to_display_open_positions() {
        assertTrue(new CareersPage().openPositionsHeader.isDisplayed());
    }

    @When("user selects {string}")
    public void user_selects(String category) {
        new CareersPage().chooseFilter(category);
    }

    @Then("user should be able to display only positions contain {string}")
    public void user_should_be_able_to_display_only_positions_contain(String keyword) {
        for (WebElement position : new CareersPage().positions) {
            assertTrue(position.getText().contains(keyword));
        }
    }

    @When("User clicks {string} and then Learn more")
    public void user_clicks_and_then_learn_more(String position) {
        new CareersPage().selectPosition_LearnMore(position);
    }

    @Then("User should be able to display {string}")
    public void user_should_be_able_to_display(String expected) {
        String actual = Driver.get().getCurrentUrl();
        assertEquals(expected, actual);
    }

    @When("User clicks {string} and Apply for this position")
    public void user_clicks_and_apply_for_this_position(String position) {
        new CareersPage().selectPosition_Apply(position);
    }
}
