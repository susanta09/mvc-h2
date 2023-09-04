package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmpRepository;
@Service
public class EmpServiceImpl implements EmpService{
	@Autowired
	private EmpRepository empRepository;

	@Override
	public Boolean saveData(Employee employee) {
		Employee e = empRepository.save(employee);
//		System.out.println("successfull");
//		System.out.println(e);
		if (e != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Employee> getAllData() {
		List<Employee>li=empRepository.findAll();
		return li;
	}

	@Override
	public Employee getEmpById(Integer id) {
	
	 return empRepository.findById(id).get();
	}

	@Override
	public void deleteEmpById(Integer id) {
		empRepository.deleteById(id);
	}

	

}
