package Interface;

import Main.Cliente;
import Main.Servidor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Wz
 */
public class Inicial extends javax.swing.JFrame {

    Cliente cliente;
    Servidor servidor;
    private boolean status = true;

    public Inicial() {
        initComponents();
        cliente = new Cliente(this);
        servidor = new Servidor(this, cliente);
        comecar();
        setIconImage((new ImageIcon(getClass().getResource("mip2pico.png"))).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHome = new javax.swing.JPanel();
        jlLogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBConectar = new javax.swing.JButton();
        jBIdentificar = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();
        jBAtualizar = new javax.swing.JButton();
        jPIP = new javax.swing.JPanel();
        jlSeuIP = new javax.swing.JLabel();
        jtSeuIP = new javax.swing.JLabel();
        jlID = new javax.swing.JLabel();
        jtID = new javax.swing.JLabel();
        jPIP1 = new javax.swing.JPanel();
        jlSeuIP1 = new javax.swing.JLabel();
        jtSucIP = new javax.swing.JLabel();
        jlIDSuc = new javax.swing.JLabel();
        jtIDSuc = new javax.swing.JLabel();
        jPIP2 = new javax.swing.JPanel();
        jlAnt = new javax.swing.JLabel();
        jtAntIP = new javax.swing.JLabel();
        jlIDAnt = new javax.swing.JLabel();
        jtIDAnt = new javax.swing.JLabel();
        jCred = new javax.swing.JLabel();
        jLAvisos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiPeertoPeer");
        setResizable(false);

        jPanelHome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelHome.setMaximumSize(new java.awt.Dimension(900, 576));
        jPanelHome.setPreferredSize(new java.awt.Dimension(900, 576));

        jlLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/mip2p300.png"))); // NOI18N

        jBConectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/conectar.png"))); // NOI18N
        jBConectar.setEnabled(false);
        jBConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConectarActionPerformed(evt);
            }
        });

        jBIdentificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/identificar.png"))); // NOI18N
        jBIdentificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIdentificarActionPerformed(evt);
            }
        });

        jBSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/sair.png"))); // NOI18N
        jBSair.setEnabled(false);
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });

        jBAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/update.png"))); // NOI18N
        jBAtualizar.setEnabled(false);
        jBAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBIdentificar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBIdentificar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jBConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jBAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPIP.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlSeuIP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/seu ip.png"))); // NOI18N

        jtSeuIP.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jtSeuIP.setForeground(new java.awt.Color(51, 51, 51));
        jtSeuIP.setText("192.168.500.1");

        jlID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/iD.png"))); // NOI18N

        jtID.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jtID.setForeground(new java.awt.Color(51, 51, 51));
        jtID.setText("1234567891");

        javax.swing.GroupLayout jPIPLayout = new javax.swing.GroupLayout(jPIP);
        jPIP.setLayout(jPIPLayout);
        jPIPLayout.setHorizontalGroup(
            jPIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPIPLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlSeuIP, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlID, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(jPIPLayout.createSequentialGroup()
                .addGroup(jPIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPIPLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jtID))
                    .addGroup(jPIPLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jtSeuIP)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPIPLayout.setVerticalGroup(
            jPIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPIPLayout.createSequentialGroup()
                .addComponent(jlSeuIP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtSeuIP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlID, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtID)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPIP1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlSeuIP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/ipSucessor.png"))); // NOI18N

        jtSucIP.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jtSucIP.setForeground(new java.awt.Color(51, 51, 51));
        jtSucIP.setText("192.168.0.100");

        jlIDSuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/iD.png"))); // NOI18N

        jtIDSuc.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jtIDSuc.setForeground(new java.awt.Color(51, 51, 51));
        jtIDSuc.setText("1234567891");

        javax.swing.GroupLayout jPIP1Layout = new javax.swing.GroupLayout(jPIP1);
        jPIP1.setLayout(jPIP1Layout);
        jPIP1Layout.setHorizontalGroup(
            jPIP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPIP1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPIP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlSeuIP1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlIDSuc, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(jPIP1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jtIDSuc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPIP1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtSucIP)
                .addGap(33, 33, 33))
        );
        jPIP1Layout.setVerticalGroup(
            jPIP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPIP1Layout.createSequentialGroup()
                .addComponent(jlSeuIP1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtSucIP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlIDSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtIDSuc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPIP2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlAnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/ipAntecessor.png"))); // NOI18N

        jtAntIP.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jtAntIP.setForeground(new java.awt.Color(51, 51, 51));
        jtAntIP.setText("192.168.0.100");

        jlIDAnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/iD.png"))); // NOI18N

        jtIDAnt.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jtIDAnt.setForeground(new java.awt.Color(51, 51, 51));
        jtIDAnt.setText("1234567891");

        javax.swing.GroupLayout jPIP2Layout = new javax.swing.GroupLayout(jPIP2);
        jPIP2.setLayout(jPIP2Layout);
        jPIP2Layout.setHorizontalGroup(
            jPIP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPIP2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPIP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlAnt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlIDAnt, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(jPIP2Layout.createSequentialGroup()
                .addGroup(jPIP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPIP2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jtIDAnt))
                    .addGroup(jPIP2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jtAntIP)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPIP2Layout.setVerticalGroup(
            jPIP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPIP2Layout.createSequentialGroup()
                .addComponent(jlAnt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtAntIP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlIDAnt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtIDAnt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jCred.setForeground(new java.awt.Color(153, 153, 153));
        jCred.setText("por William Lima e Juan Cavalcante");

        jLAvisos.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLAvisos.setText("  ");

        javax.swing.GroupLayout jPanelHomeLayout = new javax.swing.GroupLayout(jPanelHome);
        jPanelHome.setLayout(jPanelHomeLayout);
        jPanelHomeLayout.setHorizontalGroup(
            jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHomeLayout.createSequentialGroup()
                .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHomeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jCred))
                    .addGroup(jPanelHomeLayout.createSequentialGroup()
                        .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelHomeLayout.createSequentialGroup()
                                .addGap(296, 296, 296)
                                .addComponent(jlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelHomeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLAvisos, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelHomeLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jPIP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPIP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanelHomeLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHomeLayout.setVerticalGroup(
            jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPIP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPIP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLAvisos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jCred))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHome, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHome, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comecar() {
        servidor.start();       
        Att();
    }
    private void jBConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConectarActionPerformed
       cliente.setIPServidor(cliente.getSucIpProcuradoString());
       try {
            cliente.join();
        } catch (Exception ex) {
            Logger.getLogger(Inicial.class.getName()).log(Level.SEVERE, null, ex);
            
        }
       jBAtualizar.setEnabled(true);

    }//GEN-LAST:event_jBConectarActionPerformed

    private void jBIdentificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIdentificarActionPerformed
        if(status == true){
            String ipdoNo = JOptionPane.showInputDialog(this, "Digite o endereço IP de um nó que pertence a rede");
            cliente.setIPServidor(ipdoNo);
            cliente.lookup(Integer.parseInt(String.valueOf(cliente.getId())));
            status = false;
        }
        else {
            String iddoNo = JOptionPane.showInputDialog(this, "Digite o ID procurado:");
            cliente.lookup(Integer.parseInt(iddoNo));
        }
               
        
    }//GEN-LAST:event_jBIdentificarActionPerformed

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        cliente.leave();
        jBConectar.setEnabled(false);
        jBSair.setEnabled(false);
        status = true;
    }//GEN-LAST:event_jBSairActionPerformed

    private void jBAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtualizarActionPerformed
        cliente.update();
        jBAtualizar.setEnabled(false);
    }//GEN-LAST:event_jBAtualizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Inicial().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAtualizar;
    private javax.swing.JButton jBConectar;
    private javax.swing.JButton jBIdentificar;
    private javax.swing.JButton jBSair;
    private javax.swing.JLabel jCred;
    private javax.swing.JLabel jLAvisos;
    private javax.swing.JPanel jPIP;
    private javax.swing.JPanel jPIP1;
    private javax.swing.JPanel jPIP2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelHome;
    private javax.swing.JLabel jlAnt;
    private javax.swing.JLabel jlID;
    private javax.swing.JLabel jlIDAnt;
    private javax.swing.JLabel jlIDSuc;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlSeuIP;
    private javax.swing.JLabel jlSeuIP1;
    private javax.swing.JLabel jtAntIP;
    private javax.swing.JLabel jtID;
    private javax.swing.JLabel jtIDAnt;
    private javax.swing.JLabel jtIDSuc;
    private javax.swing.JLabel jtSeuIP;
    private javax.swing.JLabel jtSucIP;
    // End of variables declaration//GEN-END:variables

    //Getters e Setters
    public String getjLAvisos() {
        return jLAvisos.getText();
    }
    public void setjLAvisos(String texto) {
        jLAvisos.setText(texto);
    }

    public void setjBConectar(boolean b) {
        jBConectar.setEnabled(b);
    }

    public void setjBIdentificar(boolean b) {
        jBIdentificar.setEnabled(b);
    }

    public void setjBSair(boolean b) {
        jBSair.setEnabled(b);
    }

    public String getjTSeuIP() {
        return jtSeuIP.getText();
    }

    public void setjTSeuIP(String texto) {
        jtSeuIP.setText(texto);
    }

    public String getjTSucIP() {
        return jtSucIP.getText();
    }

    public void setjTSucIP(String texto) {
        jtSucIP.setText(texto);
    }

    public String getjTAntIP() {
        return jtAntIP.getText();
    }

    public void setjTAntIP(String texto) {
        jtAntIP.setText(texto);
    }

    public String getjTID() {
        return jtID.getText();
    }

    public void setjTID(String texto) {
        jtID.setText(texto);
    }

    public String getjTIDAnt() {
        return jtIDAnt.getText();
    }

    public void setjTIDAnt(String texto) {
        jtIDAnt.setText(texto);
    }

    public String getjTIDSuc() {
        return jtIDSuc.getText();
    }

    public void setjTIDSuc(String texto) {
        jtIDSuc.setText(texto);
    }

    public void Att() {
        setjTSeuIP(cliente.getIPString());
        setjTID(String.valueOf(cliente.getId()));
        setjTSucIP(cliente.getIpSucString());
        setjTIDSuc(String.valueOf(cliente.getIdSuc()));
        setjTAntIP(cliente.getIpAntString());
        setjTIDAnt(String.valueOf(cliente.getIdAnt()));
    }
}
