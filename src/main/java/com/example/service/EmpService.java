package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Employee;
@Service
public interface EmpService {
	public Boolean saveData(Employee employee);
	public Employee getEmpById(Integer id);
	public void deleteEmpById(Integer id);
	public List<Employee> getAllData();
}
