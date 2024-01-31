package company.pruebapractica_02.interfazGUI;

public class ScreenAdmin extends javax.swing.JFrame {

    private String usuario;
    private String password;
    
    public ScreenAdmin(String user, String pass) {
        initComponents();
        this.usuario = user;
        this.password = pass;
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        usoRAMProgressBar.addChangeListener((e) -> {
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usoRAMProgressBar = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        usoMinimoDeRam = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        usoDeRam = new javax.swing.JLabel();
        usoMaximoDeRam = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        memoriaRamTotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ramDisponible = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        logOutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MONITOREO DE LA MEMORIA RAM DEL EQUIPO");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("RAM en uso:");

        usoMinimoDeRam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usoMinimoDeRam.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Mínimo de uso de RAM:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Máximo de uso de RAM:");

        usoDeRam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usoDeRam.setText("jLabel3");

        usoMaximoDeRam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usoMaximoDeRam.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Memoria RAM total del equipo:");

        memoriaRamTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        memoriaRamTotal.setText("jLabel3");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("RAM disponible:");

        ramDisponible.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ramDisponible.setText("jLabel3");

        jMenu1.setText("REPORTE");

        jMenuItem2.setText("Generar reporte PDF");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("SALIR");

        logOutMenuItem.setText("Cerrar sesión");
        logOutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(logOutMenuItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(48, 48, 48))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(52, 52, 52))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(102, 102, 102))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(129, 129, 129))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(usoMaximoDeRam)
                            .addComponent(usoMinimoDeRam)
                            .addComponent(ramDisponible)
                            .addComponent(usoDeRam)
                            .addComponent(memoriaRamTotal)))
                    .addComponent(usoRAMProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(usoRAMProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(memoriaRamTotal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usoDeRam))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ramDisponible))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(usoMinimoDeRam))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(usoMaximoDeRam))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        /*TODO: Al pulsar este botón, debemos generar un reporte en formato PDF,
        /que nos muestre los correos que hemos mandado y hemos recogido donde se da
        una alerta del valor de uso de RAM superior a X*/
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void logOutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutMenuItemActionPerformed
        //Cerramos la pantalla actual y abrimos la pantalla de login
        this.dispose();
        ScreenLogin newScreenLogin = new ScreenLogin();
    }//GEN-LAST:event_logOutMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem logOutMenuItem;
    private javax.swing.JLabel memoriaRamTotal;
    private javax.swing.JLabel ramDisponible;
    private javax.swing.JLabel usoDeRam;
    private javax.swing.JLabel usoMaximoDeRam;
    private javax.swing.JLabel usoMinimoDeRam;
    private javax.swing.JProgressBar usoRAMProgressBar;
    // End of variables declaration//GEN-END:variables
}
