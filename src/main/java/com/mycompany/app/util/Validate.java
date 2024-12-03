package com.mycompany.app.util;

import com.mycompany.app.model.InputDate;
import com.mycompany.app.model.ValidateResultObject;

import java.util.*;

public class Validate {
  public ValidateResultObject returnObj = new ValidateResultObject();
  public InputDate date;
  public String partialVoidMessage = "Must be a valid ";
  public String pastMessage = "Must be in the past";
  public String requiredMessage = "This field is required";

  public ValidateResultObject day(String day, String month, String year) {
    // TODO: trim incoming strings before they hit methods
    if (day == "") {
      returnObj.setpassing(false);
      returnObj.setMessage(requiredMessage);
      return returnObj;
    }
    ;
    InputDate date = new InputDate(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));

    Calendar dateObj = Calendar.getInstance();
    dateObj.set(date.getYear() + 1900, date.getMonth() - 1, date.getDay());
    if (date.getDay() != 0) {
      returnObj.setMessage(partialVoidMessage + "day");
    }
    ;

    if (dateObj.get(Calendar.YEAR) - 1900 == Calendar.getInstance().get(Calendar.YEAR) - 1900 &&
        dateObj.get(Calendar.MONTH) == Calendar.getInstance().get(Calendar.MONTH) &&
        dateObj.getTime().getTime() > Calendar.getInstance().getTime().getTime()) {
      returnObj.message = pastMessage;
    }
    ;

    if (dateObj.get(Calendar.DAY_OF_MONTH) != date.getDay()) {
      returnObj.setMessage(partialVoidMessage + "day");
    }
    ;

    if (returnObj.message.length() > 1)
      returnObj.setpassing(false);
    return returnObj;
  }

}
