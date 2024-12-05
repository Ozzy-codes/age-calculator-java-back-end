package com.mycompany.app.util;

import com.mycompany.app.model.InputDate;
import com.mycompany.app.model.ValidateResultObject;

import java.util.*;

public class Validate {
  private InputDate date;
  private String partialVoidMessage = "Must be a valid ";
  private String pastMessage = "Must be in the past";
  private String requiredMessage = "This field is required";

  public ValidateResultObject day(String day, String month, String year) {
    ValidateResultObject dayResultReturnObj = new ValidateResultObject();
    if (day == "") {
      dayResultReturnObj.setpassing(false);
      dayResultReturnObj.setMessage(requiredMessage);
      return dayResultReturnObj;
    }
    ;
    InputDate date = new InputDate(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));

    Calendar dateObj = Calendar.getInstance();
    dateObj.set(date.getYear() + 1900, date.getMonth() - 1, date.getDay());

    if (dateObj.get(Calendar.YEAR) - 1900 == Calendar.getInstance().get(Calendar.YEAR) - 1900 &&
        dateObj.get(Calendar.MONTH) == Calendar.getInstance().get(Calendar.MONTH) &&
        dateObj.getTime().getTime() > Calendar.getInstance().getTime().getTime()) {
      dayResultReturnObj.message = pastMessage;
    }
    ;

    if (dateObj.get(Calendar.DAY_OF_MONTH) != date.getDay()) {
      dayResultReturnObj.setMessage(partialVoidMessage + "day");
    }
    ;

    if (dayResultReturnObj.message.length() > 1)
      dayResultReturnObj.setpassing(false);
    return dayResultReturnObj;
  }

}
