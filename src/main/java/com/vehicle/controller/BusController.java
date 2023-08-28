package com.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.vehicle.customexception.BrandNotFoundException;
import com.vehicle.customexception.IdnotFoundExcpetion;
import com.vehicle.customexception.InvalidException;
import com.vehicle.entity.Bus;
import com.vehicle.service.BusService;

@RestController

public class BusController {

	@Autowired
	BusService bs;

	@PatchMapping(value = "/setBus")

	public String setBus(@RequestBody Bus bus) throws InvalidException {
		return bs.setBus(bus);
	}

	@PostMapping(value = "/setAllBus")

	public String setAllBus(@RequestBody List<Bus> bus) throws InvalidException {
		return bs.setAllBus(bus);
	}

	@GetMapping(value = "/getBus")
	public List<Bus> getAllBus() {
		return bs.getAllBus();
	}

	@GetMapping(value = "/getBus/{b}")
	public Bus getById(@PathVariable int b) throws IdnotFoundExcpetion {

		return bs.getById(b);
	}

	@GetMapping(value = "/getByBrand/{s}")
	public List<Bus> getByBrand(@PathVariable String s) throws BrandNotFoundException {
		return bs.getByBrand(s);

	}

	@PutMapping(value = "/update/{id}")
	public String update(@PathVariable int id, @RequestBody Bus bus) throws InvalidException, IdnotFoundExcpetion {
		return bs.update(id, bus);
	}

}
