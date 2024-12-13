package com.mycompany.app.util;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import com.mycompany.app.model.ValidateResultObject;

public class ValidateTest {
  Validate validate = new Validate();

  @Test
  public void day_passInEmptyDayString() {
    String day = "";
    String month = "2";
    String year = "2023";

    ValidateResultObject expectedObj = new ValidateResultObject(false, "This field is required");

    ValidateResultObject returnObj = validate.day(day, month, year);

    assertEquals(expectedObj.isPassing(), returnObj.isPassing());
    assertEquals(expectedObj.getMessage(), returnObj.getMessage());
  }

  @Test
  public void day_passInEmptyMonthString() {
    String day = "1";
    String month = "";
    String year = "2023";
    ValidateResultObject expectedObj = new ValidateResultObject(true, "");
    ValidateResultObject returnedObj = new ValidateResultObject();

    try {
      returnedObj = validate.day(day, month, year);
    } catch (Exception e) {
      Assert.fail("Should not throw exception");
    }

    assertEquals(expectedObj.isPassing(), returnedObj.isPassing());
    assertEquals(expectedObj.getMessage(), returnedObj.getMessage());
  }

  @Test
  public void day_passInEmptyYearString() {
    String day = "1";
    String month = "2";
    String year = "";
    ValidateResultObject expectedObj = new ValidateResultObject(true, "");
    ValidateResultObject returnedObj = new ValidateResultObject();

    try {
      returnedObj = validate.day(day, month, year);
    } catch (Exception e) {
      Assert.fail("Should not throw exception");
    }

    assertEquals(expectedObj.isPassing(), returnedObj.isPassing());
    assertEquals(expectedObj.getMessage(), returnedObj.getMessage());
  }

  @Test
  public void day_passInEmptyYearAndMonthStrings() {
    String day = "1";
    String month = "";
    String year = "";
    ValidateResultObject expectedObj = new ValidateResultObject(true, "");
    ValidateResultObject returnedObj = new ValidateResultObject();

    try {
      returnedObj = validate.day(day, month, year);
    } catch (Exception e) {
      Assert.fail("Should not throw exception");
    }

    assertEquals(expectedObj.isPassing(), returnedObj.isPassing());
    assertEquals(expectedObj.getMessage(), returnedObj.getMessage());
  }

  @Test
  public void day_passInZero() {
    String day = "0";
    String month = "2";
    String year = "2023";

    ValidateResultObject expectedObj = new ValidateResultObject(false, "Must be a valid day");

    ValidateResultObject returnObj = validate.day(day, month, year);

    assertEquals(expectedObj.isPassing(), returnObj.isPassing());
    assertEquals(expectedObj.getMessage(), returnObj.getMessage());
  }

  @Test
  public void day_passInDayGreaterThanAllowedInMonth() {
    String day = "30";
    String month = "2";
    String year = "2023";

    ValidateResultObject expectedObj = new ValidateResultObject(false, "Must be a valid day");

    ValidateResultObject returnObj = validate.day(day, month, year);

    assertEquals(expectedObj.isPassing(), returnObj.isPassing());
    assertEquals(expectedObj.getMessage(), returnObj.getMessage());
  }

  @Test
  public void day_passInExtraDayInNonLeapYear() {
    String day = "29";
    String month = "2";
    String year = "2023";

    ValidateResultObject expectedObj = new ValidateResultObject(false, "Must be a valid day");

    ValidateResultObject returnObj = validate.day(day, month, year);

    assertEquals(expectedObj.isPassing(), returnObj.isPassing());
    assertEquals(expectedObj.getMessage(), returnObj.getMessage());
  }

  @Test
  public void day_passInFutureDay() {
    String day = Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1);
    String month = Integer.toString(Calendar.getInstance().get(Calendar.MONTH) + 1);
    String year = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));

    if (Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == Calendar.getInstance()
        .getActualMaximum(Calendar.DAY_OF_MONTH)) {
      return;
    }
    ;

    ValidateResultObject expectedObj = new ValidateResultObject(false, "Must be in the past");

    ValidateResultObject returnObj = validate.day(day, month, year);

    assertEquals(expectedObj.isPassing(), returnObj.isPassing());
    assertEquals(expectedObj.getMessage(), returnObj.getMessage());
  }

  @Test
  public void month_passInEmptyString() {
    String day = "1";
    String month = "";
    String year = "2023";

    ValidateResultObject expectedObj = new ValidateResultObject(false, "This field is required");

    ValidateResultObject returnObj = validate.month(day, month, year);

    assertEquals(expectedObj.isPassing(), returnObj.isPassing());
    assertEquals(expectedObj.getMessage(), returnObj.getMessage());
  }

  @Test
  public void month_passInFutureMonth() {
    if (Calendar.getInstance().get(Calendar.MONTH) == Calendar.getInstance().getActualMaximum(Calendar.MONTH)) {
      return;
    }
    ;

    String day = "1";
    String month = Integer.toString(Calendar.getInstance().get(Calendar.MONTH) + 2);
    String year = "2023";

    ValidateResultObject expectedObj = new ValidateResultObject(false, "Must be in the past");

    ValidateResultObject returnObj = validate.month(day, month, year);

    assertEquals(expectedObj.isPassing(), returnObj.isPassing());
    assertEquals(expectedObj.getMessage(), returnObj.getMessage());
  }

  @Test
  public void month_passInZero() {
    String day = "1";
    String month = "0";
    String year = "2023";

    ValidateResultObject expectedObj = new ValidateResultObject(false, "Must be a valid month");

    ValidateResultObject returnObj = validate.month(day, month, year);

    assertEquals(expectedObj.isPassing(), returnObj.isPassing());
    assertEquals(expectedObj.getMessage(), returnObj.getMessage());
  }

  @Test
  public void month_passInMonthGreaterThanTwelve() {
    String day = "1";
    String month = "13";
    String year = "2023";

    ValidateResultObject expectedObj = new ValidateResultObject(false, "Must be a valid month");

    ValidateResultObject returnObj = validate.month(day, month, year);

    assertEquals(expectedObj.isPassing(), returnObj.isPassing());
    assertEquals(expectedObj.getMessage(), returnObj.getMessage());
  }
}
