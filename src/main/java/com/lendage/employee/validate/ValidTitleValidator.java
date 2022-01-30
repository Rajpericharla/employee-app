package com.lendage.employee.validate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lendage.employee.constants.Title;

public class ValidTitleValidator implements ConstraintValidator<ValidTitle, String> {

	private static final List<Title> availableCategories = new ArrayList<>(Arrays.asList(Title.values()));

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return availableCategories.stream().anyMatch(c -> c.getValue().equalsIgnoreCase(value));
	}

}