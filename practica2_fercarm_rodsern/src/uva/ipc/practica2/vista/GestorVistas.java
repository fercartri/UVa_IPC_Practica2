package uva.ipc.practica2.vista;

import javax.swing.JFrame;

/**
 * Clase para el controlador de las diferentes vistas de la aplicación
 * @author Fernando Carmona
 * @author Rodrigo Serna
 */
public class GestorVistas {
    private JFrame vistaActual;
    
    
    /**
     * Muestra VistaMenuPrincipal
     */
    public void mostrarVistaMenuPrincipal() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaMenuPrincipal();
        vistaActual.setVisible(true);
    }
    
    /**
     * Muestra VistaComprarBillete
     */
    public void mostrarVistaComprarBillete() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaComprarBillete();
        vistaActual.setVisible(true);
    }
    
    /**
     * Muestra VistaMenuUsuario
     */
    public void mostrarVistaMenuUsuario() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaMenuUsuario();
        vistaActual.setVisible(true);
    }
    
    /**
     * Muestra VistaRecargarTarjeta
     */
    public void mostrarVistaRecargarTarjeta() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaRecargarTarjeta();
        vistaActual.setVisible(true);
    }
    
    /**
     * Muestra VistaMisViajes
     */
    public void mostrarVistaMisViajes() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaMisViajes();
        vistaActual.setVisible(true);
    }
}
