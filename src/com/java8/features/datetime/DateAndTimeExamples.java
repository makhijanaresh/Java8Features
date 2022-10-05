package com.java8.features.datetime;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateAndTimeExamples {
	
	public static void main(String[] args) {
		//simpleDateFormatExample();
	//	localDateExamples();
	//localTimeExamples();
		//localDateTimeExample();
		zonedDateTimeExample();
	}

	private static void simpleDateFormatExample() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);
		System.out.println(strDate);
	}

	private static void zonedDateTimeExample() {
	//	System.out.println(ZoneId.of("Europe/Paris"));
		//System.out.println("Asia/Kolkata");
		// ZoneId.getAvailableZoneIds().forEach(System.out::println);
		System.out.println(ZonedDateTime.parse("2015-06-04T10:15:30+02:00[Europe/Paris]"));
	}

	private static void localDateTimeExample() {
		System.out.println(LocalDateTime.now());
		System.out.println(LocalDateTime.now(ZoneId.of("GMT")));
		System.out.println(LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30));
		System.out.println(LocalDateTime.parse("2015-03-20T06:30:00"));
		System.out.println("Tomorrow DateTime:" + LocalDateTime.now().plusDays(1));
		System.out.println("Time before 2 hours:" + LocalDateTime.now().minusHours(2));
		System.out.println("Current Month:" + LocalDateTime.now().getMonth());
	}

	private static void localTimeExamples() {
		System.out.println(LocalTime.now());
		System.out.println(LocalTime.now(ZoneId.of("GMT")));
		System.out.println(LocalTime.parse("06:30"));
		System.out.println(LocalTime.of(6, 30));
		System.out.println(LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS));
		System.out.println(LocalTime.now(Clock.system(ZoneId.of("Asia/Kolkata"))).getHour());

		System.out.println(LocalTime.parse("06:30") + " is before:" + LocalTime.parse("07:30") + ":"
				+ (LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"))));

		System.out.println(LocalTime.parse("06:30") + " is after:" + LocalTime.parse("07:30") + ":"
				+ (LocalTime.parse("06:30").isAfter(LocalTime.parse("07:30"))));

		System.out.println("LocalTime Max:" + LocalTime.MAX);
		System.out.println("LocalTime Min:" + LocalTime.MIN);
	}

	private static void localDateExamples() {
		System.out.println(LocalDate.now());
		System.out.println(LocalDate.now(ZoneId.of("GMT")));
		System.out.println(LocalDate.of(2015, 02, 20));
		System.out.println(LocalDate.parse("2015-02-20"));
		System.out.println("Tomorrow Date:" + LocalDate.now().plusDays(1));
		System.out.println("Previous month same day:" + LocalDate.now().minus(1, ChronoUnit.MONTHS));
		System.out.println("Date of week::" + LocalDate.now().getDayOfWeek());
		System.out.println("Is leap year" + LocalDate.now().isLeapYear());
		System.out.println("2016-06-12 is before: 2016-06-11"
				+ (LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11"))));

		System.out.println("2016-06-12 is after: 2016-06-11"
				+ (LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11"))));

		System.out.println(
				"First day of month:" + LocalDate.parse("2021-06-12").with(TemporalAdjusters.firstDayOfMonth()));

		System.out.println("LocalDate Max:" + LocalDate.MAX);
		System.out.println("LocalDate Min:" + LocalDate.MIN);

		System.out.println("days between two dates:"
				+ Period.between(LocalDate.parse("2022-02-04"), LocalDate.parse("2022-03-07")));

		System.out.println("days between two dates in days:"
				+ Period.between(LocalDate.parse("2022-02-04"), LocalDate.parse("2022-03-07")).getDays());

		System.out.println("days between two dates in months:"
				+ Period.between(LocalDate.parse("2022-02-04"), LocalDate.parse("2022-03-07")).getMonths());

	}
}
