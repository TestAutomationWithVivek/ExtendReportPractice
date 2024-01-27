package com.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {
	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeClass
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
		
        System.setProperty("webdriver.chrome.driver", "C:\\\\Eclips-SeleniumAutomation-Workspace\\\\drivers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
	}
	
	@Test(priority = 0)
	public void login() throws IOException {
		test = extent.createTest("MyFirstTest", "Sample description");
		 // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        // info(details)
        test.info("This step shows usage of info(details)");
        // log with snapshot
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
		
		
		WebElement elementUserName = driver.findElement(By.name("username"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		elementUserName.sendKeys("Vivekfadat@gmail.com");
		
		WebElement elementPassword = driver.findElement(By.name("password"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		elementPassword.sendKeys("Vivek@1234");
		
		WebElement elementButtonLOgIn = driver.findElement(By.xpath("//input[@class='button']"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		elementButtonLOgIn.click();
		
	   
	}
	
	@Test(priority = 1)
	public void payBill() throws IOException {
		test = extent.createTest("MyFirstTest", "Sample description");
		 // log(Status, details)
       test.log(Status.INFO, "This step shows usage of log(status, details)");
       // info(details)
       test.info("This step shows usage of info(details)");
       // log with snapshot
       test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
       // test with snapshot
       test.addScreenCaptureFromPath("screenshot.png");
		
		
		
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
	
	@AfterClass
	public void tearDown() {
		extent.flush();
		//driver.close();
	}


}
