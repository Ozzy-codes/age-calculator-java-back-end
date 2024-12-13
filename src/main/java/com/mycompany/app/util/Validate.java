package com.mycompany.app.util;

import com.mycompany.app.model.InputDate;
import com.mycompany.app.model.ValidateResultObject;

import java.util.*;

public class Validate {
  private String partialVoidMessage = "Must be a valid ";
  private String pastMessage = "Must be in the past";
  private String requiredMessage = "This field is required";

  public ValidateResultObject day(String day, String month, String year) {
    ValidateResultObject dayResultReturnObj = new ValidateResultObject(true, "");
    if (day == "") {
      dayResultReturnObj.setPassing(false);
      dayResultReturnObj.setMessage(requiredMessage);
      return dayResultReturnObj;
    }
    ;

    if (month == "")
      month = "-1";
    if (year == "")
      year = "-1";

    InputDate inputData = new InputDate(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));

    Calendar currentDate = Calendar.getInstance();

    if (inputData.getYear() == currentDate.get(Calendar.YEAR) &&
        inputData.getMonth() == currentDate.get(Calendar.MONTH) + 1 &&
        inputData.getDay() > currentDate.get(Calendar.DAY_OF_MONTH)) {
      dayResultReturnObj.setMessage(pastMessage);
    }

    currentDate.set(inputData.getYear(), inputData.getMonth() - 1, inputData.getDay());

    if (currentDate.get(Calendar.DAY_OF_MONTH) != inputData.getDay()) {
      dayResultReturnObj.setMessage(partialVoidMessage + "day");
    }
    ;

    if (dayResultReturnObj.getMessage().length() > 1)
      dayResultReturnObj.setPassing(false);
    return dayResultReturnObj;
  }

  public ValidateResultObject month(String day, String month, String year) {
    ValidateResultObject monthResultReturnObj = new ValidateResultObject(true, "");
    if (month == "") {
      monthResultReturnObj.setPassing(false);
      monthResultReturnObj.setMessage(requiredMessage);
      return monthResultReturnObj;
    }

    if (day == "")
      day = "-1";
    if (year == "")
      year = "-1";

    InputDate inputData = new InputDate(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
    Calendar currentDate = Calendar.getInstance();

    if (inputData.getYear() == currentDate.get(Calendar.YEAR) &&
        inputData.getMonth() > currentDate.get(Calendar.MONTH) + 1) {
      monthResultReturnObj.setMessage(pastMessage);
    }
    if (inputData.getMonth() < 1 || inputData.getMonth() > 12) {
      monthResultReturnObj.setMessage(partialVoidMessage + "month");
    }
    if (monthResultReturnObj.getMessage().length() > 1)
      monthResultReturnObj.setPassing(false);

    return monthResultReturnObj;
  }

  public ValidateResultObject year(String day, String month, String year) {
    ValidateResultObject yearResultReturnObj = new ValidateResultObject(true, "");
    if (year == "") {
      yearResultReturnObj.setPassing(false);
      yearResultReturnObj.setMessage(requiredMessage);
      return yearResultReturnObj;
    }

    if (day == "")
      day = "-1";
    if (month == "")
      month = "-1";

    InputDate inputData = new InputDate(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
    Calendar currentDate = Calendar.getInstance();

    if (inputData.getYear() > currentDate.get(Calendar.YEAR)) {
      yearResultReturnObj.setMessage(pastMessage);
    }
    if (year.length() < 4 || year.length() > 4) {
      yearResultReturnObj.setMessage("Please enter a year in YYYY format");
    }
    if (inputData.getYear() < 1) {
      yearResultReturnObj.setMessage(partialVoidMessage + "year");
    }
    if (yearResultReturnObj.getMessage().length() > 1)
      yearResultReturnObj.setPassing(false);

    return yearResultReturnObj;
  }
}
