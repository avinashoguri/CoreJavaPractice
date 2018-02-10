package core.java;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Date manipulation practice class
 * @author Donthu Avinash Babu
 *
 */
public class DatePractice {

	/**
	 * java.time.Clock practice
	 */
	@Test
	public void clock() {
		Clock clock = Clock.systemUTC();
		System.out.println("clock.instant(): " + clock.instant());
		System.out.println("clock.millis(): " + clock.millis());
		System.out.println("clock.getZone(): " + clock.getZone());
	}

	/**
	 * java.time.LocalDate practice. This class will have only date part without time part
	 */
	@Test
	public void localDate() {
		LocalDate localDate1 = LocalDate.now();
		System.out.println("localDate: " + localDate1);

		Clock clock1 = Clock.systemUTC();
		LocalDate localDate2 = LocalDate.now(clock1);
		System.out.println("localDate2: " + localDate2);
	}

	/**
	 * java.time.LocalTime practice. This class will have only time part without date
	 */
	@Test
	public void localTime() {
		LocalTime localTime1 = LocalTime.now();
		System.out.println("localTime1: " + localTime1);

		Clock clock1 = Clock.systemUTC();
		LocalTime localTime2 = LocalTime.now(clock1);
		System.out.println("localTime2: " + localTime2);

		Clock clock2 = Clock.systemDefaultZone();
		LocalTime localTime3 = LocalTime.now(clock2);
		System.out.println("localTime3: " + localTime3);
	}

	/**
	 * java.time.LocalDateTime practice. This class useful to work on date or time or both
	 */
	@Test
	public void localDateTime() {
		LocalDateTime localDateTime1 = LocalDateTime.now();
		System.out.println("localDateTime1: " + localDateTime1);

		Clock clock1 = Clock.systemUTC();
		LocalDateTime localDateTime2 = LocalDateTime.now(clock1);
		System.out.println("localDateTime2: " + localDateTime2);

		Clock clock2 = Clock.systemDefaultZone();
		LocalDateTime localDateTime3 = LocalDateTime.now(clock2);
		System.out.println("localDateTime3: " + localDateTime3);
	}

	/**
	 * java.time.ZonedDateTime practice
	 */
	@Test
	public void zonedDateTime() {
		ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
		System.out.println("zonedDateTime1: " + zonedDateTime1);

		Clock clock1 = Clock.systemUTC();
		ZonedDateTime zonedDateTime2 = ZonedDateTime.now(clock1);
		System.out.println("zonedDateTime2: " + zonedDateTime2);

		ZonedDateTime zonedDateTime3 = ZonedDateTime.now(ZoneId.of("Asia/Calcutta"));
		System.out.println("zonedDateTime3: " + zonedDateTime3);
	}

	/**
	 * java.time.Duration practice.
	 */
	@Test
	public void duration() {
		LocalDateTime localDateTime1 = LocalDateTime.of(2014, Month.NOVEMBER, 27, 15, 50);
		LocalDateTime localDateTime2 = LocalDateTime.of(2016, Month.NOVEMBER, 27, 15, 50);

		Duration duration1 = Duration.between(localDateTime1, localDateTime2);
		System.out.println("duration1: " + duration1);
		System.out.println("days: " + duration1.toDays());
		System.out.println("months: " + duration1.toDays() / 30);
		System.out.println("years: " + (duration1.toDays() / 30) / 12);
		System.out.println("hours: " + duration1.toHours());
		System.out.println("minutes: " + duration1.toMinutes());
		System.out.println("seconds: " + duration1.getSeconds());
	}

	@Test
	public void convertUtilDateToLocalDate() {
		Date date = new Date();
		System.out.println("convertUtilDateToLocalDate() date: " + date);

		Instant instant = date.toInstant();
		System.out.println("convertUtilDateToLocalDate() instant: " + instant);

		ZoneId systemDefaultZoneId = ZoneId.systemDefault();
		LocalDate localDate = instant.atZone(systemDefaultZoneId).toLocalDate();
		System.out.println("convertUtilDateToLocalDate() localDate: " + localDate);
	}

