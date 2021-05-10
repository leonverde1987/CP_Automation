/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Suites;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author TestingIT
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    Suites.RunGridChrome.class
    //SpiraRun.RunGridFirefox.class
})  
public class RunGrid {
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        //Leer archivo de configuración
        Properties Config = new generic.genericGrid().getPropetiesFile("configuracion\\configuracion.properties");
        //Crear carpeta de evidencia
        String ruta = new generic.evidenceGrid().creaCarpetaRepeticion();
        Config.setProperty("rutaEvidencia",ruta);
        Config.store(new FileWriter("configuracion\\configuracion.properties"),"Actualizacoión de ruta evidencias");
  
//        new generic.genericGrid().leventarNodosGrid();

    }

}