package StepDefinitions;

import common.BasePage;
import io.cucumber.java.Before;

public class HomePageHooks extends BasePage {
    @Before("@HomePage")
    public void init(){
        setBrowser();
    }

}
