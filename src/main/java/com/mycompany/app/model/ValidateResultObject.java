package com.mycompany.app.model;

public class ValidateResultObject {
  private boolean passing;

  private String message;

  public ValidateResultObject() {
  }

  public ValidateResultObject(boolean passing, String message) {
    this.passing = passing;
    this.message = message;
  }

  public boolean ispassing() {
    return passing;
  }

  public void setpassing(boolean pass) {
    this.passing = pass;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "ValidateResultObject {" +
        "passing= " + passing +
        " , message= " + message +
        " }";
  }
}
