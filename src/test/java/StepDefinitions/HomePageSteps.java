package StepDefinitions;

import common.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.HomePage_PageObjects;

public class HomePageSteps extends BasePage {

    @Given("user is on home page")
    public void user_is_on_home_page() {
        System.out.println("Inside step: user is on home page");
        getInstance(HomePage_PageObjects.class).launchHomePage();
    }
    @When("user clicks on get a demo button on home page")
    public void user_clicks_on_get_a_demo_button_on_home_page() {
        System.out.println("Inside step: user clicks on get a demo button on home page");
        getInstance(HomePage_PageObjects.class).clickOnGetADemoOnHomePage();
    }
    @Then("verify the partner selection page")
    public void verify_the_partner_selection_page() {
        System.out.println("Inside step: verify the partner selection page");
        getInstance(HomePage_PageObjects.class).verifyPartnerSelectionPage();
    }

}
