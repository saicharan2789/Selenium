package StepDefinition;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Runner.RunnerClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

//Used basic functions are better understanding and wait at few places to show test cases are working

public class StepDefinition {

	WebDriver driver;

	@Given("the user in the main page")
	public void the_user_in_the_main_page() throws Throwable{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
	}

	@When("user clicks the form authentication link")
	public void user_clicks_the_form_authentication_link() throws Throwable {
		WebElement formAuth =  driver.findElement(By.linkText("Form Authentication"));
		formAuth.click();	   
	}

	@Then("user types correct username {string} and wrong password {string}")
	public void user_types_correct_username_and_wrong_password(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@Then("clicks login button")
	public void clicks_login_button() throws Throwable {
		driver.findElement(By.xpath("//i")).click();
	}

	@Then("asserts the login validation")
	public void asserts_the_login_validation() {
		//		boolean actualResult = driver.getPageSource().contains("logout");
		//		System.out.println("the actual result is " +actualResult);
		org.junit.Assert.assertTrue("true", driver.getPageSource().contains("logout"));
	}

	@Then("checks authentication")
	public void checks_authentication() throws Throwable {
		WebElement failure = driver.findElement(By.xpath("//*[@id=\'flash\']"));
	}

	@Then("user types incorrect username as {string} and correct password as {string}")
	public void user_types_incorrect_username_as_and_correct_password_as(String username1, String password1) {
		driver.findElement(By.id("username")).sendKeys(username1);
		driver.findElement(By.id("password")).sendKeys(password1);
	}


	@Then("user types correct username as {string} and correct password as {string}")
	public void user_types_correct_username_as_and_correct_password_as(String username2, String password2) {
		driver.findElement(By.id("username")).sendKeys(username2);
		driver.findElement(By.id("password")).sendKeys(password2);
	}

	@Then("after successfull login user logs out")
	public void after_succesfull_login_user_logs_out() {
		driver.findElement(By.xpath("//i[@class = 'icon-2x icon-signout']")).click();
	}

	@When("User clicks Infinite Scroll link on the menu")
	public void user_clicks_Infinite_Scroll_link_on_the_menu() {
		WebElement InfiniteScroll = driver.findElement(By.linkText("Infinite Scroll"));
		InfiniteScroll.click();
		Med_Wait();
	}

	@Then("Scroll down twice and Scroll up back to the top of the page")
	public void scroll_down_twice_and_Scroll_up_back_to_the_top_of_the_page() {
		try {
			scrollPageDown(driver);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Med_Wait();
	}

	@Then("Asserts Infinite Scroll text")
	public void asserts_Infinite_Scroll_text() {
		WebElement test = driver.findElement(By.xpath("//h3[text()='Infinite Scroll']"));
		String Result = test.getText();
		org.junit.Assert.assertEquals("Infinite Scroll",Result);
	}

	public static void scrollPageDown(WebDriver driver) throws Throwable {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		for(int i =0; i<2 ;i++) {
			js.executeScript("window.scrollTo(0,1000)");
			Med_Wait();
		}
		js.executeScript("window.scrollTo(0,-1000)");
	}

	@When("User clicks Key Presses link on the menu")
	public void user_clicks_Key_Presses_link_on_the_menu() {
		WebElement KeyPress = driver.findElement(By.linkText("Key Presses"));
		KeyPress.click();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.urlContains("key_presses"));
	}

	@When("keypress keys & assert them")
	public void keypress_keys_assert_them() throws Throwable {
		boolean res = driver.getPageSource().contains("interact");
		System.out.println("the result is " +res);
		Med_Wait();
		if (res == true) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			WebElement Result = driver.findElement(By.id("result"));
			String Result2 = resultSet(Result);
			org.junit.Assert.assertEquals("ENTER", Result2);
			Med_Wait();
			robot.keyPress(KeyEvent.VK_SPACE);
			robot.keyRelease(KeyEvent.VK_SPACE);
			Result2 = resultSet(Result);
			org.junit.Assert.assertEquals("SPACE", Result2);
			Med_Wait();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Result2 = resultSet(Result);
			org.junit.Assert.assertEquals("ESCAPE", Result2);
			Med_Wait();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyRelease(KeyEvent.VK_ALT);
			Result2 = resultSet(Result);
			org.junit.Assert.assertEquals("ALT", Result2);
		}
	}

	public static String resultSet(WebElement Result) {
		String Result1 = Result.getText();
		System.out.println("the result is" +Result1);
		String Result2 = Result1.substring(13);
		return Result2;
	}

	//created this method to show how the test cases are working  
	public static void Med_Wait() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
