package net.journal.journalAPP.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Getter
@Setter
public class WeatherResponse {

    private Current current;
    // import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
    @Getter
    @Setter
    public class Current{
        private int temperature;
        private ArrayList<String> weather_descriptions;
        @JsonProperty("feelslike")
        private int feelsLike;
    }

}
