package uva.ipc.practica2.vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import uva.ipc.practica2.Main;
import uva.ipc.practica2.modelo.Modelo;

/**
 * Clase para el controlador de la vista de comprar billete
 * @author Fernando Carmona
 * @author Rodrigo Serna
 */
public class ControladorComprarBillete {
    private VistaComprarBillete miVista;
    private Modelo miModelo;
    private String datosBillete;
   
    
    /**
     * Inicializar la vista y el modelo a partir de una vista proporcionada
     * @param vista un objeto vista cualquiera
     */
    public ControladorComprarBillete(VistaComprarBillete vista) {
        miVista = vista;
        miModelo = uva.ipc.practica2.Main.getModelo();
        miModelo.resetTodo();
    }
    
    /**
     * Consultar todas las estaciones posibles del sistema
     * @return estaciones un ArrayList<String> con el nombre de las estaciones
     */
    public ArrayList<String> cargarEstaciones(){
        ArrayList<String> estaciones = new ArrayList<>();
        estaciones = miModelo.getEstaciones();
        return estaciones;
    }
    
    /**
     * Consultar todas las rutas posibles del sistema para un origen y destino dados en una fecha determinada
     * @param origen la estación de origen
     * @param destino la estación de destino
     * @param findesemana true si el billete es para un día de fin de semana y false si no lo es
     * @return rutas un ArrayList<String> con las rutas posibles
     */
    public ArrayList<String> cargarRutasPosibles(String origen, String destino, boolean findesemana){
        ArrayList<String> rutas_aux = new ArrayList<>();
        ArrayList<String> rutas = new ArrayList<>();
        
        rutas_aux = miModelo.getRutas();
        
        for(int i = 0; i < rutas_aux.size(); i++){
            String linea = rutas_aux.get(i);
            String[] token = linea.split(";");
            String ruta = token[0];
            String orig = token[1];
            String dest = token[2];
            String tiempo = token[3];
            String precio = token[4];
            String h_semana = token[5];
            String h_finde = token[6];
            
            LocalTime ahora = LocalTime.now();  //Guardar la hora actual
            Date hoy = new Date();
            if(orig.equals(origen) && dest.equals(destino)){
                if(findesemana){   //Es fin de semana
                    String[] pos_h = h_finde.split(",");
                    for(int j = 0; j < pos_h.length; j++){
                        if(hoySeleccionado(miVista.getFecha())){    //La fecha seleccionada es hoy
                            if(ahora.isBefore(LocalTime.parse(pos_h[j], DateTimeFormatter.ofPattern("HH:mm")))){
                                String l = ruta + " " + pos_h[j] + " " + tiempo + "min " + precio + " €";                                
                                rutas.add(l);
                            }
                        }else{
                            String l = ruta + " " + pos_h[j] + " " + tiempo + "min " + precio + " €";
                            rutas.add(l);
                        }
                    }
                }
                else{
                    String[] pos_h = h_semana.split(",");
                    for(int j = 0; j < pos_h.length; j++){
                        if(hoySeleccionado(miVista.getFecha()) && ahora.isBefore(LocalTime.parse(pos_h[j], DateTimeFormatter.ofPattern("HH:mm")))){
                            String l = ruta + " " + pos_h[j] + " " + tiempo + "min " + precio + " €";
                            rutas.add(l);
                        }else if(hoy.before(miVista.getDate())){
                            String l = ruta + " " + pos_h[j] + " " + tiempo + "min " + precio + " €";
                            rutas.add(l);
                        }
                    }
                }
            }
        }
            
        return rutas;
    }
    
    /**
     * Resetea los valores al estado inicial
     */
    public void resetTodo(){
        miModelo.resetTodo();
    }

