package com.tcs.scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcs.constants.AutomationConstants;
import com.tcs.pages.CFDashboard;
import com.tcs.pages.CFLogin;
import com.tcs.utilities.ExcelUtility;

public class TCCFLogin extends TestBase {
	CFLogin objCFLogin;
	CFDashboard objCFDashboard;
	
	
	@Test(priority=1) 
    public void verifyCFLink() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
    //Create Login Page object
    objCFLogin= new CFLogin(driver);   
   objCFLogin.clickCFLink();
   Thread.sleep(1000);
   for(String winHandle :driver.getWindowHandles())
   {
   	driver.switchTo().window(winHandle);
   }
   String expectedURL =AutomationConstants.CFAFURL;
   String actualURL =driver.getCurrentUrl();
   Assert.assertEquals(expectedURL,actualURL);
   System.out.println("Login page opened ,Test1 passed ");
	}
	
	
	
	@Test(priority=2) //Invalid login with both fields blank
    public void verifyInvalidLogin1() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
    //Create Login Page object
    objCFLogin= new CFLogin(driver);
    objCFLogin.clearEmail();
    objCFLogin.clearPassword();
    objCFLogin.clickLogin();
  Thread.sleep(1000);
//Capturing Validation Message and verifying.    
  String validationMessage =objCFLogin.getEmail().getAttribute("validationMessage");	
  String ExpectedValidation= AutomationConstants.TXT1;
  Assert.assertEquals(ExpectedValidation,validationMessage);
  System.out.println("Login Failed, Test2 Passed");
  Thread.sleep(2000);
	}
	
	
	@Test(priority=3) //Verify invalid login with valid email and invalid password
    public void verifyInvalidLogin2() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
    //Create Login Page object
    objCFLogin= new CFLogin(driver);
	
  String email = ExcelUtility.getCellData(1,0);
    String password = ExcelUtility.getCellData(4,0);
       objCFLogin.setEmail(email);
       objCFLogin.setPassword(password);
       objCFLogin.clickLogin();
       Thread.sleep(6000);
       
       String expectedURL =AutomationConstants.CFURL2;
       String actualURL =driver.getCurrentUrl();
       Assert.assertEquals(expectedURL,actualURL);
       System.out.println("Login failed ,Test3 passed ");
       driver.navigate().back();
	
       Thread.sleep(3000);
	}
	
	
	@Test(priority=4)//Verify invalid login with valid email and null password
	public void verifyInvalidLogin3() throws IOException, Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		    //Create Login Page object
		    objCFLogin= new CFLogin(driver);
			objCFLogin.clearEmail();
		  String email = ExcelUtility.getCellData(1,0);
		  objCFLogin.setEmail(email);
		  objCFLogin.clearPassword();
		       objCFLogin.clickLogin();
		       Thread.sleep(10000);
		     //Capturing Validation Message and verifying.    
		       String validationMessage = objCFLogin.getPassword().getAttribute("validationMessage");	
		       String ExpectedValidation= AutomationConstants.TXT1;		
		       Assert.assertEquals(ExpectedValidation,validationMessage);
		       System.out.println("Login Failed, Test4 Passed");
		       	}
	
	
	@Test(priority=5)//	Verify invalid login with invalid email and valid password
	
	 public void verifyInvalidLogin4() throws IOException, Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		    //Create Login Page object
		    objCFLogin= new CFLogin(driver);
		    //login to application
		  
		    objCFLogin.clearEmail();
		    String email = ExcelUtility.getCellData(3,0);
		    objCFLogin.clearPassword();
		   String password = ExcelUtility.getCellData(2,0);
		    objCFLogin.setEmail(email);
		  objCFLogin.setPassword(password);
		  
		  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	

		  objCFLogin.clickLogin();
		  String expectedURL =AutomationConstants.CFURL2;
	       String actualURL =driver.getCurrentUrl();
	       Assert.assertEquals(expectedURL,actualURL);
	       System.out.println("Login failed ,Test5 passed ");
	       driver.navigate().back();
		  Thread.sleep(5000);
	}
	
	@Test(priority=6)//Verify invalid login with blank email and valid password
	
	 public void verifyInvalidLogin5() throws IOException, Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		    //Create Login Page object
		    objCFLogin= new CFLogin(driver);
		    //login to application
		    
		   //objCFLogin.clickCFLink();
		    objCFLogin.clearEmail();
		    objCFLogin.clearPassword();
		    String password = ExcelUtility.getCellData(2,0);
		    objCFLogin.setPassword(password);
		    objCFLogin.clickLogin();
		  //Capturing Validation Message and verifying.    
		     
		    String validationMessage =objCFLogin.getEmail().getAttribute("validationMessage");	
		    String ExpectedValidation= AutomationConstants.TXT1;
		  		
		    Assert.assertEquals(ExpectedValidation,validationMessage);
		    System.out.println("Login Failed, Test6 Passed");


			  Thread.sleep(6000);
	}
	
	@Test(priority=7)//Verify invalid login with invalid email and invalid password
	public void verifyInvalidLogin6() throws IOException, Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		    //Create Login Page object
		    objCFLogin= new CFLogin(driver);
		    //login to application
		    
		   //objCFLogin.clickCFLink();
		    objCFLogin.clearEmail();
		    String email = ExcelUtility.getCellData(3,0);
		    objCFLogin.clearPassword();
		   String password = ExcelUtility.getCellData(4,0);
		    objCFLogin.setEmail(email);
		  objCFLogin.setPassword(password);		  
		  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		  objCFLogin.clickLogin(); 
		  Thread.sleep(6000);
		  String expectedURL =AutomationConstants.CFURL2;
		  String actualURL =driver.getCurrentUrl();
		  Assert.assertEquals(expectedURL,actualURL);
		  System.out.println("Login failed, Test 7 passed");
		  Thread.sleep(2000);
		  }
	
	
	//@BeforeClass
	@Test(priority=8)
    public void verifyValidLogin() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
    //Create Login Page object
    objCFLogin= new CFLogin(driver);
    //login to application
    objCFLogin.clearEmail();
    String email = ExcelUtility.getCellData(1,0);
    objCFLogin.clearPassword();
   String password = ExcelUtility.getCellData(2,0);
    objCFLogin.setEmail(email);
  objCFLogin.setPassword(password);  
  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
  objCFLogin.clickLogin(); 
  Thread.sleep(6000);
      String expectedURL =AutomationConstants.CFURL1;
  String actualURL =driver.getCurrentUrl();
  Assert.assertEquals(expectedURL,actualURL);
  System.out.println("Customer Front End Dashboard Opened,Test8 Passed");
    Thread.sleep(2000);
  }
	
	
	@Test(priority=9)
    public void verifyMyProfile() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
