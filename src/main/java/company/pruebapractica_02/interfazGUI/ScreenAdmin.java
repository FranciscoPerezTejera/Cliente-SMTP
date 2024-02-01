package company.pruebapractica_02.interfazGUI;

import company.pruebapractica_02.operaciones.GetEmailOperation;
import company.pruebapractica_02.operaciones.SendEmailOperation;
import company.pruebapractica_02.utils.Utiles;
import java.awt.Color;
import java.io.IOException;
import java.util.Date;
import javax.mail.MessagingException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;

public class ScreenAdmin extends javax.swing.JFrame {

    private final String USER = "tejeraperezfrancisco@gmail.com";
    private final String TOKEN = "frtfmywbyhlododz";
    private final String ASUNTO = "ALERTA DE RAM";
    private final int LIMITE = 50;

    private String usuario;
    private String password;
    private Utiles utilidades;
    private long totalMemory;
    private long availableMemory;
    private long usedMemory;
    private double percentageUsed;
    private double valorMinimo;
    private double valorMaximo;
    private boolean inicializado;
    private SendEmailOperation sendEmailOperations;
    private GetEmailOperation getEmailOperations;
    private StringBuilder mensaje;
    private Date fecha;

    public ScreenAdmin(String user, String pass) {
        initComponents();
        this.usuario = user;
        this.password = pass;
        this.inicializado = false;
        this.sendEmailOperations = new SendEmailOperation();
        this.getEmailOperations = new GetEmailOperation(user, pass, ASUNTO);
        this.fecha = new Date();
        this.utilidades = new Utiles();
        mensaje = new StringBuilder(fecha.toString() + "\nLa memoria RAM ha superado el 60% en su ordenador y "
                + "esto es un mensaje automatizado para avisarle de dicho evento.");
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        usoRAMProgressBar.setMinimum(0);
        usoRAMProgressBar.setMaximum(100);
        usoRAMProgressBar.setBackground(Color.GREEN);
        usoRAMProgressBar.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                if (usoRAMProgressBar.getValue() >= 60) {
                    usoRAMProgressBar.setBackground(Color.RED);
                } else if (usoRAMProgressBar.getValue() >= 50) {
                    usoRAMProgressBar.setBackground(Color.ORANGE);
                } else {
                    usoRAMProgressBar.setBackground(Color.GREEN);
                }
            }
        });

        actualizarInformacion(inicializado);

        Thread hiloDeMemoria = new Thread(() -> {

            while (true) {

                memoriaRamTotal.setText(utilidades.formatBytes(totalMemory));
                usoDeRam.setText(utilidades.formatBytes(usedMemory));
                ramDisponible.setText(utilidades.formatBytes(availableMemory));
                porcentajeRam.setText(utilidades.formatPercentage(percentageUsed));
                usoRAMProgressBar.setValue((int) percentageUsed);
                usoMinimoDeRam.setText(utilidades.formatPercentage(valorMinimo));
                usoMaximoDeRam.setText(utilidades.formatPercentage(valorMaximo));

                if (percentageUsed > LIMITE) {

                    mensaje.append("\n ESTADÍSTICAS DE LA MEMORIA\n");
                    mensaje.append("\nMemoria total de su equipo: " + utilidades.formatBytes(totalMemory));
                    mensaje.append("\nMemoria en uso: " + utilidades.formatBytes(usedMemory));
                    mensaje.append("\nPorcentaje de memoria en el momento del mensaje: " + utilidades.formatPercentage(percentageUsed));

                    try {

                        sendEmailOperations.sendTextMessage(USER,
                                USER,
                                ASUNTO,
                                mensaje.toString(),
                                USER,
                                TOKEN);

                        getEmailOperations.getEmailsAndSave(user, password, ASUNTO);

                    } catch (MessagingException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    mensaje = new StringBuilder(fecha.toString() + "\nLa memoria RAM ha superado el 60% en su ordenador y "
                            + "esto es un mensaje automatizado para avisarle de dicho evento.");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                actualizarInformacion(inicializado);
            }
        });
        hiloDeMemoria.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usoRAMProgressBar = new javax.swing.JProgressBar();
        usoMinimoDeRam = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        usoMaximoDeRam = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ramDisponible = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        usoDeRam = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        memoriaRamTotal = new javax.swing.JLabel();
        porcentajeRam = new javax.swing.JLabel();
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

        usoMinimoDeRam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usoMinimoDeRam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usoMinimoDeRam.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Mínimo de uso de RAM:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Máximo de uso de RAM:");

        usoMaximoDeRam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usoMaximoDeRam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usoMaximoDeRam.setText("jLabel3");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("RAM disponible:");

        ramDisponible.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ramDisponible.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ramDisponible.setText("jLabel3");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Uso de la memoria RAM:");

        usoDeRam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usoDeRam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usoDeRam.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Memoria RAM total del equipo:");

        memoriaRamTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        memoriaRamTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        memoriaRamTotal.setText("jLabel3");

        porcentajeRam.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        porcentajeRam.setText("jLabel2");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel5)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(4, 4, 4)))
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(usoRAMProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(porcentajeRam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usoMinimoDeRam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usoDeRam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ramDisponible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(memoriaRamTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usoMaximoDeRam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usoRAMProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(porcentajeRam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memoriaRamTotal)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
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

        usoMinimoDeRam.getAccessibleContext().setAccessibleName("4");
        usoMaximoDeRam.getAccessibleContext().setAccessibleName("5");
        ramDisponible.getAccessibleContext().setAccessibleName("3");
        usoDeRam.getAccessibleContext().setAccessibleName("2");
        memoriaRamTotal.getAccessibleContext().setAccessibleName("1");
        porcentajeRam.getAccessibleContext().setAccessibleName("6");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        utilidades.generarReporteDeCorreos();

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void logOutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutMenuItemActionPerformed
        //Cerramos la pantalla actual y abrimos la pantalla de login
        this.dispose();
        ScreenLogin newScreenLogin = new ScreenLogin();
    }//GEN-LAST:event_logOutMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem logOutMenuItem;
    private javax.swing.JLabel memoriaRamTotal;
    private javax.swing.JLabel porcentajeRam;
    private javax.swing.JLabel ramDisponible;
    private javax.swing.JLabel usoDeRam;
    private javax.swing.JLabel usoMaximoDeRam;
    private javax.swing.JLabel usoMinimoDeRam;
    private javax.swing.JProgressBar usoRAMProgressBar;
    // End of variables declaration//GEN-END:variables

    private void actualizarInformacion(boolean ini) {

        SystemInfo systemInfo = new SystemInfo();
        GlobalMemory memory = systemInfo.getHardware().getMemory();

        totalMemory = memory.getTotal();
        availableMemory = memory.getAvailable();
        usedMemory = totalMemory - availableMemory;

        percentageUsed = (usedMemory * 100.0) / totalMemory;

        if (!inicializado) {
            valorMinimo = percentageUsed;
            valorMaximo = percentageUsed;
            inicializado = true;

        } else {
            if (valorMinimo > percentageUsed) {
                valorMinimo = percentageUsed;
            }
            if (valorMaximo < percentageUsed) {
                valorMaximo = percentageUsed;
            }
        }

    }
}
