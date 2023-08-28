package com.vehicle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.customexception.BrandNotFoundException;
import com.vehicle.customexception.IdnotFoundExcpetion;
import com.vehicle.customexception.InvalidException;
import com.vehicle.dao.BusDao;
import com.vehicle.entity.Bus;

@Service
public class BusService {

	@Autowired
	BusDao bd;

	public String setBus(Bus bus) throws InvalidException {

		try {

			if (bus.getBoard().equalsIgnoreCase("white")) {
				return bd.setBus(bus);
			} else {
				throw new InvalidException("Invalid Data");
			}
		} catch (InvalidException exception) {
			return "Invalid Data";
		}

	}

	public String setAllBus(List<Bus> bus) throws InvalidException {

		List<Bus> s = bus.stream()
				.filter(x -> x.getBoard().equalsIgnoreCase("White") || x.getBoard().equalsIgnoreCase("Yellow"))
				.toList();

		if (s.isEmpty()) {
			throw new InvalidException("Invalid data");
		} else {
			return bd.setAllBus(s);

		}

	}

	public List<Bus> getAllBus() {

		return bd.getAllBus();
	}

	public Bus getById(int b) throws IdnotFoundExcpetion {
		
		
		return bd.getById(b);
	}

	public List<Bus> getByBrand(String s) throws BrandNotFoundException {
		List<Bus> x =bd.getByBrand(s);
		if (x.isEmpty()) {
			throw new BrandNotFoundException("Brand not listed");
		} else {
			return x;
		}
	}

	public String update(int id, Bus bus) throws InvalidException, IdnotFoundExcpetion {
		 Bus x=getById(id);
		 Bus y=bus;
		 
		 x.setId(id);
		 x.setName(y.getName());
		 x.setBrand(y.getBrand());
		 x.setBoard(y.getBoard());
		 x.setColor(y.getColor());
		 bd.setBus(x);
		 return "Updated Successfully";
		 
	}

}
