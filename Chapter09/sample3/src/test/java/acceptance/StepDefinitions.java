package acceptance;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

/** Steps definitions for calculator.feature */
public class StepDefinitions {
    private String server = System.getProperty("calculator.url");

    private RestTemplate restTemplate = new RestTemplate();

    private String a;
    private String b;
    private String result;

    @Given("^I have dividend and divisor: (.*) and (.*)$")
    public void i_have_dividend_and_divisor(String a, String b) throws Throwable {
        this.a = a;
        this.b = b;
    }

    @When("^the calculator divides them$")
    public void the_calculator_divides_them() throws Throwable {
        String url = String.format("%s/divide?a=%s&b=%s", server, a, b);
        result = restTemplate.getForObject(url, String.class);
    }

    @Then("^I receive (.*) as the quotient$")
    public void i_receive_as_the_quotient(String expectedResult) throws Throwable {
        assertEquals(expectedResult, result);
    }
}
