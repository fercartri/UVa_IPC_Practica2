package uva.ipc.practica1;

import uva.ipc.practica1.modelo.Modelo;
import uva.ipc.practica1.vista.Controlador;
import uva.ipc.practica1.vista.Vista;

/**
 * Aplicación sencilla para comprar billetes de tren
 * @author Fernando Carmona
 * @author Rodrigo Serna
 * Grupo 45 del L5
 */
public class Main {
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }
}
