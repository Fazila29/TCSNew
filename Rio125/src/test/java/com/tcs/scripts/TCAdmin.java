package com.tcs.scripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcs.constants.AutomationConstants;
import com.tcs.pages.Admin;
import com.tcs.pages.Agent;
import com.tcs.pages.CFLogin;
import com.tcs.utilities.ExcelUtility;

public class TCAdmin extends TestBase{
	
	CFLogin objCFLogin;
	Admin objAdmin;
	

	@Test(priority=1)
    public void verifyAdminLink() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
    //Create Login Page object
    objCFLogin= new CFLogin(driver);
    objAdmin= new Admin(driver);
    objAdmin.clickAdminLink();
    Thread.sleep(2000);
    for(String winHandle :driver.getWindowHandles())
    {
    	driver.switchTo().window(winHandle);
    }
    
    String expectedURL =AutomationConstants.ADURL1;
    String actualURL =driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    System.out.println("Admin Back end Login Page Opened,Admin-Test1 Passed");
      Thread.sleep(2000);   
	}
	
	@Test(priority=2) //Invalid login with both fields blank
    public void verifyAgentInvalidLogin1() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
objAdmin= new Admin(driver);	

objAdmin.clearadEmail();
objAdmin.clearadPassword();
Thread.sleep(2000);   
objAdmin.clickadLogin();
Thread.sleep(4000);
objAdmin.BlankAlertDisplayed();

Thread.sleep(2000);

	}
	@Test(priority=3) //Verify invalid login with valid email and invalid password
    public void verifyADInvalidLogin2() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
    //Create Login Page object
    objAdmin= new Admin(driver);
	
  String email = ExcelUtility.getCellData(1,2);
    String password = ExcelUtility.getCellData(4,2);
       objCFLogin.setEmail(email);
       objCFLogin.setPassword(password);
       objAdmin.clickadLogin();
       Thread.sleep(2000);
       
       objAdmin.BlankAlert3Displayed();

       Thread.sleep(2000);    
	}
	
	
	@Test(priority=4)//Verify invalid login with valid email and null password
	public void verifyADInvalidLogin3() throws IOException, Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		    //Create Login Page object
		    objAdmin= new Admin(driver);
			objAdmin.clearadEmail();
		  String email = ExcelUtility.getCellData(1,2);
		  objAdmin.setadEmail(email);
		  objAdmin.clearadPassword();
		       objAdmin.clickadLogin();
		       Thread.sleep(3000);
	
		       objAdmin.BlankAlert4Displayed();       
		       
		       Thread.sleep(2000);
		   	 
		       
		       
	}
	
	@Test(priority=5)//	Verify invalid login with invalid email and valid password
	
	 public void verifyAdInvalidLogin4() throws IOException, Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		    //Create Login Page object
		    objAdmin= new Admin(driver);
		    //login to application
		  
		    objAdmin.clearadEmail();
		    String email = ExcelUtility.getCellData(3,2);
		    objCFLogin.clearPassword();
		   String password = ExcelUtility.getCellData(2,2);
		    objAdmin.setadEmail(email);
		  objAdmin.setadPassword(password);
		  
		  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	

		  objAdmin.clickadLogin();
		  Thread.sleep(2000);
	
	
	
	}

	@Test(priority=6)//Verify invalid login with blank email and valid password
	
	 public void verifyInvalidLogin5() throws IOException, Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		    //Create Login Page object
		    objAdmin= new Admin(driver);
		    
		    objAdmin.clearadEmail();
		    objAdmin.clearadPassword();
		    String password = ExcelUtility.getCellData(2,2);
		    objCFLogin.setPassword(password);
		    objAdmin.clickadLogin();
		    Thread.sleep(2000);
	
	
	}
	
	
	@Test(priority=7)//Verify invalid login with invalid email and invalid password
	public void verifyInvalidLogin6() throws IOException, Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		
		 objAdmin= new Admin(driver);
		    //login to application
		  
		    objAdmin.clearadEmail();
		    String email = ExcelUtility.getCellData(3,2);
		    objCFLogin.clearPassword();
		   String password = ExcelUtility.getCellData(4,2);
		    objAdmin.setadEmail(email);
		  objAdmin.setadPassword(password);
		  
		  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	

		  objAdmin.clickadLogin();
		  Thread.sleep(2000);
	
	}
		
		
		
		
	@Test(priority=8)
    public void verifyADValidLogin() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
    //Create Login Page object
   
    objAdmin= new Admin(driver);
        //login to application
    objAdmin.clearadEmail();
    String email = ExcelUtility.getCellData(1,2);
    objAdmin.clearadPassword();
   String password = ExcelUtility.getCellData(2,2);
    objAdmin.setadEmail(email);
  objAdmin.setadPassword(password);
  
  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	

  objAdmin.clickadLogin();
