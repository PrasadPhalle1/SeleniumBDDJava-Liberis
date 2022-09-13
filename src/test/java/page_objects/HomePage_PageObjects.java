package page_objects;

import common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_PageObjects extends BasePage {

    @FindBy(xpath = "//a[text()='Get a Demo']")
    private WebElement dashbordGetADemo_BTN;

    @FindBy(xpath = "(//div[@class='inner-content'])[2]//div//div//label[text()= \"I'm a Broker\"]")
    private WebElement broker_TXT;

    @FindBy(xpath = "(//div[@class='inner-content'])[2]//div//div//label[text()= \"I'm an ISO\"]")
    private WebElement iso_TXT;

    @FindBy(xpath = "(//div[@class='inner-content'])[2]//div//div//label[text()= \"I'm a Strategic Partner\"]")
    private WebElement strategicPartner_TXT;



    public void launchHomePage(){
        loadUrl(prop.getProperty("URL"));
    }

    public void clickOnGetADemoOnHomePage(){
        try{
            waitForPageLoaded();
            clickElement(dashbordGetADemo_BTN);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void verifyPartnerSelectionPage(){
        try{
            waitForPageLoaded();
            System.out.println("Currently opened URL is: " + driver.getCurrentUrl());
            Assert.assertEquals(driver.getCurrentUrl(),"https://www.liberis.com/become-a-partner");
            String firstPartner = broker_TXT.getAttribute("for");
            String secondPartner = iso_TXT.getAttribute("for");
            String thirdPartner = strategicPartner_TXT.getAttribute("for");
            System.out.println("First Types of Partners is: " + firstPartner);
            System.out.println("Second Types of Partners is: " + secondPartner);
            System.out.println("Third Types of Partners is: " + thirdPartner);
            Assert.assertEquals(broker_TXT.getAttribute("for"),firstPartner);
            Assert.assertEquals(iso_TXT.getAttribute("for"),secondPartner);
            Assert.assertEquals(strategicPartner_TXT.getAttribute("for"),thirdPartner);

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}
