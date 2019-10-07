package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CountryController {
    // localhost:2019/names/all
    @GetMapping(value = "/names/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries() {
        CountriesApplication.countryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(CountriesApplication.countryList.countryList, HttpStatus.OK);
    }

    // localhost:2019/names/start/{letter}
    @GetMapping(value = "/names/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByFirstLetter(@PathVariable char letter) {
        ArrayList<Country> rtnCountries = CountriesApplication.countryList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    // localhost:2019/names/size/{number}
    @GetMapping(value = "/names/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesBySize(@PathVariable int number) {
        ArrayList<Country> rtnCountries = CountriesApplication.countryList.findCountries(c -> c.getName().length() <= number);
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    // localhost:2019/population/size/{people}
    @GetMapping(value = "/population/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByPopulationLargerThan(@PathVariable long people) {
        ArrayList<Country> rtnCountries = CountriesApplication.countryList.findCountries(c -> c.getPopulation() >= people);
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    // localhost:2019/population/min
    @GetMapping(value = "/population/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithSmallestPopulation() {
        CountriesApplication.countryList.countryList.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));
        return new ResponseEntity<>(CountriesApplication.countryList.countryList.get(0), HttpStatus.OK);
    }

    // localhost:2019/population/max
    @GetMapping(value = "/population/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithLargestPopulation() {
        CountriesApplication.countryList.countryList.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));
        return new ResponseEntity<>(CountriesApplication.countryList.countryList.get(0), HttpStatus.OK);
    }

    // localhost:2019/age/age/{age}
    @GetMapping(value = "/age/age/{age}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByAgeGreaterThan(@PathVariable int age) {
        ArrayList<Country> rtnCountries = CountriesApplication.countryList.findCountries(c -> c.getMedianAge() >= age);
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    // localhost:2019/age/min
    @GetMapping(value = "/age/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithSmallestAge() {
        CountriesApplication.countryList.countryList.sort((c1, c2) -> (int)(c1.getMedianAge() - c2.getMedianAge()));
        return new ResponseEntity<>(CountriesApplication.countryList.countryList.get(0), HttpStatus.OK);
    }

    // localhost:2019/population/max
    @GetMapping(value = "/age/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithLargestAge() {
        CountriesApplication.countryList.countryList.sort((c1, c2) -> (int)(c2.getMedianAge() - c1.getMedianAge()));
        return new ResponseEntity<>(CountriesApplication.countryList.countryList.get(0), HttpStatus.OK);
    }
}
