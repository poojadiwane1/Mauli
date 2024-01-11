package lissner;





import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;



public class lisenerA extends coverFoxBase.BaseClass implements ITestListener{
 

@Test
 @Override
public void onTestSuccess(ITestResult result) {
	  
	  String name = result.getName();
	  
	  Reporter.log("TC "+name+" is sucesseful execute",true);
  }
  
  @Override
	public void onTestFailure(ITestResult result) {
	  Reporter.log("TC "+result.getName()+" is get failed",true);
	  
	  
	  
	  //this method will take screenshot when any method will get failed
	  
	  
		try {
			coverFoxUtility.ComUseMethod. ScreenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		
	}
  
  @Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("TC "+result.getName()+" is skipped, check dependant method",true);
	}
}
