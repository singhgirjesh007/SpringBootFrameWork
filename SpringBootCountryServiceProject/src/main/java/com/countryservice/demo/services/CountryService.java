package com.countryservice.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.countryservice.demo.beans.Country;
import com.countryservice.demo.controllers.AddResponse;
import com.countryservice.demo.repositories.CountryRepository;

//class which is used for Autowired , need to use @Component annotation

@Component
@Service
public class CountryService {

	@Autowired
	CountryRepository countryrep;

	public List getAllCountries() {
		return countryrep.findAll();
		
	}

	public Country getCountryById(int id) {

		return countryrep.findById(id).get();
	}

	public Country getCountryByName(String name) {
		List<Country> countries = countryrep.findAll();
		Country country = null;
		for(Country con : countries) {
			if(con.getCountryName().equals(name))
				country =con;
		}
		return country;
		
	}

	public Country addCountry(Country country) {
		country.setId(getMaxID());
		countryrep.save(country);
		return country;
	}

	// utitlity method to get MaxId
	public int getMaxID() {

		return countryrep.findAll().size()+1;
	}

	public Country updateCountry(Country country) {

		countryrep.save(country);
		return country;
	}

	public AddResponse deleteCountry(int id) {
		countryrep.deleteById(id);
		AddResponse res = new AddResponse();
		res.setMsg("country delated");
		res.setId(id);
		
		return res;

		
	}

}
