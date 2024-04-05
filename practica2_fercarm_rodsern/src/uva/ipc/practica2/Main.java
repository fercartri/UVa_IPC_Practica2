package uva.ipc.practica2;

import uva.ipc.practica2.modelo.Modelo;
import uva.ipc.practica2.vistaComprarBillete.Controlador;
import uva.ipc.practica2.vistaComprarBillete.Vista;

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
