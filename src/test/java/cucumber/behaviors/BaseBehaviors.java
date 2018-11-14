package cucumber.behaviors;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.framework.SettingsManager;
import cucumber.steps.BaseSteps;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

@Slf4j
public class BaseBehaviors {

    protected SettingsManager settingsManager = new SettingsManager();

    @Steps
    private BaseSteps baseSteps;

    private String testID;
    private String testSetID;

    @Before
    public void beforeMethod (Scenario scenario) throws NoSuchFieldException, IllegalAccessException {

        Serenity.getCurrentSession().put("Start Time", System.currentTimeMillis());

        if (scenario.getSourceTagNames().toString().contains("@testSet_id")) {
            testSetID = (scenario.getSourceTagNames().stream().filter(tag -> tag.contains("@testSet_id:")).findFirst().get().split(":")[1]);
        } else testSetID = "";

        if (scenario.getSourceTagNames().toString().contains("@test_id")) {
            testID = (scenario.getSourceTagNames().stream().filter(tag -> tag.contains("@test_id:")).findFirst().get().split(":")[1]);
        }

        baseSteps.webdriver_initialization();

        Serenity.getCurrentSession().put("Scenario Name", scenario.getName());
        Serenity.getCurrentSession().put("Scenario Info", scenario);
    }

    @After
    public void afterMethod(Scenario scenario) {
        String status = scenario.getStatus().toString();
        log.info("BaseBehaviors => Test status: ", status);
        baseSteps.webdriver_finalization();

    }
}
