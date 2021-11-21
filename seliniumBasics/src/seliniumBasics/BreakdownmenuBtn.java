package seliniumBasics;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BreakdownmenuBtn {
	
	public static void main(String[] args) {
		//1) Open the browser
		ChromeDriver driver = new ChromeDriver();
		// 2) Maximize it
		driver.manage().window() .maximize();
		//3) Navigate to application
		driver.get("https://whitecircleschool.com/dropdowndemo/");
		//4) Select 'SOUTH AFRICA' from drop down menu
		WebElement countries = driver.findElementByName("country");
		Select select = new Select(countries);
		select.selectByVisibleText("SOUTH AFRICA");
		}
		//5)close browser
		

}
