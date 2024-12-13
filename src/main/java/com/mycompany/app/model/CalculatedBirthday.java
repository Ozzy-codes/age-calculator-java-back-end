package com.mycompany.app.model;

public class CalculatedBirthday {
  private Integer year;
  private Integer month;
  private Integer day;

  public CalculatedBirthday() {
  }

  public CalculatedBirthday(Integer year, Integer month, Integer day) {
    this.year = year;
    this.month = month;
    this.day = day;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Integer getMonth() {
    return month;
  }

  public void setMonth(Integer month) {
    this.month = month;
  }

  public Integer getDay() {
    return day;
  }

  public void setDay(Integer day) {
    this.day = day;
  }

  @Override
  public String toString() {
    return "CalculatedBirthday [year=" + year + ", month=" + month + ", day=" + day + "]";
  }
}
