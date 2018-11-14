package cucumber.behaviors;

import cucumber.api.java.en.Given;
import cucumber.framework.SettingsManager;
import cucumber.steps.HomeSteps;
import cucumber.steps.NavigationSteps;
import cucumber.steps.ServiceSteps;
import net.thucydides.core.annotations.Steps;

public class NavigationBehaviors {

    SettingsManager settingsManager = new SettingsManager();

    @Steps
    HomeSteps homeSteps;
    @Steps
    ServiceSteps serviceSteps;
    @Steps
    NavigationSteps navigationSteps;

    @Given("user is on booking home page")
    public void open_home_page(){
        String url = settingsManager.getUrl();
        navigationSteps.opens_web_page(url);
        serviceSteps.wait_for_page_loaded();
    }
}
