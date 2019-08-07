package com.example.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.emp.Employee;
@Service
public class RestService {
private Map<Integer,Employee> map=new HashMap<Integer,Employee>();
public Employee save(Employee e) throws Exception
{
	if(map.containsKey(e.getId()))
		throw new Exception("Already exist");
	map.put(e.getId(),e);
	return e;
}
public Employee get(int id) throws Exception {
	if (!map.containsKey(id)) {
		throw new Exception("Employee doesn't exist");
	}
	return map.get(id);
}
public Set<Employee> getAll() throws Exception {
	if (map.isEmpty()) {
		throw new Exception("No data");
	}
	return new HashSet<>(map.values());
}
public Employee update(int id,Employee e) throws Exception {
	if ( !map.containsKey(e.getId())) {
		throw new Exception("Employee doesn't exist");
	}
	map.put(id,e);
	return e;
}
public String delete(int id) throws Exception {
	if (!map.containsKey(id)) {
		throw new Exception("Employee doesn't exist");
	}
	map.remove(id);
	return ("deleted");
}
}
