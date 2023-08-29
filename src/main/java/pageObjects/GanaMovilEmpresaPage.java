package pageObjects;

import common.enums.InfoContactTexts;
import common.utilities.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class GanaMovilEmpresaPage extends BaseActions {
	private WebDriver driver;

	

	  private Boolean errorMessage = Boolean.TRUE; // "Error en el componente";
	  
	  private final By confirmMessage = By.cssSelector("label#loading-label");
	    protected GanaMovilEmpresaPage ganaMovilEmpresaPage;

	
	public GanaMovilEmpresaPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//this.setContato();
	}
	



	public void goContentMenus(String menus) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		errorMessage = Boolean.TRUE;
		try {
			String[] arr = menus.split("[|]", -2);
			
		  if (arr[0].equals("Negocios")) {
			findAndClickElem(xpathContact(InfoContactTexts.menuNegocios)); // "//span[contains(.,\'Negocios\')]"			
		  }
		  
		  if (arr[1].equals("Menu hamburguesa")) {
			driver.findElement(By.cssSelector(".hidden > svg > path")).click();// menu hamburguesa
			//findAndClickElem(xpathContact(InfoContactTexts.menuAmburguesa)); 
			js.executeScript("window.scrollTo(0,432)");
		  }
		  
		  if (arr[2].equals("GanaMóvil Empresas")) {
			  findAndClickElem(xpathContact(InfoContactTexts.menuGanaMovilEmpresas)); 
			  
			  js.executeScript("window.scrollTo(0,432)");
			// 7 | click | linkText=Tutoriales | 
			driver.findElement(By.linkText("Tutoriales")).click();
			// 8 | runScript | window.scrollTo(0,1912.800048828125) | 
			js.executeScript("window.scrollTo(0,1912.800048828125)");

			// 3 | click | css=.flex > .text-justify:nth-child(2) | 
			driver.findElement(By.cssSelector(".flex > .text-justify:nth-child(2)")).click();
		  }
		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {
			errorMessage = Boolean.FALSE;
		}

	}

	/**
	 * find info contacto
	 * 
	 * @param locator , text (expresion de busqueda)
	 */

	public String findContacto(String text) {

		int inicio = text.lastIndexOf(",'")+ (int)2;
		int fin = text.indexOf(":");
		System.out.println("contacto: " + text.substring(inicio, fin));

		return text.substring(inicio, fin);

	}
	
	/**
	 * find info contacto valor
	 * 
	 * @param locator , text (expresion de busqueda)
	 */

	public String findContactoValor(String text) {

		int inicio = text.indexOf(":");
		int fin = text.length() - (int)2;
		System.out.println("valor: " + text.substring(inicio, fin));

		return text.substring(inicio, fin);

	}
	
	

	/**
	 * information in contact section page
	 */
	public String xpathContact(InfoContactTexts option) {
		//  ganaMovilEmpresaPage = new GanaMovilEmpresaPageTest(driver);
		switch (option) {
		case menuNegocios:
			return "//span[contains(.,\'Negocios\')]".toString(); //   "//span[contains(.,\'Negocios\')]";
		
		case menuAmburguesa:
			return ".hidden > svg > path".toString(); // 
			
		case menuGanaMovilEmpresas:
			return "//h6[contains(.,\'GanaMóvil Empresas\')]".toString();
			
		default: "".toString();
		}
		return "".toString();
	}



	/**
	 * Returns the message error if element dont exist	 * 
	 * @return
	 */
	public Boolean getMessageInvalid() {
		return errorMessage;
	}

}
