package demoWithTestNG;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GridDemo {

WebDriver driver;

	@BeforeTest
	public void launchApplication() throws MalformedURLException {
		// 1) Open the browser
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.LINUX);
		driver = new RemoteWebDriver(new URL("http://172.17.0.1:4444/wd/hub"), cap);
		// 1.1) Maximize the browser
		driver.manage().window().maximize();
		// 2) Navigate to the application
		driver.get("https://www.linkedin.com/");
	}

	@Test
	public void titleVerification() {
		// 3) Verify title of the page is - 'LinkedIn: Log In or Sign Up
		String expectedTitle = "LinkedIn: Log In or Sign Up";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
