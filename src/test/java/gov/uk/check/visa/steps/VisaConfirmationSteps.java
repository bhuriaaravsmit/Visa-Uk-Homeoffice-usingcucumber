package gov.uk.check.visa.steps;

import gov.uk.check.visa.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class VisaConfirmationSteps {
    @Given("I am on homepage")
    public void iAmOnHomepage() {

    }

    @When("I clicked on start button")
    public void iClickedOnStartButton() {
        new StartPage().stratNowButton();
    }

    @And("I clicked next button")
    public void iClickedNextButton() {
        new SelectNationalityPage().clickNextStepButton();
    }

    @And("I select reason is Tourism")
    public void iSelectReasonIsTourism() {
        new ReasonForTravelPage().clickOnReasonForVisitTourism();
    }

    @Then("I can see the message about visa requirements")
    public void iCanSeeTheMessageAboutVisaRequirements() {
        String actualResultMessage=new ResultPage().getResultMessage();
        String expectedResultMessage="You will not need a visa to come to the UK";
        Assert.assertEquals(actualResultMessage,expectedResultMessage);
    }

    @And("I select the Nationality {string}")
    public void iSelectTheNationality(String country) {
        new SelectNationalityPage().selectNationality(country);
    }

    @And("I select reason is work academic visit or business")
    public void iSelectReasonIsWorkAcademicVisitOrBusiness() {
        new ReasonForTravelPage().clickOnReasonForVisitAcademic();
    }

    @And("I click on reason for travel next step button")
    public void iClickOnReasonForTravelNextStepButton() {
        new ReasonForTravelPage().clickNextStepButton();
    }



    @And("I click on next step in duration of stay page")
    public void iClickOnNextStepInDurationOfStayPage() {
        new DurationOfStayPage().clickNextStepButton();

    }

    @And("I selected health and care provision")
    public void iSelectedHealthAndCareProvision() {
        new WorkTypePage().clickOnHealthAndCareProvision();
    }

    @And("I clicked on next button in work type page")
    public void iClickedOnNextButtonInWorkTypePage() {
        new WorkTypePage().clickNextStepButton();
    }

    @Then("verify the visa requirement for this purpose")
    public void verifyTheVisaRequirementForThisRequirement() {
        String actualSuccessMessage= new ResultPage().getResultMessageforHealthAndCare();
        Assert.assertTrue(actualSuccessMessage.contains("You need a visa to work in health and care"));

    }

    @And("I select intendent to stay for longer than six month {string}")
    public void iSelectIntendentToStayForLongerThanSixMonth(String time) {
        new DurationOfStayPage().selectLengthOfStay(time);
    }

    @And("I select the reason to join family and partner")
    public void iSelectTheReasonToJoinFamilyAndPartner() {
        new ReasonForTravelPage().clickOnReasonForJoinPartnerAndFamily();

    }

    @And("I selected immigration status {string}")
    public void iSelectedImmigrationStatus(String status) {
        new FamilyImmigrationStatusPage().selectImmigrationStatus(status);
    }

    @And("I click on immigration next button")
    public void iClickOnImmigrationNextButton() {
        new FamilyImmigrationStatusPage().clickNextStepButton();
    }

    @Then("verify the message for visa requirement")
    public void verifyTheMessageForVisaRequirement() {
        String actualSuccessMessage= new ResultPage().getResultMessageforChina();
        Assert.assertTrue(actualSuccessMessage.contains("You’ll need a visa to join your family or partner in the UK"));
    }
}
