package CoverFoxProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressDetails_POM {
	@FindBy(xpath = "(//input[@type='number'])[1]")private WebElement pinCode;
	@FindBy(xpath = "(//input[@type='number'])[2]")private WebElement MobNo;
	@FindBy(xpath = "//div[@class='next-btn']")private WebElement continueButton;
	
	  public  AddressDetails_POM(WebDriver driver) {
	    	PageFactory.initElements(driver, this);
	    }
	public void code(String No1) {
		pinCode.sendKeys(No1);
		
	}
	public void Number(String No) {
		MobNo.sendKeys(No);
		
	}
	public void continuePress() {
		continueButton.click();
		
	}

}
