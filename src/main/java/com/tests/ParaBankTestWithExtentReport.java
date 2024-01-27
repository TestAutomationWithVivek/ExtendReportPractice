package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParaBankTestWithExtentReport extends ExtentReportUpdated {
	
	@Test(priority = 0)
	public void login() {
		test = extent.createTest("login");
		
		WebElement elementLogo = driver.findElement(By.className("logo"));
		Assert.assertTrue(elementLogo.isDisplayed());
		
		WebElement elementUserName = driver.findElement(By.name("username"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		elementUserName.sendKeys("viveksjjdjdj");
		
		WebElement elementPassword = driver.findElement(By.name("password"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		elementPassword.sendKeys("jkdjkdj");
		
		WebElement elementButtonLOgIn = driver.findElement(By.xpath("//input[@class='button']"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		elementButtonLOgIn.click();
	}
	
	@Test(priority = 1)
	public void payBill() {
		test = extent.createTest("payBill");
		
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
		elementAccountNumber.sendKeys("5654645");
		elementVerifyAccountNumber.sendKeys("5654645");
		elementAmount.sendKeys("10");
		WebElement elementSendPaymentButton = driver.findElement(By.xpath("//input[@type = 'submit' and @class= 'button']"));
		elementSendPaymentButton.click();
		
		WebElement elementconfirmationTExt = driver.findElement(By.xpath("//div[h1[text()='Bill Payment Complete']]"));
		String actualText = elementconfirmationTExt.getText();
		String expectedText = "Bill Payment Complete";
		Assert.assertEquals(actualText, expectedText);
	}

}