	@Test
	public void convertLocalDateToUtilDate() {
		LocalDate localDate = LocalDate.now();
		System.out.println("convertLocalDateToUtilDate() localDate: " + localDate);

		ZoneId zoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(zoneId).toInstant());
		System.out.println("convertLocalDateToUtilDate() date: " + date);
	}

	@Test
	public void convertUtilDateToLocalDateTime() {
		Date date = new Date();
		System.out.println("convertUtilDateToLocalDateTime() date: " + date);

		Instant instant = date.toInstant();
		System.out.println("convertUtilDateToLocalDateTime() instant: " + instant);

		ZoneId systemDefaultZoneId = ZoneId.systemDefault();
		LocalDateTime localDateTime = instant.atZone(systemDefaultZoneId).toLocalDateTime();
		System.out.println("convertUtilDateToLocalDateTime() localDateTime: " + localDateTime);
	}

	@Test
	public void convertLocalDateTimeToUtilDate() {
		Clock clock = Clock.systemDefaultZone();
		LocalDateTime localDateTime = LocalDateTime.now(clock);
		System.out.println("convertLocalDateTimeToUtilDate() localDateTime: " + localDateTime);

		ZoneId zoneId = ZoneId.systemDefault();
		Date date = Date.from(localDateTime.atZone(zoneId).toInstant());
		System.out.println("convertLocalDateTimeToUtilDate() date: " + date);
	}

	@Test
	public void convertUtilDateToLocalTime() {
		Date date = new Date();
		System.out.println("convertUtilDateToLocalTime() date: " + date);

		Instant instant = date.toInstant();
		System.out.println("convertUtilDateToLocalTime() instant: " + instant);

		ZoneId systemDefaultZoneId = ZoneId.systemDefault();
		LocalTime localTime = instant.atZone(systemDefaultZoneId).toLocalTime();
		System.out.println("convertUtilDateToLocalTime() localTime: " + localTime);
	}

	@Test
	public void convertUtilDateToZonedDateTime() {
		Date date = new Date();
		System.out.println("convertUtilDateToZonedDateTime() date: " + date);

		Instant instant = date.toInstant();
		System.out.println("convertUtilDateToZonedDateTime() instant: " + instant);

		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = instant.atZone(zoneId);
		System.out.println("convertUtilDateToZonedDateTime() zonedDateTime: " + zonedDateTime);
	}

	@Test
	public void convertZonedDateTimeToUtilDate() {
		Clock clock = Clock.systemDefaultZone();
		ZonedDateTime zonedDateTime = ZonedDateTime.now(clock);
		System.out.println("convertZonedDateTimeToUtilDate() zonedDateTime: " + zonedDateTime);

		Date date = Date.from(zonedDateTime.toInstant());
		System.out.println("convertZonedDateTimeToUtilDate() date: " + date);
	}

	@Test
	public void convertLocalDateTimeToZonedDateTime() {
		Clock clock = Clock.systemDefaultZone();
		LocalDateTime localDateTime = LocalDateTime.now(clock);
		System.out.println("convertLocalDateTimeToZonedDateTime() localDateTime: " + localDateTime);

		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
		System.out.println("convertLocalDateTimeToZonedDateTime() zonedDateTime: " + zonedDateTime);
	}

	/**
	 * Method to convert one date format to another date format
	 * @throws ParseException 
	 */
	@Ignore
	@Test
	public void converDateFormat1() throws ParseException {
		/*convert date from yyyy-mm-dd to mm/dd/yyyy*/
		DateFormat fromFormat1 = new SimpleDateFormat("yyyy-mm-dd");
		DateFormat toFormat1 = new SimpleDateFormat("mm/dd/yyyy");

		Date date = fromFormat1.parse("2017-01-27");
		String convertedDate1 = toFormat1.format(date);
		System.out.println("convertedDate1: " + convertedDate1);

		/*convert date from yyyy-mm-dd to dd/mm/yyyy*/
		DateFormat fromFormat2 = new SimpleDateFormat("yyyy-mm-dd");
		DateFormat toFormat2 = new SimpleDateFormat("dd/mm/yyyy");
		Date date2 = fromFormat2.parse("2017-01-27");
		String convertedDate2 = toFormat2.format(date2);
		System.out.println("convertedDate2: " + convertedDate2);

		/*convert date from dd/mm/yyyy to yyyy-mm-dd*/
		DateFormat fromFormat3 = new SimpleDateFormat("dd/mm/yyyy");
		DateFormat toFormat3 = new SimpleDateFormat("yyyy-mm-dd");
		Date date3 = fromFormat3.parse("27/01/2017");
		String convertedDate3 = toFormat3.format(date3);
		System.out.println("convertedDate3: " + convertedDate3);

		/*convert Thu Apr 20 22:52:16 IST 2017 to 2017/04/20*/
		SimpleDateFormat fromFormat4 = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		SimpleDateFormat toFormat4 = new SimpleDateFormat("yyyy/MM/dd");
		Date date4 = fromFormat4.parse("Thu Apr 20 22:52:16 IST 2017");
		String convertedDate4 = toFormat4.format(date4);
		System.out.println("convertedDate4: " + convertedDate4);

		// convert new Date to yyyy/MM/dd
		Date date5 = new Date();
		DateFormat toFormat5 = new SimpleDateFormat("yyyy/MM/dd");
		String convertedDate5 = toFormat5.format(date5);
		System.out.println("convertedDate5: " + convertedDate5);
	}

	/**
	 * Convert String to java.util.Date
	 * 
	 * String to Date -> SimpleDateFormat.parse(String)
	 * Date to String -> SimpleDateFormat.format(date)
	 * @throws ParseException 
	 */
	@Ignore
	@Test
	public void convertStringToUtilDate() throws ParseException {
		// 20-Jul-2017
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MMM-yyyy");
		String date1 = "20-Jul-2017";

		Date convertedDate1 = simpleDateFormat1.parse(date1);
		System.out.println("convertedDate1: " + convertedDate1);
		System.out.println("simpleDateFormat1.format(convertedDate1): " + simpleDateFormat1.format(convertedDate1));

		// 20/07/2017
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
		String date2 = "20/07/2017";
		Date convertedDate2 = simpleDateFormat2.parse(date2);
		System.out.println("convertedDate2: " + convertedDate2);
		System.out.println("simpleDateFormat2.format(convertedDate2): " + simpleDateFormat2.format(convertedDate2));

		//Thu, July 20 2017
		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("E, MMM dd yyyy");
		String date3 = "Thu, July 20 2017";
		Date convertedDate3 = simpleDateFormat3.parse(date3);
		System.out.println("convertedDate3: " + convertedDate3);
		System.out.println("simpleDateFormat3.format(convertedDate3): " + simpleDateFormat3.format(convertedDate3));

		//Thursday, July 10 2017 12:10:08 PM
		SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("EEEE, MMM dd yyyy HH:mm:ss a");
		String date4 = "Thursday, July 20 2017 12:10:08 PM";
		Date convertedDate4 = simpleDateFormat4.parse(date4);
		System.out.println("convertedDate4: " + convertedDate4);
		System.out.println("simpleDateFormat4.format(convertedDate4): " + simpleDateFormat4.format(convertedDate4));

		// Sun Apr 16 22:52:16 EDT 2017
		SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		simpleDateFormat5.setTimeZone(TimeZone.getTimeZone("EDT"));
		String date5 = "Sun Apr 16 22:52:16 EDT 2017";
		Date convertedDate5 = simpleDateFormat5.parse(date5);
		System.out.println("convertedDate5: " + convertedDate5);
		System.out.println("simpleDateFormat5.format(convertedDate5): " + simpleDateFormat5.format(convertedDate5));
	}

	/**
	 * Convert String to java.time.LocalDate
	 */
	@Ignore
	@Test
	public void convertStringToLocalDate() {
		// 10/07/2017
		String date1 = "20/07/2017";
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate localDate1 = LocalDate.parse(date1, formatter1);
		System.out.println("localDate1: " + localDate1);
		System.out.println("formatter1.format(localDate1): " + formatter1.format(localDate1));

		//10-07-2017
		String date2 = "2017-07-21";
		LocalDate localDate2 = LocalDate.parse(date2);
		System.out.println("localDate2: " + localDate2);

		// 20-Jul-2017
		String date3 = "20-Jul-2017";
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d-MMM-yyyy");
		LocalDate localDate3 = LocalDate.parse(date3, formatter2);
		System.out.println("localDate3: " + localDate3);
		System.out.println("formatter2.format(localDate3): " + formatter2.format(localDate3));

		//Thu, Jul 20 2017
		String date4 = "Thu, Jul 20 2017";
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("E, MMM d yyyy");
		LocalDate localDate4 = LocalDate.parse(date4, formatter3);
		System.out.println("localDate4: " + localDate4);
		System.out.println("formatter3.format(localDate4): " + formatter3.format(localDate4));

		//Thursday, Jul 10 2017 12:10:08 PM
		String date5 = "Thursday, Jul 20 2017 12:10:08 PM";
		DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("EEEE, MMM d yyyy HH:mm:ss a");
		LocalDateTime localDate5 = LocalDateTime.parse(date5, formatter4);
		System.out.println("localDate5: " + localDate5);
		System.out.println("formatter4.format(localDate5): " + formatter4.format(localDate5));
	}

	/**
	 * Print day of week if date is given
	 */
	@Test
	public void getDayOfWeek() {
		int year = 2015;
		int month = 8;
		int day = 5;

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		Date date = calendar.getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
		System.out.println(simpleDateFormat.format(date));

		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("E");
		System.out.println(simpleDateFormat2.format(date));

		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("EEE");
		System.out.println(simpleDateFormat3.format(date));

		// JDK 8
		LocalDateTime localDateTime = LocalDateTime.of(2017, 9, 27, 8, 24);
		System.out.println(localDateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH));

		LocalDate localDate = LocalDate.of(2017, 9, 27);
		System.out.println(localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
	}

	/**
	 * Convert java.time.LocalDateTime to java.sql.Timestamp
	 */
	@Test
	@Ignore
	public void convertLocalDateTimeToTimestamp() {
		LocalDateTime localDateTime = LocalDateTime.now(Clock.systemDefaultZone());
		System.out.println("localDateTime: " + localDateTime); // localDateTime: 2017-05-30T21:29:25.097
		Timestamp timestamp = Timestamp.from(localDateTime.toInstant(ZoneOffset.ofHours(0)));
		System.out.println("timestamp: " + timestamp); // timestamp: 2017-05-31 02:59:25.097
	}

	/**
	 * Add day, month and year to java.util.Date
	 */
	@Ignore
	public void addDayMonthYearToJavaUtilDate() {
		Calendar calendar = Calendar.getInstance();
		System.out.println("Current Date: " + calendar.getTime());

		calendar.add(Calendar.DAY_OF_MONTH, 10);
		System.out.println("Add 10 days: " + calendar.getTime());

		calendar.add(Calendar.MONTH, 1);
		System.out.println("Add 1 month: " + calendar.getTime());

		calendar.add(Calendar.YEAR, 3);
		System.out.println("Add 3 years: " + calendar.getTime());

		calendar.add(Calendar.DAY_OF_MONTH, -5);
		System.out.println("Reduce 5 days: " + calendar.getTime());

		calendar.add(Calendar.MONTH, -2);
		System.out.println("Reduce 2 months: " + calendar.getTime());

		calendar.add(Calendar.YEAR, -4);
		System.out.println("Reduce 4 years: " + calendar.getTime());
	}

	/**
	 * Check whether input date is past date or not
	 * @throws ParseException
	 */
	@Test
	public void dateFormatPractice() throws ParseException {
		// method 1
		String inputDate = "20170710";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date convertDate = dateFormat.parse(inputDate);

		Instant instant = convertDate.toInstant();
		ZoneId systemDefaultZoneId = ZoneId.systemDefault();
		LocalDate localDate = instant.atZone(systemDefaultZoneId).toLocalDate();

		LocalDate today = LocalDate.now(Clock.systemDefaultZone());
		boolean isPast = localDate.isBefore(today);
		boolean isFuture = localDate.isAfter(today);
		System.out.println("inputDate: " + localDate + ", today: " + today + ", isPast: " + isPast + ", isFuture: " + isFuture);

		// method 2
		String inputDate2 = "20190814";
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate localDate2 = LocalDate.parse(inputDate2, dateTimeFormatter);
		LocalDate today2 = LocalDate.now(Clock.systemDefaultZone());
		boolean isPast2 = localDate2.isBefore(today2);
		boolean isFuture2 = localDate2.isAfter(today2);
		System.out.println(
				"inputDate2: " + localDate2 + ", today2: " + today2 + ", isPast2: " + isPast2 + ", isFuture: " + isFuture2);
	}

	@Test
	public void validateUsingUtilDate() {
		// 20170999 - using java.util.Date
		try {
			SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMdd");
			simpleDateFormat1.setLenient(false);
			String date1 = "20170999";
			Date convertedDate1 = simpleDateFormat1.parse(date1);
			System.out.println("convertedDate1: " + convertedDate1);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 20170999 - using java.util.Date
		try {
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd");
			String date2 = "20170999";
			Date convertedDate2 = simpleDateFormat2.parse(date2);
			System.out.println("convertedDate2: " + convertedDate2);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void validateUsingLocalDate() {
		//  20170999 - using java.time.LocalDate
		try {
			String date1 = "20170999";
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyyMMdd");
			LocalDate localDate1 = LocalDate.parse(date1, formatter1);
			System.out.println("localDate1: " + localDate1);
			System.out.println("formatter1.format(localDate1): " + formatter1.format(localDate1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void convertLocalDateToString() {
		// MMM-yy
		LocalDate localDate = LocalDate.now(Clock.systemDefaultZone());
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM-yy");
		System.out.println("localDate: " + localDate + ", convertedDate: " + dateTimeFormatter.format(localDate));

		// dd-MM-yy
		LocalDate localDate2 = LocalDate.now(Clock.systemDefaultZone());
		DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("dd-MMM-yy");
		System.out.println("localDate: " + localDate2 + ", convertedDate: " + dateTimeFormatter2.format(localDate2));
	}

	@Test
	public void calculateNoOfWeekendsBetweenTwoDays() {
		// jdk 8 
		LocalDate fromDate = LocalDate.of(2017, 9, 12);
		LocalDate toDate = LocalDate.of(2017, 9, 15);
		calculateNoOfWeekends(fromDate, toDate);

		fromDate = LocalDate.of(2017, 9, 12);
		toDate = LocalDate.of(2017, 9, 18);
		calculateNoOfWeekends(fromDate, toDate);

		fromDate = LocalDate.of(2017, 9, 16);
		toDate = LocalDate.of(2017, 9, 25);
		calculateNoOfWeekends(fromDate, toDate);
	}

	private void calculateNoOfWeekends(LocalDate fromDate, LocalDate toDate) {
		System.out.println("Input -> fromDate: " + fromDate + ", toDate: " + toDate);

		int noOfWeekends = 0;
		do {
			DayOfWeek dayOfWeek = fromDate.getDayOfWeek();
			String weekName = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
			System.out.println("fromDate: " + fromDate + ", weekName: " + weekName);

			if ("saturday".equalsIgnoreCase(weekName) || "sunday".equalsIgnoreCase(weekName)) {
				noOfWeekends++;
			}
			fromDate = fromDate.plusDays(1);
		} while (fromDate.isBefore(toDate));

		System.out.println("number of weekends: " + noOfWeekends);
	}

	/**
	 * Convert java.time.LocalDateTime to java.time.LocalDate
	 */
	@Test
	public void convertLocalDateTimeToLocalDate() {
		LocalDateTime localDateTime = LocalDateTime.of(2017, 9, 27, 8, 29);
		LocalDate localDate = localDateTime.toLocalDate();
		System.out.println("localDate: " + localDate);
	}

	/**
	 * Convert java.time.LocalDateTime to java.time.LocalTime
	 */
	@Test
	public void convertLocalDateTimeToLocalTime() {
		LocalDateTime localDateTime = LocalDateTime.of(2017, 9, 27, 8, 29);
		LocalTime localTime = localDateTime.toLocalTime();
		System.out.println("localTime: " + localTime);
	}

	@Test
	public void getYearBaseValue() {
		LocalDate localDate = LocalDate.now(Clock.systemDefaultZone());
		System.out.println("date: " + localDate.getDayOfMonth() + ", month: " + localDate.getMonthValue() + ", year: "
				+ localDate.getYear() + ", dayOfYear: " + localDate.getDayOfYear() + ", weekOfTheYear: "
				+ localDate.get(WeekFields.of(Locale.ENGLISH).weekOfWeekBasedYear()) + ", weekOfTheMonth: "
				+ localDate.get(WeekFields.of(Locale.ENGLISH).weekOfMonth()));

		ZoneId zoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(zoneId).toInstant());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		System.out.println("date: " + calendar.get(Calendar.DATE) + ", month: " + (calendar.get(Calendar.MONTH) + 1) + ", year: "
				+ calendar.get(Calendar.YEAR) + ", dayOfTheYear: " + calendar.get(Calendar.DAY_OF_YEAR) + ", weekOfTheYear: "
				+ calendar.get(Calendar.WEEK_OF_YEAR) + ", monthOfTheYear: " + (calendar.get(Calendar.MONTH) + 1)
				+ ", weekOfTheMonth: " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
	}

	@Test
	public void lengthOfTheMonth() {
		// until JDK 7
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, Calendar.SEPTEMBER, 29);
		int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("September: no.of days: " + daysInMonth);

		calendar.set(2017, Calendar.FEBRUARY, 10);
		daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("February: no.of days: " + daysInMonth);

		// JDK 8
		YearMonth yearMonth = YearMonth.of(2017, 9);
		daysInMonth = yearMonth.lengthOfMonth();
		System.out.println("JDK 8: September: no.of days: " + daysInMonth);

		yearMonth = YearMonth.of(2017, 2);
		daysInMonth = yearMonth.lengthOfMonth();
		System.out.println("JDK 8: February: no.of days: " + daysInMonth);
	}

	@Test
	public void getDayOfWeekOfMonth() {
		System.out.println("All mondays of september 2017: " + getDatesOfDayOfWeekOfMonth(2017, 9, "monday"));
		System.out.println("All sundays of february 2017: " + getDatesOfDayOfWeekOfMonth(2017, 2, "sunday"));
	}

	/**
	 * Get dates of all mondays of a month
	 * Get dates of all tuesdays of a month
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	private List<String> getDatesOfDayOfWeekOfMonth(int year, int month, String day) {
		List<String> dates = new ArrayList<>();

		LocalDate monthFirstDate = LocalDate.of(year, month, 1);
		LocalDate monthLastDate = LocalDate.of(year, month, YearMonth.of(year, month).lengthOfMonth());

		System.out.println("monthFirstDate: " + monthFirstDate + ", monthLastDate: " + monthLastDate);

		for (; monthFirstDate.isBefore(monthLastDate); monthFirstDate = monthFirstDate.plusDays(1)) {
			if (day.equalsIgnoreCase(monthFirstDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH))) {
				dates.add(monthFirstDate.toString());
			}
		}

		return dates;
	}

	@Test
	public void javaTimePeriod() {
		Period tenDays = Period.ofDays(10);
		System.out.println("tenDays.getDays(): " + tenDays.getDays());

		Period yearsMonthsDays = Period.of(5, 3, 15);
		System.out.println(yearsMonthsDays.getYears() + " years, " + yearsMonthsDays.getMonths() + " months, "
				+ yearsMonthsDays.getDays() + " days");

		System.out.println("--- calculation duration --- ");
		LocalDate oldDate = LocalDate.of(1987, Month.JULY, 20);
		LocalDate newDate = LocalDate.of(2017, Month.SEPTEMBER, 29);

		System.out.println("oldDate: " + oldDate);
		System.out.println("newDate: " + newDate);

		// check period between dates
		Period period = Period.between(oldDate, newDate);

		System.out.println(period.getYears() + " years," + period.getMonths() + " months," + period.getDays() + " days");
	}

	@Test
	public void javaTimeTemporalChronoUnit() {
		LocalDateTime oldDate = LocalDateTime.of(1987, Month.JULY, 20, 4, 05, 00);
		LocalDateTime newDate = LocalDateTime.of(2017, Month.SEPTEMBER, 29, 10, 05, 15);

		System.out.println("oldDate: " + oldDate + ", newDate: " + newDate);

		// calculate duration
		long years = ChronoUnit.YEARS.between(oldDate, newDate);
		long months = ChronoUnit.MONTHS.between(oldDate, newDate);
		long weeks = ChronoUnit.WEEKS.between(oldDate, newDate);
		long days = ChronoUnit.DAYS.between(oldDate, newDate);
		long hours = ChronoUnit.HOURS.between(oldDate, newDate);
		long minutes = ChronoUnit.MINUTES.between(oldDate, newDate);
		long seconds = ChronoUnit.SECONDS.between(oldDate, newDate);
		long milis = ChronoUnit.MILLIS.between(oldDate, newDate);
		long nano = ChronoUnit.NANOS.between(oldDate, newDate);

		System.out.println(years + " years");
		System.out.println(months + " months");
		System.out.println(weeks + " weeks");
		System.out.println(days + " days");
		System.out.println(hours + " hours");
		System.out.println(minutes + " minutes");
		System.out.println(seconds + " seconds");
		System.out.println(milis + " milis");
		System.out.println(nano + " nano");

	}

	@Test
	public void convert12HoursDateTimeTo24Hours() throws ParseException {
		// Java 7
		String date = "10-Aug-2017 07:56:12 PM";
		System.out.println("String: inputDate: " + date);
		SimpleDateFormat fromFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
		SimpleDateFormat toFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

		Date inputDate = fromFormat.parse(date);
		System.out.println("Date: inputDate: " + inputDate);

		String outputDate = toFormat.format(inputDate);
		System.out.println("JDK7: outputDate: " + outputDate);

		// Java 8
		String outputDate2 = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:ss a"))
				.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss"));
		System.out.println("JDK8: outputDate: " + outputDate2);
	}

	@Test
	public void formatDateBasedOnLocale() {
		DateFormat denmarkDateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, new Locale("da", "DK"));
		String date = denmarkDateFormat.format(new Date()); // date is 7 Jan 2018
		System.out.println(date); // 07-01-2018

		DateFormat ukDateFormat = DateFormat.getDateInstance(DateFormat.FULL, new Locale("en", "UK"));
		String date2 = ukDateFormat.format(new Date());
		System.out.println(date2); // Sunday, January 7, 2018
	}

	@Test
	public void formatTimeBaseOnLocale() {
		DateFormat denmarkTimeFormat = DateFormat.getTimeInstance(DateFormat.FULL, new Locale("da", "DK"));
		String time = denmarkTimeFormat.format(new Date());
		System.out.println(time); // 12:24:59 IST
	}

	@Test
	public void formatDateTimeBasedOnLocale() {
		DateFormat dateTimeFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.DEFAULT, new Locale("en", "US"));
		String dateTime = dateTimeFormat.format(new Date());
		System.out.println(dateTime); // Sunday, January 7, 2018 12:26:44 PM
	}

	@Test
	public void formatDaysUsingDateFormatSymbols() {
		DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(new Locale("da", "DK"));
		dateFormatSymbols.setWeekdays(new String[] { "unused", "1-sunday", "2-monday", "3-tuesday", "4-wednesday", "5-thursday",
				"6-friday", "7-saturday" });
		String pattern = "EEEE MMMM yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, dateFormatSymbols);

		String date = simpleDateFormat.format(new Date());
		System.out.println(date); // 1-sunday januar 2018
	}

	@Test
	public void getMonthFullShortNameByMonthNumber() {
		// method 1
		String januaryName = new DateFormatSymbols().getMonths()[0];
		System.out.println("januaryName: " + januaryName);

		// method 2 - from JDK 8
		String julyName = Month.of(7).name();
		System.out.println("julyName: " + julyName);

		// method 3 - from JDK 8 using CHINESE Locale
		String mayName = Month.of(5).getDisplayName(TextStyle.SHORT, Locale.CHINESE);
		System.out.println("mayName: " + mayName);

		// FRENCH Locale
		String septemberName = Month.of(9).getDisplayName(TextStyle.FULL, Locale.FRENCH);
		System.out.println("septemberName: " + septemberName);
	}
}