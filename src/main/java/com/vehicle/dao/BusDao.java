package com.vehicle.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicle.customexception.IdnotFoundExcpetion;
import com.vehicle.entity.Bus;
import com.vehicle.repository.BusRepository;

@Repository
public class BusDao {

	@Autowired
	BusRepository br;

	public String setBus(Bus bus) {
		br.save(bus);
		return "Successfully saved";
	}

	public String setAllBus(List<Bus> bus) {
		br.saveAll(bus);
		return "SuccessFully Saved";
	}

	public List<Bus> getAllBus() {

		return br.findAll();
	}

//	public Bus getById(int b) {
//
//		return br.findById(b).get();
//	}
	
	public Bus getById(int b) throws IdnotFoundExcpetion {
		return br.findById(b).orElseThrow(()->new IdnotFoundExcpetion("Id Does not exited"));
	}

	public List<Bus> getByBrand(String s) {
		return br.getByBrand(s);
	}

}
