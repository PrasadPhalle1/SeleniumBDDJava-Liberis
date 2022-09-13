package StepDefinitions;

import common.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.HomePage_PageObjects;
import page_objects.PartnerPage_PageObjects;

public class PartnerPageSteps extends BasePage {

    @Given("user is on become a partner page")
    public void user_is_on_become_a_partner_page() {
        System.out.println("Inside step: user is on become a partner page");
        getInstance(HomePage_PageObjects.class).verifyPartnerSelectionPage();
    }
    @When("user clicks on get a demo button on become a partner page")
    public void user_clicks_on_get_a_demo_button_on_become_a_partner_page() {
        System.out.println("Inside step: user clicks on get a demo button on become a partner page");
        getInstance(PartnerPage_PageObjects.class).clickOnGetADemoOnPartnerPage();
    }
    @Then("verify the validation message")
    public void verify_the_validation_message() {
        System.out.println("Inside step: verify the validation message");
        getInstance(PartnerPage_PageObjects.class).verifyMessage();
    }

}
