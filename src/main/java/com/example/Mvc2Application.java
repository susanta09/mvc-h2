package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.entity.Employee;
import com.example.service.EmpServiceImpl;

@SpringBootApplication
public class Mvc2Application {

	public static void main(String[] args) {
			SpringApplication.run(Mvc2Application.class, args);
//	EmpServiceImpl semp=context.getBean(EmpServiceImpl.class);
//	Employee e=new Employee(12, "susanta", 26, 76000.00);
//	semp.saveData(e);
	}

}
