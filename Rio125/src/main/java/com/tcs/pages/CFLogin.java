package com.tcs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CFLogin {
 WebDriver driver;
	 
	 //objects
 @FindBy(partialLinkText="http://www.phptravels.net/login")
 private WebElement cflink;
 @FindBy(name="email")
 private WebElement email;
 @FindBy(name="password")
private WebElement password;  
@FindBy(xpath="//button[@type=\"submit\"]")
private WebElement login;
	    
	    
	    public CFLogin(WebDriver driver){
	        this.driver = driver;
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
	    }
	    
	    //Click on the link
	    public void clickCFLink() {
	    cflink.click();
	    }
	    
	    //Set email in text box
	    
	    public void setEmail(String strEmail){
	    	email.sendKeys(strEmail);     
	    }

	     public void clearEmail() {
	    	 email.clear();
	     }
	   
	    
	  //Set password in password textbox
	     public void setPassword(String strPassword){
	       password.sendKeys(strPassword);
	    }
	    
	     public void clearPassword() {
	    	password.clear();
	    }
	       
	  //Click on login button 
	     public void clickLogin(){ 
	    	      login.click();   
	     }
	    
	     public WebElement getEmail() {
	 		return email;
	 	}

	 	public void setEmail(WebElement email) {
	 		this.email = email;
	 	}
	 	 public WebElement getPassword() {
		 		return password;
		 	}

		 	public void setPassword(WebElement password) {
		 		this.password = password;
		 	}
}
