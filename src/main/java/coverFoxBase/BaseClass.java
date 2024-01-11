package coverFoxBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class BaseClass {

	static protected  WebDriver driver ;
	
	public static void lunchBrowser() {
		 driver = new ChromeDriver();
		driver.get("https://www.coverfox.com");
		Reporter.log("lunching the Browser",true);
	}
	
	public void closeBeowser() {
		Reporter.log("closing the browser",true);
		driver.close();
	}

}
