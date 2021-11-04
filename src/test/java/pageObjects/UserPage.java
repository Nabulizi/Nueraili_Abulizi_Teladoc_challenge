package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage {
	public WebDriver driver;
	

	public UserPage(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public void SetFirstName(String firstname) {
		firstName.sendKeys(firstname);
	}
	
	@FindBy(xpath="//*[contains(text(),' Add User')]")
	@CacheLookup
	static
	WebElement linkAddUser;
	
	public static void clickAddUser() {	
		UserPage.linkAddUser.click();
	}
	
	//WebElement addUser=driver.findElement(By.xpath("//*[contains(text(),' Add User')] "));   //*[@type='add']   
    WebDriverWait wait=new WebDriverWait(driver,5);
    WebElement addUserModal=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Close')]")));
    @FindBy(name="FirstName")
    @CacheLookup
    WebElement firstName;
    //WebElement firstName=driver.findElement(By.name("FirstName"));
    
    WebElement LastName=driver.findElement(By.name("LastName"));
    WebElement UserName=driver.findElement(By.name("UserName"));
    WebElement PassWord=driver.findElement(By.name("Password"));
    WebElement companyA=driver.findElement(By.xpath("//*[@type='radio' and @value='15']"));
    WebElement companyB=driver.findElement(By.xpath("//*[@type='radio' and @value='16']"));
    WebElement selectRole = driver.findElement(By.name("RoleId"));
    WebElement email=driver.findElement(By.name("Email"));
    WebElement cellPhone=driver.findElement(By.name("Mobilephone"));
	
	
}
