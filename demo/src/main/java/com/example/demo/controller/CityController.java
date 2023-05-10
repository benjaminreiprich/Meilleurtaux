package com.example.demo.controller;

import com.example.demo.exceptions.CityNotFoundException;
import com.example.demo.model.City;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CityController {

    @GetMapping("/city/{zipCode}")
    public ResponseEntity<?> getCityInfo(@PathVariable String zipCode) {
        String govApiUrl = "https://geo.api.gouv.fr/communes?codePostal=" + zipCode;
        RestTemplate restTemplate = new RestTemplate();
        try {
            JsonNode response = restTemplate.getForObject(govApiUrl, JsonNode.class);
            City cityInfo = new City();
            if (response != null && response.size() > 0) {
                String cityName = response.get(0).get("nom").asText();
                Integer cityPopulation = response.get(0).get("population").asInt();
                cityInfo.setName(cityName);
                cityInfo.setPopulation(cityPopulation);

                return ResponseEntity.ok().body(cityInfo);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CityNotFoundException("La ville demandée avec le code " + zipCode + " est introuvable.").getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }        }

}