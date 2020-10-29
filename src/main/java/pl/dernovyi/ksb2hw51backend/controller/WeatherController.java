package pl.dernovyi.ksb2hw51backend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import pl.dernovyi.ksb2hw51backend.model.weather.Weather;

@RestController
@RequestMapping(value = "/weather")
@CrossOrigin(origins = "http://localhost:4200")
public class WeatherController {

    @GetMapping
    public ResponseEntity<Weather> getWeather(  @RequestParam(defaultValue = "London") String city){
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder url = UriComponentsBuilder.fromHttpUrl("http://api.weatherstack.com/current")
                .queryParam("access_key", "3b3e5cf8143b0bcc149653a5fdb66d3f")
                .queryParam("query", city);
        return new ResponseEntity(restTemplate.getForEntity(url.toUriString(),
                Weather.class), HttpStatus.OK);
    }
}
