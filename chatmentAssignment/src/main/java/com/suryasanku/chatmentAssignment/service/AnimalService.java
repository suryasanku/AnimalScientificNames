package com.suryasanku.chatmentAssignment.service;

import java.util.List;

import com.suryasanku.chatmentAssignment.responsedto.AnimalResponseDto;

public interface AnimalService {

	String addAnimal(String animalName,String fact);

    AnimalResponseDto getAnimal(String animalName);

	List<AnimalResponseDto>getAllAnimals();

}
