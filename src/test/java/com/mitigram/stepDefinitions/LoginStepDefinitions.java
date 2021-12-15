package com.mitigram.stepDefinitions;

import com.mitigram.pages.HomePage;
import com.mitigram.pages.LoginPage;
import com.mitigram.utilities.ConfigurationReader;
import com.mitigram.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import static org.junit.Assert.assertEquals;


public class LoginStepDefinitions {


    @Given("User navigates to log in page")
    public void user_navigates_to_log_in_page() {
        HomePage homePage = new HomePage();
        //BrowserUtilities.hover(homePage.notification);
        //homePage.closeNotification.click();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].click()", homePage.closeNotification);

        homePage.login.click();
    }

    @When("User enters valid credentials and clicks Log in")
    public void user_enters_valid_credentials_and_clicks_log_in() {
        new LoginPage().login();
    }

    @Then("Page url should not be equal to {string}")
    public void page_url_should_not_be_equal_to(String expected) {
        String actual = Driver.get().getCurrentUrl();
        assertEquals(expected, actual);
    }

    @When("User enters {string} and {string} and clicks Log in")
    public void user_enters_and_and_clicks_log_in(String email, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
        loginPage.login.click();
    }

    @Then("User should receive the {string}")
    public void user_should_receive_the(String expected) {
        String actual = new LoginPage().notification.getText();
        assertEquals(expected, actual);
    }

    @When("User clicks Contact us")
    public void user_clicks_contact_us() {
        new LoginPage().contactUs.click();
    }

    @Then("User should be able to navigate to Contact page and page title should be {string}")
    public void user_should_be_able_to_navigate_to_contact_page_and_page_title_should_be(String expected) {
        String actual = Driver.get().getTitle();
        assertEquals(expected, actual);
    }

    @When("User clicks Forgot your password?")
    public void user_clicks_forgot_your_password() {
        new LoginPage().forgotYourPassword.click();
    }

    @When("User enters his-her email address to input box and clicks Email link")
    public void user_enters_his_her_email_address_to_input_box_and_clicks_email_link() {
        new LoginPage().emailInput.sendKeys(ConfigurationReader.get("email") + Keys.ENTER);
    }

    @When("User should be able to display {string} message")
    public void user_should_be_able_to_display_message(String expected) {
        String actual = new LoginPage().confirmationMessage.getText();
        assertEquals(expected, actual);
    }

    @When("User clicks {string} icon")
    public void user_clicks_icon(String store) {
        new LoginPage().selectStore(store);
    }

    @Then("User should be able to navigate store's {string}")
    public void user_should_be_able_to_navigate_store_s(String expected) {
        String actual = Driver.get().getCurrentUrl();
        assertEquals(expected, actual);
    }


}
