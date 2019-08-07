package com.example.demo;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.emp.Employee;


@RestController
@RequestMapping("/simple")
public class Simplecontroller {
	@Autowired
	private RestService restservice;
	private String token="";
@GetMapping
	@RequestMapping(value="/hello")
	public Object helloWorld()
	{
		return "hello world" ;
	}

@PostMapping
@RequestMapping(value="/employee")
public Employee saveEmp(@RequestBody Employee e) throws Exception{
	return restservice.save(e);
}
@GetMapping
@RequestMapping(value="/employee/{id}")
public Employee getbyid(@PathVariable("id") int id,@RequestHeader("token") String token) throws Exception{
	if(this.token==null || !this.token.equals(token))
		throw new Exception("Invalid token");
	return restservice.get(id);
}
@GetMapping
@RequestMapping(value="/employees")
public Set<Employee> getbyid() throws Exception{
	return restservice.getAll();
}

@PutMapping
@RequestMapping(value="/employee/update/{id}")
public Employee getbyid(@PathVariable("id") int id, @RequestBody Employee e) throws Exception{
	return restservice.update(id,e);
}
@DeleteMapping
@RequestMapping(value="/employee/delete/{id}")
public String deleteemp(@PathVariable int id) throws Exception{
	return restservice.delete(id);
}
@GetMapping
@RequestMapping(value="/employee/token")
public String token() throws Exception{
	token= UUID.randomUUID().toString();
	return token;
}
}
