package steps;


import generic.genericGrid;
import java.util.Properties;
import org.junit.ComparisonFailure;
import org.openqa.selenium.remote.RemoteWebDriver;

public class registroSocioAdulto extends genericGrid{

    /**
     * Est´s método abre el menú Registro Socio Adulto.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param Config Es el archivo de configuración de la aplicación.
     * @param contador Es el valor entero del paso ejecutado.
     * @param Escenario Es el nombre del caso del prueba.
     * @param navegador Es el nombre dle navegador donde se esta ejecutando el caso de prueba.
     * @throws InterruptedException 
     */
    public void clickMenuRegistroSocioAdulto(RemoteWebDriver driver, Properties Elementos, Properties Config, int contador, String Escenario, String navegador) throws InterruptedException{
        this.clickJS(driver, "xpath", Elementos.getProperty("mnu_socio"));
        this.clickJS(driver, "xpath", Elementos.getProperty("mnu_nuevo_socio"));
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    /**
     * Est´s método abre el menú Registro Socio Adulto.
     * @param driver Elemento WebDriver de la prueba.
     * @param Elementos Es el archivo properties de los elementos.
     * @param Config Es el archivo de configuración de la aplicación.
     * @param contador Es el valor entero del paso ejecutado.
     * @param Escenario Es el nombre del caso del prueba.
     * @param navegador Es el nombre dle navegador donde se esta ejecutando el caso de prueba.
     * @throws InterruptedException 
     */
    public void clickBotonAdulto(RemoteWebDriver driver, Properties Elementos, Properties Config, int contador, String Escenario, String navegador) throws InterruptedException{
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_btn_adulto"));
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
    public void ingresarDatosPersonalesSocio(RemoteWebDriver driver, String pnombre, String snombre, String papellido, String sapellido, String fnacimiento, String nacionalidad, String Estado, String ciudad, String rfc, String CURP, String tipoidentificacion, String identificacion, Properties Elementos, Properties Config, int contador, String Escenario, String navegador) throws InterruptedException{
        this.dormirSeg(3);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_txt_pnombre"), pnombre);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_txt_snombre"), snombre);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_txt_apaterno"), papellido);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_txt_amaterno"), sapellido);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_txt_fecha_nacimiento"), fnacimiento);
        
//        this.clickJS(driver, "xpath", Elementos.getProperty("soc_lbl_sexo"));
//        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_sexo"), "Masculino");
//        this.clicTextoTabla(driver, "Masculino", "li", Elementos.getProperty("soc_tbl_sexo"));
        
//        this.clickJS(driver, "xpath", Elementos.getProperty("soc_lbl_nacionalidad"));
//        this.clicTextoTabla(driver, nacionalidad, "li", Elementos.getProperty("soc_lts_nacionalidad"));
//        this.dormirSeg(2);
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_lbl_estado"));
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_estado"), Estado);
        this.clicTextoTabla(driver, Estado, "li", Elementos.getProperty("soc_lts_estado"));
        this.dormirSeg(2);
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_lbl_ciudad"));
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_ciudad"), ciudad);
        this.clicTextoTabla(driver, ciudad, "li", Elementos.getProperty("soc_lts_ciudad"));
        
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_rfc"), rfc);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_curp"), CURP);
        
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_lbl_pais_RFC"));
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_pais_RFC"), "México");
        this.clicTextoTabla(driver, "México", "li", Elementos.getProperty("soc_lts_pais_RFC"));
        
