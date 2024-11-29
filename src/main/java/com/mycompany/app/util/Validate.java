package com.mycompany.app.util;

import com.mycompany.app.model.InputDate;
import com.mycompany.app.model.ValidateInput;

import java.util.*;

public class Validate {
  public ValidateInput returnObj;
  public InputDate date;
  public String partialVoidMessage = "Must be a valid ";
  public String pastMessage = "Must be in the past";
  public String requiredMessage = "This field is required";

  public ValidateInput day(InputDate date) {
    if (Integer.toString(date.getDay()) == " ") {
      returnObj.setpassing(false);
      returnObj.setMessage(requiredMessage);
      return returnObj;
    }
    ;

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
