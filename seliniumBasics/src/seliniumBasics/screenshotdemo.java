package seliniumBasics;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class screenshotdemo {
	 static ChromeDriver driver;
	public static void main(String[] args) throws IOException {		
		try {
		// 1) Open the browser
		 driver = new ChromeDriver();
		//2) Maximize it
		driver.manage().window() .maximize();
		// 3) Navigate to application
		driver.get("https://google.com");
		//4) Type 'mobile' in the search box
		driver.findElementByName("qry").sendKeys("mobile");
		//4.1) Wait for all the items to appear in the auto-complete box
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions. visibilityOfElementLocated(By.xpath("(//ul[contains (@role, 'listbox')])[1]")));
		// 5) Select 4th item from the drop-down
		Actions actions = new Actions (driver);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
		sendKeys(Keys.ARROW_DOWN). sendKeys(Keys.ENTER).build().perform();
		}
		catch(Exception e)
		{
			getscreenshot();
			}
		}

	private static void getscreenshot()throws IOException  {
		
		File ss = ((TakesScreenshot) driver).getScreenshotAs (OutputType. FILE);
		FileHandler.copy(ss, new File("/home/agirkarcisco/Documents/screengrab.png"));
	}

}
