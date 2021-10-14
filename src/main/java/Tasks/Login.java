package Tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterface.ChoucairAcademyLoginPage;


public class Login implements Task {
    private String strUser;
    private String strPassworw;

    public Login(String strUser, String strPassworw) {
        this.strUser = strUser;
        this.strPassworw = strPassworw;
    }

    public static Login onThePage(String strUser, String strPassworw) {
        return Tasks.instrumented(Login.class, strUser, strPassworw);
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(Click.on(ChoucairAcademyLoginPage.LOGIN_BUTTON),
        Enter.theValue(strUser).into(ChoucairAcademyLoginPage.INPUT_USER),
        Enter.theValue((strPassworw) ).into(ChoucairAcademyLoginPage.INPUT_PASSWORD),
        Click.on(ChoucairAcademyLoginPage.ENTER_BUTTON)
        );
    }
}
