package TestCases;


import org.junit.Test;
import com.lowagie.text.BadElementException;
import com.lowagie.text.DocumentException;
import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebDriver;
import steps.GenericSteps;
import steps.LoginSteps;
import steps.registroUsuario;



public class CPSN_Registro_Usuario{
    
    //STEPS
    public GenericSteps genericSteps = new GenericSteps();
    public LoginSteps loginSteps = new LoginSteps();
    public registroUsuario registroUsuariosSteps = new registroUsuario();
    


    //UIELEMENTS
    public Properties UIRegistro = null;
    
    public Properties Config = null;
    private RemoteWebDriver driver = null;
    public List<String> Pasos = new ArrayList<String>();
    public int contador = 0;
    public String Resultado = "";
    public String ResultadoGlobal = "";
    public String Escenario = "";
    public String RutaEvidencia = "";
    public String Navegador="";
    public CSVReader DataDriven=null;
    public String[] filaDatos=null;
    

    
    
    @Before
    public void PrepararEjecucion() throws FileNotFoundException, MalformedURLException, InterruptedException{
    
        Config = genericSteps.getPropetiesFile("configuracion\\configuracion.properties");
        UIRegistro = genericSteps.getPropetiesFile("configuracion\\uielements\\registro.properties");
        DataDriven = genericSteps.ObtenerDatos("configuracion\\Datos\\datoRegistro.csv");
        contador = 1;
        RutaEvidencia = Config.getProperty("rutaEvidencia");
        Resultado = "Fallido";
        Navegador = Config.getProperty("Navegador");
        driver = genericSteps.openGridBrowser(Navegador, Config);
        ResultadoGlobal = "Exitoso";
        //Abrir URL
        this.genericSteps.ingresarAURL(driver, Config);
    }
    
    @Test
    public void CPSN_Registro_Usuario() throws InterruptedException, DocumentException, BadElementException, IOException, Exception {
        DataDriven.readNext();
        int Repeticion = 1;
        
        while((filaDatos = DataDriven.readNext()) != null){
            String sucursal = filaDatos[0];
            String puesto = filaDatos[1];
            String nomina = filaDatos[2];
            String pnombre = filaDatos[3];
            String snombre = filaDatos[4];
            String papellido = filaDatos[5];
            String sapellido = filaDatos[6];
            String contrasena = filaDatos[7];
            String usuarioAutoriza = filaDatos[8];
            String contrasenaAutoriza = filaDatos[9];
            
            try{

                    Escenario = "CP_Registro_Usuario "+Repeticion;

                    //Paso 1
                    contador++;
                    Pasos.add(contador+".- Ingresar menú: Registro");
                    this.registroUsuariosSteps.clickMenuRegistro(driver, UIRegistro, Config, contador, Escenario, Navegador);
                    
                    //Paso 3
                    contador++;
                    Pasos.add(contador+".- Ingresar los datos del registro Sucursal: "+sucursal+", Nómina: "+nomina+", Primer Nombre: "+pnombre+", Segundo Nombre: "+snombre+", Primer Apellido: "+papellido+", Segundo Apellido: "+sapellido+", Contraseña: "+contrasena+", Usuario Autoriza: "+usuarioAutoriza+", Contraseña Usuario Autoriza: "+contrasenaAutoriza+".");
                    this.registroUsuariosSteps.ingresarDatosUsuarioNuevo(driver, sucursal, puesto, nomina, pnombre, snombre, papellido, sapellido, contrasena, contrasena, usuarioAutoriza, contrasenaAutoriza, UIRegistro, Config, contador, Escenario, Navegador);
                    
                    //Paso 4
                    contador++;
                    Pasos.add(contador+".- Aceptar aviso de privacidad.");
                    this.registroUsuariosSteps.clicAceptaAvisos(driver, UIRegistro, Config, contador, Escenario, Navegador);
                   
                    //Paso 9
                    contador++;
                    Pasos.add(contador+".- Presionar el botón: Registrar.");
                    this.registroUsuariosSteps.clicRegistrarUsuariosNuevo(driver, UIRegistro, Config, contador, Escenario, Navegador);
                    
                    contador++;
                    Pasos.add(contador+".- Presionar el botón: Si.");
                    this.registroUsuariosSteps.clicbotonSi(driver, UIRegistro, Config, contador, Escenario, Navegador);
                    Resultado="Exitoso";
                    
            }catch(NoSuchElementException s){
                Resultado = "Ejecución Fallida, No se encontró elemento: "+s;
                genericSteps.capturarEvidencia(driver, Config, contador, Escenario, Navegador);
            }catch(InterruptedException e){
                Resultado = "Ejecución Fallida: "+e;
                genericSteps.capturarEvidencia(driver, Config, contador, Escenario, Navegador);
            }finally{
                genericSteps.finalizarTestCase(driver, Escenario, Resultado, contador, Pasos, RutaEvidencia, Config.getProperty("Modulo"), Config.getProperty("Version"), Navegador);
                if(!"Exitoso".equals(Resultado.substring(0, 7))){
                    ResultadoGlobal = Resultado;
                }
                Resultado="Fallido";
                contador=0;
            }
            Repeticion++;
        }
        if(!"Exitoso".equals(ResultadoGlobal.substring(0, 7))){
            throw new Exception("Navegador: "+Navegador + "\n Resultado: \n" + ResultadoGlobal);
        }
    }

    @After
    public void cerrarTest(){
        genericSteps.cerrarNavegador(driver);
    }   
}
