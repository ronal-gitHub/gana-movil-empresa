package base;

import common.utilities.BaseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pageObjects.GanaMovilEmpresaPage;
import pageObjects.LoginPage;

import java.time.Duration;

/**
 * Class contains logic that is executed before and after every test class
 */
public class BaseTests {
    private WebDriver driver;

    protected BaseActions baseActions;
   // protected WindowManager windowManager;
    protected LoginPage loginPage;
    protected GanaMovilEmpresaPage ganaMovilEmpresaPage;
  
        
    /**
     * Initialize browser
     * Initialize Implicit Wait
     *
     * @param hostUrl found in testng.xml
     */
    @BeforeClass
    @Parameters({"hostUrl", "browser", "timeout"})
    public void setUp( @Optional("https://www.bg.com.bo")  String hostUrl, @Optional("chrome")  String browser, @Optional("20") int timeout) {
        if (browser.equals("chrome")) {
        	 ChromeOptions chromeOptions = new ChromeOptions();
        	 chromeOptions.addArguments("--remote-allow-origins=*");
           System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
         //   System.setProperty("webdriver.chrome.driver", "D:\\work\\inst-2023\\driversRbc\\chromedriver_win32\\chromedriver.exe");
        	
            driver = new ChromeDriver(chromeOptions);
        } // More browsers can be added
      
        driver.get(hostUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));

        baseActions = new BaseActions(driver);
        ganaMovilEmpresaPage = new GanaMovilEmpresaPage(driver);
      //  loginPage = new LoginPage(driver);
        
            
    }

    /**
     * Close browser
     */
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
