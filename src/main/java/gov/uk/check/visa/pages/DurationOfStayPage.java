package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DurationOfStayPage extends Utility {

    private static final Logger log= LogManager.getLogger(DurationOfStayPage.class.getName());
    public DurationOfStayPage(){
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath="//input[@id='response-0']")
    WebElement lessThanSixMonths;
    @CacheLookup
    @FindBy(xpath="//input[@id='response-1']")
    WebElement moreThanSixMonths;
    @CacheLookup
    @FindBy(xpath="//button[contains(text(),'Continue')]")
    WebElement nextStepButton;
    public void selectLengthOfStay(String moreOrLess)
    {


        switch (moreOrLess){
            case "more":
                clickOnElement(moreThanSixMonths);
                break;
            case "less":

                clickOnElement(lessThanSixMonths);
                break;
            default:
                System.out.println("enter less or more");
                break;
        }
        log.info("Select length of stay" + moreOrLess +moreThanSixMonths.toString());
    }
    public void clickNextStepButton()
    {
        clickOnElement(nextStepButton);
        log.info("Clicking on nextStepButton link : " +nextStepButton.toString());
    }



}