package com.suryasanku.chatmentAssignment.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.suryasanku.chatmentAssignment.responsedto.AnimalResponseDto;
import com.suryasanku.chatmentAssignment.service.AnimalService;
import org.springframework.http.HttpHeaders;



//
//@RestController
//
//@RequestMapping("/movies")
//
//public class MovieResource {
//
//1
//
//
//@Value("$(api.key}") private String apikey;
//
//
//
//@Autowired
//
//
//private RestTemplate restTemplate;
//
//
//@RequestMapping("/{movieId)")
//
//public Movie getMovieInfo(@PathVariable("movieId") String movieId) { MovieSummary movieSummary = restTemplate.getForObject(
//
//"https://api.themoviedb.org/3/movie/"+movieId"?api_key=" + apikey,
//
//MovieSummary.class
@RestController
@RequestMapping("/animals")
public class AnimalController {
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	@Autowired
	private AnimalService animalservice;
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	@Value("${api.key}")
	private String apiKey;
	@Value("${service.url}")
	private String url;
	@PostMapping("/{animalName}")
	public String addAnimal(@PathVariable("animalName") String animalName){
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("X-RapidAPI-Key", "c482fbc63dmshadbf4a82e785b8dp199efcjsn055d7056d92e");
        headers.add("X-RapidAPI-Host", "animaliapi3.p.rapidapi.com");
		ResponseEntity<String> response = restTemplate.exchange(
			    url+animalName, HttpMethod.GET, new HttpEntity<Object>(headers),
                String.class);
		//"http://localhost:8080"  +
//		ResponseEntity<NewAnimal> response =
//				  restTemplate.getForEntity(
//				  "https://animaliapi3.p.rapidapi.com/all/"+animalName,
//				  NewAnimal.class);
		System.out.println(response.getBody());
		String fact="nothing";
		String factor=response.getBody();
		for(int i=0;i<factor.length()-7;i++) {
			if(factor.charAt(i)=='s'&&factor.charAt(i+1)=='c'&&factor.charAt(i+2)=='i') {
				fact=factor.substring(i+17,factor.length()-3);
				break;
			}
		}
		
     	return animalservice.addAnimal(animalName,fact);
				
		
	}
//	@GetMapping("/facts/{animalName}")
//	public AnimalResponseDto getAnimal(@PathVariable String animalName) {
//		return animalservice.getAnimal(animalName);
//	}
	@GetMapping("/getAllAnimals")
	public List<AnimalResponseDto> getAllAnimals() {
		return animalservice.getAllAnimals();
	}

	
	

}
