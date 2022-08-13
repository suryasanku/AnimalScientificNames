package com.suryasanku.chatmentAssignment.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import com.suryasanku.chatmentAssignment.dto.mapper;
import com.suryasanku.chatmentAssignment.entity.Animal;
import com.suryasanku.chatmentAssignment.repository.AnimalRepository;
import com.suryasanku.chatmentAssignment.responsedto.AnimalResponseDto;





@Service
public class AnimalServiceImpl implements AnimalService{
	
	@Autowired
	private AnimalRepository animalrepository;
	 

	
//	@Value("#{${simple.map}}")
//	Map<String, String> simpleMap;
	@Autowired 
	private HttpServletRequest request;
	
	List<String>list=new ArrayList<>();


	

  

	@Override
	public String addAnimal(String animalName,String fact) {

		String x;
		Animal animal=new Animal();
		animal.setIpaddress(request.getRemoteAddr());
		if(fact!=null) {
			animal.setFact("The scientific name of this animal is"+" "+fact);
			x="The scientific name of this animal is"+" "+fact;
		}else {
			animal.setFact("sorry this animal doesnt exist");
			x="sorry this animal doesnt exist";
		}

		  Date date = Calendar.getInstance().getTime();  
          DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
          String strDate = dateFormat.format(date);  
		animal.setTimeOfAccess(strDate);
		if(list.contains(animalName)==false) {
			animal.setAnimalName(animalName);
			list.add(animalName);
			
		}
	
			
			
			
		

		
		
		animalrepository.save(animal);
		return x;
		
	}


	@Override
	public AnimalResponseDto getAnimal(String animalName) {
		Animal animal=animalrepository.findByAnimalName(animalName);
		return mapper.animaltoanimalresponsedto(animal);
		
	}


	@Override
	public List<AnimalResponseDto> getAllAnimals() {
		// TODO Auto-generated method stub
		List<Animal>animals=StreamSupport.stream(animalrepository.findAll().spliterator(), false).collect(Collectors.toList());
		return mapper.animalstoanimalsresponsedto(animals);
	}

}
