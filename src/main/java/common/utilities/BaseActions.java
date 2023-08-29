package common.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

import javax.xml.xpath.XPath;

/**
 * Class contains
 * -Global Locators
 * -Global Methods
 * -Basic Methods
 */
public class BaseActions {
    private WebDriver driver;

    public BaseActions(WebDriver driver) {

        this.driver = driver;
    }


	// Timeout value for explicit waits in seconds
    private final int waitForElementTimeout = 20;

    private Boolean errorMessage = Boolean.TRUE; //"Error en el componente";


  
    /**
     * Wait for Element
     *
     * @param locator
     */

    public void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitForElementTimeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait for Element to be clickable
     *
     * @param locator
     */

    public void waitForElementIsClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitForElementTimeout));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Get text
     *
     * @param locator
     */
    public String getText(By locator) {
        return driver.findElement(locator).getText().trim();
    }

    /**
     * Click element
     *
     * @param locator
     */
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    /**
     * Clears field
     * Writes field
     * @param locator
     */
    public void sendKeys(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    /**
     * Scroll at the bottom of the page with Javascript
     */
    protected void scrollBottomPageJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }


    /////////// Global Actions ////////
    /**     
     * find info contacto
     * @param locator , text (expresion de busqueda)
     */
    public void findAndClickElem( String text) {        
        driver.findElement(xpath( text )).click();
    }
    
    public void findTextElem( String text) {
    	this.errorMessage = Boolean.TRUE;
     try {
    	driver.findElement(xpath( text ));
        
        
	} catch (Exception ex) {
		
		 ex.printStackTrace();  
	} finally {
		this.errorMessage = Boolean.FALSE;    	
	}
        
    }
    
    
    /**
     * find by xpath
     *
     * @param locator
     */
    public  By xpath( String locator ) {
       return  By.xpath(locator);
    }

    /**
     * find by linkText
     *
     * @param locator
     */
    public void linkText(String locator ) {
        By.linkText(locator);
    }
    
    /**
     * find by cssSelector
     *
     * @param locator
     */
    public void cssSelector(String locator ) {
        By.cssSelector(locator);
    }
    
    
    
    


}
