package guru.springframework.springaifunctions.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonClassDescription("Weather API request")
public record WeatherRequest(
        @JsonProperty(required = true, value = "lat")
        @JsonPropertyDescription("Latitude of the location")
        Double lat,

        @JsonProperty(required = true, value = "lon")
        @JsonPropertyDescription("Longitude of the location")
        Double lon
) {}
