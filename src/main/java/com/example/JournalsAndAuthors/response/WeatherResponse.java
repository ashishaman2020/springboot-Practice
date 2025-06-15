package com.example.JournalsAndAuthors.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WeatherResponse {
    private Current current;

    public class Current {
        private int temperature;
        @JsonProperty("weather_descriptions")
        private List<String> weatherDescription;
        @JsonProperty("feelslike")
        private int feelsLike;

        public int getTemperature() {
            return temperature;
        }

        public void setTemperature(int temperature) {
            this.temperature = temperature;
        }

        public List<String> getWeatherDescription() {
            return weatherDescription;
        }

        public void setWeatherDescription(List<String> weatherDescription) {
            this.weatherDescription = weatherDescription;
        }

        public int getFeelsLike() {
            return feelsLike;
        }

        public void setFeelsLike(int feelsLike) {
            this.feelsLike = feelsLike;
        }
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }
}
