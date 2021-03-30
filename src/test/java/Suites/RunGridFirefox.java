/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Suites;


import java.io.FileWriter;
import java.util.Properties;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author TestingIT
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    
})
public class RunGridFirefox {
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        //Leer archivo de configuración
        Properties Config = new generic.genericGrid().getPropetiesFile("configuracion\\configuracion.properties");

        //Asignar navegador de ejecución
        Config.setProperty("Navegador","firefox");
        Config.store(new FileWriter("configuracion\\configuracion.properties"),"Cambio de Navegador a Chrome");
        
        //new Generic.genericGrid().leventarNodosGrid();
    }

}