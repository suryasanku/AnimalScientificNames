package com.suryasanku.chatmentAssignment.requestdto;



import java.util.Date;

import lombok.Data;

@Data
public class AnimalRequestDto {
	private Long id;
	private String animalName;
	private String ipaddress;
	private String fact;
	private String timeOfAccess;
//	private Date currentTime;
	

}
