package stepdefinition;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@Abhishek")
    public void beforeScenario() throws IOException {

            StepDefinition st = new StepDefinition();
            if (StepDefinition.place_id==null) {
                st.add_place_payload("abhi", "oriya", "bbi");
                st.user_calls_api_with_post_http_request("AddPlaceAPI", "post");
                st.verify_place_id_created_maps_to_using("abhi","GetPlaceAPI");
            }
    }
}
