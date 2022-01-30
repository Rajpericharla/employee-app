package com.lendage.employee.constants;

public enum Title {
	DEVELOPER("Developer"), PM("PM"), CEO("CEO"), CTO("CTO");

	private String value;

	Title(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}