package com.struts.controllers;
import com.opensymphony.xwork2.ActionSupport;

public class HomeController extends ActionSupport {

  @Override
  public String execute() throws Exception
  {
      //call Service class to store personBean's state in database
      return SUCCESS;
  }
  public String test()
  {
      return "success";
  }

}
