package com.example.entity;


import jakarta.annotation.security.PermitAll;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	@NotEmpty(message = "Name can not be empty")
	@Pattern(regexp = "^[A-Z][a-z]+\\W[A-Z][a-z]+$",
			  message ="First letter of String Must be capital.Take a space between two string")
	private String empName;
	
	@NotNull(message = "Age can not be empty")
	@Min(value = 18,message = "Age must be above 18.")
	@Max(value = 70,message =" below 70")
	private Integer empAge;
	@NotNull(message = "Age can not be empty")
	@Min(value = 10000, message = "Minimum salary is 10,000")
	private Double empSal;
	
}
