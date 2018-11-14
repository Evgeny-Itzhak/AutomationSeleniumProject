package cucumber.steps;

import cucumber.framework.SettingsManager;
import cucumber.pages.HomePage;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.exceptions.SerenityManagedException;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

@Slf4j
public class BaseSteps extends ScenarioSteps {

    @Steps
    BackendSteps backendSteps;

    protected HomePage homePage;
    protected SettingsManager settingsManager = new SettingsManager();


    public void webdriver_initialization() {

        settingsManager.initialization();
        System.setProperty("webdriver.ie.driver", "./src/test/resources/drivers/IEDriver.exe");
//        System.setProperty("webdriver.edge.driver", "./src/test/resources/drivers/EDGEdriver.exe");
//        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/ChromeD.exe");


    }

    public void webdriver_finalization() {
        try {
            log.info("Before getDriver().close();");
            getDriver().close();
            log.info("After getDriver().close();");
        } catch (SerenityManagedException e) {
            log.info("Got SerenityManagedException");
        }
    }
}
