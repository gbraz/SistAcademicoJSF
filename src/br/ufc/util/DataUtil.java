package br.ufc.util;

import java.util.Date;
import java.util.GregorianCalendar;

public class DataUtil {

	public static Date date(int dia, int mes, int ano) {

		return new GregorianCalendar(ano, mes, dia).getTime();
	}

	public static Date addDia(Date data, int qtdDias) {

		GregorianCalendar calendarDaData = new GregorianCalendar();
		calendarDaData.setTime(data);
		calendarDaData.add(GregorianCalendar.DAY_OF_MONTH, qtdDias);

		return calendarDaData.getTime();
	}

}
