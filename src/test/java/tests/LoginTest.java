package tests;

import org.testng.annotations.Test;
import Utilities.Xls_Reader;
import data.DataFile;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class LoginTest {

	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();

	@BeforeMethod
	public void beforeMethod() {

		lp.openScotiaBankLoginPage();
	}

	@AfterMethod
	public void afterMethod() {

	}

	@Test
	public void verifyWrongEmailPassowordTest() throws InterruptedException {

		lp.login(df.wrongEmail, df.wrongPassword);
		Assert.assertEquals(df.gobalErr, lp.readGobalError());

	}

	@Test
	public void verifySpecialCharactersEmailPassowordTest() throws InterruptedException {
		lp.login(df.emailWithSpecialChar, df.wrongPassword);
		Assert.assertEquals(df.emailWithSpecialCharErr, lp.readEmailError());
	}

	@Test
	public void verifyEmptyEmailPassowordTest() throws InterruptedException {
		lp.login("", df.wrongPassword);
		Assert.assertEquals(df.emptyEmailErr, lp.readEmailError());
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		lp.openBrowser();
	}

	@AfterClass
	public void afterClass() {
		lp.closeBrowser();
	}
}
