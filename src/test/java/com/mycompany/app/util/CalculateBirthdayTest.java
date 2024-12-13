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

    System.out.println(birthday);

    assertEquals(expectedZero, birthday.getDay());
    assertEquals(expectedZero, birthday.getMonth());
    assertEquals(expectedOne, birthday.getYear());
  }
}