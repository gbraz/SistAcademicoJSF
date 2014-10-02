package br.ufc.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class DataUtilTest {

	@Test
	public void addDiaDeveIncrementarDiasDaData() {

		Integer dia = 10;
		Integer mes = 1;
		Integer ano = 1989;
		Date data = DataUtil.date(dia, mes, ano);
		Date dataIncrementada = DataUtil.addDia(data, 1);

		Calendar cal = new GregorianCalendar();
		cal.setTime(dataIncrementada);

		Assert.assertEquals(dia + 1, cal.get(Calendar.DAY_OF_MONTH));
	}

}
