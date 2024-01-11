package CoverFoxProject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage_POM {
	@FindBy(xpath =  "//div[contains(text(),' matching Health')]") private WebElement resultInString;
    @FindBy(id = "plans-list")private List<WebElement> PlaneList;
    
    public  ResultPage_POM(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    public void ValidatePlaneListWithResults() throws InterruptedException {
    	
    	// for selenium class
    	Thread.sleep(5000);
    	String test = resultInString.getText();	
    	//matching helth insurance plane
    	String ar[] = test.split(" ");
    	String NumberOfResultsInString = ar[0];
    	//convert string into integer
    	int NumberOfResultInInteger = Integer.parseInt(NumberOfResultsInString);
    	
    	
    	int TotalNumberOfPlanes = PlaneList.size();
    	
    	if(TotalNumberOfPlanes == NumberOfResultInInteger) {
    	System.out.println("43 matching Health Insurance Plans is maching with result ,  TC PASS");	
    	}
    	else {
    		System.out.println("Plane number is not matching");
    		
    	}
    	
    	
    }
    
    public int textResult() throws InterruptedException {
    	Thread.sleep(5000);
    	String test = resultInString.getText();	
    	//matching helth insurance plane
    	String ar[] = test.split(" ");
    	String NumberOfResultsInString = ar[0];
    	//convert string into integer
    	int NumberOfResultInInteger = Integer.parseInt(NumberOfResultsInString);
    	return NumberOfResultInInteger;
    	
    	
    	
    }
    
    public int bannerResult() {
    	int TotalNumberOfPlanes = PlaneList.size();
    	return TotalNumberOfPlanes;
    	
    }

}
