package page_obj_modl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class base_page {
	  
    WebDriver driver;
    
    public base_page(WebDriver driver) {
    this.driver=driver;
    PageFactory.initElements(driver,this);
    
    }

}