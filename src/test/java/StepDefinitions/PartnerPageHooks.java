package StepDefinitions;

import common.BasePage;
import io.cucumber.java.After;

public class PartnerPageHooks extends BasePage {

    @After("@PartnerPage")
    public void endSession(){
        closeDriver();
    }
}
