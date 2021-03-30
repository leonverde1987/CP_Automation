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
    TestCases.CPSN_Registro_Usuario.class
})  
public class RunGridChrome {
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        //Leer archivo de configuración
        Properties Config = new generic.genericGrid().getPropetiesFile("configuracion\\configuracion.properties");

        Config.setProperty("Navegador","chrome");
        Config.store(new FileWriter("configuracion\\configuracion.properties"),"Cambio de Navegador a Chrome");
        
        //new generic.genericGrid().leventarNodosGrid();
    }

}
