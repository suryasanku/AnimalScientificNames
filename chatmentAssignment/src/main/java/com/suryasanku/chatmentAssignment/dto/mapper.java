package com.suryasanku.chatmentAssignment.dto;

import java.util.ArrayList;
import java.util.List;

import com.suryasanku.chatmentAssignment.entity.Animal;
import com.suryasanku.chatmentAssignment.responsedto.AnimalResponseDto;



public class mapper {
	public static AnimalResponseDto animaltoanimalresponsedto(Animal animal) {
		AnimalResponseDto animalresponsedto=new AnimalResponseDto();
		animalresponsedto.setFact(animal.getFact());
		animalresponsedto.setIpaddress(animal.getIpaddress());
		animalresponsedto.setTimeOfAccess(animal.getTimeOfAccess());
		
		return animalresponsedto;
	}
	public static List<AnimalResponseDto> animalstoanimalsresponsedto(List<Animal>animals){
		List<AnimalResponseDto>animalresponsedto=new ArrayList<>();
		for(Animal animal:animals) {
			animalresponsedto.add(animaltoanimalresponsedto(animal));
		}
		return animalresponsedto;
	}

}
