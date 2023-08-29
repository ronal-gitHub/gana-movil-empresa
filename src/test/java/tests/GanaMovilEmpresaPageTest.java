package tests;

import base.BaseTests;
import pageObjects.GanaMovilEmpresaPage;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Scope of the test:
 * - Verify not successful log in when username is invalid
 * - Verify not successful log in when password is invalid
 * - Verify not successful log in when password and username are invalid
 */

public class GanaMovilEmpresaPageTest extends BaseTests {
	  private  String textTelefono;
	  private  String textWhatsApp;
	  private  String textEmail ;
	  private  String textHorarios;
	  private Boolean errorMessage = Boolean.TRUE; // "Error en el componente";
	  private  String menuNegocios ;
	  private  String menuAmburguesa ;
	  private  String menuGanaMovilEmpresas ; 	
	 
	public void setContato() {
		this.errorMessage = Boolean.TRUE;
		try {
			
			 this.textTelefono="//*[contains(.,\'Teléfono: 800-10-3999\')]";
			 this.textWhatsApp = "//*[contains(.,\'WhatsApp: (+591)-721-03001\')]";
			 this.textEmail = "//*[contains(.,\'Email: bancoganadero@bg.com.bo\')]";
			 this.textHorarios = "//*[contains(.,\'Horarios: 07:00 a 22:00 Hrs. (Lunes a Domingo)\')]";
			 
			// this.menuNegocios = "//span[contains(.,\'Negocios\')]";
			// this.menuAmburguesa = ".hidden > svg > path";
			// this.menuGanaMovilEmpresas = "//h6[contains(.,\'GanaMóvil Empresas\')]";
		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {
			this.errorMessage = Boolean.FALSE;
		}
	}
	
    @Test(alwaysRun = true, description = "User busca los datos de contacto.")
    public void testStep_1(@Optional("https://www.bg.com.bo") String hostUrl) {
    	
    	this.setContato();
    	 Assert.assertEquals(hostUrl, "https://www.bg.com.bo");
    }

    @Parameters({"menus"})
    @Test(alwaysRun = true, description = "Cuando Ingreso al menú (Negocios|Menu hamburguesa|GanaMóvil Empresas)", dependsOnMethods = "testStep_1")
    public void testStep_2(@Optional("Negocios|Menu hamburguesa|GanaMóvilEmpresas") String menus) {
    	ganaMovilEmpresaPage.goContentMenus(menus );
        Assert.assertEquals(ganaMovilEmpresaPage.getMessageInvalid(), Boolean.FALSE);
    }

  
    @Test(alwaysRun = true, description = "Y busco los datos de contacto", dependsOnMethods = "testStep_2")
    public void testStep_3() {   
    	String contacto;
    	contacto =ganaMovilEmpresaPage.findContacto(this.textTelefono);
        Assert.assertEquals(contacto, "Teléfono");
        
        contacto= ganaMovilEmpresaPage.findContacto( this.textWhatsApp);
        Assert.assertEquals(contacto, "WhatsApp");
        
        contacto =ganaMovilEmpresaPage.findContacto( this.textEmail);
        Assert.assertEquals(contacto, "Email");
        
        contacto= ganaMovilEmpresaPage.findContacto( this.textHorarios);
        Assert.assertEquals(contacto, "Horarios");
        
    }

    
    @Test(alwaysRun = true, description = "Entonces obtengo un listado\n"
    		+ "con el\n"
    		+ "Teléfono: 800-10-3999\n"
    		+ "WhatsApp: (+591)-721-03001\n"
    		+ "Email: bancoganadero@bg.com.bo\n"
    		+ "Horarios: 07:00 a 22:00 Hrs. (Lunes a Domingo)", dependsOnMethods = "testStep_3")
    public void testStep_4() {
    	String valor;
    	valor=ganaMovilEmpresaPage.findContactoValor( this.textTelefono);
        Assert.assertEquals(valor, ": 800-10-3999'");
        System.out.println("'Telefono: " + valor);

        valor=ganaMovilEmpresaPage.findContactoValor( this.textWhatsApp);
        Assert.assertEquals(valor, ": (+591)-721-03001'");
        System.out.println("WhatsApp: " + valor);
        
        valor=ganaMovilEmpresaPage.findContactoValor( this.textEmail);
        Assert.assertEquals(valor, ": bancoganadero@bg.com.bo'");
        System.out.println("Email: " + valor);
        
        valor=ganaMovilEmpresaPage.findContactoValor( this.textHorarios);
        Assert.assertEquals(valor, ": 07:00 a 22:00 Hrs. (Lunes a Domingo)'");
        System.out.println("Horario: " + valor);
        
    }

	public String getMenuNegocios() {
		return this.menuNegocios; // menuAmburguesa
	}

	public String getMenuAmburguesa() {
		return this.menuAmburguesa; // menuAmburguesa
	}
	
	public String getMenuGanaMovilEmpresas() {
		return this.menuGanaMovilEmpresas; // menuAmburguesa
	}	
		
			
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
