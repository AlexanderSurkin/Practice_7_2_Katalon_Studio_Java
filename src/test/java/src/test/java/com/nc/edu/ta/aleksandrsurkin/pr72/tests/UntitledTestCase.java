package src.test.java.com.nc.edu.ta.aleksandrsurkin.pr72.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
//import org.openqa.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UntitledTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver",
            "src/test/java/src/test/java/com/nc/edu/ta/aleksandrsurkin/pr72/chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("https://www.google.com/");
    driver.findElement(By.name("q")).click();
    driver.findElement(By.name("q")).clear();
    driver.findElement(By.name("q")).sendKeys("Netcracker");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//div[@id='rso']/div/div/div/div/div/a/h3")).click();
    driver.findElement(By.linkText("Careers")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='A Culture that is Focused Forward'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("//div[@id='jobdept-group']/div/button/span[2]/span")).click();
    driver.findElement(By.xpath("//div[@id='jobdept-group']/div/div/ul/li[13]/a/span")).click();
    new Select(driver.findElement(By.id("jobdept"))).selectByVisibleText("Quality Assurance");
    driver.findElement(By.xpath("//div[@id='location-group']/div/button/span[2]/span")).click();
    driver.findElement(By.xpath("//div[@id='location-group']/div/div/ul/li[8]/a/span")).click();
    new Select(driver.findElement(By.id("location"))).selectByVisibleText("India");
  }

  @After
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
