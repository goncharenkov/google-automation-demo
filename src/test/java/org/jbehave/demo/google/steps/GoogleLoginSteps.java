package org.jbehave.demo.google.steps;

import java.util.Map;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
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
	private Map<String, String> message;

	@Given("home google page $url")
	public void givenGoogleBasePase(String url) {
		open(url);
		homePage = new GoogleHomePage(getSelenium());
	}
	
	@Given("gmail authentication form")
	public void givenGoogleAuthenticationForm() {
		loginPage = homePage.clickLoginButton();
	}

	@When("the user has entered wrong username\\password")
	public void whenEnteredWrongAccount() {
		loginPage.enterUserName("wrong@gmail.com");
		loginPage.enterPassord("wrong");
	}

	@When("log-in button has been pressed")
	public void whenPressedLoginButton() {
		loginPage.pressEnterButton();
	}

	@Then("the user should see corresponding error message: $examplesTable")
	public void thenExpectingErrorMessage(ExamplesTable examplesTable) {
		message = examplesTable.getRow(0);
		Assert.assertTrue(loginPage.isLoginErrorMessage(message.get("message")));
	}
}
