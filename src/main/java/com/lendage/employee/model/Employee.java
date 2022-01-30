package com.lendage.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.lendage.employee.validate.ValidTitle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer employeeNo;
	
	@Column
	@NotBlank(message = "FirstName is mandatory")
	private String firstName;
	
	@Column
	@NotBlank(message = "LastName is mandatory")
	private String lastName;
	
	@Column
	private String dob;
	
	@Column
	@ValidTitle
	private String title;
}
