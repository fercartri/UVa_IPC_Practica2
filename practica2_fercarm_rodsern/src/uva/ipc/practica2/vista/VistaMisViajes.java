package uva.ipc.practica2.vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;

/**
 * Clase para la interfaz gráfica de la vista de mis viajes
 * @author Fernando Carmona
 * @author Rodrigo Serna
 */
public class VistaMisViajes extends javax.swing.JFrame {
    private final ControladorMisViajes miControlador;
    
    /**
     * Crea la nueva vista de mis viajes
     */
    public VistaMisViajes() {
        initComponents();
        miControlador = new ControladorMisViajes(this);
        cargarHistorial();  
        DialogModificar.setLocationRelativeTo(null);
    }
    
    public void cargarHistorial(){
        ArrayList<String> aux = new ArrayList<>();
        
        listaAntiguos.removeAll();
        aux = miControlador.cargarViajesAntiguos();
        String[] add = new String[aux.size()];
        for(int i = 0; i < add.length; i++){
            add[i] = aux.get(i);
        }
        
        listaAntiguos.setListData(add);
        
        listaFuturos.removeAll();
        aux = miControlador.cargarViajesFuturos();
        add = new String[aux.size()];
        for(int i = 0; i < add.length; i++){
            add[i] = aux.get(i);
        }
        
        listaFuturos.setListData(add);
    }
    
    public String getBilleteSeleccionado(){
        return listaFuturos.getSelectedValue();
    }
    
    public String getFechaSeleccionada(){
        String tokens[] = getBilleteSeleccionado().split(";");
        return tokens[0];
        
    }
    
