package com.tcs.pages;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CFDashboard {
	WebDriver driver;
	 
	 //objects
	//@FindBy(css="a[class=' waves-effect']")
	//private WebElement mybookings;
	@FindBy(xpath="//i[@class='la la-shopping-cart mr-2 text-color-3']")
	private WebElement mybookings;
	

@FindBy(xpath="//i[@class='la la-eye']")
private WebElement viewvoucher;
@FindBy(xpath="//i[@class='la la-wallet mr-2 text-color-9']")
private WebElement addfunds;

@FindBy(xpath="//input[@type='radio'and@id='gateway_paypal']")
private WebElement paypalradio;


@FindBy(xpath="//button[contains(.,'Pay Now')]")
private WebElement paynow;
@FindBy(xpath="//div[contains(.,'Back to Invoice')]")
private WebElement backtoinvoice;

@FindBy(xpath="//div[@class=\"paypal-button-label-container\"]")
private WebElement paypalclk;

//MY PROFILE ELEMENTS
@FindBy(xpath="//i[@class='la la-user mr-2 text-color-2']")
private WebElement myprofile;

@FindBy(name="firstname")
private WebElement firstname;
@FindBy(xpath="//input[@name='lastname']")
private WebElement lastname;
@FindBy(name="phone")
private WebElement phone;
@FindBy(xpath="//span[@id='select2-from_country-container']")
private WebElement country;
@FindBy(xpath="//input[@name='state']")
private WebElement state;
@FindBy(xpath="//input[@name='city']")
private WebElement city;
@FindBy(xpath="//input[@name='fax']")
private WebElement fax;
@FindBy(name="zip")
private WebElement postalcode;
@FindBy(name="address1")
private WebElement address1;
@FindBy(name="address2")
private WebElement address2;
@FindBy(xpath="//button[@type='submit']")
private WebElement updateprofile;
//logout
@FindBy(xpath="//i[@class='la la-power-off mr-2 text-color-6']//parent::a")
private WebElement logout;



public CFDashboard(WebDriver driver){
    this.driver = driver;
    //This initElements method will create all WebElements
    PageFactory.initElements(driver, this);
}

public void clickMyBookings() {
    mybookings.click();
    }

public void waitVoucher2() {
WebDriverWait wait = new WebDriverWait(new ChromeDriver(), 5);
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='la la-eye']")));
}

public void viewVoucher1() {
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewvoucher);
}
public void waitVoucher() {
WebDriverWait wait3 = new WebDriverWait(driver, 10);
wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='la la-eye']")));
}

public void GotCookies() throws InterruptedException {
	
    String alertMsg = driver.switchTo().alert().getText();
    System.out.println(alertMsg);
    Thread.sleep(2000);
    driver.switchTo().alert().accept();
   }

public void clickVoucher() {
	viewvoucher.click();
}

public void clickAddFunds() {
	addfunds.click();
}

public void findPayPal1() {
	Actions actions = new Actions(driver);
	actions.moveToElement(paypalradio);
	actions.perform();
}

public void findPayPal2() {
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paypalradio);
}

public void findPayPal3() {
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", paypalradio);
}
public void clickPayPal() {
	paypalradio.sendKeys(Keys.RETURN);
}
public void checkPayPal() {
boolean eleSelected = driver.findElement(By.xpath("//input[@type='radio'and@id='gateway_paypal']")).isSelected();
System.out.println(eleSelected );
}
public void viewpaynow() {
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", paynow);
}
public void clickPayNow() {
	paynow.sendKeys(Keys.RETURN);
}

public void clickBacktoInvoice() {
	paynow.sendKeys(Keys.RETURN);
}

public void clickYes() {
driver.switchTo().alert().accept();
}

public void clickPayPalclk() {
	paypalclk.sendKeys(Keys.RETURN);
}


//my profile actions
public void clickMyProfile() {
	myprofile.click();
}


public void clearFirstName() {
	 firstname.clear();
}
public void setFirstName(String strFirstName){
	firstname.sendKeys(strFirstName);     
}


public void clearLastName() {
	 lastname.clear();
}
public void setLastName(String strLastName){
	lastname.sendKeys(strLastName);     
}

public void clearPhone() {
	 phone.clear();
}
public void setPhone(String strPhone){
	phone.sendKeys(strPhone);     
}

//logout action


/* public String addCatElect(){
	    	
	        Select category_item= new Select(category);
	    	category_item.selectByVisibleText("ELECTRONICS");
	        return category_item.getFirstSelectedOption().getText();
	       }
	        
   }*/
    
public void clearState() {
	 state.clear();
}
public void setState(String strState){
	state.sendKeys(strState);     
}

public void clearCity() {
	 city.clear();
}
public void setCity(String strCity){
	city.sendKeys(strCity);     
}


public void clearFax() {
	 state.clear();
}
public void setFax(String strFax){
	fax.sendKeys(strFax);     
}

public void clearPost() {
	 postalcode.clear();
}
public void setPost(String strPost){
	postalcode.sendKeys(strPost);     
}

public void clearAdrs1() {
	 address1.clear();
}
public void setAdrs1(String strAdrs1){
	address1.sendKeys(strAdrs1);     
}

public void clearAdrs2() {
	 address2.clear();
}
public void setAdrs2(String strAdrs2){
	address2.sendKeys(strAdrs2);     
}

public void clickUpdate() {
	updateprofile.sendKeys(Keys.RETURN);
}


public void findLogout() {
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", logout);
}
public void clickLogout() {
	logout.sendKeys(Keys.RETURN);
}

}










