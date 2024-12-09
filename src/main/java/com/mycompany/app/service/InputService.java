package com.mycompany.app.service;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.app.model.ValidateResultObject;
import com.mycompany.app.util.Validate;

public class InputService {
    private Validate validator = new Validate();

    public InputService() {
    }

    // TODO: return a HashMap of result objs that can return contents to identify
    // which views will be sent
    public Map<String, ValidateResultObject> validate(String day, String month, String year) {
        String sanitizedDay = day.trim();
        String sanitizedMonth = month.trim();
        String sanitizedYear = year.trim();

        Map<String, ValidateResultObject> validationResultMap = new HashMap<String, ValidateResultObject>();

        ValidateResultObject dayResult = validator.day(sanitizedDay, sanitizedMonth, sanitizedYear);

        validationResultMap.put("dayResult", dayResult);
        return validationResultMap;
    }
}
