package com.mycompany.app.model;

public class ValidateInput {
  public boolean passing;

  public String message;

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
    return "ValidateInput {" +
        "passing= " + passing +
        " , message= " + message +
        " }";
  }
}
