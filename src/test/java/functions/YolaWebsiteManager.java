package functions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pages.Login;
import pages.YolaHomePage;
import pages.YoloWebsitePage;


public class YolaWebsiteManager {

	private static WebDriver driver;

	private static WaitHandler wait;
	
    public YolaWebsiteManager(WebDriver driver) {
    	YolaWebsiteManager.driver = driver;
		wait = new WaitHandler(driver);
	}

	public void Login(String username,String password) {
		driver.get("http://www.yola.com");
		Login loginPage = PageFactory.initElements(driver, Login.class);
		
		loginPage.btnLogin.click();
		wait.waitToBeDisplayed(loginPage.txtEmail, 30);

		/** Type Username and password */
		loginPage.txtEmail.sendKeys(username);
		System.out.println("===== Username Typed =====");
		loginPage.txtPassword.sendKeys(password);
		System.out.println("===== Password Typed =====");

		loginPage.btnSignIn.click();
		wait.waitToBeDisplayed(loginPage.logoYola, 30);

	}

	public void AddTemplate(String template,String websiteName,String comboCategory) throws InterruptedException {		  
		  
		  YolaHomePage yolaHomePage = PageFactory.initElements(driver,YolaHomePage.class);
		  yolaHomePage.btnAddNewSite.click();
	      wait.waitToBeDisplayed(yolaHomePage.lblWebsiteTemplate, 30);
	      

	      YoloWebsitePage yoloWebsitePage = PageFactory.initElements(driver,YoloWebsitePage.class);
	      Actions mouse = new Actions(driver);
	      Thread.sleep(2000);
	      mouse.moveToElement(yoloWebsitePage.templateList.findElement(By.xpath("//ul/li//h3[text()='"+ template + "']"))).perform();
	      Thread.sleep(4000);
	      yoloWebsitePage.templateList.findElement(By.xpath("//ul/li//h3[text()='"+ template + "']/preceding-sibling::div//a[contains(text(),'Use This Template')]")).click();;

	      wait.waitToBeDisplayed(yoloWebsitePage.txtWebsiteName, 30);
	      wait.waitToBeHidden(yoloWebsitePage.loadingIcon, 30);
	      yoloWebsitePage.txtWebsiteName.sendKeys(websiteName);
	      Select category = new Select(yoloWebsitePage.comboCategory);
	      category.selectByValue(comboCategory);
	      wait.waitToBeHidden(yoloWebsitePage.loadingIcon, 30);
	      yoloWebsitePage.btnSubmit.click();
	      Thread.sleep(2000);
	      wait.waitToBeClickable(yoloWebsitePage.btnFinishSetup, 30);
	      yoloWebsitePage.btnFinishSetup.click();
	      wait.waitToBeDisplayed(yoloWebsitePage.btnWidgetNext, 30);
	      wait.waitToBeHidden(yoloWebsitePage.loadingSite, 30);
		
	}

	public void createWebsite(String searchVlaue) throws InterruptedException {
		  
	      YoloWebsitePage yoloWebsitePage = PageFactory.initElements(driver,YoloWebsitePage.class);
	      Thread.sleep(2000);
	      WebElement dragElement = driver.findElement(By.xpath("//div[@class='widgets-parent scroll-content']//div/a/span[text()='YouTube']"));
	      driver.switchTo().frame(yoloWebsitePage.iframe);
	      int xto=yoloWebsitePage.widgetDropContainer.getLocation().x;
	      int yto=yoloWebsitePage.widgetDropContainer.getLocation().y;
	      driver.switchTo().parentFrame();
	      Actions mouse = new Actions(driver);
	      mouse.clickAndHold(dragElement).moveByOffset(xto, yto).release().build().perform();
	      Thread.sleep(2000);
	      
	      driver.switchTo().frame(yoloWebsitePage.youTubeIframe);
	      yoloWebsitePage.txtSearch.sendKeys(searchVlaue);
	      yoloWebsitePage.btnSearch.click();
	      Thread.sleep(2000);
	      yoloWebsitePage.firstRowResults.click();
	      driver.switchTo().parentFrame();
	      wait.waitToBeDisplayed(yoloWebsitePage.btnSave, 30);
	      yoloWebsitePage.btnSave.click();
	      Thread.sleep(2000);

	      driver.switchTo().frame(yoloWebsitePage.iframe);
	      assertEquals(yoloWebsitePage.containerYoutube.isDisplayed(), true,"You tube widget was not added successfully");
		
	}

}