    public Date getDateSeleccionada(){
        String tokens[] = getBilleteSeleccionado().split(";");
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date fecha = formato.parse(tokens[0]);
            return fecha;
        } catch (ParseException e) {
            // Manejar la excepción si la cadena no puede ser parseada como una fecha
            e.printStackTrace();
            return null;
        }
        
    }

    
    public void setErrorNoBillete(){
        lbError.setText("Debe seleccionar un billete");
    }
    
    public void setDialogRadios(boolean bici, boolean silla, boolean mascota){
        checkBoxBiciDialog.setSelected(bici);
        checkBoxSillaDialog.setSelected(silla);
        checkBoxMascotaDialog.setSelected(mascota);
    }
    
    public void resetError(){
        lbError.setText(" ");
    }
    
    public void setDialogVisible(boolean valor){
        DialogModificar.setVisible(valor);
    }
    
    public boolean[] getDialogOptions(){
        boolean[] opciones = new boolean[3];
        opciones[0] = checkBoxBiciDialog.isSelected();
        opciones[1] = checkBoxSillaDialog.isSelected();
        opciones[2] = checkBoxMascotaDialog.isSelected();
        return opciones;
    }
    
    public String getListaRutasPosiblesString(){
        return lista_rutas_posiblesDialog.getSelectedValue();
    }
    
    public boolean isListaRutasPosiblesDialogSelected(){
        return !lista_rutas_posiblesDialog.isSelectionEmpty();
    }
    
    public void setlbErrorDialogVisible(boolean valor){
        lbErrorDialog.setVisible(valor);
    }
    
    public void cargarRutasDialog(String origen, String destino, boolean findesemana){
        lista_rutas_posiblesDialog.removeAll();
        ArrayList<String> aux = new ArrayList<>();
        aux = miControlador.cargarRutasPosiblesDialog(origen, destino, findesemana);
        String[] add = new String[aux.size()];
        for(int i = 0; i < add.length; i++){
            add[i] = aux.get(i);
        }
        
        lista_rutas_posiblesDialog.setListData(add);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DialogModificar = new javax.swing.JDialog();
        info2 = new javax.swing.JPanel();
        titulo2Dialog = new javax.swing.JLabel();
        subtitulo2Dialog = new javax.swing.JLabel();
        btnConfDialog = new javax.swing.JButton();
        btnCancelDialog = new javax.swing.JButton();
        checkBoxBiciDialog = new javax.swing.JCheckBox();
        checkBoxSillaDialog = new javax.swing.JCheckBox();
        checkBoxMascotaDialog = new javax.swing.JCheckBox();
        lbEquipajeDialog = new javax.swing.JLabel();
        lbBicicletaDialog = new javax.swing.JLabel();
        lbMascotaDialog = new javax.swing.JLabel();
        lbSillaDialog = new javax.swing.JLabel();
        jScrollPane2Dialog = new javax.swing.JScrollPane();
        lista_rutas_posiblesDialog = new javax.swing.JList<>();
        lbErrorDialog = new javax.swing.JLabel();
        panelGlobal = new javax.swing.JPanel();
        pnlListas = new javax.swing.JPanel();
        pnlListaAtiguos = new javax.swing.JPanel();
        lbAntiguos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaAntiguos = new javax.swing.JList<>();
        pnlListaFuturos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbFuturos = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaFuturos = new javax.swing.JList<>();
        pnlError = new javax.swing.JPanel();
        lbError = new javax.swing.JLabel();
        pnlTitulo = new javax.swing.JPanel();
        lblViajes = new javax.swing.JLabel();
        pnlButtons = new javax.swing.JPanel();
        pnlBtnModificar = new javax.swing.JPanel();
        btnDevolver = new javax.swing.JButton();
        btnEquipaje = new javax.swing.JButton();
        pnlBtnVolver = new javax.swing.JPanel();
        btnVolver = new javax.swing.JToggleButton();

        DialogModificar.setTitle("MODIFICAR BILLETE");
        DialogModificar.setBackground(new java.awt.Color(207, 246, 248));
        DialogModificar.setModal(true);
        DialogModificar.setSize(new java.awt.Dimension(600, 750));

        info2.setBackground(new java.awt.Color(207, 246, 248));
        info2.setPreferredSize(new java.awt.Dimension(500, 750));

        titulo2Dialog.setFont(new java.awt.Font("Stencil", 1, 48)); // NOI18N
        titulo2Dialog.setForeground(new java.awt.Color(94, 145, 136));
        titulo2Dialog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo2Dialog.setText("MODIFICAR BILLETE");

        subtitulo2Dialog.setFont(new java.awt.Font("Stencil", 1, 18)); // NOI18N
        subtitulo2Dialog.setForeground(new java.awt.Color(94, 145, 136));
        subtitulo2Dialog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subtitulo2Dialog.setText("tREN");
        subtitulo2Dialog.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        subtitulo2Dialog.setMaximumSize(new java.awt.Dimension(268, 19));
        subtitulo2Dialog.setMinimumSize(new java.awt.Dimension(268, 19));
        subtitulo2Dialog.setPreferredSize(new java.awt.Dimension(268, 19));

        btnConfDialog.setBackground(new java.awt.Color(94, 145, 136));
        btnConfDialog.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnConfDialog.setForeground(new java.awt.Color(255, 255, 255));
        btnConfDialog.setText("CONFIRMAR");
        btnConfDialog.setToolTipText("Siguiente paso");
        btnConfDialog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfDialogActionPerformed(evt);
            }
        });

        btnCancelDialog.setBackground(new java.awt.Color(94, 145, 136));
        btnCancelDialog.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnCancelDialog.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelDialog.setText("CANCELAR");
        btnCancelDialog.setToolTipText("Anterior paso");
        btnCancelDialog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelDialogActionPerformed(evt);
            }
        });

        checkBoxBiciDialog.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        checkBoxBiciDialog.setForeground(new java.awt.Color(94, 145, 136));
        checkBoxBiciDialog.setText("Bicicleta");
        checkBoxBiciDialog.setToolTipText("Marcar si se va a llevar bicicleta");
        checkBoxBiciDialog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkBoxBiciDialog.setMaximumSize(new java.awt.Dimension(598, 516));
        checkBoxBiciDialog.setMinimumSize(new java.awt.Dimension(598, 516));

        checkBoxSillaDialog.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        checkBoxSillaDialog.setForeground(new java.awt.Color(94, 145, 136));
        checkBoxSillaDialog.setText("Silla de ruedas");
        checkBoxSillaDialog.setToolTipText("Marcar si se va a llevar silla de ruedas");
        checkBoxSillaDialog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        checkBoxMascotaDialog.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        checkBoxMascotaDialog.setForeground(new java.awt.Color(94, 145, 136));
        checkBoxMascotaDialog.setText("Mascota");
        checkBoxMascotaDialog.setToolTipText("Marcar si se va a llevar mascota");
        checkBoxMascotaDialog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbEquipajeDialog.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        lbEquipajeDialog.setForeground(new java.awt.Color(94, 145, 136));
        lbEquipajeDialog.setText("Equipaje especial:");

        lbBicicletaDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bicicleta.png"))); // NOI18N
        lbBicicletaDialog.setToolTipText("");

        lbMascotaDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mascota.png"))); // NOI18N

        lbSillaDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/silla.png"))); // NOI18N

        lista_rutas_posiblesDialog.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        lista_rutas_posiblesDialog.setToolTipText("Seleccionar tren");
        lista_rutas_posiblesDialog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lista_rutas_posiblesDialog.setPreferredSize(new java.awt.Dimension(400, 200));
        jScrollPane2Dialog.setViewportView(lista_rutas_posiblesDialog);

        lbErrorDialog.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        lbErrorDialog.setForeground(new java.awt.Color(255, 0, 0));
        lbErrorDialog.setText("Debe seleccionar una hora");

        javax.swing.GroupLayout info2Layout = new javax.swing.GroupLayout(info2);
        info2.setLayout(info2Layout);
        info2Layout.setHorizontalGroup(
            info2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info2Layout.createSequentialGroup()
                .addGroup(info2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(info2Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(info2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(info2Layout.createSequentialGroup()
                                .addComponent(lbMascotaDialog)
                                .addGap(10, 10, 10)
                                .addGroup(info2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkBoxSillaDialog)
                                    .addComponent(checkBoxMascotaDialog)))
                            .addGroup(info2Layout.createSequentialGroup()
                                .addComponent(lbBicicletaDialog)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkBoxBiciDialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbSillaDialog)
                            .addComponent(lbEquipajeDialog)))
                    .addGroup(info2Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(lbErrorDialog))
                    .addGroup(info2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane2Dialog, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(info2Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnCancelDialog)
                        .addGap(105, 105, 105)
                        .addComponent(btnConfDialog))
                    .addGroup(info2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(info2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(titulo2Dialog)
                            .addComponent(subtitulo2Dialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        info2Layout.setVerticalGroup(
            info2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo2Dialog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subtitulo2Dialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2Dialog, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(lbEquipajeDialog)
                .addGap(10, 10, 10)
                .addGroup(info2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(checkBoxBiciDialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBicicletaDialog))
                .addGap(0, 0, 0)
                .addGroup(info2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(checkBoxSillaDialog)
                    .addComponent(lbSillaDialog))
                .addGap(0, 0, 0)
                .addGroup(info2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(checkBoxMascotaDialog)
                    .addComponent(lbMascotaDialog))
                .addGap(45, 45, 45)
                .addComponent(lbErrorDialog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(info2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfDialog)
                    .addComponent(btnCancelDialog))
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout DialogModificarLayout = new javax.swing.GroupLayout(DialogModificar.getContentPane());
        DialogModificar.getContentPane().setLayout(DialogModificarLayout);
        DialogModificarLayout.setHorizontalGroup(
            DialogModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogModificarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(info2, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        DialogModificarLayout.setVerticalGroup(
            DialogModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogModificarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(info2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tren Castilla y León");
        setPreferredSize(new java.awt.Dimension(660, 555));
        setSize(new java.awt.Dimension(660, 555));

        panelGlobal.setBackground(new java.awt.Color(233, 255, 255));
        panelGlobal.setLayout(new java.awt.BorderLayout());

        pnlListas.setBackground(new java.awt.Color(233, 255, 255));
        pnlListas.setMinimumSize(new java.awt.Dimension(400, 100));
        pnlListas.setPreferredSize(new java.awt.Dimension(400, 100));

        pnlListaAtiguos.setBackground(new java.awt.Color(233, 255, 255));
        pnlListaAtiguos.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pnlListaAtiguosAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lbAntiguos.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbAntiguos.setForeground(new java.awt.Color(94, 145, 136));
        lbAntiguos.setText("BILLETES ANTIGUOS:");
        pnlListaAtiguos.add(lbAntiguos);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(300, 80));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(450, 150));

        listaAntiguos.setBackground(new java.awt.Color(204, 255, 255));
        listaAntiguos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaAntiguos.setToolTipText("");
        jScrollPane1.setViewportView(listaAntiguos);

        pnlListaAtiguos.add(jScrollPane1);

        pnlListas.add(pnlListaAtiguos);

        pnlListaFuturos.setBackground(new java.awt.Color(233, 255, 255));
        pnlListaFuturos.setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setBackground(new java.awt.Color(233, 255, 255));

        lbFuturos.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbFuturos.setForeground(new java.awt.Color(94, 145, 136));
        lbFuturos.setText("BILLETES FUTUROS:");
        jPanel1.add(lbFuturos);

        jScrollPane3.setMinimumSize(new java.awt.Dimension(300, 80));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(450, 150));

        listaFuturos.setBackground(new java.awt.Color(204, 255, 255));
        listaFuturos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaFuturos.setToolTipText("");
        jScrollPane3.setViewportView(listaFuturos);

        jPanel1.add(jScrollPane3);

        pnlListaFuturos.add(jPanel1);

        pnlError.setBackground(new java.awt.Color(233, 255, 255));

        lbError.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        lbError.setForeground(new java.awt.Color(255, 0, 0));
        lbError.setText(" ");
        pnlError.add(lbError);

        pnlListaFuturos.add(pnlError);

        pnlListas.add(pnlListaFuturos);

        panelGlobal.add(pnlListas, java.awt.BorderLayout.CENTER);

        pnlTitulo.setBackground(new java.awt.Color(233, 255, 255));
        pnlTitulo.setMinimumSize(new java.awt.Dimension(400, 100));

        lblViajes.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        lblViajes.setForeground(new java.awt.Color(94, 145, 136));
        lblViajes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblViajes.setText("MIS VIAJES");
        pnlTitulo.add(lblViajes);

        panelGlobal.add(pnlTitulo, java.awt.BorderLayout.PAGE_START);

        pnlButtons.setBackground(new java.awt.Color(233, 255, 255));
        pnlButtons.setMinimumSize(new java.awt.Dimension(400, 100));
        pnlButtons.setLayout(new java.awt.GridLayout(2, 0, 0, 15));

        pnlBtnModificar.setBackground(new java.awt.Color(233, 255, 255));
        pnlBtnModificar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 5));

        btnDevolver.setBackground(new java.awt.Color(94, 145, 136));
        btnDevolver.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnDevolver.setForeground(new java.awt.Color(255, 255, 255));
        btnDevolver.setText("DEVOLVER BILLETE");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });
        pnlBtnModificar.add(btnDevolver);

        btnEquipaje.setBackground(new java.awt.Color(94, 145, 136));
        btnEquipaje.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnEquipaje.setForeground(new java.awt.Color(255, 255, 255));
        btnEquipaje.setText("MODIFICAR BILLETE");
        btnEquipaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipajeActionPerformed(evt);
            }
        });
        pnlBtnModificar.add(btnEquipaje);

        pnlButtons.add(pnlBtnModificar);

        pnlBtnVolver.setBackground(new java.awt.Color(233, 255, 255));

        btnVolver.setBackground(new java.awt.Color(94, 145, 136));
        btnVolver.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        pnlBtnVolver.add(btnVolver);

        pnlButtons.add(pnlBtnVolver);

        panelGlobal.add(pnlButtons, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelGlobal, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelGlobal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Eventos-----------------------------------------------------------------------------
    
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        miControlador.procesarBtnVolver();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void pnlListaAtiguosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pnlListaAtiguosAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlListaAtiguosAncestorAdded

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        miControlador.procesarDevolver();
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void btnEquipajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipajeActionPerformed
        miControlador.procesarModificar();
    }//GEN-LAST:event_btnEquipajeActionPerformed

    private void btnConfDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfDialogActionPerformed
        miControlador.procesarBtnConfDialogActionPerformed();
    }//GEN-LAST:event_btnConfDialogActionPerformed

    private void btnCancelDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelDialogActionPerformed
        miControlador.procesarBtnCancelDialogActionPerformed();
    }//GEN-LAST:event_btnCancelDialogActionPerformed
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DialogModificar;
    private javax.swing.JButton btnCancelDialog;
    private javax.swing.JButton btnConfDialog;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnEquipaje;
    private javax.swing.JToggleButton btnVolver;
    private javax.swing.JCheckBox checkBoxBiciDialog;
    private javax.swing.JCheckBox checkBoxMascotaDialog;
    private javax.swing.JCheckBox checkBoxSillaDialog;
    private javax.swing.JPanel info2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2Dialog;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbAntiguos;
    private javax.swing.JLabel lbBicicletaDialog;
    private javax.swing.JLabel lbEquipajeDialog;
    private javax.swing.JLabel lbError;
    private javax.swing.JLabel lbErrorDialog;
    private javax.swing.JLabel lbFuturos;
    private javax.swing.JLabel lbMascotaDialog;
    private javax.swing.JLabel lbSillaDialog;
    private javax.swing.JLabel lblViajes;
    private javax.swing.JList<String> listaAntiguos;
    private javax.swing.JList<String> listaFuturos;
    private javax.swing.JList<String> lista_rutas_posiblesDialog;
    private javax.swing.JPanel panelGlobal;
    private javax.swing.JPanel pnlBtnModificar;
    private javax.swing.JPanel pnlBtnVolver;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlError;
    private javax.swing.JPanel pnlListaAtiguos;
    private javax.swing.JPanel pnlListaFuturos;
    private javax.swing.JPanel pnlListas;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JLabel subtitulo2Dialog;
    private javax.swing.JLabel titulo2Dialog;
    // End of variables declaration//GEN-END:variables
}
