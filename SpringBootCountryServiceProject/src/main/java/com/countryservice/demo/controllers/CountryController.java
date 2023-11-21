package com.countryservice.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.countryservice.demo.beans.Country;
import com.countryservice.demo.services.CountryService;



/**
 * http://localhost:8080/getCountries
 * http://localhost:8080/getCountries/1
 * http://localhost:8080/getCountries/countryname?name=india
 * http://localhost:8080/addcountry
 * http://localhost:8080/updatecountry/2
 * http://localhost:8080/deletecountry/2
 */

@RestController
public class CountryController {
	
	
	//Autowired concept - No need to create an Object of class , just start with variables
	//Concept of dependency injection - No need to create an Object
	//class which is used for Autowired , need to use @Component annotation
	
	//CountryService countryService = new CountryService(); --> Object not requied with new
	
	@Autowired
	CountryService countryService;
	
	@GetMapping("/getCountries")
	public List getAllCountries() {
		return countryService.getAllCountries();
	}
	
	@GetMapping("/getCountries/{id}")
	public  ResponseEntity<Country> getCountryByID(@PathVariable(value="id") int id) {
		try {
		Country country =countryService.getCountryById(id);
		return new ResponseEntity<Country>(country,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
			}
		}
	
	
	@GetMapping("/getCountries/countryname")
	public  ResponseEntity<Country> getCountrybyName(@RequestParam(value="name") String name) {
		
		try {
			Country country =countryService.getCountryByName(name);
			return new ResponseEntity<Country>(country,HttpStatus.OK);
			}
			catch(Exception e)
			{
				return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
				}
			}
	
	
	
	@PostMapping("/addcountry")
	public Country addCountry(@RequestBody Country country) {
		return countryService.addCountry(country);	
	}
	
	@PutMapping(("/updatecountry/{id}"))
	public ResponseEntity<Country> updateCountry(@PathVariable(value="id") int id,@RequestBody Country country) {
		 try {
		Country existCountry = countryService.getCountryById(id);
		 
		 existCountry.setCountryName(country.getCountryName());
		 existCountry.setCountryCapital(country.getCountryCapital());
		 
		 Country updateCountry=countryService.updateCountry(existCountry);
		 return new ResponseEntity<Country>(updateCountry,HttpStatus.OK);
		 }
		 catch(Exception e) {
			 return new ResponseEntity<Country>(HttpStatus.CONFLICT);
		 }
	}
	
	
	@DeleteMapping("/deletecountry/{id}")
	public  ResponseEntity<Country> deleteCountry(@PathVariable(value="id") int id) {
		Country country = null;
		try {
		country= countryService.getCountryById(id);
		countryService.deleteCountry(id);
		
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Country>(country,HttpStatus.OK);
				
	}
}
