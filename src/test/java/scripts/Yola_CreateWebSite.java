package scripts;

import functions.PropertyFileData;
import functions.YolaWebsiteManager;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Yola_CreateWebSite {
	
    private WebDriver driver;
    
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();  	
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--start-maximized");
      options.addArguments("--ignore-certificate-errors");
      options.addArguments("--disable-popup-blocking");
	  driver = new ChromeDriver(options);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  @Test
  public void myTest() throws InterruptedException{
	  
	  YolaWebsiteManager createWebsite = new YolaWebsiteManager(driver);
	  PropertyFileData yolaData = new PropertyFileData("Yola-Wedsite","websiteData.properties");
	  
	  /*Login to the application*/
	  createWebsite.Login(yolaData.getProperty("email"),yolaData.getProperty("password"));

	  /*add website template and create*/
	  createWebsite.AddTemplate(yolaData.getProperty("template"), yolaData.getProperty("websiteName"), yolaData.getProperty("category"));

	  /*Drag and drop youtube widget and save*/
	  createWebsite.createWebsite(yolaData.getProperty("searchVlaue"));
	  
      System.out.println("=======Test Case Executed ============");
  }

}
