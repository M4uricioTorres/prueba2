package testCases;


import config.Base;
import config.BaseDocker;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.Agregar;
import page.Busqueda;
import page.Login;

import java.sql.Driver;

public class CPA001_BuscarGoogle extends Base {


    /*
    public void testParameterWithXML() {

        Login login = new Login(driver);
        Busqueda busqueda = new Busqueda(driver);
        login.buscar("que sucede");
        busqueda.esperarResultado();

    }

*/
    @Test(priority = 0)
    public void testParameterWithXML(){
        Login login = new Login(driver);
        Busqueda busqueda= new Busqueda(driver);
        login.logear("torresmauricio.es@gmail.com","123456");
        //busqueda.esperarResultado();
    }

    @Test(priority = 1)
    public void testAgregarItem(){
        Agregar agregar = new Agregar(driver);
        //Busqueda busqueda=new Busqueda(driver);
        agregar.AddItem();

    }


}
