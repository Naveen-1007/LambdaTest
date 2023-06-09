package sample;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UseCase1_Firefox {

	public String username = "naveen.moorthy.p";
	public String accesskey = "C13aIVqwPav9w1hGjfV9tgYt7zHf7JxapiImUhbNnX8Gcuc4To";
	public static RemoteWebDriver driver = null;
	public String gridURL = "@hub.lambdatest.com/wd/hub";
	boolean status = false;

	@BeforeClass
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "Firefox");
		capabilities.setCapability("browserVersion", "114.0");
		capabilities.setCapability("platform", "win10");
		capabilities.setCapability("build", "NaveenPS");
		capabilities.setCapability("name", "NaveenPS1Run2");
		capabilities.setCapability("visual", true);
		capabilities.setCapability("video", true);
		capabilities.setCapability("network", true);
		capabilities.setCapability("console", true);
		capabilities.setCapability("terminal", true);
		capabilities.setCapability("w3c", true);
		capabilities.setCapability("plugin", "java-testNG");
		try {
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testSimple() throws Exception {
		try {
			driver.get("https://ecommerce-playground.lambdatest.io/index.php");
			driver.findElement(By.xpath("(//li/a[@class='icon-left both nav-link dropdown-toggle'])[3]")).click();
			driver.findElement(By.xpath("//div/a[contains(text(),'Register')]")).click();
			driver.findElement(By.id("input-firstname")).click();
			driver.findElement(By.id("input-firstname")).clear();
			driver.findElement(By.id("input-firstname")).sendKeys("Test");
			driver.findElement(By.id("input-lastname")).clear();
			driver.findElement(By.id("input-lastname")).sendKeys("User1");
			driver.findElement(By.id("input-email")).click();
			driver.findElement(By.id("input-email")).clear();
			driver.findElement(By.id("input-email")).sendKeys("test3394@gmail.com");
			driver.findElement(By.id("input-telephone")).clear();
			driver.findElement(By.id("input-telephone")).sendKeys("+919873628822");
			driver.findElement(By.id("input-password")).click();
			driver.findElement(By.id("input-password")).clear();
			driver.findElement(By.id("input-password")).sendKeys("test@1234");
			driver.findElement(By.id("input-confirm")).clear();
			driver.findElement(By.id("input-confirm")).sendKeys("test@1234");
			driver.findElement(By.xpath("//div[@id='content']/form/div/div/div/label")).click();
			driver.findElement(By.xpath("//input[@value='Continue']")).click();
			driver.findElement(By.xpath("//div[@class='buttons mb-4']/a")).click();
			driver.findElement(By.xpath("//div[@id='entry_217825']/a/div/span")).click();
			driver.findElement(By.linkText("Edit cart")).click();
			WebElement cartItem = driver.findElement(By.xpath("//div[@id='content']/p"));
			assert cartItem.isDisplayed();
			System.out.println("Cart is empty");
			System.out.println("Proceeding to add an item");
			driver.findElement(By.linkText("Continue")).click();
			driver.findElement(By.xpath("(//div[@id='entry_213248']/div/div/div/div/div/a/figure/div/img)[1]")).click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='entry_212408']/div/div[2]//div/a")));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			driver.findElement(By.xpath("//div[@id='entry_216842']/button")).click();
			driver.findElement(By.linkText("View Cart")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
			driver.findElement(By.xpath("//div[@id='content']/form/div/table/tbody/tr/td[4]/div/div/button/i")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
			WebElement payment = driver.findElement(By.id("input-payment-firstname"));
			assert payment.isDisplayed();
			System.out.println("Product is in stock - proceeding to buy");
			driver.findElement(By.id("input-payment-firstname")).click();
			driver.findElement(By.id("input-payment-firstname")).clear();
			driver.findElement(By.id("input-payment-firstname")).sendKeys("Test");
			driver.findElement(By.id("input-payment-lastname")).click();
			driver.findElement(By.id("input-payment-lastname")).clear();
			driver.findElement(By.id("input-payment-lastname")).sendKeys("User1");
			driver.findElement(By.id("input-payment-company")).click();
			driver.findElement(By.id("input-payment-address-2")).click();
			driver.findElement(By.id("input-payment-address-1")).click();
			driver.findElement(By.id("input-payment-address-1")).clear();
			driver.findElement(By.id("input-payment-address-1")).sendKeys("test address");
			driver.findElement(By.id("input-payment-city")).click();
			driver.findElement(By.id("input-payment-city")).clear();
			driver.findElement(By.id("input-payment-city")).sendKeys("New York");
			driver.findElement(By.id("input-payment-postcode")).click();
			driver.findElement(By.id("input-payment-postcode")).clear();
			driver.findElement(By.id("input-payment-postcode")).sendKeys("10001");
			driver.findElement(By.id("input-payment-country")).click();
			new Select(driver.findElement(By.id("input-payment-country"))).selectByVisibleText("United States");
			driver.findElement(By.id("input-payment-zone")).click();
			new Select(driver.findElement(By.id("input-payment-zone"))).selectByVisibleText("New York");
			driver.findElement(By.xpath("//form[@id='form-checkout']/div/div[2]/div/div[5]/label")).click();
			driver.findElement(By.xpath("//button[@id='button-save']/i")).click();
			driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=extension/maza/checkout/confirm");
			driver.findElement(By.id("button-confirm")).click();
			driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=checkout/success");
			driver.findElement(By.linkText("Continue")).click();
			System.out.println("Purchase is successful");
			driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
			driver.findElement(By.xpath("//div[@id='widget-navbar-217834']/ul/li[6]/a/div/span")).click();
			driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/account");
			driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/logout");
			driver.findElement(By.linkText("Continue")).click();
			driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");

			driver.get("https://www.lambdatest.com/selenium-playground/upload-file-demo");
			driver.findElement(By.id("file")).click();
			driver.findElement(By.id("file")).clear();
			driver.findElement(By.id("file")).sendKeys("C:\\Users\\Administrator\\Documents\\LambdaTest-320-180.png");
			String Status = driver.findElement(By.xpath("//input[@id='file']/following-sibling::div")).getText();
			if (Status == "File Successfully Uploaded") {
				System.out.println("File Upload is successful");
			} else {
				System.out.println("File Upload is not successful");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterClass
	public void tearDown() throws Exception {
		if (driver != null) {
			((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
			driver.quit();
		}
	}
}
