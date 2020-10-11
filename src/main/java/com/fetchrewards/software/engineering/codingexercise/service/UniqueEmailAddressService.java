package com.fetchrewards.software.engineering.codingexercise.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class UniqueEmailAddressService {

	public int getNumberOfUniqueEmailAddress(String[] uniqueEmailAddress) {
		
		int index = 0;
		String emailAddress = "";
		
		Set<String> set = new HashSet<String>();
		
		for(int i = 0; i < uniqueEmailAddress.length; i++) {
			
			for(int j = 0; j < uniqueEmailAddress[i].length(); j++) {
				
				if(uniqueEmailAddress[i].charAt(j) != '.' && uniqueEmailAddress[i].charAt(j) != '+' && 
						uniqueEmailAddress[i].charAt(j) != '@') {
					emailAddress += uniqueEmailAddress[i].substring(j, j + 1);
				}
				
				if(uniqueEmailAddress[i].charAt(j) == '+' || uniqueEmailAddress[i].charAt(j) == '@') {
					index = uniqueEmailAddress[i].indexOf('@');
					emailAddress += uniqueEmailAddress[i].substring(index, uniqueEmailAddress[i].length());
					j = uniqueEmailAddress[i].length();
				}
			}
			
			if(!set.contains(emailAddress)) {
				set.add(emailAddress);
			}
			emailAddress = "";
		}
		
		return set.size();
	}

}
