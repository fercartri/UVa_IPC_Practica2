package uva.ipc.practica2;

import uva.ipc.practica2.modelo.Modelo;
import uva.ipc.practica2.vista.GestorVistas;

/**
 * Aplicación sencilla para la gestión y compra de billetes de tren
 * @author Fernando Carmona
 * @author Rodrigo Serna
 * Grupo 45 del L5
 */
public class Main {
    private static GestorVistas gestor;
    private static Modelo modelo;
    
    
    /**
     * Consultar el gestor de vistas de la aplicación
     * @return gestor el gestor de vistas
     */
    public static GestorVistas getGestorVistas(){
        return gestor;
    }
    
    /**
     * Consultar el modelo de la aplicación
     * @return modelo el modelo
     */
    public static Modelo getModelo(){
        return modelo;
    }
    
    public static void main(String args[]) {
        gestor = new GestorVistas();
        modelo = new Modelo();
        gestor.mostrarVistaMenuPrincipal();
    }
}
