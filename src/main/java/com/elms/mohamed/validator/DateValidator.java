package com.elms.mohamed.validator;

import java.time.LocalDate;

public class DateValidator {

	public static boolean isInvalidDate(LocalDate date) {
		LocalDate today = LocalDate.now();
		boolean invalid = false;
		if(date.isBefore(today)) {
			invalid = true;
		}
		// if true, it is a valid date , else it is an invalid date
		return invalid;
	}
}
