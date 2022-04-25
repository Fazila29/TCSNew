package com.tcs.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Agent {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"Main\"]/section[1]/div/div/div[3]/div/div/div[2]/div/div/div[1]/div/a/small")
	private WebElement agentlink;
	
	 @FindBy(xpath="//input[@type='email']")
	private WebElement email;
	 @FindBy(xpath="//input[@type='password']")
	private WebElement password;  
	@FindBy(xpath="//button[@type='submit']")
	private WebElement login;
	
	
	
	@FindBy(xpath="//i[@class='la la-shopping-cart mr-2 text-color-3']")
	private WebElement agmybookings;

	@FindBy(xpath="//i[@class='la la-wallet mr-2 text-color-9']")
	private WebElement agaddfunds;
	

	@FindBy(xpath="//i[@class='la la-user mr-2 text-color-2']")
	private WebElement agmyprofile;
	
	
	
	
	@FindBy(xpath="//a[@href='https://www.phptravels.net/'and@title='home']")
	private WebElement aghome;
	
	@FindBy(xpath="//a[@href='https://www.phptravels.net/hotels'and@title='home']")
	private WebElement aghotels;
	
	@FindBy(xpath="//span[@id='select2-hotels_city-container']")
	private WebElement aghotelscity1;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	private WebElement aghotelscity2;
	@FindBy(xpath="//input[@type='hidden'and@value='en']")
	private WebElement aghotelscitydrop;
	@FindBy(xpath="//i[@class='mdi mdi-search']")
	private WebElement aghotelssearch;
	
	@FindBy(xpath="//a[@href='https://www.phptravels.net/flights'and@title='home']")
	private WebElement agflights;
	

	@FindBy(xpath="//a[@href='https://www.phptravels.net/tours'and@title='home']")
	private WebElement agtours;

	@FindBy(xpath="//a[@href='https://www.phptravels.net/visa'and@title='home']")
	private WebElement agvisa;
	

	@FindBy(xpath="//a[@href='https://www.phptravels.net/blog'and@title='blog']")
	private WebElement agblogs;

	@FindBy(xpath="//a[@href='https://www.phptravels.net/offers'and@title='offers']")
	
		private WebElement agoffers;

	@FindBy(xpath="//button[contains(.,'USD')]")
	private WebElement agcurrency;
	
	@FindBy(xpath="//a[@href='https://www.phptravels.net/currency-INR']")
	private WebElement aginr;
	
	
	
	@FindBy(xpath="//button[contains(.,'Account')]")
	private WebElement agaccounts;

	@FindBy(xpath="//a[@href='https://www.phptravels.net/account/logout']")
	private WebElement aglogout;
	

	
	public Agent(WebDriver driver){
	    this.driver = driver;
	    //This initElements method will create all WebElements
	    PageFactory.initElements(driver, this);
	}	
	
	public void clickAgentLink() {
	    agentlink.click();
	    }
	
	public void setEmail(String strEmail){
    	email.sendKeys(strEmail);     
    }

     public void clearEmail() {
    	 getEmail().clear();
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
    
	
	
	public void clickagMyBookings() {
	    agmybookings.click();
	    }

	public void clickagAddFunds() {
	    agaddfunds.click();
	    }

	public void clickagMyProfile() {
	    agmyprofile.click();
	    }

	public void clickagHome() {
	    aghome.click();
	    }

	public void clickagHotels() {
	    aghotels.click();
	    }
	public void clickagHotelscity1() {
	    aghotelscity1.click();
	    }
	
	
	public void SetagHotelscity2(String strSetagHotelscity2){
		aghotelscity2.sendKeys(strSetagHotelscity2);
	    }
	public void WaitCity() {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='hidden'and@value='en']")));
	}
	public void SelectCity() {
		aghotelscitydrop.sendKeys(Keys.RETURN);	
	}
	
	
	 public void ClickSearch() {
			aghotelssearch.click();
			
		}
	

	public void clickagFlights() {
	    agflights.click();
	    }
	public void clickagTours() {
	    agtours.click();
	    }
	public void clickagVisa() {
	    agvisa.click();
	    }
	public void clickagBlogs() {
	    agblogs.click();
	    }
	public void clickagOffers() {
	    agoffers.click();
	    }
	
	public void clickagCurrency() {
	    agcurrency.click();
	    }
	public void clickagINR() {
	    aginr.click();
	    }
	
	
	public void AssertagINR() {
	 if(aginr.isSelected()) { 
	        System.out.println("USD isconverted to INR,Test17 Passed: " ); 
	 } 
	 else { 
	    System.out.println("Not converted"); 
	 } 
	}
	public void clickagAccounts() {
	    agaccounts.click();
	    }
	public void MousetoLogout() {
	

	//Creating object of an Actions class
	Actions action = new Actions(driver);

	//Performing the mouse hover action on the target element.
	action.moveToElement(aglogout).perform();
	}
	
	public void clickagLogout() {
	    aglogout.sendKeys(Keys.RETURN);
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
