package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;



public class ComUseMethod {
	
public static void ImplicitalyWait(WebDriver driver, int time) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time)) ;
				
}

public static void ScrollIntoView(WebDriver driver, WebElement element) {
	 JavascriptExecutor js = (JavascriptExecutor)driver;
     
     js.executeScript("arguments[0].scrollIntoView();", element);
	
	
}

public static void ScreenShot(WebDriver driver, String scrrnshotName) throws IOException {
	 File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   File destination = new File("C:\\Users\\Pooja\\Downloads\\ScreenShot//"+scrrnshotName+".png");
	   FileHandler.copy(Source, destination);
						
}

public static String ExelRead_standerd (String fileName, String sheetName , int Row , int Cell ) throws EncryptedDocumentException, IOException {
	
	FileInputStream myFile = new FileInputStream("C:\\Users\\Pooja\\Documents\\"+fileName+".xlsx");
	Sheet mySheet = WorkbookFactory.create(myFile).getSheet(sheetName);
	String Data = mySheet.getRow(Row).getCell(Cell).getStringCellValue();
    return Data;
}


public static void ExelRead (String fileName, String sheetName ) throws EncryptedDocumentException, IOException {
	
	FileInputStream myFile = new FileInputStream("C:\\Users\\Pooja\\Documents\\"+fileName+".xlsx");
	Sheet mySheet = WorkbookFactory.create(myFile).getSheet(sheetName);
	int r1 = mySheet.getLastRowNum();
	int c1 = mySheet.getRow(0).getLastCellNum();
	int noOfRow = c1-1;
	for (int i = 0; i <=r1; i++) {
		for (int j = 0; j <= noOfRow; j++) {
			CellType myCellDataType = mySheet.getRow(i).getCell(j).getCellType();
			
			if(myCellDataType==CellType.BOOLEAN)
			{
				boolean valueBoolean = mySheet.getRow(i).getCell(j).getBooleanCellValue();
				System.out.print(valueBoolean+" ");
				
			}
			else if(myCellDataType==CellType.NUMERIC) {
				double valueNumeric = mySheet.getRow(i).getCell(j).getNumericCellValue();

				System.out.print(valueNumeric+" ");
				
			}
			else if (myCellDataType==CellType.STRING) {
				 String valueString = mySheet.getRow(i).getCell(j).getStringCellValue();

				System.out.print(valueString+" ");
				
			}
			
		}System.out.println();
	}
	
}

public static void takeScreenShotWithDate(WebDriver driver , String TCID) throws IOException {
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest = new File("C:\\Users\\Pooja\\Downloads\\ScreenShot//"+TCID+timeStamp+".png");
	Reporter.log("Location of Screenshot: "+dest, true);
	FileHandler.copy(src, dest);
	
}

	//public static void main(String[] args) throws IOException {
		
	//}
public static String PropertyFile(String key) throws IOException {
	// for read data we use it
	//create object of properties class
	Properties prop = new Properties();
	
	
	//File location
	FileInputStream Myfile = new FileInputStream("C:\\Users\\Pooja\\eclipse-workspace\\selenium_study\\src\\propertyFileStudy\\PropertyFileCreate");
	//Load file
	
	//FileInputStream Myfile = new FileInputStream(System.getProperty("user.dir")+"\\CoverFoxProject");
	prop.load(Myfile);
	String value = prop.getProperty(key);
	System.out.println(value);
	return value;
}

}

	
	

	



	
	

	