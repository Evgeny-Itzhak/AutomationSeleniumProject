package cucumber.steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class NavigationSteps extends BaseSteps{

    @Step
    public void opens_web_page(String url){
        getDriver().get(url);
        getDriver().manage().window().maximize();
        Serenity.getCurrentSession().put("Main Page Handle", getDriver().getWindowHandle());
    }
}
