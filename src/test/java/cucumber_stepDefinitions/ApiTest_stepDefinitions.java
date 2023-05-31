package cucumber_stepDefinitions;

import Utilities.RequestSpec;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;


public class ApiTest_stepDefinitions {

    private static ResponseOptions<Response> response ;

    @Given("I perform GET Operations for {string}")
    public void i_perform_get_operations_for(String url) {

      response =   RequestSpec.GetOps(url);

    }
    @Then("I should see the  author name as {string}")
    public void i_should_see_the_author_name_as(String authorName) {

     assertThat(response.getBody().jsonPath().get("author"), hasItem("typicode"));
    }

}
