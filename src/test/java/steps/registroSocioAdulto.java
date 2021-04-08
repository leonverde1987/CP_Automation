package steps;


import generic.genericGrid;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class registroSocioAdulto extends genericGrid{

    /**
     * Est´s método abre el menú Registro 
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param Config Es el archivo de configuración de la aplicación.
     * @param contador Es el valor entero del paso ejecutado.
     * @param Escenario Es el nombre del caso del prueba.
     * @param navegador Es el nombre dle navegador donde se esta ejecutando el caso de prueba.
     * @throws InterruptedException 
     */
    public void clickMenuRegistro(RemoteWebDriver driver, Properties Elementos, Properties Config, int contador, String Escenario, String navegador) throws InterruptedException{
        this.clickJS(driver, "xpath", Elementos.getProperty("reg_btn_nuevo"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    
    
    /**
     * Este método acepta los avisos de privacidad
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param Config Es el archivo de configuración de la aplicación.
     * @param contador Es el valor entero del paso ejecutado.
     * @param Escenario Es el nombre del caso del prueba.
     * @param navegador Es el nombre dle navegador donde se esta ejecutando el caso de prueba.
     * @throws InterruptedException 
     */
    public void clicAceptaAvisos(RemoteWebDriver driver, Properties Elementos, Properties Config, int contador, String Escenario, String navegador) throws InterruptedException{
            this.clickJS(driver, "xpath", Elementos.getProperty("reg_btn_acepta_terminos"));
            this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método presiona el botón registrar usuario.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param Config Es el archivo de configuración de la aplicación.
     * @param contador Es el valor entero del paso ejecutado.
     * @param Escenario Es el nombre del caso del prueba.
     * @param navegador Es el nombre dle navegador donde se esta ejecutando el caso de prueba.
     * @throws InterruptedException 
     */
    public void clicRegistrarUsuariosNuevo(RemoteWebDriver driver, Properties Elementos, Properties Config, int contador, String Escenario, String navegador) throws InterruptedException{
        this.clickJS(driver, "xpath", Elementos.getProperty("reg_btn_registrar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método presiona el botón registrar usuario.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param Config Es el archivo de configuración de la aplicación.
     * @param contador Es el valor entero del paso ejecutado.
     * @param Escenario Es el nombre del caso del prueba.
     * @param navegador Es el nombre dle navegador donde se esta ejecutando el caso de prueba.
     * @throws InterruptedException 
     */
    public void clicbotonSi(RemoteWebDriver driver, Properties Elementos, Properties Config, int contador, String Escenario, String navegador) throws InterruptedException{
        this.clickJS(driver, "xpath", Elementos.getProperty("reg_btn_si"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Este método ingresa los datos necesarios para un uusario.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param Config Es el archivo de configuración de la aplicación.
     * @param contador Es el valor entero del paso ejecutado.
     * @param Escenario Es el nombre del caso del prueba.
     * @param navegador Es el nombre dle navegador donde se esta ejecutando el caso de prueba.
     * @throws InterruptedException 
     */
    public void ingresarDatosUsuarioNuevo(RemoteWebDriver driver,String sucursal, String puesto, String noempleado, String pnombre, String snombre, String papellido, String sapellido, String contrasena, String confcontrasena, String usuaautoriza, String confautoriza, Properties Elementos, Properties Config, int contador, String Escenario, String navegador) throws InterruptedException{
        this.clickJS(driver, "xpath", Elementos.getProperty("reg_lbl_sucursal_label"));
        this.clicTextoTabla(driver, sucursal, "li", Elementos.getProperty("reg_lst_sucursales"));
        this.dormirSeg(3);
        this.clickJS(driver, "xpath", Elementos.getProperty("reg_lbl_puesto_label"));
        this.clicTextoTabla(driver, puesto, "li", Elementos.getProperty("reg_lst_puesto"));
        this.dormirSeg(3);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("reg_ipt_no_empleado"), noempleado);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("reg_ipt_primer_nombre"), pnombre);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("reg_ipt_segundo_nombre"), snombre);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("reg_ipt_apellido_paterno"), papellido);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("reg_ipt_apellido_materno"), sapellido);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("reg_iptn_contrasena"), contrasena);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("reg_iptn_confirma_contra2"), contrasena);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("reg_iptn_usu_autoriza"), usuaautoriza);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("reg_iptn_contra_auto"), confautoriza);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
}
