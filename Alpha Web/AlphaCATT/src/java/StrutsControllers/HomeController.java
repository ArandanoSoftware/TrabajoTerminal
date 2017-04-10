package StrutsControllers;

import com.opensymphony.xwork2.ActionSupport;

public class HomeController extends ActionSupport{
    @Override
    
    public String execute(){
      return SUCCESS;
    }
    public String otro(){
      return "success";
    }

}