//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  Thread.sleep(4000);
  
  assertTrue(driver.getTitle().contains("Dashboard"));
  System.out.println("LOGIN Success;Admin Back- End Dashboard Opened,Admin-Test8 Passed");
    Thread.sleep(2000);
  }
	/*@Test(priority=9)
    public void verifyADWebsite() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
    //Create Login Page object
   
    objAdmin= new Admin(driver);
    Thread.sleep(2000);
    String MainWindow=driver.getWindowHandle();
	objAdmin.clickadWebsite();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    Thread.sleep(2000);
    /*for(String winHandle :driver.getWindowHandles())
    {
    	driver.switchTo().window(winHandle);
    }
    
  
    String expectedURL =AutomationConstants.ADURL4;
    String actualURL =driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    assertTrue(driver.getTitle().contains("JSTRAVELS"));
    System.out.println("Navigated to a different page,Admin-Test9-a Passed");
      Thread.sleep(4000); 
      driver.switchTo().window(MainWindow);
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  Thread.sleep(3000);
	   
	 String expectedURL2 =AutomationConstants.ADURL2;
	  String actualURL2 =driver.getCurrentUrl();
	  Assert.assertEquals(expectedURL2,actualURL2);
	  System.out.println("Returned to Admin Dashboard, Test9-b Passed");
	    Thread.sleep(2000);
	 
	
	}*/

	@Test(priority=10)
    public void verifyADBookings() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
    //Create Login Page object
   
    objAdmin= new Admin(driver);
    Thread.sleep(2000);
	objAdmin.clickadBooking();
    Thread.sleep(2000);
    String expectedURL =AutomationConstants.ADURL3;
    String actualURL =driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    System.out.println("Admin Back end Bookings Page Opened,Admin-Test10 Passed");
      Thread.sleep(2000); 
	}
	
	/*@Test(priority=11)
    public void verifyInvoice() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
    //Create Login Page object
   
    objAdmin= new Admin(driver);
    String MainWindow=driver.getWindowHandle();
    Thread.sleep(2000);
    objAdmin.ViewadInvoice();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	objAdmin.clickadInvoice();
    Thread.sleep(4000);
    for(String winHandle :driver.getWindowHandles())
    {
    	driver.switchTo().window(winHandle);
    }
    
    Thread.sleep(2000);
    String expectedURL =AutomationConstants.ADURL5;
    String actualURL =driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    System.out.println("Admin Back end Invoice displayed,Admin-Test11-a Passed");
      Thread.sleep(2000); 
      driver.switchTo().window(MainWindow);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  Thread.sleep(5000);
	   
	 String expectedURL2 =AutomationConstants.ADURL3;
	  String actualURL2 =driver.getCurrentUrl();
	  Assert.assertEquals(expectedURL2,actualURL2);
	  System.out.println("Returned to booking page, Admin-Test11-b Passed");
	    Thread.sleep(2000);  
      
	}
	
	@Test(priority=12)
    public void verifyADDeleteBooking() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
  
    objAdmin= new Admin(driver);
    Thread.sleep(2000);
	objAdmin.clickadDelete();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(2000);
    objAdmin.acceptAlert();
    Thread.sleep(2000);
	
	}	*/
	@Test(priority=13)
    public void verifyADPendToConf() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
  
    objAdmin= new Admin(driver);
    Thread.sleep(2000);
    objAdmin.GetConfNumberInitial();
    Thread.sleep(2000);
	objAdmin.clickadPending();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(2000);
    objAdmin.clickConfirmed();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(2000);
    driver.navigate().refresh();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(3000);
    objAdmin.GetConfNumberFinal();
    Thread.sleep(2000);
	
	}	
}
