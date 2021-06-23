package assignments;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assinment2 {
	WebDriver driver;

	@Before
	public void startbrowser() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginpage() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");

		driver.findElement(By.xpath("//button[text()='Sign in']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@id='side-menu']/li[3]/a/span[1]"))));

		driver.findElement(By.xpath("//ul[@id='side-menu']/li[3]/a/span[1]")).click();

		driver.findElement(By.xpath("//a[text()='Add Customer']")).click();

		String PAGE_TITLE = driver.getTitle();

		Assert.assertTrue(PAGE_TITLE, true);

		WebElement ACCOUNT_NAME_ELEMENT = driver.findElement(By.cssSelector("input#account"));

		WebDriverWait wait1 = new WebDriverWait(driver, 10);

		wait1.until(ExpectedConditions.visibilityOf(ACCOUNT_NAME_ELEMENT));

		ACCOUNT_NAME_ELEMENT.sendKeys("PARRU");

		String CUSTOMER_NAME_GIVEN = ACCOUNT_NAME_ELEMENT.getAttribute("value");

		driver.findElement(By.cssSelector("select#cid"));

		Select sel = new Select(driver.findElement(By.cssSelector("select#cid")));
		
		//By.xpath("//span[@id = 'select2-country-container']/ancestor::span[3]/preceding::select[1]");

		sel.selectByValue("36");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("newProjessswct53@gmail.com");

		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("8484ss39208402");

		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("679-a west dr");

		driver.findElement(By.xpath("//input[@id= 'city']")).sendKeys("princeton");

		driver.findElement(By.xpath("//input[@id= 'state']")).sendKeys("RoadIsland");

		driver.findElement(By.xpath("//input[@id= 'zip']")).sendKeys("98765");

		driver.findElement(By.xpath("//select[@id ='country']"));

		Select selcountry = new Select(driver.findElement(By.xpath("//select[@id ='country']")));

		selcountry.selectByValue("United Kingdom");

		Select select = new Select(driver.findElement(By.xpath("//select[@id='currency']")));

		select.selectByValue("1");

		Select select1 = new Select(driver.findElement(By.xpath("//select[@id='group']")));

		select1.selectByVisibleText("January 2021");

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("****LLLLLLL");

		driver.findElement(By.xpath("//input[@id='cpassword']")).sendKeys("****LLLLLLL");

		driver.findElement(By.xpath("//button[@id = 'submit']")).click();

		Thread.sleep(2000);

		WebElement EMSG_ALERT_ELEMENT = driver.findElement(By.xpath("//div[@id='emsg']"));

		String EMSG = EMSG_ALERT_ELEMENT.getText();

		System.out.println(EMSG);

		WebElement SUMMARY_PAGE_ELEMENT = driver.findElement(By.xpath("//a[@id = 'summary']"));

		WebDriverWait wait3 = new WebDriverWait(driver, 10);

		wait3.until(ExpectedConditions.visibilityOf(SUMMARY_PAGE_ELEMENT));

		WebElement LIST_CUSTOMERS_ELEMENT = driver.findElement(By.xpath("//a[contains(text(),'List Customers')]"));

		WebDriverWait wait4 = new WebDriverWait(driver, 10);

		wait4.until(ExpectedConditions.visibilityOf(LIST_CUSTOMERS_ELEMENT));

		LIST_CUSTOMERS_ELEMENT.click();

		WebElement CUSTOMER_NAME_ELEMENT = driver.findElement(By.xpath(
				"//table[@class='table table-bordered table-hover sys_table footable footable-loaded']/child::tbody[1]/child::tr[1]/child::td[3]/a"));

		String CUSTOMER_NAME = CUSTOMER_NAME_ELEMENT.getText();

		Assert.assertEquals(CUSTOMER_NAME_GIVEN, CUSTOMER_NAME);

	}

	@After

	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
