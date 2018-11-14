package cucumber.pages;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class BasePage extends PageObject {

    public void waitUntilLoading() {
        log.info("Start sync loading");
        waitForDocumentReadyState();
//        waitForJQuery();
        log.info("End sync loading");
    }

    public void waitForDocumentReadyState() {
        try {
            (new WebDriverWait(getDriver(), 5)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                }
            });
        } catch (RuntimeException e) {
            log.error("Failed sync document ready state");
        }
    }

    public void waitForJQuery() {
        try {
            (new WebDriverWait(getDriver(), 5)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
                }
            });
        } catch (RuntimeException e) {
            log.error("Failed sync JQuery");
        }
    }
}
