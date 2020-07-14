package com.ambientflix.restdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestdemoApplication.class, args);
		
		RestTemplate restTemplate = new RestTemplate();
		//HttpEntity<String> request = new HttpEntity<>("");
		MovieResults result = restTemplate.getForObject("https://api.themoviedb.org/3/search/movie?api_key=9950b15cd666adb852b2ea54472b7c38&query=Jack+Reacher", MovieResults.class);		

		System.out.println("Total: " + result.getTotal_results());

		for(MovieResult movieResult : result.getResults()) {
			System.out.println(movieResult.getTitle());
		}
		
	}

}
