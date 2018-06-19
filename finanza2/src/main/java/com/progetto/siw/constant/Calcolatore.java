package com.progetto.siw.constant;

import java.time.LocalDate;
import java.time.Period;

import javax.annotation.ManagedBean;

@ManagedBean
public class Calcolatore {
	
	public static boolean convalidaEtaAllievo(LocalDate date) {
		return (Period.between(LocalDate.of(1900,1,1), date).getDays() > 0) && 
				!(Period.between(date, LocalDate.now()).getYears() < 18);
	}

	public static boolean convalidaDataCorso(LocalDate date) {
			return (Period.between(LocalDate.now(), date).getDays() > 0);
	}

	public static boolean isDataPassata(LocalDate date) {
		return (Period.between(date, LocalDate.now()).getDays() > 0);
	}
}
