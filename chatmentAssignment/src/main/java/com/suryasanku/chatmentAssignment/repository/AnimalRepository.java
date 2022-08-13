package com.suryasanku.chatmentAssignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suryasanku.chatmentAssignment.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal,Long> {

	Animal findByAnimalName(String animalName);

}
