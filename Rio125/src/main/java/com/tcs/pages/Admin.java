package com.tcs.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin {
	
WebDriver driver;
	
	@FindBy(xpath="//a[contains(.,'admin')]")
	private WebElement adminlink;
	
	 @FindBy(xpath="//input[@name='email'and@type='text']")
	private WebElement ademail;
	 @FindBy(xpath="//input[@name='password'and@type='password']")
	private WebElement adpassword;  
	@FindBy(xpath="//span[contains(.,'Login')and@class='ladda-label']")
	private WebElement adlogin;
	@FindBy(xpath="//div[contains(.,'Invalid Login Credentials')and@class='alert alert-danger loading wow fadeIn animated animated']")
	private WebElement adinvalidalert3;
	
	@FindBy(xpath="//div[@class='alert alert-danger loading wow fadeIn animated animated']/child::p")
	private WebElement adinvalidalert4;
	
	
	
	@FindBy(xpath="//a[contains(.,'Website')and@class='nav-link']")
	private WebElement adwebsite;
	@FindBy(xpath="//a[@href='https://www.phptravels.net/api/admin/bookings'and@class='nav-link loadeffect']")
	private WebElement adbookings;
	
	@FindBy(xpath="//select[@class='form-select status paid']//parent::td//../following-sibling::td[2]//child::a")
	private WebElement adinvoice;
	
	@FindBy(xpath="//select[@class='form-select status cancelled']//parent::td//../following-sibling::td[4]//child::button")
	private WebElement addelete;
	
	
	@FindBy(xpath="//div[@class='alert alert-danger loading wow fadeIn animated animated']")
	private WebElement bothblankalert;
	
	@FindBy(xpath="//div[contains(.,'Confrimed Bookings')]/preceding-sibling::div[@class='display-5']")
	private WebElement confirmednumber;
	
	@FindBy(xpath="//select[@class='form-select status pending']")
	private WebElement pending;
	
	@FindBy(xpath="//select[@class='form-select status pending']/child::option[@class='Confirmed']")
	private WebElement confirmed;
	
	
	
	public Admin(WebDriver driver){
	    this.driver = driver;
	    //This initElements method will create all WebElements
	    PageFactory.initElements(driver, this);
	}	
	
	public void clickAdminLink() {
	    adminlink.click();
	    }
	
	public void setadEmail(String strEmail){
    	ademail.sendKeys(strEmail);     
    }

     public void clearadEmail() {
    	ademail.clear();
     }
   
    
  //Set password in password textbox
     public void setadPassword(String strPassword){
       adpassword.sendKeys(strPassword);
    }
    
     public void clearadPassword() {
    	adpassword.clear();
    }
       
  //Click on login button 
     public void clickadLogin(){ 
    	      adlogin.click();   
     }
     
     public void clickadWebsite(){ 
	      adwebsite.click();   
}   
     
    
	
     public void clickadBooking(){ 
	      adbookings.click();   
}
	
     public void ViewadInvoice() throws InterruptedException{ 
    	 
    	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", adinvoice);
    	 Thread.sleep(500);    
}	

     public void clickadInvoice(){ 
	      adinvoice.click();   
}
     
     public void clickadDelete(){ 
	      addelete.click();   
}
     
     public void acceptAlert(){ 
    	 driver.switchTo().alert().accept();   
}    
     
     public void BlankAlertDisplayed(){ 
    	 if(bothblankalert.isDisplayed()) { 
    	       System.out.println("Login failed,Admin-Test2 Passed. Return: " +bothblankalert.isDisplayed()); 
    	    } 
    	   else { 
    	      System.out.println("Admin Test-2 failed. Return: " +bothblankalert.isDisplayed()); 
    	    } 
}  
     
     public void BlankAlert3Displayed(){ 
    	 if(adinvalidalert3.isDisplayed()) { 
    		 System.out.println(adinvalidalert3.getText());
    	       System.out.println("Login failed,Admin-Test3 Passed. Return: " +adinvalidalert3.isDisplayed()); 
    	    } 
    	   else { 
    	      System.out.println("Admin Test-3 failed. Return: " +adinvalidalert3.isDisplayed()); 
    	    } 
}     
     
     public void BlankAlert4Displayed(){ 
    	 if(adinvalidalert4.isDisplayed()) { 
    		 System.out.println(adinvalidalert4.getText());
    	       System.out.print("Login failed,Admin-Test4 Passed. Return: " +adinvalidalert4.isDisplayed()); 
    	    } 
    	   else { 
    	      System.out.println("Admin Test-4 failed. Return: " +adinvalidalert4.isDisplayed()); 
    	    } 
}        
   
     
     
     
     
     
     public void GetConfNumberInitial(){ 
    	 String InitialConfirmedNumber =confirmednumber.getText();
    	 System.out.println("The initial number of confirmed booking --- "+InitialConfirmedNumber);
    	  
}    
     public void clickadPending(){ 
	      pending.click();   
} 
     
     public void clickConfirmed(){ 
	      confirmed.click();   
} 	

     public void GetConfNumberFinal(){ 
    	 String FinalConfirmedNumber=confirmednumber.getText();
    	 System.out.println("The Final number of confirmed booking --- "+FinalConfirmedNumber);
    	  
}       
     
}
