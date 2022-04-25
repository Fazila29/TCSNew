package com.tcs.scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcs.constants.AutomationConstants;
import com.tcs.pages.Agent;
import com.tcs.pages.CFLogin;
import com.tcs.utilities.ExcelUtility;

public class TCAgent extends TestBase {
	CFLogin objCFLogin;
	Agent objAgent;
	

	@Test(priority=1)
    public void verifyAgentLink() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
    //Create Login Page object
    objCFLogin= new CFLogin(driver);
    objAgent= new Agent(driver);
    objAgent.clickAgentLink();
    Thread.sleep(2000);
    for(String winHandle :driver.getWindowHandles())
    {
    	driver.switchTo().window(winHandle);
    }
    
    String expectedURL =AutomationConstants.CFAFURL;
    String actualURL =driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    System.out.println("Agent front end Login Page Opened,Test1 Passed");
      Thread.sleep(2000);   
	}

	@Test(priority=2) //Invalid login with both fields blank
    public void verifyAgentInvalidLogin1() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
objAgent= new Agent(driver);	
objCFLogin= new CFLogin(driver);
objAgent.clearEmail();
objAgent.clearPassword();
Thread.sleep(2000);   
objAgent.clickLogin();
Thread.sleep(2000);

String validationMessage = objAgent.getEmail().getAttribute("validationMessage");	
String ExpectedValidation= AutomationConstants.TXT1;	
Assert.assertEquals(ExpectedValidation,validationMessage);
System.out.println("Login Failed, Agent-Test2 Passed");

	}
	
	@Test(priority=3) //Verify invalid login with valid email and invalid password
    public void verifyAgentInvalidLogin2() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
    //Create Login Page object
    objAgent= new Agent(driver);
	
  String email = ExcelUtility.getCellData(1,1);
    String password = ExcelUtility.getCellData(4,1);
       objCFLogin.setEmail(email);
       objCFLogin.setPassword(password);
       Thread.sleep(2000);
       objCFLogin.clickLogin();	
       Thread.sleep(3000);
       
       String expectedURL =AutomationConstants.AFURL13;
       String actualURL =driver.getCurrentUrl();
       Assert.assertEquals(expectedURL,actualURL);
       System.out.println("Login failed ,Agent-Test3 passed ");
       driver.navigate().back();
	
       Thread.sleep(2000);
	}
	

	@Test(priority=4)//Verify invalid login with valid email and null password
	public void verifyAgentInvalidLogin3() throws IOException, Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		    //Create Login Page object
		    objAgent= new Agent(driver);
			objCFLogin.clearEmail();
		  String email = ExcelUtility.getCellData(1,1);
		  objCFLogin.setEmail(email);
		  objCFLogin.clearPassword();
		       objCFLogin.clickLogin();
		       Thread.sleep(2000);
		     //Assert popupmessage
		     //Capturing Validation Message and verifying.    
		       
		       
		       String validationMessage = objCFLogin.getPassword().getAttribute("validationMessage");	
		       String ExpectedValidation= AutomationConstants.TXT1;		
		       Assert.assertEquals(ExpectedValidation,validationMessage);
		       System.out.println("Login Failed, Agent-Test4 Passed");
		       	}
	
	@Test(priority=5)//	Verify invalid login with invalid email and valid password
	 public void verifyAgentInvalidLogin4() throws IOException, Exception {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
			    //Create Login Page object
			    objAgent= new Agent(driver);
			    //login to application
			  
			    objCFLogin.clearEmail();
			    String email = ExcelUtility.getCellData(3,1);
			    objCFLogin.clearPassword();
			   String password = ExcelUtility.getCellData(2,1);
			    objCFLogin.setEmail(email);
			  objCFLogin.setPassword(password);
			  Thread.sleep(1000);

			  objCFLogin.clickLogin();
			  String expectedURL =AutomationConstants.AFURL13;
		       String actualURL =driver.getCurrentUrl();
		       Assert.assertEquals(expectedURL,actualURL);
		       System.out.println("Login failed ,Agent-Test5 passed ");
		       driver.navigate().back();
			  Thread.sleep(3000);
		}
	
	@Test(priority=6)//Verify invalid login with blank email and valid password
	
	 public void verifyAgentInvalidLogin5() throws IOException, Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		    //Create Login Page object
		    objCFLogin= new CFLogin(driver);
		    //login to application
		    
		   //objCFLogin.clickCFLink();
		    objCFLogin.clearEmail();
		    objCFLogin.clearPassword();
		    String password = ExcelUtility.getCellData(2,1);
		    objCFLogin.setPassword(password);
		    objCFLogin.clickLogin();
		  //Capturing Validation Message and verifying.    
		     
		    String validationMessage =objCFLogin.getEmail().getAttribute("validationMessage");	
		    String ExpectedValidation= AutomationConstants.TXT1;
		  		
		    Assert.assertEquals(ExpectedValidation,validationMessage);
		    System.out.println("Login Failed, Agent-Test6 Passed");


			  Thread.sleep(2000);
	}
	
	@Test(priority=7)//Verify invalid login with invalid email and invalid password
	public void verifyAgentInvalidLogin6() throws IOException, Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		    //Create Login Page object
		    objAgent= new Agent(driver);
		    //login to application
		    objCFLogin.clearEmail();
		    String email = ExcelUtility.getCellData(3,1);
		    objCFLogin.clearPassword();
		   String password = ExcelUtility.getCellData(4,1);
		    objCFLogin.setEmail(email);
		  objCFLogin.setPassword(password);
		  
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	

		  objCFLogin.clickLogin();
		  
		  Thread.sleep(3000);
		  String expectedURL =AutomationConstants.AFURL13;
		  String actualURL =driver.getCurrentUrl();
		  Assert.assertEquals(expectedURL,actualURL);
		  System.out.println("Login failed, Agent-Test7 passed");
		  Thread.sleep(2000);
		  }
	
		
	@Test(priority=8)
    public void verifyAFValidLogin() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
    //Create Login Page object
   
    objAgent= new Agent(driver);
        //login to application
    objCFLogin.clearEmail();
    String email = ExcelUtility.getCellData(1,1);
    objCFLogin.clearPassword();
   String password = ExcelUtility.getCellData(2,1);
    objCFLogin.setEmail(email);
  objCFLogin.setPassword(password);
  
  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	

  objCFLogin.clickLogin();
  
  Thread.sleep(4000);
  
      String expectedURL =AutomationConstants.AFURL1;
  String actualURL =driver.getCurrentUrl();
  Assert.assertEquals(expectedURL,actualURL);
  System.out.println("LOGIN Success;Agent Front End Dashboard Opened,Agent-Test8 Passed");
    Thread.sleep(2000);
  }
	
	
	

	@Test(priority=9)
    public void verifyagMyBookings() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
   
    objAgent= new Agent(driver);
    
    objAgent.clickagMyBookings();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(2000);
    
    String expectedURL =AutomationConstants.AFURL2;
    String actualURL =driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    System.out.println("Agent Front End Bookings Page Opened,Agent-Test9 Passed");
      Thread.sleep(2000);
	driver.navigate().back();
	Thread.sleep(2000);
	}
	
	@Test(priority=10)
    public void verifyagAddFunds() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
   
    objAgent= new Agent(driver);
    
    objAgent.clickagAddFunds();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(2000);
    
    String expectedURL =AutomationConstants.AFURL3;
    String actualURL =driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    System.out.println("Agent Front End Add Funds Page Opened,Test10 Passed");
      Thread.sleep(2000);
	driver.navigate().back();
	Thread.sleep(2000);
	}	
	
	@Test(priority=11)
    public void verifyagMyProfile() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
   
    objAgent= new Agent(driver);
    
    objAgent.clickagMyProfile();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(2000);
    
    String expectedURL =AutomationConstants.AFURL4;
    String actualURL =driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    System.out.println("Agent Front End My Profile Page Opened,Test 11 Passed");
      Thread.sleep(2000);
	driver.navigate().back();
	Thread.sleep(2000);
	}
	
	
	@Test(priority=12)
    public void verifyaghome() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
   
    objAgent= new Agent(driver);
    
    objAgent.clickagHome();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(2000);
    
    String expectedURL =AutomationConstants.AFURL5;
    String actualURL =driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    System.out.println("Agent Front End Home Page Opened,Agent-Test 12 Passed");
      Thread.sleep(2000);
	driver.navigate().back();
	Thread.sleep(2000);
	}
	@Test(priority=13)
    public void verifyaghotels() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
   
    objAgent= new Agent(driver);
    
    objAgent.clickagHotels();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(2000);
    
    String expectedURL =AutomationConstants.AFURL6;
    String actualURL =driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    System.out.println("Agent Front End Hotels Page Opened,Agent-Test 13-A Passed");
      Thread.sleep(2000);
 objAgent.clickagHotelscity1();
      Thread.sleep(2000);
      String aghotelscity2 = ExcelUtility.getCellData(6,0);
	    objAgent.SetagHotelscity2(aghotelscity2); 
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    Thread.sleep(2000);
	   // objAgent.WaitCity();
	    Thread.sleep(2000);
	    objAgent.SelectCity();
	    Thread.sleep(2000);
      objAgent.ClickSearch();
      Thread.sleep(4000);   
      System.out.println("Hotels can be searched by cityname");
	driver.navigate().back();
	Thread.sleep(2000);
	}
	
	@Test(priority=14)
    public void verifyagFlights() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
   
    objAgent= new Agent(driver);
    
    objAgent.clickagFlights();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(2000);
    
    String expectedURL =AutomationConstants.AFURL7;
    String actualURL =driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    System.out.println("Agent Front End Flights Page Opened,Agent-Test 14 Passed");
      Thread.sleep(2000);
	driver.navigate().back();
	Thread.sleep(2000);
	}
	
	@Test(priority=15)
    public void verifyagTours() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
   
    objAgent= new Agent(driver);
    
    objAgent.clickagTours();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(2000);
    
    String expectedURL =AutomationConstants.AFURL8;
    String actualURL =driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    System.out.println("Agent Front End Tours Page Opened,Agent-Test 15 Passed");
      Thread.sleep(2000);
	driver.navigate().back();
	Thread.sleep(2000);
	}
	
	@Test(priority=16)
    public void verifyagVisa() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
   
    objAgent= new Agent(driver);
    
    objAgent.clickagVisa();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(2000);
    
    String expectedURL =AutomationConstants.AFURL9;
    String actualURL =driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    System.out.println("Agent Front End Visa Page Opened,Agent-Test 16 Passed");
      Thread.sleep(2000);
	driver.navigate().back();
	Thread.sleep(2000);
	}
	
	@Test(priority=17)
    public void verifyagBlogs() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
   
    objAgent= new Agent(driver);
    
    objAgent.clickagBlogs();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(2000);
    
    String expectedURL =AutomationConstants.AFURL10;
    String actualURL =driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    System.out.println("Agent Front End Blog Page Opened,Agent-Test 17 Passed");
      Thread.sleep(2000);
	driver.navigate().back();
	Thread.sleep(2000);
	}
	
	
	@Test(priority=18)
    public void verifyagOffers() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
   
    objAgent= new Agent(driver);
    
    objAgent.clickagOffers();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(2000);
    
    String expectedURL =AutomationConstants.AFURL11;
    String actualURL =driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    System.out.println("Agent Front End Offers Page Opened,Agent-Test 18 Passed");
      Thread.sleep(2000);
	
	}
	

	@Test(priority=19)
    public void verifyagCurrencyConversion() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
   
    objAgent= new Agent(driver);
    
    objAgent.clickagCurrency();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(2000);
    
    objAgent.clickagINR();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(2000);
    //objAgent.AssertagINR();
   
	Thread.sleep(2000);
	}
	
	@Test(priority=20)
    public void verifyagLogout() throws IOException, Exception {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
   
    objAgent= new Agent(driver);
    Thread.sleep(2000);
    objAgent.clickagAccounts();
    Thread.sleep(1000);
    objAgent.clickagLogout();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(3000);
    
    String expectedURL =AutomationConstants.AFURL12;
    String actualURL =driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    System.out.println("Successfully logged out,Agent-Test 20 Passed");
      Thread.sleep(2000);
	
	}		
	
	
	
	}

