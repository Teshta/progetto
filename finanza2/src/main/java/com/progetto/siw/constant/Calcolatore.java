package com.progetto.siw.constant;

import java.time.LocalDate;
import java.time.Period;

import javax.annotation.ManagedBean;

@ManagedBean
public class Calcolatore {
	
	public static boolean convalidaEtaAllievo(LocalDate date) {
		return (Period.between(LocalDate.of(1900,1,1), date).getDays() > 0) && 
				!(Period.between(date, LocalDate.now()).getYears() < 14);
	}

	public static boolean convalidaDataCorso(LocalDate date) {
		return (Period.between(LocalDate.of(1900,1,1), date).getDays() > 0) &&
				(Period.between(date, LocalDate.now()).getDays() > 0);
	}

	public static boolean isDataPassata(LocalDate date) {
		return (Period.between(date, LocalDate.now()).getDays() > 0);
	}

	public static int calcolaEta(LocalDate birthDate, LocalDate currentDate) {
		if ((birthDate != null) && (currentDate != null)) {
			return Period.between(birthDate, currentDate).getYears();
		} else {
			return 0;
		}
	}

	public static int calcolaEta(LocalDate birthDate) {
		if (birthDate != null) {
			return Period.between(birthDate, LocalDate.now()).getYears();
		} else {
			return 0;
		}
	}
}
