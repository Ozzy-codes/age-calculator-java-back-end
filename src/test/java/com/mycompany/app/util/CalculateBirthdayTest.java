package com.mycompany.app.util;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

import com.mycompany.app.model.CalculatedBirthday;

public class CalculateBirthdayTest {
  CalculateBirthday calculateBirthday = new CalculateBirthday();

  @Test
  public void month_equal_to_current_month_and_day_equal_today() {
    Calendar currentDate = Calendar.getInstance();
    Integer day = currentDate.get(Calendar.DATE);
    Integer calculatedMonth = currentDate.get(Calendar.MONTH) + 1 % 13;
    Integer month = calculatedMonth == 0 ? 1 : calculatedMonth;
    Integer year = currentDate.get(Calendar.YEAR) - 1;
    Integer expectedZero = 0;
    Integer expectedOne = 1;

    CalculatedBirthday birthday = calculateBirthday.getAge(day, month, year);

    assertEquals(expectedZero, birthday.getDay());
    assertEquals(expectedZero, birthday.getMonth());
    assertEquals(expectedOne, birthday.getYear());
  }

  @Test
  public void month_equal_to_current_month_and_day_is_less_than_current_day() {
    Calendar currentDate = Calendar.getInstance();
    Integer day = currentDate.get(Calendar.DATE);
    if (day == 1)
      return;
    day -= 1;
    Integer calculatedMonth = currentDate.get(Calendar.MONTH) + 1 % 13;
    Integer month = calculatedMonth == 0 ? 1 : calculatedMonth;
    Integer year = currentDate.get(Calendar.YEAR) - 1;
    Integer expectedZero = 0;
    Integer expectedOne = 1;

    CalculatedBirthday birthday = calculateBirthday.getAge(day, month, year);

    assertEquals(expectedOne, birthday.getDay());
    assertEquals(expectedZero, birthday.getMonth());
    assertEquals(expectedOne, birthday.getYear());
  }

  @Test
  public void month_equal_to_current_month_and_day_is_greater_than_current_day() {
    Calendar currentDate = Calendar.getInstance();
    Integer day = currentDate.get(Calendar.DATE) + 1;
    Integer daysInTheMonth = currentDate.getActualMaximum(Calendar.DATE);
    Integer calculatedMonth = currentDate.get(Calendar.MONTH) + 1 % 13;
    Integer month = calculatedMonth == 0 ? 1 : calculatedMonth;
    Integer year = currentDate.get(Calendar.YEAR) - 1;
    Integer expectedDay = daysInTheMonth - day + (day - 1);
    Integer expectedMonth = 11;
    Integer expectedYear = 0;

    if (day > daysInTheMonth)
      return;

    CalculatedBirthday birthday = calculateBirthday.getAge(day, month, year);

    assertEquals(expectedDay, birthday.getDay());
    assertEquals(expectedMonth, birthday.getMonth());
    assertEquals(expectedYear, birthday.getYear());
  }

  @Test
  public void month_greater_than_current_month_and_day_is_equal_to_current_day() {
    Calendar currentDate = Calendar.getInstance();
    Integer day = currentDate.get(Calendar.DATE);
    Integer month = currentDate.get(Calendar.MONTH) + 2;
    Integer year = currentDate.get(Calendar.YEAR) - 1;
    Integer expectedDay = 0;
    Integer expectedMonth = 11;
    Integer expectedYear = 0;

    if (month > 12)
      return;

    CalculatedBirthday birthday = calculateBirthday.getAge(day, month, year);

    assertEquals(expectedDay, birthday.getDay());
    assertEquals(expectedMonth, birthday.getMonth());
    assertEquals(expectedYear, birthday.getYear());
  }

  @Test
  public void month_greater_than_current_month_and_day_is_greater_than_current_day() {
    Calendar currentDate = Calendar.getInstance();
    Integer day = currentDate.get(Calendar.DATE) + 1;
    Integer month = currentDate.get(Calendar.MONTH) + 2;
    Integer year = currentDate.get(Calendar.YEAR) - 1;
    currentDate.set(year + 1, month - 2, 0);
    Integer expectedDay = currentDate.getActualMaximum(Calendar.DATE) - 1;
    Integer expectedMonth = 10;
    Integer expectedYear = 0;

    if (month > 12)
      return;

    CalculatedBirthday birthday = calculateBirthday.getAge(day, month, year);

    assertEquals(expectedDay, birthday.getDay());
    assertEquals(expectedMonth, birthday.getMonth());
    assertEquals(expectedYear, birthday.getYear());
  }

  @Test
  public void month_greater_than_current_month_and_day_is_less_than_current_day() {
    Calendar currentDate = Calendar.getInstance();
    Integer day = currentDate.get(Calendar.DATE) - 1;
    Integer month = currentDate.get(Calendar.MONTH) + 2;
    Integer year = currentDate.get(Calendar.YEAR) - 1;
    currentDate.set(year + 1, month - 2, 0);
    Integer expectedDay = 1;
    Integer expectedMonth = 11;
    Integer expectedYear = 0;

    if (day < 1)
      return;

    CalculatedBirthday birthday = calculateBirthday.getAge(day, month, year);

    assertEquals(expectedDay, birthday.getDay());
    assertEquals(expectedMonth, birthday.getMonth());
    assertEquals(expectedYear, birthday.getYear());
  }
}
