package com.mycompany.app.service;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.app.model.ValidateResultObject;
import com.mycompany.app.util.Validate;

public class InputService {
    private Validate validator = new Validate();

    public InputService() {
    }

    public Map<String, ValidateResultObject> validate(String day, String month, String year) {
        String sanitizedDay = day.trim();
        String sanitizedMonth = month.trim();
        String sanitizedYear = year.trim();
        // Map<> returnMap = new HashMap<>(Map.of("model", mapModel, "passing"));

        Map<String, ValidateResultObject> validationResultMap = new HashMap<String, ValidateResultObject>();

        ValidateResultObject dayResult = validator.day(sanitizedDay, sanitizedMonth, sanitizedYear);

        validationResultMap.put("dayResult", dayResult);
        return validationResultMap;
    }
}
