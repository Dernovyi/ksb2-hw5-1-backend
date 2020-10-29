package pl.dernovyi.ksb2hw51backend.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.dernovyi.ksb2hw51backend.model.YesOrNo;


@RestController
@RequestMapping(path = "/game")
//@CrossOrigin(origins = "http://localhost:4200")
public class EventController {


    @GetMapping
    public ResponseEntity<YesOrNo> get(){
        RestTemplate restTemplate = new RestTemplate();

      return  restTemplate.getForEntity("https://yesno.wtf/api/",
                YesOrNo.class);

    }

}
