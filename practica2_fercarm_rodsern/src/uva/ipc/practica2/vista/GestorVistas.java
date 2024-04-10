package uva.ipc.practica2.vista;

import javax.swing.JFrame;

/**
 * @author Fernando Carmona Palacio
 * @author Rodrigo Serna Albarrán
 */
public class GestorVistas {

    private JFrame vistaActual;

    public void mostrarVistaComprarBillete() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaComprarBillete();
        vistaActual.setVisible(true);
    }
    
    public void mostrarVistaMenuPrincipal() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaMenuPrincipal();
        vistaActual.setVisible(true);
    }
    
    public void mostrarVistaMenuUsuario() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaMenuUsuario();
        vistaActual.setVisible(true);
    }
    
    public void mostrarVistaMisViajes() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaMisViajes();
        vistaActual.setVisible(true);
    }
    
    public void mostrarVistaRecargarTarjeta() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaRecargarTarjeta();
        vistaActual.setVisible(true);
    }
}
