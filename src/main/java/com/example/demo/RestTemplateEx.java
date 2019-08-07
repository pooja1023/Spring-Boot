package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.emp.Employee;

public class RestTemplateEx {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		Employee request = new Employee();
		request.setId(9);
		request.setName("ABCDE");
		request.setAddress("Hyderabad");
		System.out.println(" Calling Post api");
		ResponseEntity<Employee> postForEntity = restTemplate.postForEntity("http://localhost:8080/simple/employee", request, Employee.class);
		System.out.println("Data posted succesfully");
		System.out.println("Status Code: " + postForEntity.getStatusCodeValue());
		System.out.println("Body" + postForEntity.getBody());
		System.out.println("Headers: " + postForEntity.getHeaders());
		System.out.println("\n\n");
		
		System.out.println("Calling Get api");
		Employee e = restTemplate.getForObject("http://localhost:8080/simple/employee/9", Employee.class);
		System.out.println(e);
	}

}