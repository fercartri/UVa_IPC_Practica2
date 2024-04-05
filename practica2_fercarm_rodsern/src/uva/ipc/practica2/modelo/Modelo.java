package uva.ipc.practica2.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase para el modelo de la aplicación
 * @author Fernando Carmona
 * @author Rodrigo Serna
 */
public class Modelo {
    private ArrayList<String> estaciones = new ArrayList<>();
    private ArrayList<String> rutas = new ArrayList<>();
    private boolean tarjeta_credito_pasada;
    private boolean tarjeta_renfe_pasada;    
    private double saldo;
    
    
    public Modelo(){
        cargarEstaciones();
        cargarRutas();
        
        tarjeta_credito_pasada = false;
        tarjeta_renfe_pasada = false;    
        saldo = 20;
    }
    
    /**
     * Cargar todas las estaciones al iniciar el modelo
     */
    private void cargarEstaciones(){
        File archivo = new File("./file/estaciones.csv");
        
        try {
            Scanner scanner = new Scanner(archivo);
            // Leer cada línea del archivo y agregarla al ComboBox
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                estaciones.add(linea);
            }
            
            scanner.close();
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }
    }
    
    /**
     * Cargar todas las rutas al iniciar el modelo
     */
    private void cargarRutas(){
        File archivo = new File("./file/rutas.csv");
        
        try {
            Scanner scanner = new Scanner(archivo);
            // Leer cada línea del archivo y agregarla al ComboBox
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                rutas.add(linea);
            }
            
            scanner.close();
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }
    }
    
    /**
     * Consultar todas las estaciones posibles del sistema
     * @return estaciones un ArrayList<String> con el nombre de las estaciones
     */
    public ArrayList<String> getEstaciones(){
        return estaciones;
    }
    
    /**
     * Consultar todas las rutas posibles del sistema
     * @return rutas un ArrayList<String> con toda la información de las rutas
     */
    public ArrayList<String> getRutas(){
        return rutas;
    }
    
    /**
     * Resetear el estado del pago
     */
    public void resetTodo(){
        tarjeta_credito_pasada = false;
        tarjeta_renfe_pasada = false;
    }
    
    /**
     * Actualiza que se ha procedido al pago mediante tarjeta de crédito
     */
    public void tarjetaCreditoPasada(){
        tarjeta_credito_pasada = true;
    }
    
    /**
     * Devuelve si se ha pagado mediante tarjeta de crédito
     * @return true si se ha pagado y false en caso contrario
     */
    public boolean getPagadoCredito(){
        return tarjeta_credito_pasada;
    }

    /**
     * Actualiza que se ha procedido al pago mediante tarjeta de usuario de TCyL
     * Pone en true que la tarjeta de bono de renfe ha sido pasada
     * Después intenta efectuar la operación de pago con el saldo disponible del bono
     * Si es posible la operación devuelve true, en caso contrario, false
     * @param precio un número real mayor que 0
     * @return un valor booleano cualquiera
     */
    public void tarjetaRenfePasada(){
        tarjeta_renfe_pasada = true;
    }
    
    /**
     * Devuelve si se ha pagado mediante tarjeta de usuario de TCyL
     * @return true si se ha pagado y false en caso contrario
     */
    public boolean getPagadoRenfe(){
        return tarjeta_renfe_pasada;
    }
    
    public void setSaldo(double nuevo){
        saldo = nuevo;
    }
    
    /**
     * Devuelve el saldo que queda en la tarjeta de usuario TCyL
     * @return un double con el saldo restante
     */
    public double getSaldo(){
        return saldo;
    }    
}
