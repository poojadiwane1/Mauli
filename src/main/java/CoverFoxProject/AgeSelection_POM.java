package CoverFoxProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AgeSelection_POM {
	@FindBy(id = "Age-You") private WebElement AgeOfMembers;
	@FindBy(xpath = "//div[@class='next-btn']")private WebElement nextButton;
 
	 public  AgeSelection_POM(WebDriver driver) {
	    	PageFactory.initElements(driver, this);
	    }
	
	
	public void selectAge() {
	  Select s = new Select(AgeOfMembers);
	  s.selectByVisibleText("18 years");
  }
  
  public void next()
  {
	  nextButton.click();
	  
  }
  
  
  
		
}