    /**
     * Comprueba si existe la ruta entre dos estaciones
     * @param o la estación de origen
     * @param d la estación de destino
     * @return true si existe una ruta y false si no existe
     */
    public boolean compEstaciones(String o, String d){
        ArrayList<String> rutas = new ArrayList<>();
        
        rutas = miModelo.getRutas();
        
        for(int i = 0; i < rutas.size(); i++){
            String linea = rutas.get(i);
            String[] token = linea.split(";");
            String orig = token[1];
            String dest = token[2];
            if (orig.equals(o) && dest.equals(d)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Comprueba si la fecha seleccionada por el usuario es válida
     * @return true si es válida y false en caso contrario
     */
    public boolean compFecha(String fApp){
        if(fApp == null){
            return false;
        }
        
        String fActual;
        String dia, mes, anno;
        
        LocalDate hoy = LocalDate.now();
        int d = hoy.getDayOfMonth();
        int m = hoy.getMonthValue();
        int a = hoy.getYear();
                
        if(d < 10){
            dia = "0" + d;
        }
        else{
            dia = "" + d;
        }
        
        if(m < 10){
            mes = "0" + m;
        }
        else{
            mes = "" + m;
        }      
        
        fActual = dia + "-" + mes + "-" + a;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date fechaActual = sdf.parse(fActual);
            Date fechaApp = sdf.parse(fApp);

            if (fechaApp.compareTo(fechaActual) >= 0) {
                return true;
            }
            else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * Consulta si la fecha seleccionada para el viaje es el mismo día que se hace la compra
     * @return true si es el mismo día y false en caso contrario
     */
    public boolean hoySeleccionado(String fApp){
        String fActual;
        String dia, mes, anno;
        
        LocalDate hoy = LocalDate.now();
        int d = hoy.getDayOfMonth();
        int m = hoy.getMonthValue();
        int a = hoy.getYear();
                
        if(d < 10){
            dia = "0" + d;
        }
        else{
            dia = "" + d;
        }
        
        if(m < 10){
            mes = "0" + m;
        }
        else{
            mes = "" + m;
        }      
        
        fActual = dia + "-" + mes + "-" + a;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date fechaActual = sdf.parse(fActual);
            Date fechaApp = sdf.parse(fApp);

            if (fechaApp.equals(fechaActual)) {
                return true;
            }
            else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * Comprueba si la operación de pago por tarjeta de crédito es correcta
     * @return true si es correcta y false en caso contrario
     */
    public boolean comprobarPagoCredito(char[] p){
        String s = "";
        
        if(!miModelo.getPagadoCredito()){
            return false;
        }
        
        for(int i = 0; i < p.length; i++){
            s += p[i];
        }
        
        return s.equals("1234");
    }
    
    /**
     * Avisa al modelo de que la tarjeta de crédito ha sido pasada
     */
    public void tarjetaCreditoPasada(){
        miModelo.tarjetaCreditoPasada();
    }
    
    /**
     * Se procesa el pago, si es posible, mediante la tarjeta de renfe
     * @param precio un número mayor o igual que cero
     * @return true si el pago se ha llevado a cabo con éxito y false en caso contrario
     */
    public boolean tarjetaRenfePasada(double precio){
        if(precio <= miModelo.getSaldo()){  //Se puede procesar el pago
            miModelo.tarjetaRenfePasada();
            miModelo.setSaldo(miModelo.getSaldo()-precio);
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Almacena el parámetro billete en una variable local para más tarde enviarla al historial
     * @param billete un String con datos del billete
     */
    public void prepararDatosHistorial(String billete){
        datosBillete = billete;
    }
    
    /**
     * Mete el billete almacenado localmente en el historial
     */
    public void meterBilleteHistorial(){
        miModelo.meterBilleteEnHistorial(datosBillete);
    }
    
    //PROCESAR EVENTOS------------------------------------------------------------------------------------
    /**
     * Comprueba que la ruta seleccionada existe, si no, devuelve error
     * Comprueba que la fecha seleccionada es válida, si no, devuelve error
     * Almacena los datos introducidos en el modelo y pone visible solo el siguiente paso
     */
    public void procesarBtnSigP1ActionPerformed(){
        if(!compEstaciones(miVista.getOrigen(), miVista.getDestino())){    //Ruta no valida\\
            miVista.setTextoLbError1("Ruta no existente");
            miVista.setVisibilidadLbError1(true);
        }
        else if(!compFecha(miVista.getFecha())){  //Ruta correcta pero fecha no valida
            miVista.setTextoLbError1("Fecha no válida");
            miVista.setVisibilidadLbError1(true);
            
        }
        else{   //Ambas son correctas
            miVista.setVisibilidadLbError1(false);
            miVista. cargarRutasPosibles(miVista.getOrigen(), miVista.getDestino(), miVista.getFinDeSemana());
            miModelo.guardarFecha(miVista.getFecha());
            miModelo.guardarOrigen(miVista.getOrigen());
            miModelo.guardarDestino(miVista.getDestino());

            miVista.setVisible(0,1,0);       
            miVista.setNoVisible(1,0,1);
        }
    }
    
    /**
     * Comprueba que hay una ruta seleccionada, si no, devuelve error
     * Almacena los datos introducidos en el modelo y pone visible solo el siguiente paso
     */
    public void procesarBtnSigP2ActionPerformed(){
        if(miVista.isListaRutasPosiblesSelected()){   //Hay algún elemento seleccionado
            int indice = miVista.getListaRutasPosiblesIndex();
            String datosBillete = miVista.getListaRutasPosiblesString();
            prepararDatosHistorial(datosBillete);
            miVista.setRadioButtonCredito(false);
            miVista.setRadioButtonRenfe(false);
            miVista.setVisible(0,0,1);
            miVista.setNoVisible(1,1,0);
            miModelo.guardarRadios(miVista.getBicicleta(), miVista.getSilla(), miVista.getMascota());
        }
        else{   //No hay elementos seleccionados
             miVista.setVisibilidadLbError2(true);
        }    
    }
    
    /**
     * Pone visible solo el paso anterior
     */
    public void procesarBtnAntP2ActionPerformed(){
        miVista.setVisible(1,0,0);
        miVista.setNoVisible(0,1,1);
    }
            
    /**
     * Activa este botón y hace visibles los pasos del mismo, 
     * en caso de que el otro botón estuviera activado, lo desactiva y oculta sus pasos
     */
    public void procesarRadioBtnRenfeActionPerformed(){
        resetTodo();    
        miVista.setVisibilidadLbError3(false);
        if(miVista.getRadioButtonCredito()){
            miVista.setRadioButtonCredito(false);
        }
        miVista.setRadioButtonRenfe(true);
        miVista.setVisibilidadLbTarjetaRenfe(true);
        miVista.setVisibilidadLbMantenerRenfe(true);
        miVista.setVisibilidadLbTarjetaCredito(false);
        miVista.setVisibilidadLbMantenerCredito(false);
        miVista.setVisibilidadLbPin(false);
        miVista.setVisibilidadPin(false);
        miVista.setVisibilidadButtonPin(false);
    }
    
    /**
     * Activa este botón y hace visibles los pasos del mismo, 
     * en caso de que el otro botón estuviera activado, lo desactiva y oculta sus pasos
     */
    public void procesarRadioBtnCreditoActionPerformed(){
        resetTodo();
        miVista.setVisibilidadLbError3(false);
        if(miVista.getRadioButtonRenfe()){
              miVista.setRadioButtonRenfe(false);
        }
        miVista.setRadioButtonCredito(true);
        miVista.setVisibilidadLbTarjetaRenfe(false);
        miVista.setVisibilidadLbMantenerRenfe(false);
        miVista.setVisibilidadLbTarjetaCredito(true);
        miVista.setVisibilidadLbMantenerCredito(true);
        miVista.setVisibilidadLbPin(true);
        miVista.setVisibilidadPin(true);
        miVista.setVisibilidadButtonPin(true);
    }
    
    /**
     * Pone visible solo el paso anterior
     */
    public void procesarBtnAntP3ActionPerformed(){
        miVista.setVisible(0,1,0);
        miVista.setNoVisible(1,0,1);
    }
    
    /**
     * Intercambia el origen y el destino introducidos entre sí
     */
    public void procesarBtnIntercambioActionPerformed(){
        int origen = miVista.getIndexOrigen();
        int destino = miVista.getIndexDestino();
        miVista.setIndexDestino(origen);
        miVista.setIndexOrigen(destino);
    }
    
    /**
     * Comprueba si el pin introducido por la tarjeta es correcto y si ha pasado la tarjeta 2 segundos, si no, devuelve error
     * En caso correcto, pone visible el menú de pago correcto y mete el billete en el historial
     */
    public void procesarBtnPinActionPerformed(){
        if(comprobarPagoCredito(miModelo.getPin())){   //Se ha pagado con tarjeta de crédito y el PIN es correcto
            miVista.setVisibilidadLbError3(false);
            miVista.setVisibilidadPagoCorrecto(true);
            meterBilleteHistorial();
        }
        else{
            miVista.setPinText("");
            miVista.setTextoLbError3("Error al procesar el pago");
            miVista.setVisibilidadLbError3(true);
        }
    }
    
    /**
     * Oculta el menú de pago correcto y vuelve a poner visible el paso 1 para la compra de un nuevo billete
     */
    public void procesarBtnBilleteActionPerformed(){
        miVista.resetTodo();
        miVista.setVisible(1,0,0);
        miVista.setNoVisible(0,1,1);
        miVista.disponerPagoCorrecto();
    }
    
    /**
     * Oculta el menú de pago correcto y el menú de los pasos y vuelve a la pantalla del menú principal
     */
    public void procesarBtnSalirActionPerformed(){
        miVista.disponerPagoCorrecto();
        Main.getGestorVistas().mostrarVistaMenuPrincipal();
    }
    
    /**
     * Oculta los pasos y vuelve a la pantalla del menú principal
     */
    public void procesarCancelar(){
        Main.getGestorVistas().mostrarVistaMenuPrincipal();
    }
    
    /**
     * Inicia el timer de la tarjeta de renfe
     */
    public void procesarLbTarjetaRenfeMouseEntered(){
        miVista.empezarTimerRenfe();
    }
    
    /**
     * Para el timer de la tarjeta renfe
     */
    public void procesarLbTarjetaRenfeMouseExited(){
        miVista.pararTimerRenfe();
    }
    
    /**
     * Comprueba que el saldo es suficiente para efectuar la compra del billete, si no lo es, devuelve error
     * En caso de que sí lo sea actualiza el saldo de la tarjeta y mete el billete en el historial poniendo visible el menú de pago correcto
     */
    public void procesarTimerRenfeActionPerformed(){
         if(tarjetaRenfePasada(miVista.getPrecio())){
                meterBilleteHistorial();
                miVista.setVisibilidadLbError2(false);
                miVista.setVisibilidadPagoCorrecto(true);
            }
            else{
                miVista.setTextoLbError2("Saldo insuficiente");
                miVista.setVisibilidadLbError2(true);
            }
    }
    
}
