package com.rapido.parent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rapido.parent.dto.BookingDetailsForAllRidersDto;
import com.rapido.parent.dto.Coordinatesdto;
import com.rapido.parent.dto.Customerdto;
import com.rapido.parent.dto.ResponseSelectDto;
import com.rapido.parent.dto.ResponseStructure;
import com.rapido.parent.dto.SearchDestLocResponseDto;
import com.rapido.parent.dto.SelectRidedto;
import com.rapido.parent.entity.Customer;
import com.rapido.parent.service.CoordinateService;
import com.rapido.parent.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService cs;
	@Autowired
	private CoordinateService coordinateservice;
	
	@PostMapping("/customer/createaccount")
	public void createacc(@RequestBody Customerdto customerdto)
	{
		cs.createaccservice(customerdto);
	}
	
	@DeleteMapping("/customer/deleteaccount")
	public ResponseStructure<Customer> deleteacc(@RequestParam int id)
	{
		return cs.deleteaccservice(id);
	}
	
	@GetMapping("/customer/getaccount")
	public ResponseStructure<Customer> getaccount(@RequestParam int id)
	{
		return cs.findbyidservice(id);
	}
	
	@GetMapping("/customer/searchdroplocation")
	public List<SearchDestLocResponseDto> searchDropLocation(@RequestParam String searchkey) {

		return cs.searchDropLocation(searchkey);
	}
	
	@PostMapping("/customer/selectride")
	public ResponseSelectDto selectride(@RequestParam int id, @RequestBody SelectRidedto selectridedto) {

		return coordinateservice.selectrideservice(id, selectridedto);
	}
	
	@PostMapping("/customer/confirmride")
	public BookingDetailsForAllRidersDto confirmride(@RequestParam int id, @RequestParam String vehicletype,@RequestBody Coordinatesdto cordinatesdto) {

		return cs.confirmRideService(id, vehicletype,cordinatesdto);
	}



}
