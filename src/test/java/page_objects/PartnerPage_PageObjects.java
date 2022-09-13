package page_objects;

import common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PartnerPage_PageObjects extends BasePage {

    @FindBy(xpath = "//a[@class='btn btn--medium js-partner-hero-button']")
    private WebElement partnerGetADemo_BTN;

    @FindBy(xpath = "//div[@class= 'ph-error-inner']")
    private WebElement partnerErrorMSG;


    public void clickOnGetADemoOnPartnerPage(){
        try{
            waitForPageLoaded();
            clickElement(partnerGetADemo_BTN);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void verifyMessage(){
        try{
            waitForElementVisibility(partnerErrorMSG);
            System.out.println("Validation message is: " + partnerErrorMSG.getText());
            Assert.assertEquals(partnerErrorMSG.getText(), "Please select a type of partner");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}
