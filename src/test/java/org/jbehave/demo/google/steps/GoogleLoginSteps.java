package org.jbehave.demo.google.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.demo.google.BaseSeleniumActions;
import org.jbehave.demo.google.pages.GoogleHomePage;
import org.jbehave.demo.google.pages.GoogleServiceLogin;

import org.junit.Assert;

/**
 * @author Vadym_Goncharenko
 *
 */
public class GoogleLoginSteps extends BaseSeleniumActions {

	public GoogleLoginSteps() throws Exception {
		super();
	}

	private GoogleHomePage homePage;
	private GoogleServiceLogin loginPage;

	@Given(" home google web page $url")
	public void givenGoogleBasePase(String url) {
		open(url);
		homePage = new GoogleHomePage(getSelenium());
	}
	
	@Given(" google authentication form")
	public void givenGoogleAuthenticationForm() {
		loginPage = homePage.clickLoginButton();
	}

	@When(" the user has entered wrong username\\password")
	public void whenEnteredWrongAccount() {
		loginPage.enterUserName("wrong@gmail.com");
		loginPage.enterPassord("wrong");
	}

	@When(" log-in button has been pressed")
	public void whenPressedLoginButton() {
		loginPage.pressEnterButton();
	}

	@Then(" the user should see corresponding error message")
	public void thenExpectingErrorMessage() {
		Assert.assertTrue(loginPage.isLoginErrorMessage());
	}
}
