package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class YolaHomePage {

	final WebDriver driver;

	public YolaHomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[@class='add-site-button']")
	public WebElement btnAddNewSite;

	@FindBy(how = How.XPATH, using = "//h2[text()='Select a Website Template']")
	public WebElement lblWebsiteTemplate;
}
