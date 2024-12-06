package com.mycompany.app.util;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import com.mycompany.app.model.ValidateResultObject;

public class ValidateTest {
    Validate validate = new Validate();

    @Test
    public void day_passInEmptyString() {
        String day = "";
        String month = "2";
        String year = "2023";

        ValidateResultObject expectedObj = new ValidateResultObject(false, "This field is required");

        ValidateResultObject returnObj = validate.day(day, month, year);

        assertEquals(expectedObj.ispassing(), returnObj.ispassing());
        assertEquals(expectedObj.getMessage(), returnObj.getMessage());
    }

    @Test
    public void day_passInZero() {
        String day = "0";
        String month = "2";
        String year = "2023";

        ValidateResultObject expectedObj = new ValidateResultObject(false, "Must be a valid day");

        ValidateResultObject returnObj = validate.day(day, month, year);

        assertEquals(expectedObj.ispassing(), returnObj.ispassing());
        assertEquals(expectedObj.getMessage(), returnObj.getMessage());
    }

    @Test
    public void day_passInDayGreaterThanAllowedInMonth() {
        String day = "30";
        String month = "2";
        String year = "2023";

        ValidateResultObject expectedObj = new ValidateResultObject(false, "Must be a valid day");

        ValidateResultObject returnObj = validate.day(day, month, year);

        assertEquals(expectedObj.ispassing(), returnObj.ispassing());
        assertEquals(expectedObj.getMessage(), returnObj.getMessage());
    }

    @Test
    public void day_passInExtraDayInNonLeapYear() {
        String day = "29";
        String month = "2";
        String year = "2023";

        ValidateResultObject expectedObj = new ValidateResultObject(false, "Must be a valid day");

        ValidateResultObject returnObj = validate.day(day, month, year);

        assertEquals(expectedObj.ispassing(), returnObj.ispassing());
        assertEquals(expectedObj.getMessage(), returnObj.getMessage());
    }

    @Test
    public void day_passInFutureDay() {
        String day = Integer.toString(Calendar.getInstance().get(Calendar.DATE) + 1);
        String month = Integer.toString(Calendar.getInstance().get(Calendar.MONTH) + 1);
        String year = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));

        if (Calendar.getInstance().get(Calendar.DATE) == Calendar.getInstance().getActualMaximum(Calendar.DATE)) {
            return;
        }
        ;

        ValidateResultObject expectedObj = new ValidateResultObject(false, "Must be in the past");

        ValidateResultObject returnObj = validate.day(day, month, year);

        assertEquals(expectedObj.ispassing(), returnObj.ispassing());
        assertEquals(expectedObj.getMessage(), returnObj.getMessage());
    }
}
