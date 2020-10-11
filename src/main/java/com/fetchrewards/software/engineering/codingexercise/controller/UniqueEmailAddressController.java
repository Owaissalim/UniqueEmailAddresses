package com.fetchrewards.software.engineering.codingexercise.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fetchrewards.software.engineering.codingexercise.bean.UniqueEmailAddress;
import com.fetchrewards.software.engineering.codingexercise.service.UniqueEmailAddressService;


@Controller
public class UniqueEmailAddressController {

	@Autowired
	private UniqueEmailAddressService uniqueEmailAddressService;
	
	@Autowired
	public UniqueEmailAddressController(UniqueEmailAddressService uniqueEmailAddressService) {
		super();
		this.uniqueEmailAddressService = uniqueEmailAddressService;
	}
	
	@GetMapping(value = "/")
	public String getHomePage() {
		
		return "index";
	}
	
	@PostMapping(value = "/getCountOfUniqueEmailAddress")
	@ResponseBody
	public int getCountOfUniqueEmailAddress(@RequestBody UniqueEmailAddress uniqueEmailAddress) {
		
		return uniqueEmailAddressService.getNumberOfUniqueEmailAddress(uniqueEmailAddress.getEmailAddress());
	}
	
}
