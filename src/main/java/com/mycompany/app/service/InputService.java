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

    Map<String, ValidateResultObject> validationResultMap = new HashMap<String, ValidateResultObject>();

    ValidateResultObject dayResult = validator.day(sanitizedDay, sanitizedMonth, sanitizedYear);
    ValidateResultObject monthResult = validator.month(sanitizedDay, sanitizedMonth, sanitizedYear);
    // TODO: conduct year tests, put objects on Map

    validationResultMap.put("dayResultObject", dayResult);
    validationResultMap.put("monthResultObject", monthResult);
    validationResultMap.put("yearResultObject", new ValidateResultObject(true, ""));
    return validationResultMap;
  }
}
