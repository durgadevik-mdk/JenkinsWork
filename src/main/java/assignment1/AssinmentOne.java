package assignment1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssinmentOne {

	WebDriver driver;

	@Before
	public void startbrowser() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test
	public void loginpage() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");

		driver.findElement(By.xpath("//button[text()='Sign in']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[contains(text(),'Bank & Cash')]")).click();

		driver.findElement(By.xpath("//a[contains(text(),'New Account')]")).click();

		Thread.sleep(3000);

		 driver.findElement(By.xpath("//input[@id='account']")).sendKeys("Deviam Thanthaveedu");;
		
		driver.findElement(By.xpath("//input[@id='description']")).sendKeys("Save Money and Help Others");

		driver.findElement(By.xpath("//input[@id= 'balance' and @ type='text']")).sendKeys("1000");

		driver.findElement(By.cssSelector("input#account_number")).sendKeys("123 456 7890");

		driver.findElement(By.cssSelector("input#contact_person")).sendKeys("aaaa");

		driver.findElement(By.cssSelector("input#contact_phone")).sendKeys("123 456 7890");

		driver.findElement(By.xpath("//button[@type='submit' and @class='btn btn-primary']")).click();

	}

	@After
	public void tearDown() {

		driver.close();
	}

}
