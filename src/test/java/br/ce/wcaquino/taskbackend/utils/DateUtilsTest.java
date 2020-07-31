package br.ce.wcaquino.taskbackend.utils;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilsTest {

	
	
	@Test
	public void retornoTrueDataFutura() {
		LocalDate date = LocalDate.of(2021, 10, 15);
		DateUtils.isEqualOrFutureDate(date);
		Assert.assertEquals(true, DateUtils.isEqualOrFutureDate(date));
	}
	
	@Test
	public void retornoFalseDataPassada() {
		LocalDate date = LocalDate.of(2019, 10, 15);
		DateUtils.isEqualOrFutureDate(date);
		Assert.assertEquals(false, DateUtils.isEqualOrFutureDate(date));
	}
	
	@Test
	public void retornoTrueDataPresente() {
		LocalDate date = LocalDate.now();
		DateUtils.isEqualOrFutureDate(date);
		Assert.assertEquals(true, DateUtils.isEqualOrFutureDate(date));
	}
	
	
	
}
