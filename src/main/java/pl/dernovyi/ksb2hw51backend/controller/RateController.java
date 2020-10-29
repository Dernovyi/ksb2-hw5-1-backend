package pl.dernovyi.ksb2hw51backend.controller;

import com.sun.javafx.cursor.CursorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.dernovyi.ksb2hw51backend.model.Rate.Rate;
import pl.dernovyi.ksb2hw51backend.model.Rate.TypeCurrency;

import java.util.Random;

@RestController
@RequestMapping(path = "/rate")
@CrossOrigin(origins = "http://localhost:4200")
public class RateController {
    @GetMapping
    public ResponseEntity<Rate> getRate(@RequestParam(defaultValue = "PLN") String currencyType,
                                        @RequestParam(defaultValue = "random") String choice){
        RestTemplate restTemplate = new RestTemplate();
        if(choice.equalsIgnoreCase("random")){
            choice = TypeCurrency.values()[new Random().nextInt(30)].toString();
        }
        UriComponentsBuilder url = UriComponentsBuilder.fromHttpUrl("https://api.exchangeratesapi.io/latest")
                .queryParam("base", currencyType);

        return new ResponseEntity(restTemplate.getForEntity(url.toUriString(),
                Rate.class), HttpStatus.OK);

    }
}
