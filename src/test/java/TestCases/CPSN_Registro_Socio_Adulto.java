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
import steps.registroSocioAdulto;

public class CPSN_Registro_Socio_Adulto{
    
    //STEPS
    public GenericSteps genericSteps = new GenericSteps();
    public LoginSteps loginSteps = new LoginSteps();
    public registroSocioAdulto registroAdultoSteps = new registroSocioAdulto();
    


    //UIELEMENTS
    public Properties UIRegistroAdulto = null;
    public Properties UILogin = null;
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
        UIRegistroAdulto = genericSteps.getPropetiesFile("configuracion\\uielements\\UIRegistroAdulto.properties");
        UILogin = genericSteps.getPropetiesFile("configuracion\\uielements\\UILogin.properties");
        DataDriven = genericSteps.ObtenerDatos("configuracion\\Datos\\dt_RegistroUsuarioAdulto.csv");
        contador = 1;
        RutaEvidencia = Config.getProperty("rutaEvidencia");
        Resultado = "Fallido";
        Navegador = Config.getProperty("Navegador");
        driver = genericSteps.openGridBrowser(Navegador, Config);
        ResultadoGlobal = "Exitoso";
        //Abrir URL
        this.genericSteps.ingresarAURL(driver, Config);
        //Hacer Login
        this.loginSteps.loginAplicativo(driver, Config.getProperty("UsuServicios"), Config.getProperty("PasServicios"), UILogin);

    }
    
    @Test
    public void CPSN_Registro_Socio() throws InterruptedException, DocumentException, BadElementException, IOException, Exception {
        DataDriven.readNext();
        int Repeticion = 1;
        
        while((filaDatos = DataDriven.readNext()) != null){
            //Personales
            String pnombre = filaDatos[0]; 
            String snombre = filaDatos[1]; 
            String papellido = filaDatos[2]; 
            String sapellido = filaDatos[3]; 
            String fnacimiento = filaDatos[4]; 
            String nacionalidad = filaDatos[5]; 
            String Estado = filaDatos[6]; 
            String ciudad = filaDatos[7]; 
            String rfc = filaDatos[8]; 
            String CURP = filaDatos[9]; 
            String tipoidentificacion = filaDatos[10]; 
            String identificacion = filaDatos[11];
            //Contacto
            String estadoContacto = filaDatos[12]; 
            String ciudadContacto = filaDatos[13]; 
            String asentamientoContacto = filaDatos[14];  
            String cpContacto = filaDatos[15];  
            String calleContacto = filaDatos[16]; 
            String ubicacionContacto = filaDatos[17]; 
            String noExt = filaDatos[18]; 
            String noInt = filaDatos[19];
            String anosResidencia = filaDatos[20]; 
            String telContacto = filaDatos[21];
            //Generales
            String casaHabita = filaDatos[22];
            String escolaridad = filaDatos[23];
            String profesion = filaDatos[24];
            String sexo = filaDatos[25];
            String tipoSocio = filaDatos[26];
            String comoEntero = filaDatos[27];	
            String salud = filaDatos[28];	
            String estadoCivil = filaDatos[29];
            //Beneficiario
            String nombresBene = filaDatos[30]; 
            String apaternoBene = filaDatos[31]; 
            String amaternoBene = filaDatos[32]; 
            String telBene = filaDatos[33];
            //Empleos
            String ocupacion = filaDatos[34];
            //Referencias
            String nombreRef = filaDatos[35];
            String telRef = filaDatos[36]; 
            String tipoRef = filaDatos[37];           
            //Referencias

            try{

                Escenario = "RSA Registro Socio Adulto "+Repeticion;

                //Paso 1
                Pasos.add(contador+".- Ir al menú: Socio -> Nuevo");
                this.registroAdultoSteps.clickMenuRegistroSocioAdulto(driver, UIRegistroAdulto, Config, contador, Escenario, Navegador);

                //Paso 2
                contador++;
                Pasos.add(contador+".- Presionar el botón: Adulto.");
                this.registroAdultoSteps.clickBotonAdulto(driver, UIRegistroAdulto, Config, contador, Escenario, Navegador);

                //Paso 4
                contador++;
                Pasos.add(contador+".- Ingresar los datos personales del socio.");
                this.registroAdultoSteps.ingresarDatosPersonalesSocio(driver, pnombre, snombre, papellido, sapellido, fnacimiento, nacionalidad, Estado, ciudad, rfc, CURP, tipoidentificacion, identificacion, UIRegistroAdulto, Config, contador, Escenario, Navegador);

                //Paso 5
                contador++;
                Pasos.add(contador+".- Ingresar los datos de contacto del socio.");
                this.registroAdultoSteps.ingresarDatosContacto(driver, estadoContacto, ciudadContacto, asentamientoContacto, cpContacto, calleContacto, ubicacionContacto, noExt, noInt, anosResidencia, telContacto, UIRegistroAdulto, Config, contador, Escenario, Navegador);
                
                //Paso 6
                contador++;
                Pasos.add(contador+".- Ingresar los datos generales del socio.");
                this.registroAdultoSteps.ingresarDatosGenerales(driver, casaHabita, escolaridad, profesion, sexo, tipoSocio, comoEntero, salud, estadoCivil, UIRegistroAdulto, Config, contador, Escenario, Navegador);
                
                //Paso 7
                contador++;
                Pasos.add(contador+".- Ingresar los datos del beneficiario del socio.");
                this.registroAdultoSteps.ingresarDatosBeneficiario(driver, nombresBene, apaternoBene, amaternoBene, telBene, UIRegistroAdulto, Config, contador, Escenario, Navegador);
                
                //Paso 8
                contador++;
                Pasos.add(contador+".- Ingresar los datos del empleo del socio.");
                this.registroAdultoSteps.ingresarDatosEmpleo(driver, ocupacion, UIRegistroAdulto, Config, contador, Escenario, Navegador);
                
                //Paso 9
                contador++;
                Pasos.add(contador+".- Ingresar los datos del referneica del socio.");
                this.registroAdultoSteps.ingresarDatosReferencia(driver, nombreRef, telRef, tipoRef, UIRegistroAdulto, Config, contador, Escenario, Navegador);
                
                //Paso 9
                contador++;
                Pasos.add(contador+".- Presionar el botón: Guardar.");
                this.registroAdultoSteps.presionarGuardar(driver, UIRegistroAdulto, Config, contador, Escenario, Navegador);
                
                Resultado="Exitoso";
                    
            }catch(NoSuchElementException s){
                Resultado = "Ejecución Fallida, No se encontró elemento: "+s;
                genericSteps.capturarEvidencia(driver, Config, contador, Escenario, Navegador);
            }catch(InterruptedException e){
                Resultado = "Ejecución Fallida: "+e;
                genericSteps.capturarEvidencia(driver, Config, contador, Escenario, Navegador);
            }finally{
                genericSteps.finalizarTestCase(driver, Escenario, Resultado, contador, Pasos, RutaEvidencia, Config.getProperty("Modulo"), Config.getProperty("Version"), Navegador);
                loginSteps.logonAplicativo(driver, UILogin);
                if(!"Exitoso".equals(Resultado.substring(0, 7))){
                    ResultadoGlobal = Resultado;
                }
                Resultado="Fallido";
                contador=0;
            }
            Repeticion++;
        }
    }

    @After
    public void cerrarTest(){
        genericSteps.cerrarNavegador(driver);
    }   
}
