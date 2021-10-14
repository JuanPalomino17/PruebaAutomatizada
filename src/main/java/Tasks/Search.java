package Tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterface.SearchChoucairPage;

public class Search implements Task {
    private String course;
    public static Performable the(String course) {

        return Tasks.instrumented(Search.class,course);
    }

    public Search(String course) {
        this.course = course;
    }

    @Override
    public <T extends Actor > void performAs(T actor){
        actor.attemptsTo(Click.on(SearchChoucairPage.BUTTON_UC),
                Enter.theValue(course).into(SearchChoucairPage.INPUT_COURSE),
                Click.on(SearchChoucairPage.BUTTON_GO),
                Click.on(SearchChoucairPage.SELECT_COURSE)
        );
    }
}
