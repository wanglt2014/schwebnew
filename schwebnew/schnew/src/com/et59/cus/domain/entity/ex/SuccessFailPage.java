package com.et59.cus.domain.entity.ex;

public class SuccessFailPage
{
  private String page_title;
  private String page_successmessage;
  private String page_failmeessage;

  public String getPage_title()
  {
    return this.page_title; }

  public void setPage_title(String page_title) {
    this.page_title = page_title; }

  public String getPage_successmessage() {
    return this.page_successmessage; }

  public void setPage_successmessage(String page_successmessage) {
    this.page_successmessage = page_successmessage; }

  public String getPage_failmeessage() {
    return this.page_failmeessage; }

  public void setPage_failmeessage(String page_failmeessage) {
    this.page_failmeessage = page_failmeessage;
  }
}