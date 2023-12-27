package tests;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {

	WebDriver driver;

	@Test(dataProvider = "getLoginData")
	public void login(String email, String password, String expectedResult) throws IOException, InterruptedException {

		LandingPage landingpage = new LandingPage(driver);
		LoginPage loginpage = new LoginPage(driver);
		AccountPage accountpage = new AccountPage(driver);

		landingpage.myAccountDropDown().click();
		landingpage.loginoption().click();
		loginpage.emailfield().sendKeys(email);
		
		
		loginpage.passwordfield().sendKeys(password);
		loginpage.loginbutton().click();
		String actualResult = null;
		try {

			if (accountpage.edityouraccountinfo().isDisplayed()) {
				actualResult = "Successful";
			}

		} catch (Exception e) {

			System.out.println("Inside catch block");
			actualResult = "Failure";

		}
		Thread.sleep(3000);
		System.out.println("actualresult is :" + actualResult);

		Assert.assertEquals(actualResult, expectedResult);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@BeforeMethod
	public void lauchbrowser() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

	}

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = { { "ranjanapushpa1@gmail.com", "Aradhana18#", "Successful" },
				{ "dummy", "dummy", "Failure" } };
		return data;
	}

}
