package coverFoxTest;







import java.io.IOException;

//import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;

import org.testng.Assert;
import org.testng.Reporter;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import CoverFoxProject.AddressDetails_POM;
import CoverFoxProject.AgeSelection_POM;

import CoverFoxProject.HomePage_POM;
import CoverFoxProject.ResultPage_POM;
import CoverFoxProject.SelectMemberWanted_POM;


@Listeners(lissner.ExtentReporterNG.class)

//test execution with base class, utility class, POm class and test class
public class varify_coverFox_massege_equalTo_displayed_banner extends coverFoxBase.BaseClass
 {
	//public static org.apache.log4j.Logger logger;
	
	//WebDriver driver ;
	HomePage_POM  home ;
	SelectMemberWanted_POM members ;
	AgeSelection_POM age ;
	AddressDetails_POM address ;
	ResultPage_POM result ;
	
	
	
	@BeforeClass
	public void pririquisiteOfCoverFox() throws InterruptedException  {
		//logger = org.apache.log4j.Logger.getLogger("CoverFoxInsurance");
		//  PropertyConfigurator.configure("log4j.properties");
		 // logger.info("lunching cover fox browser");
		 // logger.error("please select browser of cover fox");
		
		lunchBrowser();		
		coverFoxUtility.ComUseMethod.ImplicitalyWait(driver, 5);
		//driver=new ChromeDriver();
		home = new HomePage_POM(driver);
		members = new SelectMemberWanted_POM(driver);
		age = new AgeSelection_POM(driver);
		address = new 	AddressDetails_POM(driver);
		result = new ResultPage_POM(driver);
		Thread.sleep(1000);
		
		//Reporter.log("lunching browser", true);
		//driver.get("https://www.coverfox.com");
		
		
	}
		@BeforeMethod
		public void details() throws InterruptedException, EncryptedDocumentException, IOException    {
			
		//	logger.info("opening home page");
			home.SelectGender();
			Thread.sleep(2000);
			//logger.info("adding members");
			members.next();
			
			Thread.sleep(1000);
			//here Age data is alredy predeclare inside POM class
			//logger.info("adding age");
			age.selectAge();
			Thread.sleep(1000);
			age.next();
			Thread.sleep(2000);
			//here data for pine code pick up through exel file
			//logger.info("adding address");
			address.code("443101");
			Thread.sleep(2000);
			//here data for mobile no is pick up from property file
			address.Number("9425614521");
			Thread.sleep(1000);
			address.continuePress();
			Thread.sleep(1000);
			
			
			
			 //throws InterruptedException  EncryptedDocumentException  IOException   {
					
			
		}
		
		@Test
		public void a() throws InterruptedException, IOException {
			int text = result.textResult();
			int banner = result.bannerResult();
			
			Reporter.log("validating actual and expected result", true);
			//logger.info("validating actual and expected result");
			Assert.assertEquals(text, banner, "TC Failed : actual and expected result is not true" );
			Thread.sleep(1000);
			
			System.out.println("closing browser");
			
			//coverFoxUtility.ComUseMethod.takeScreenShotWithDate(driver, "TCID");
			//Thread.sleep(2000);
		}
		
		//@AfterMethod
		//public void closerowser1() throws InterruptedException  {
		//	Thread.sleep(2000);
		//	driver.close();
			
			
		//}
		
		
		
	}
	

  

