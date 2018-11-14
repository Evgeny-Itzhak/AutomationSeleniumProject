package cucumber.steps;

import cucumber.pages.ServicePage;
import net.thucydides.core.annotations.Step;

public class ServiceSteps {

    protected ServicePage servicePage;

    @Step
    public void wait_for_page_loaded() {
        servicePage.waitForDocumentReadyState();
    }
}
