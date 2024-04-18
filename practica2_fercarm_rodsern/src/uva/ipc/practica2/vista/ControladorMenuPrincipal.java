package uva.ipc.practica2.vista;

import uva.ipc.practica2.Main;
import uva.ipc.practica2.modelo.Modelo;

/**
 * Clase para el controlador de la vista de menu principal
 * @author Fernando Carmona
 * @author Rodrigo Serna
 */
public class ControladorMenuPrincipal {
    private VistaMenuPrincipal miVista;
    private Modelo miModelo;
    
    /**
     * Inicializar la vista y el modelo a partir de una vista proporcionada
     * @param vista un objeto vista cualquiera
     */
    public ControladorMenuPrincipal(VistaMenuPrincipal vista){
        miVista = vista;
        miModelo = uva.ipc.practica2.Main.getModelo();
    }
    
    //Eventos-----------------------------------------------------------------------------
    /**
     * Pone por pantalla el menú de comprar un billete
     */
    public void procesarComprar(){
        Main.getGestorVistas().mostrarVistaComprarBillete();
    }
    
    /**
     * Pone por pantalla el menú del usuario
     */
    public void procesarTarjeta(){
        Main.getGestorVistas().mostrarVistaMenuUsuario();
    }
    
    /**
     * Cierra el programa
     */
    public void procesarSalir(){
        System.exit(0);
    }
}
