/*
 * package com.countryservice.demo.controllers;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.countryservice.demo.beans.Country; import
 * com.countryservice.demo.services.CountryService1;
 * 
 *//**
	 * http://localhost:8080/getCountries http://localhost:8080/getCountries/1
	 * http://localhost:8080/getCountries/countryname?name=india
	 * http://localhost:8080/addcountry http://localhost:8080/updatecountry
	 * http://localhost:8080/deletecountry/2
	 *//*
		 * 
		 * @RestController public class CountryController1 {
		 * 
		 * // Autowired concept - No need to create an Object of class , just start with
		 * variables //Concept of dependency injection - No need to create an Object
		 * //class which is used for Autowired , need to use @Component annotation
		 * 
		 * //CountryService countryService = new CountryService(); --> Object not
		 * requied with new
		 * 
		 * 
		 * @Autowired CountryService1 countryService;
		 * 
		 * @GetMapping("/getCountries") public List getAllCountries() { return
		 * countryService.getAllCountries(); }
		 * 
		 * @GetMapping("/getCountries/{id}") public Country
		 * getCountryByID(@PathVariable(value = "id") int id) {
		 * 
		 * return countryService.getCountryById(id); }
		 * 
		 * @GetMapping("/getCountries/countryname") public Country
		 * getCountrybyID(@RequestParam(value = "name") String name) {
		 * 
		 * return countryService.getCountryByName(name); }
		 * 
		 * @PostMapping("/addcountry") public Country addCountry(@RequestBody Country
		 * country) { return countryService.addCountry(country); }
		 * 
		 * @PutMapping(("/updatecountry")) public Country updateCountry(@RequestBody
		 * Country country) { return countryService.updateCountry(country); }
		 * 
		 * @DeleteMapping("/deletecountry/{id}") public AddResponse
		 * deleteCountry(@PathVariable(value = "id") int id) {
		 * 
		 * return countryService.deleteCountry(id); } }
		 */