package CoverFoxProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_POM {
	@FindBy(xpath = "(//div[@tabindex='0'])[2]")private WebElement genderSelection;
public HomePage_POM (WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public void SelectGender() {
	genderSelection.click();
}
}
