package steps;


import generic.genericGrid;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginSteps extends genericGrid{
    
    /**
     * Est´s método nos ayuda a validar el mensaje del resultado esperado. 
     * @param driver Elemento WebDriver de la prueba.
     * @param Dato Es el archivo de datos de la prueba.
     * @param contador Es el controlador de pasos ejecutados.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Escenario Es el nombre del caso de prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @return Regresa el resultado Exitoso o Fallido y su detalle. 
     * @throws InterruptedException 
     */
    public String validarMensajeLogin(RemoteWebDriver driver, String Dato, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        String msj = "";
        try{
            msj = this.AssertMsjElemento(driver, "id", Dato, Elementos.getProperty("id_msj_ErrorLogin"));
        }catch(ComparisonFailure e){
            msj = "Fallido, Resultado Esperado: "+e;
        }
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        return msj;
    }
    
    public void loginAplicativo(RemoteWebDriver driver, String Usuario, String Password, Properties Elementos) throws InterruptedException{
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("reg_ipt_usuario"), Usuario);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("lgn_ipt_password"), Password);
        this.click(driver, "xpath", Elementos.getProperty("lgn_btn_entrar"));
    }
    
    
    public void logonAplicativo(RemoteWebDriver driver, Properties Elementos) throws InterruptedException{
        this.click(driver, "xpath", Elementos.getProperty("soc_btn_salir"));
        this.dormirSeg(3);
        this.click(driver, "xpath", Elementos.getProperty("soc_btn_si_socio_adulto"));
    }
}
