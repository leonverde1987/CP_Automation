package steps;


import generic.genericGrid;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GenericSteps extends genericGrid{
    
    /**
     * Este método nos ayuda a regresar el nombre del navegador.
     * @param Cadena Nombre completo del navegador segun el driver.
     * @return Nombre corto del navegador.
     */
    public String navegador(String Cadena){
        String navegador="";
        Cadena = Cadena.substring(17, Cadena.length());
        //RemoteWebDriver: firefox on WINDOWS (32e13b4d-f272-43f3-9ad8-045535191a9a)
        for(int a = 0; Cadena.length() > a; a++){
            if(" ".equals(Cadena.substring(a, a+1))){
                a=Cadena.length()+1;
            }
            else{
                navegador = navegador + Cadena.substring(a, a+1);
            }
        }
        return navegador;
    }
    
    
    /**
     * Esté Método nos ayuda a dirigir el driver a una URL en especifico.
     * @param driver Elemento WebDriver de la prueba.
     * @param Config Es el archivo de configuración de la prueba.
     * @throws FileNotFoundException Cacha cualquier excepción en la ejecución.
     * @throws InterruptedException Cacha si el archivo Config no existe.
     */
    public void ingresarAURL(RemoteWebDriver driver, Properties Config) throws FileNotFoundException, InterruptedException {
        this.abrirURl(driver, Config.getProperty("urlCP"));
    }
    
    /**
     * Esté metodo nos ayuda a cerrar el driver.
     * @param driver  
     */
    public void cerrarNavegador(RemoteWebDriver driver) {
        this.cerrarDriver(driver);
    }
    
    /**
     * Captura una evidencia cuando el Test Falla.
     * @param driver Elemento WebDriver de la prueba.
     * @param Config Es el archivo config de la prueba.
     * @param error Es el número de error detectado.
     * @param Escenario Es el nombre del caso de prueba.
     * @param navegador Es el nombre del navegador donde se ejecuta la prueba.
     * @throws InterruptedException Cacha cualquier excepción.
     */
    public void capturarEvidencia(RemoteWebDriver driver, Properties Config, int error, String Escenario, String navegador) throws InterruptedException{
        
        switch(error) {
            case 1:
                this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), error, Escenario, navegador);
                break;
        }
    }
    
    /**
     * Esté método finaliza el Test Case y genera las evidencias.
     * @param driver Es el nombre del driver.
     * @param Escenario Es el nombre del Test Case.
     * @param Resultado Es el resultado del Testa Case Exitoso, Fallido o Ejecución Fallida.
     * @param contador Es el total de pasos ejecutados.
     * @param Pasos Es el detalle de los pasos ejecutados.
     * @param RutaEvidencia Es la ruta principal de la evidencia.
     * @param Modulo Es el módulo del aplicativo que se ejecuta.
     * @param Version Es la versión del aplicativo.
     * @throws Exception Cacha cualquier excepción en la ejecución.
     */
    public void finalizarTestCase(RemoteWebDriver driver, String Escenario, String Resultado, int contador, List<String> Pasos, String RutaEvidencia, String Modulo, String Version, String navegador) throws Exception{
        this.GenerarEvidencias(driver, Escenario, Resultado, contador, Pasos, RutaEvidencia, Modulo, Version, navegador);
    }
    
    /**
     * 
     * @param Config
     * @throws InterruptedException
     * @throws FileNotFoundException 
     */
    public void ejecucionGrid(Properties Config) throws InterruptedException, FileNotFoundException{
        this.leventarNodosGrid();
    }
    
    /**
     * Cerramos los nodos del grid selenium.
     * @throws InterruptedException Cacha cualquier excepción de ejecución.
     */
    public void finEjecucionGrid() throws InterruptedException{
        this.cierraNodosGrid();
    }

    /**
     * Esté método nos ingresa contenido en un componente de texto.
     * @param driver Elemento WebDriver de la prueba.
     * @param usuario Es el valor del texto que se va ingresar al componente.
     * @param contador Es el controlador de pasos ejecutados.
     * @param contrasena Es la contraseña para hacer Login.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Elementos Es el archivo con los elementos del aplicativo. 
     * @param Escenario Nombre del caso de prueba a ejecutar.
     * @throws FileNotFoundException Cacha cualquier excepción en la ejecución.
     * @throws InterruptedException Cacha si el archivo Config no existe. 
     */
    public void loginOracle(RemoteWebDriver driver, String usuario, String contrasena, String idioma, 
    		int contador, Properties Config, Properties Elementos, String Escenario, String navegador) throws FileNotFoundException, InterruptedException {
        this.ingresarTexto(driver, "id", Elementos.getProperty("id_usuario"), usuario);
        this.ingresarTexto(driver, "id", Elementos.getProperty("id_contrasena"), contrasena);
        this.seleccionarComboByValue(driver, "id", Elementos.getProperty("sl_idioma"), idioma);
        this.click(driver, "id", Elementos.getProperty("btn_conexion"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Esté método nos ayuda a seleccionar una opción del combo prefijos.
     * @param driver Elemento WebDriver de la prueba.
     * @param textoBuscar Es el valor del texto que se va ingresar al componente.
     * @param contador Es el controlador de pasos ejecutados.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Elementos Es el archivo con los elementos del aplicativo.
     * @param Escenario Nombre del caso de prueba a ejecutar.
     * @throws InterruptedException Cacha si el archivo Config no existe. 
     */
    public void seleccionarPrefijo(RemoteWebDriver driver, String textoBuscar, int contador, Properties Config, Properties Elementos, String Escenario, String navegador) throws InterruptedException{
        this.seleccionarComboByText(driver, "id", Elementos.getProperty("id_cbo_prefijo"), textoBuscar);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Esté método nos ayuda a presionar el .
     * @param driver Elemento WebDriver de la prueba.
     * @param contador Es el controlador de pasos ejecutados.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Elementos Es el archivo con los elementos del aplicativo.
     * @param Escenario Nombre del caso de prueba a ejecutar.
     * @param navegador Es el navegador donde se ejecuto la prueba.
     * @throws InterruptedException Cacha si el archivo Config no existe. 
     */
    public void presionarBotonMas(RemoteWebDriver driver, int contador, Properties Config, Properties Elementos, String Escenario, String navegador) throws InterruptedException{
        this.click(driver, "xpath", Elementos.getProperty("xpath_btn_signoMas"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Esté método nos ayuda a presionar el .
     * @param driver Elemento WebDriver de la prueba.
     * @param contador Es el controlador de pasos ejecutados.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Elementos Es el archivo con los elementos del aplicativo.
     * @param Escenario Nombre del caso de prueba a ejecutar.
     * @param navegador Es el navegador donde se ejecuto la prueba.
     * @throws InterruptedException Cacha si el archivo Config no existe. 
     */
    public void presionarConsultar(RemoteWebDriver driver, int contador, Properties Config, Properties Elementos, String Escenario, String navegador) throws InterruptedException{
        this.click(driver, "xpath", Elementos.getProperty("xpath_btn_consultar"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Esté método nos ayuda a presionar el botón tareas menú izquierda
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo con los elementos del aplicativo.
     * @throws InterruptedException Cacha si el archivo Config no existe. 
     */
    public void clickBtnTareas(RemoteWebDriver driver, Properties Elementos) throws InterruptedException{
        this.click(driver, "xpath", Elementos.getProperty("btn_tareas"));
        
    }
    
    /**
     * Est´s método nos ayuda a validar el mensaje del resultado esperado. 
     * @param driver Elemento WebDriver de la prueba.
     * @param nombre Es el archivo de datos de la prueba.
     * @param contador Es el controlador de pasos ejecutados.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Escenario Es el nombre del caso de prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @return Regresa el resultado Exitoso o Fallido y su detalle. 
     * @throws InterruptedException 
     */
    public String validarNuevoRegistro(RemoteWebDriver driver, String nombre, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        String msj = this.buscarTextoTabla(driver, nombre, "td", Elementos.getProperty("eam_tbl_centro_trabajo"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        return msj;
    }
    
    /**
     * Este método nos ayuda a validar el resultado epserado de una edición. 
     * @param driver Elemento WebDriver de la prueba.
     * @param nombre Es el archivo de datos de la prueba.
     * @param contador Es el controlador de pasos ejecutados.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Escenario Es el nombre del caso de prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @return Regresa el resultado Exitoso o Fallido y su detalle. 
     * @throws InterruptedException 
     */
    public String validarEidtarRegistro(RemoteWebDriver driver, String nombre, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        String msj = this.buscarTextoTabla(driver, nombre, "td", Elementos.getProperty("eam_tbl_centro_trabajo"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        return msj;
    }
    
     
    
    /**
     * Este método nos ayuda a validar el resultado epserado de una eliminación en un catálogo. 
     * @param driver Elemento WebDriver de la prueba.
     * @param nombre Es el archivo de datos de la prueba.
     * @param contador Es el controlador de pasos ejecutados.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Escenario Es el nombre del caso de prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @return Regresa el resultado Exitoso o Fallido y su detalle. 
     * @throws InterruptedException 
     */
    public String validarEliminarRegistro(RemoteWebDriver driver, String nombre, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        String msj = this.buscarTextoTabla(driver, nombre, "td", Elementos.getProperty("eam_tbl_centro_trabajo"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        if("Fallido".equals(msj)){
            msj = "Exitoso";
        }
        return msj;
    }
    
    /**
     * Est´s método nos ayuda a validar el mensaje del resultado esperado. 
     * @param driver Elemento WebDriver de la prueba.
     * @param nombre Es el archivo de datos de la prueba.
     * @param contador Es el controlador de pasos ejecutados.
     * @param Config Es el archivo de configuración de la prueba.
     * @param Escenario Es el nombre del caso de prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @return Regresa el resultado Exitoso o Fallido y su detalle. 
     * @throws InterruptedException 
     */
    public String validarNuevoActivo(RemoteWebDriver driver, String nombre, Properties Config, Properties Elementos, int contador, String Escenario, String navegador) throws InterruptedException{
        
        this.buscarActivoMantto(driver, nombre, Elementos);
        this.dormirSeg(2);
        String msj = this.buscarTextoTabla(driver, nombre, "a", Elementos.getProperty("eam_tbl_activos"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        return msj;
    }
    
    /**
     * Est´s método nos ayuda a validar el mensaje del resultado esperado. 
     * @param driver Elemento WebDriver de la prueba.
     * @param nombre Es lo que se va ingresar como filtro.
     * @param Elementos Es el archivo properties de los elementos.
     * @throws InterruptedException 
     */
    public void buscarActivoMantto(RemoteWebDriver driver, String nombre, Properties Elementos) throws InterruptedException{
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("eam_ipt_buscar"), nombre);
        this.click(driver, "xpath", Elementos.getProperty("eam_btn_buscar_activo"));
    }
}
