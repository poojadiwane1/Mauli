package CoverFoxProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectMemberWanted_POM {
	@FindBy(xpath = "//div[@class='ms-option selected']")private WebElement Members;
	@FindBy(xpath =  "//div[@class='next-btn']")private WebElement nextButton;
	
	 public  SelectMemberWanted_POM(WebDriver driver) {
	    	PageFactory.initElements(driver, this);
	    }
	
	public void MemberSelection() throws InterruptedException {
		Members.click();
		Thread.sleep(2000);
		
	}
	
	public void next() {
		nextButton.click();
		
	}

}
