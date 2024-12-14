package com.mycompany.app.service;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.app.model.CalculatedBirthday;
import com.mycompany.app.model.ValidateResultObject;
import com.mycompany.app.util.CalculateBirthday;
import com.mycompany.app.util.Validate;

public class InputService {
  private Validate validator = new Validate();
  private CalculateBirthday cb = new CalculateBirthday();

  public Map<String, ValidateResultObject> validate(String day, String month, String year) {
    String sanitizedDay = day.trim();
    String sanitizedMonth = month.trim();
    String sanitizedYear = year.trim();

    Map<String, ValidateResultObject> validationResultMap = new HashMap<String, ValidateResultObject>();

    ValidateResultObject dayResult = validator.day(sanitizedDay, sanitizedMonth, sanitizedYear);
    ValidateResultObject monthResult = validator.month(sanitizedDay, sanitizedMonth, sanitizedYear);
    ValidateResultObject yearResult = validator.year(sanitizedDay, sanitizedMonth, sanitizedYear);

    validationResultMap.put("dayResultObject", dayResult);
    validationResultMap.put("monthResultObject", monthResult);
    validationResultMap.put("yearResultObject", yearResult);

    return validationResultMap;
  }

  public CalculatedBirthday getAge(String day, String month, String year) {
    Integer sanitizedDay = Integer.parseInt(day.trim());
    Integer sanitizedMonth = Integer.parseInt(month.trim());
    Integer sanitizedYear = Integer.parseInt(year.trim());

    CalculatedBirthday birthday = cb.getAge(sanitizedDay, sanitizedMonth, sanitizedYear);

    return birthday;
  }
}
