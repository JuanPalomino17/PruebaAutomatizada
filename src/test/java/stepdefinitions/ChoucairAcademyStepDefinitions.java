package stepdefinitions;

import Tasks.Login;
import Tasks.OpenUp;
import Tasks.Search;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.AcademyChoucairData;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.Answer;

import java.util.List;
public class ChoucairAcademyStepDefinitions {

    @Before
    public void setStage () {OnStage.setTheStage(new OnlineCast()); }

    @Given("^than Rose wants to learn automation at the academy Choucair$")
    public void thanRoseWantsToLearnAutomationAtTheAcademyChoucair(List<AcademyChoucairData> academyChoucairData)throws Exception {
        OnStage.theActorCalled("Rose").wasAbleTo(OpenUp.thePage(), Login.
                onThePage(academyChoucairData.get(0).getStrUser(),academyChoucairData.get(0).getStrPassword()));
    }


    @When("^he search for the course (.*) on the Choucair academy platform$")
    public void heSearchForTheCourseRecursosAutomatizaciónBancolombiaOnTheChoucairAcademyPlatform(List<AcademyChoucairData> academyChoucairData)
            throws Exception  {
        OnStage.theActorInTheSpotlight().attemptsTo(Search.the(academyChoucairData.get(0).getStrCourse()));
    }


    @Then("^he finds the course called resources$")
    public void heFindsTheCourseCalledResourcesRecursosAutomatizaciónBancolombia(List<AcademyChoucairData> academyChoucairData)
            throws Exception  {
                OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Answer.toThe(academyChoucairData.get(0).getStrCourse())));
    }
}
