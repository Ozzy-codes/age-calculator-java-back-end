package com.mycompany.app.util;

import java.util.Calendar;

import com.mycompany.app.model.CalculatedBirthday;

public class CalculateBirthday {

  public CalculatedBirthday getAge(Integer day, Integer month, Integer year) {
    CalculatedBirthday birthday = new CalculatedBirthday();
    Calendar currentDate = Calendar.getInstance();
    Integer currentYear = currentDate.get(Calendar.YEAR);
    Integer currentMonth = currentDate.get(Calendar.MONTH);
    Integer currentDay = currentDate.get(Calendar.DATE);

    Integer monthDifference = month - 1 - currentMonth;
    Integer dayDifference = day - currentDay;

    if (monthDifference == 0) {
      if (dayDifference > 0) {
        birthday.setYear(currentYear - year - 1);
        birthday.setMonth(11);

        currentDate.set(currentYear, currentMonth, 0);
        birthday.setDay(currentDate.getActualMaximum(Calendar.DATE) - day + currentDay);
      } else {
        birthday.setYear(currentYear - year);
        birthday.setMonth(0);
        birthday.setDay(currentDay - day);
      }
      return birthday;
    }

    return birthday;
  }
}
