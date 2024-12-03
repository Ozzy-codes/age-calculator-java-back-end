package com.mycompany.app.util;

import static org.junit.Assert.*;
import org.junit.Test;

import com.mycompany.app.model.ValidateResultObject;

public class ValidateTest {
    Validate validate = new Validate();

    @Test
    public void day_passEmptyString() {
        String day = " ";
        String month = "2";
        String year = "2023";

        ValidateResultObject expectedObj = new ValidateResultObject(false, "This field is required");

        ValidateResultObject returnObj = validate.day(day, month, year);

        assertEquals(expectedObj.ispassing(), returnObj.ispassing());
        assertEquals(expectedObj.getMessage(), returnObj.getMessage());
    }
}
