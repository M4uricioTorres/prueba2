package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Utilitarios {

    private static WebDriver driver, webDriver;


    public static void presionaEnterWindows() throws InterruptedException, AWTException {
        Robot r = new Robot();
        r.keyPress( KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
    }

    public static boolean esperarElemento(WebElement objeto) {
        boolean existe = false;
        int intentos = 0;
        while ((!existe) & intentos < 15) {
            System.out.println(intentos);
            existe = visualizarObjeto(objeto, 10);
            System.out.println("esperando los objetos " + existe);
            if (!existe) {
                intentos++;
            } else {
                System.out.println("Se encuentra Elemento :" + objeto.getText());
            }
        }
        return existe;
    }

    public static boolean visualizarObjeto(WebElement elementName, int timeout) {
        try {
            System.out.println ("Valida si Es visible el elemnto a validar.");
            WebDriverWait wait = new WebDriverWait (webDriver, timeout);
            wait.until (ExpectedConditions.visibilityOf (elementName));
            System.out.println ("Es visible el elemnto a validar.");
            return true;
        } catch (Exception e) {
            System.out.println ("No es visible el elemento a validar.");
            return false;
        }
    }

    public static boolean isEnabled(WebElement element) throws NoSuchElementException {
        System.out.println("Esta el elemento habilitado?:" + element.getAttribute("enabled"));
        return element.getAttribute("enabled").trim().equals("true");
    }

    public static void esperar(int tiempo){
        try{
            Thread.sleep( tiempo * 1000 );
        }catch (InterruptedException io){
            System.out.println(">>> "+io);
        }
    }

    public static boolean esperar(WebElement element, WebDriver driver){
        try{
            System.out.println ("Validando si elemento es visible: ");
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("\t[ "+element+" ] >>> visible.");
            return true;
        } catch (Exception e) {
            System.out.println ("No es visible el elemento a validar.");
            return false;
        }
    }

}

