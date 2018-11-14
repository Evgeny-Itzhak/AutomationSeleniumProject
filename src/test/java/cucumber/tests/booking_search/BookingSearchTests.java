package cucumber.tests.booking_search;


import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(glue = "cucumber.behaviors", features="src/test/resources/features/application/booking_search.feature")
public class BookingSearchTests {
}
