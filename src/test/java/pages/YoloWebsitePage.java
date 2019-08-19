package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class YoloWebsitePage {

	final WebDriver driver;

	public YoloWebsitePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[@class='add-site-button']")
	public WebElement btnAddNewSite;

	@FindBy(how = How.XPATH, using = "//h2[text()='Select a Website Template']")
	public WebElement lblWebsiteTemplate;

	@FindBy(how = How.XPATH, using = "//ul/li")
	public WebElement templateList;

	@FindBy(how = How.ID, using = "businessname")
	public WebElement txtWebsiteName;

	@FindBy(how = How.ID, using = "business-category")
	public WebElement comboCategory;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public WebElement btnSubmit;

	@FindBy(how = How.XPATH, using = "//div[@class='loading-overlay-img']")
	public WebElement loadingIcon;

	@FindBy(how = How.XPATH, using = "//div[@class='loading sbui-loading']")
	public WebElement loadingSite;

	@FindBy(how = How.XPATH, using = "//button[@type='submit'][contains(text(),'Finish Setup')]")
	public WebElement btnFinishSetup;

	@FindBy(how = How.ID, using = "widgets-next")
	public WebElement btnWidgetNext;

	@FindBy(how = How.XPATH, using = "//div[@class='widgets-parent scroll-content']//div/a/span[text()='YouTube']")
	public WebElement widgetYouTube;

	@FindBy(how = How.XPATH, using = "//div[@class='yola_innermost_heading_wrap']//div[@id='yola_heading_block']")
	public WebElement widgetDropContainer;

	@FindBy(how = How.XPATH, using = "//div[@id='canvas']/iframe")
	public WebElement iframe;

	@FindBy(how = How.ID, using = "search-query-results")
	public WebElement txtSearch;

	@FindBy(how = How.XPATH, using = "//div[@id='yola_dialog_wrap']//div[contains(@class,'widget dialog')]//iframe")
	public WebElement youTubeIframe;

	@FindBy(how = How.ID, using = "search-button-results")
	public WebElement btnSearch;

	@FindBy(how = How.XPATH, using = "//div[@id='results-parent-wrap']//div[@id='results-parent']/div[1]")
	public WebElement firstRowResults;

	@FindBy(how = How.XPATH, using = "//input[@value='Save']")
	public WebElement btnSave;

	@FindBy(how = How.XPATH, using = "//div[@class='YouTube_Default']")
	public WebElement containerYoutube;
}