//        this.seleccionarComboByText(driver, "xpath", Elementos.getProperty("soc_sel_identificacion"), tipoidentificacion);
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_lbl_identificacion"));
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_identificacion"), tipoidentificacion);
        this.clicTextoTabla(driver, tipoidentificacion, "li", Elementos.getProperty("soc_lts_identificacion"));
        
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_no_identificacion"), identificacion);
        
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
    }
    
    public void ingresarDatosContacto(RemoteWebDriver driver, String estadoContacto, String ciudadContacto, String asentamientoContacto, String cpContacto, String calleContacto, String ubicacionContacto, String noExt, String noInt, String anosResidencia, String telContacto, Properties Elementos, Properties Config, int contador, String Escenario, String navegador) throws InterruptedException{
        this.dormirSeg(3);
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_lbl_dom_estado"));
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_dom_estado"), estadoContacto);
        this.clicTextoTabla(driver, estadoContacto, "li", Elementos.getProperty("soc_lts_dom_estado"));
        this.dormirSeg(3);
        
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_lbl_dom_ciudad"));
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_dom_ciudad"), ciudadContacto);
        this.clicTextoTabla(driver, ciudadContacto, "li", Elementos.getProperty("soc_lts_dom_ciudad"));
        
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_txt_dom_asentamiento"), asentamientoContacto);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_dom_cp"), cpContacto);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_dom_calle"), calleContacto);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_dom_ubicacion"), ubicacionContacto);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_dom_noExt"), noExt);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_dom_noInt"), noInt);
        
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_dom_reisdencia"), anosResidencia);
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_ipt_dom_telefono"));
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_dom_telefono"), telContacto);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        
    }
    
    public void ingresarDatosGenerales(RemoteWebDriver driver, String casaHabita, String escolaridad, String Profesion, String sexo, String tipoSocio, String comoEntero, String salud, String estadoCivil, Properties Elementos, Properties Config, int contador, String Escenario, String navegador) throws InterruptedException{
        this.dormirSeg(3);
        
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_lbl_gen_casa_habitacion"));
        this.clicTextoTabla(driver, casaHabita, "li", Elementos.getProperty("soc_lts_gen_casa_habitacion"));
        
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_lbl_gen_escolaridad"));
        this.clicTextoTabla(driver, escolaridad, "li", Elementos.getProperty("soc_lts_gen_escolaridad"));
        
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_lbl_gen_profesion"));
        this.clicTextoTabla(driver, Profesion, "li", Elementos.getProperty("soc_lts_gen_profesion"));
        
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_lbl_gen_sexo"));
        this.clicTextoTabla(driver, sexo, "li", Elementos.getProperty("soc_lts_gen_sexo"));
        
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_lbl_gen_tiposocio"));
        this.clicTextoTabla(driver, tipoSocio, "li", Elementos.getProperty("soc_lts_gen_tiposocio"));
        
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_lbl_gen_entero"));
        this.clicTextoTabla(driver, comoEntero, "li", Elementos.getProperty("soc_lts_gen_entero"));
        
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_lbl_gen_salud"));
        this.clicTextoTabla(driver, salud, "li", Elementos.getProperty("soc_lts_gen_salud"));
        
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_lbl_gen_edo_civil"));
        this.clicTextoTabla(driver, estadoCivil, "li", Elementos.getProperty("soc_lts_gen_edo_civil"));
        
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_lbl_motivo"));
        this.clicTextoTabla(driver, "Ahorro", "li", Elementos.getProperty("soc_lts_motivo"));
        
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        
    }
    
    public void ingresarDatosBeneficiario(RemoteWebDriver driver, String nombresBene, String apaternoBene, String amaternoBene, String telBene, Properties Elementos, Properties Config, int contador, String Escenario, String navegador) throws InterruptedException{
        this.dormirSeg(3);
        
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_txt_ben_nombre"), nombresBene);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_ben_apaterno"), apaternoBene);
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_ben_amaterno"), amaternoBene);
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_ipt_ben_telefono"));
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_ben_telefono"), telBene);
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_ipt_ben_parentesco"));
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_lts_ben_parentesco"), "Abuelos");
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_ipt_ben_porcentaje"), "100%");
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        
    }
    
    public void ingresarDatosEmpleo(RemoteWebDriver driver, String ocupacion, Properties Elementos, Properties Config, int contador, String Escenario, String navegador) throws InterruptedException{
        this.dormirSeg(3);
        
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_lbl_emp_ocupacion"));
        this.clicTextoTabla(driver, ocupacion, "li", Elementos.getProperty("soc_lts_emp_ocupacion"));
        
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        
    }
    
    public void ingresarDatosReferencia(RemoteWebDriver driver, String nombreRef, String telRef, String tipoRef, Properties Elementos, Properties Config, int contador, String Escenario, String navegador) throws InterruptedException{
        this.dormirSeg(3);
        
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_TXT_refnombre"), nombreRef);
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_TXT_ref_telefono"));
        this.ingresarTexto(driver, "xpath", Elementos.getProperty("soc_TXT_ref_telefono"), telRef);
        
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_lbl_ref_parentezco"));
        this.clicTextoTabla(driver, tipoRef, "li", Elementos.getProperty("soc_lts_ref_parentezco"));
        
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        
    }
    
    public void presionarGuardar(RemoteWebDriver driver, Properties Elementos, Properties Config, int contador, String Escenario, String navegador) throws InterruptedException{
        this.dormirSeg(3);
        this.capturaDriver(driver, Config.getProperty("rutaEvidencia"), contador, Escenario, navegador);
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_btn_guardar_socio_adulto"));
        this.dormirSeg(3);
        this.clickJS(driver, "xpath", Elementos.getProperty("soc_btn_si_socio_adulto"));
    }
    
}
