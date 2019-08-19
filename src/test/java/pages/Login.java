package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class Login {

	final WebDriver driver;

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "um-login-email")
	public WebElement txtEmail;

	@FindBy(how = How.ID, using = "um-login-password")
	public WebElement txtPassword;

	@FindBy(how = How.XPATH, using = "//a[text()='Login']")
	public WebElement btnLogin;

	@FindBy(how = How.XPATH, using = "//button[text()='Sign in']")
	public WebElement btnSignIn;

	@FindBy(how = How.XPATH, using = "//a[@class='yola-logo']")
	public WebElement logoYola;

}
