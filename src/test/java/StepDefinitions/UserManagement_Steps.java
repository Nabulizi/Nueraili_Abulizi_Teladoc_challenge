package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.UserPage;

public class UserManagement_Steps {

		public WebDriver driver;		

	@Given("user is on User_Page {string}")
	public void user_is_on_user_page(String url) {
		System.setProperty("webdriver.chrome.driver", "//Users//nabulizi//IdeaProjects//chromedriver");
	    driver=new ChromeDriver();
	    driver.get(url);
	}
	
	@When("user click add_user link")
	public void user_click_add_user_link() {
		UserPage.clickAddUser(driver);
	}

	@Then("user should see add_user modal")
	public void user_should_see_add_user_modal() {
	    WebDriverWait wait=new WebDriverWait(driver,5);
	    WebElement addUserModal=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Close')]")));
	    String actual=addUserModal.getText();
	    Assert.assertEquals("Close",actual );
	}

	@When("user enters \"(.*?)\" in firstname field$")
	public void user_enters_first_name_in_firstname_field(String firstName) {
		driver.findElement(By.name("FirstName")).sendKeys(firstName);
	}

	@And("user enters \"(.*?)\" in username field$")
	public void user_enters_user_name_in_username_field(String userName) {
		driver.findElement(By.name("UserName")).sendKeys(userName);
	}

	@And("user enters \"(.*?)\" in password field$")
	public void user_enters_pass_word_in_password_field(String passWord) {
		driver.findElement(By.name("Password")).sendKeys(passWord);
	}

	@And("user enters \"(.*?)\" in cellphone field$")
	public void user_enters_cell_phone_in_cellphone_field(String cellPhone) {
		driver.findElement(By.name("Mobilephone")).sendKeys(cellPhone);
	}
	
	@And("user selects \"(.*?)\" role$")
	public void user_selects_role(String userRole) {
		Select role= new Select(driver.findElement(By.name("RoleId")));
		role.selectByVisibleText(userRole);
	}
	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
		UserPage.clickSaveButton(driver);
	}

	@Then("user \"(.*?)\" is added$")
	public void a_user_is_added(String fn) {
		UserPage.verifyUser(driver,fn);
	}
	
	@When("user click delete mark for username {string} from webtable")
	public void user_click_delete_mark_for_username_from_webtable(String userName) {
		UserPage.clickDelete(driver, userName);
	}

	@Then("user should be able to see confirmation Dialog")
	public void user_should_be_able_to_see_confirmation_dialog() {
		UserPage.verifyConfirmationDialog(driver);
	}

	@When("user click ok button")
	public void user_click_ok_button() {
		UserPage.clickOkButton(driver);
	}

	@Then("user {string} should be deteted from webtable")
	public void user_should_be_deteted_from_webtable(String string) {

	}

}
