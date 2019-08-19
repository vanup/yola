package functions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHandler {

	private static WebDriver driver;
	
    public WaitHandler(WebDriver driver) {
		WaitHandler.driver = driver;
	}
    /**
     * Wait for an element to  be Displayed
     * @param element WebElement
     * @param timeoutInSeconds Timeout in milliseconds
     */
    public void waitToBeDisplayed(WebElement element, int timeoutInSeconds){
    	driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.MILLISECONDS);
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (TimeoutException timeoutex){
            String errorMessage = "After " + timeoutInSeconds + "ms, failed to display element ";
            System.out.println(errorMessage);
        	throw timeoutex;
        }
        catch (Exception ex){
        	System.out.println("Error in waitToBeDisplayed: " + ex.getMessage());
        }finally {
			/* Setting the implicit wait back to default */
        	driver.manage().timeouts().implicitlyWait(30 ,TimeUnit.SECONDS);
		}
    }

    /**
     * Wait for an element to be Clickable
     * @param element WebElement
     * @param timeOutInSeconds Timeout in milliseconds
     */
    public void waitToBeClickable(WebElement element, int timeOutInSeconds){
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.pollingEvery(5 ,TimeUnit.SECONDS);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (TimeoutException timeoutex){
            String errorMessage = "After " + timeOutInSeconds + "ms, element failed to be clickable";
            System.out.println(errorMessage);
        	throw timeoutex;
        }
        catch (Exception ex){
        	System.out.println("Error in waitToBeClickable: " + ex.getMessage());
        }
    }

    /**
     * Wait for an element to be Clickable
     * @param element WebElement
     * @param timeOutInSeconds Timeout in milliseconds
     */
    public void waitToBeHidden(WebElement element, int timeOutInSeconds){
    	List<WebElement> elements = new ArrayList<WebElement>();
    	elements.add(element);
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.pollingEvery(5 ,TimeUnit.SECONDS);
            wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
        }
        catch (TimeoutException timeoutex){
            String errorMessage = "After " + timeOutInSeconds + "ms, element failed to be clickable";
            System.out.println(errorMessage);
        	throw timeoutex;
        }
        catch (Exception ex){
        	System.out.println("Error in waitToBeClickable: " + ex.getMessage());
        }
    }

}
