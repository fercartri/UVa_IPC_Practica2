package uva.ipc.practica2.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    private String miFecha;
    private String miOrigen;
    private String miDestino;
    private boolean miBici;
    private boolean miSilla;
    private boolean miMascota;
    final char[] pin = {'1', '2', '3', '4'};
    
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
     * Consulta el PIN introducido por el usuario
     * @return un array de caracteres cualquiera
     */
    public char[] getPin(){
        return pin;
    }
    
    /**
     * Consultar todas las estaciones posibles del sistema
     * @return estaciones un ArrayList<String> con el nombre de las estaciones
     */
    public ArrayList<String> getEstaciones(){
        return estaciones;
    }
    
    public ArrayList<String> getHistorial(){
        ArrayList<String> historial = new ArrayList<>();
        
        File archivo = new File("./file/billetes.csv");
        
        try {
            Scanner scanner = new Scanner(archivo);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                historial.add(linea);
            }
            
            scanner.close();
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }
        
        return historial;
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

    public void guardarFecha(String fecha){
        miFecha = fecha;
    }
    
    public void guardarOrigen(String origen){
        miOrigen = origen;
    }
    
    public void guardarDestino(String destino){
        miDestino = destino;
    }
    
    public void guardarRadios(boolean bici, boolean silla, boolean mascota){
        miBici = bici;
        miSilla = silla;
        miMascota = mascota;
    }
    
    public void guardarHistorial(String datosBillete){
        // Ruta del archivo
        String rutaArchivo = "./file/billetes.csv";
        String bicicletaString = "false";
        String mascotaString = "false";
        String sillaString = "false";
        if(miBici){
            bicicletaString = "true";
        }
        if(miMascota){
            mascotaString = "true";
        }
        if(miSilla){
            sillaString = "true";
        }
        //Preparar el formato correcto
        String datosFinal;
        String[] token = datosBillete.split(" ");
        String hora = token[1];
        String id = token [0];
        String tiempo = token[2];
        String precio = token[3];
        precio = precio.concat(token[4]); //meter el símbolo de euro
        datosFinal = miFecha;
        datosFinal = datosFinal.concat(";");
        datosFinal = datosFinal.concat(hora);
        datosFinal = datosFinal.concat(";");
        datosFinal = datosFinal.concat(id);
        datosFinal = datosFinal.concat(";");
        datosFinal = datosFinal.concat(miOrigen);
        datosFinal = datosFinal.concat(";");
        datosFinal = datosFinal.concat(miDestino);
        datosFinal = datosFinal.concat(";");
        datosFinal = datosFinal.concat(tiempo);
        datosFinal = datosFinal.concat(";");
        datosFinal = datosFinal.concat(precio);
        datosFinal = datosFinal.concat(";");
        datosFinal = datosFinal.concat(bicicletaString);
        datosFinal = datosFinal.concat(";");
        datosFinal = datosFinal.concat(sillaString);
        datosFinal = datosFinal.concat(";");
        datosFinal = datosFinal.concat(mascotaString);
        datosFinal = datosFinal.concat(";");
        
       
        // Verificar si el archivo no existe y crearlo si es necesario
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Escribir en el archivo
        try (FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw)) {

            bw.newLine(); // Agrega una nueva línea al final
            bw.write(datosFinal);
            
            bw.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public int getNumBilletes(){
        String rutaArchivo = "./file/billetes.csv";
        int numLineas= 0;
        
        File archivo = new File(rutaArchivo);     
        if (!archivo.exists()) {
           return 0;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            while (br.readLine() != null) {
                numLineas++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numLineas;
    }
    
    public static void borrarLinea(String nombreArchivo, String lineaABorrar) {
        String archivoTemporal = "./file/temp.csv";
        String lineaActual;

        try {
            File ficheroActual = new File(nombreArchivo);
            File ficheroTemp = new File(archivoTemporal);

            BufferedReader br = new BufferedReader(new FileReader(ficheroActual));
            BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroTemp));
            while ((lineaActual = br.readLine()) != null) {
                // Si la línea no es la que queremos borrar, la escribimos en el archivo temporal
                if (!lineaActual.trim().equals(lineaABorrar)) {
                    bw.write(lineaActual + System.getProperty("line.separator"));
                }
            }
            bw.close();
            br.close();

            if (!ficheroActual.delete()) {
                return;
            }

            // Renombramos el archivo temporal al nombre original
            ficheroTemp.renameTo(ficheroActual);
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    //TODO creo que podemos para borrar un billete borrar el elemento de la lista, borrar el historial y crearlo de nuevo con la lista actualizada
    public void borrarHistorial(){
        String nombreArchivo = "./file/billetes.csv";
        File ficheroActual = new File(nombreArchivo);
        ficheroActual.delete();
    } 
    
}
