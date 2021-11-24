package seliniumBasics;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Swiggy {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    baseUrl = "https://www.blazedemo.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSwiggy() throws Exception {
    // Label: Test
    // ERROR: Caught exception [ERROR: Unsupported command [resizeWindow | 1920,790 | ]]
    driver.get("https://www.google.com/search?q=swiggy+chennai&oq=swiggy&aqs=chrome.3.69i57j46j0l6.7274j0j7&sourceid=chrome&ie=UTF-8");
    driver.findElement(By.cssSelector("h3.LC20lb.MBeuO.DKV0Md")).click();
    driver.get("https://www.swiggy.com/chennai");
    driver.findElement(By.cssSelector("div.Iou1H")).click();
    driver.findElement(By.cssSelector("input._381fS._1oTLG")).clear();
    driver.findElement(By.cssSelector("input._381fS._1oTLG")).sendKeys("mumbai");
    driver.findElement(By.cssSelector("div._1joFh")).click();
    driver.findElement(By.cssSelector("div.efp8s")).click();
    driver.findElement(By.cssSelector("button.styles_itemImage__POX0b")).click();
    driver.findElement(By.cssSelector("div.F8dpS.styles_addBtnDwebReset__2Q6BN._3L1X9 > div._1RPOp")).click();
    driver.findElement(By.cssSelector("div.BaseModal_content__Ish-9.styles_dwebCard__1IRqi.BaseModal_content__show__2WOyH")).click();
    driver.findElement(By.cssSelector("div.BaseModal_overlay__2Qple")).click();
    driver.findElement(By.cssSelector("button._1gPB7")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
