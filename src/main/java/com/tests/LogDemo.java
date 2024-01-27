package com.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LogDemo {
	public WebDriver driver;
	
	Logger log = Logger.getLogger(LogDemo.class);
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Eclips-SeleniumAutomation-Workspace\\\\drivers\\\\chromedriver1.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
		log.info("===================================this is lounching para bank=============================================");
	}
	
	@Test(priority = 1)
	public void loginParaBank() {
		By userName = By.name("username");
		By password = By.name("password");
		By elementLoginButton = By.className("button");
		
		driver.findElement(userName).sendKeys("viveksjjdjdj");
		driver.findElement(password).sendKeys("jkdjkdj");
		driver.findElement(elementLoginButton).click();
	}
	
	//@Test(priority = 2)
	public void payBill() {
		WebElement elementLinkBillPay = driver.findElement(By.linkText("Bill Pay"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		elementLinkBillPay.click();
		
		WebElement elementPayeeName = driver.findElement(By.name("payee.name"));
		WebElement elementAddress = driver.findElement(By.name("payee.address.street"));
		WebElement elementCity = driver.findElement(By.name("payee.address.city"));
		WebElement elementState = driver.findElement(By.name("payee.address.state"));
		WebElement elementZipCode = driver.findElement(By.name("payee.address.zipCode"));
		WebElement elementPhone = driver.findElement(By.name("payee.phoneNumber"));
		WebElement elementAccountNumber = driver.findElement(By.name("payee.accountNumber"));
		WebElement elementVerifyAccountNumber = driver.findElement(By.name("verifyAccount"));
		WebElement elementAmount = driver.findElement(By.name("amount"));
		
		elementPayeeName.sendKeys("vivek");
		elementAddress.sendKeys("dkdkjd");
		elementCity.sendKeys("pune");
		elementState.sendKeys("maharashtra");
		elementZipCode.sendKeys("sjnsj");
		elementPhone.sendKeys("132656");
		elementAccountNumber.sendKeys("56565");
		elementVerifyAccountNumber.sendKeys("5654645");
		elementAmount.sendKeys("10");
	}
	
	@AfterMethod
	public void tearDown() {
		log.info("================================================closing the browser=================================================");
		driver.close();
	}

}
