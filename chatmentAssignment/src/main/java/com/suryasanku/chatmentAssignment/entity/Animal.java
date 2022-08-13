package com.suryasanku.chatmentAssignment.entity;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String animalName;
	private String ipaddress;
	private String fact;
	private String timeOfAccess;
//	private Date currentTime;

}
