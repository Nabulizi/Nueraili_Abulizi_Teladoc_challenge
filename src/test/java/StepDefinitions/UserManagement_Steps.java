package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.UserPage;

public class UserManagement_Steps {

		public WebDriver driver;		

	@Given("user is on User_Page {string}")
	public void user_is_on_user_page(String url) {
		System.setProperty("webdriver.chrome.driver", "//Users//nabulizi//IdeaProjects//chromedriver");
	    driver=new ChromeDriver();
	    driver.get(url);
	    driver.findElement(By.xpath("//*[contains(text(),' Add User')]")).click();;
	    //UserPage.clickAddUser();
	}

	@When("user enters <firstname>,<lastname>,<username>,<password>,<Email>,<cellphone>")
	public void user_enters_firstname_lastname_username_password_email_cellphone() {
		//driver=new ChromeDriver();
		//userPage=new UserPage(driver);
		//userPage.SetValue(driver.findElement(By.), "firstname");
	}

	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
		System.out.println("test1");
	}

	@Then("a user is added")
	public void a_user_is_added() {
		System.out.println("test1");
	}

	@Then("I add a user to web table")
	public void i_add_a_user_to_web_table() {
		System.out.println("test1");
	}

	@Then("delete a user from the web table")
	public void delete_a_user_from_the_web_table() {
		System.out.println("test1");
	}

}
