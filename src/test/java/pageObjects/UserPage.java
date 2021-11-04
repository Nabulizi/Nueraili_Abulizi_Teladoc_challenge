package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class UserPage {
	public WebDriver driver;
	

	public UserPage(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		
	@FindBy(xpath="//*[contains(text(),'Confirmation Dialog')]")
	@CacheLookup
	static
	WebElement linkAddUser;
	
	public static void clickAddUser(WebDriver driver) {	
		driver.findElement(By.xpath("//*[contains(text(),' Add User')]")).click();;
	}
	
	public static void clickSaveButton(WebDriver driver) {	
		driver.findElement(By.xpath("//*[contains(text(),'Save')]")).click();;
	}
	
  
    public static void verifyUser(WebDriver driver,String firstName) {
        String beforeXpath="/html/body/table/tbody/tr[";
        String afterXpath="]/td[1]";
        Boolean status=false;
        Boolean expected=true;
        
        //  /html/body/table/tbody/tr[1]/td[1]
        // /html/body/table/tbody/tr[2]/td[1]
        // /html/body/table/tbody/tr[3]/td[1]
        // /html/body/table/tbody/tr[8]/td[1]

    	for (int i=1;i<=7;i++){ 
    		String actualxpath=beforeXpath+i+afterXpath ; 
    		WebElement fn=driver.findElement(By.xpath(actualxpath));
    		
    		if((fn.getText()).equalsIgnoreCase(firstName)==true) {
    			System.out.println(fn.getText());
    			status=true;
    			System.out.println(firstName+" is added successfully");
    		}
		}
    		
    	Assert.assertEquals(expected, status);
    	 
    }
    
    public static void clickDelete(WebDriver driver, String userName) {
        String beforeXpath="/html/body/table/tbody/tr[";
        String afterXpath="]/td[3]";
        String deleteXpath="]/td[11]/button/i";
        int deleteRowCount=1;
        for (int i=1;i<=7;i++){ 
    		String actualxpath=beforeXpath+i+afterXpath ; 
    		WebElement fn=driver.findElement(By.xpath(actualxpath));
    		
    		if((fn.getText()).equalsIgnoreCase(userName)==true) {
    			deleteRowCount=i;
    			System.out.println(fn.getText());
    			System.out.println(userName+" is found on Row"+deleteRowCount);
    		}
    		String deleteRowXpath=beforeXpath+deleteRowCount+deleteXpath;
    		WebElement dr=driver.findElement(By.xpath(deleteRowXpath));
    		dr.click();
    		
		}
    }
    
    public static void verifyConfirmationDialog(WebDriver driver) {
    	String actual="Confirmation Dialog";
    	WebElement confirmDialod=driver.findElement(By.xpath("//*[contains(text(),'Confirmation Dialog')]"));
    	Assert.assertEquals(confirmDialod.getText(), actual);    	
    }
    
    public static void clickOkButton(WebDriver driver) {
    	WebElement oK=driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
    	oK.click();
    }
    
    
  
    

	

}