objCFDashboard= new CFDashboard(driver);	
objCFDashboard.clickMyProfile();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
Thread.sleep(3000);
String expectedURL =AutomationConstants.CFURL7;
String actualURL =driver.getCurrentUrl();
Assert.assertEquals(expectedURL,actualURL);
System.out.println("My Profile page opened");
  Thread.sleep(2000);
objCFDashboard.clearAdrs1();
String address1 = ExcelUtility.getCellData1(52,6);
objCFDashboard.setAdrs1(address1);

objCFDashboard.clearAdrs2();
String address2 = ExcelUtility.getCellData1(52,6);
objCFDashboard.setAdrs2(address2);
Thread.sleep(2000);
objCFDashboard.clickUpdate();
Thread.sleep(3000);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

String expectedURL1 =AutomationConstants.CFURL8;
String actualURL1 =driver.getCurrentUrl();
Assert.assertEquals(expectedURL1,actualURL1);
System.out.println("Profile updated successfully,Test9 passed");
  Thread.sleep(3000);
  	}
	
	
	@Test(priority=10)
    public void verifyMyBookings() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
    //Create Login Page object
    objCFDashboard= new CFDashboard(driver);	
	objCFDashboard.clickMyBookings();
	String MainWindow=driver.getWindowHandle();
	 String expectedURL =AutomationConstants.CFURL3;
	  String actualURL =driver.getCurrentUrl();
	  Assert.assertEquals(expectedURL,actualURL);
	  System.out.println("Bookings Page opened");
	    Thread.sleep(2000);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//objCFDashboard.viewVoucher1();
		//objCFDashboard.waitVoucher();
		//objCFDashboard.clickCookie();   
	    //objCFDashboard.waitVoucher2();    
	objCFDashboard.clickVoucher();
	 Thread.sleep(5000);
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  System.out.println("Displaying the voucher");
	    Thread.sleep(5000);
	   
	 driver.switchTo().window(MainWindow);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  Thread.sleep(5000);
	   
	 String expectedURL2 =AutomationConstants.CFURL3;
	  String actualURL2 =driver.getCurrentUrl();
	  Assert.assertEquals(expectedURL2,actualURL2);
	  System.out.println("Returned to booking page, Test10 Passed");
	    Thread.sleep(2000);
	 
	}
	
	/*@Test(priority=11)
    public void verifyAddFunds() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	

    objCFDashboard= new CFDashboard(driver);
    String MainWindow=driver.getWindowHandle();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    objCFDashboard.clickAddFunds();
    Thread.sleep(2000);
    String expectedURL =AutomationConstants.CFURL5;
	  String actualURL =driver.getCurrentUrl();
	  Assert.assertEquals(expectedURL,actualURL);
	  System.out.println("Add Funds page opened");
	    Thread.sleep(2000);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    objCFDashboard.findPayPal2();
	    Thread.sleep(4000);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
    objCFDashboard.clickPayPal();
    Thread.sleep(3000);
    objCFDashboard.checkPayPal();
    Thread.sleep(2000);
   
   
  /*  objCFDashboard.viewpaynow();
    Thread.sleep(3000);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    objCFDashboard.clickPayNow();
    
    Thread.sleep(3000);
    String expectedURL1 =AutomationConstants.CFURL6;
	  String actualURL1 =driver.getCurrentUrl();
	  Assert.assertEquals(expectedURL1,actualURL1);
	  System.out.println("PayPal page opened");
	    Thread.sleep(2000);
	    objCFDashboard.clickBacktoInvoice();
	    Thread.sleep(2000);
	    objCFDashboard.clickYes();
	    //Thread.sleep(2000);
	    //driver.navigate().back();
	    /*objCFDashboard.clickPayPalclk();
	    Thread.sleep(2000);
	  
	    driver.switchTo().window(MainWindow);
	  //  Thread.sleep(4000);
	    
}*/
	
	

	@Test(priority=12)
    public void verifyLogout() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
    
    objCFDashboard= new CFDashboard(driver);
    //objCFDashboard.findLogout();
    Thread.sleep(2000);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    objCFDashboard.clickLogout();
    Thread.sleep(3000);
    String expectedURL =AutomationConstants.CFURL9;
	  String actualURL =driver.getCurrentUrl();
	  Assert.assertEquals(expectedURL,actualURL);
	  System.out.println("Successfully Logged Out, Test12 passed ");
	    Thread.sleep(2000);
    
	}
	
}