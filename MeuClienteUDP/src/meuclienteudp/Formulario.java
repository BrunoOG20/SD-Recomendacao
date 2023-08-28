package meuclienteudp;

import javax.swing.JOptionPane;

public class Formulario extends javax.swing.JFrame {
    
    public Formulario() {
        initComponents();
        
        MeuClienteUDP cliente = new MeuClienteUDP();
        
        txtServidor.setText(cliente.getNomeDNS());
        txtUsuario.setText(JOptionPane.showInputDialog(null, "Informe seu identificador para o chat:").toUpperCase());
        jpnAvaliar.setVisible(false);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtServidor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnSolicitarFilme = new javax.swing.JButton();
        jpnAvaliar = new javax.swing.JPanel();
        numNota = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        txtFilme = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnLstFilmes = new javax.swing.JButton();
        btnRecomendar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Servidor");

        txtServidor.setEnabled(false);

        jLabel2.setText("Usuario");

        jLabel4.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        jLabel4.setText("Avaliar Filmes");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        btnSolicitarFilme.setText("Solicitar Filme");
        btnSolicitarFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarFilmeActionPerformed(evt);
            }
        });

        jpnAvaliar.setBorder(javax.swing.BorderFactory.createTitledBorder("Avaliar Filme"));

        numNota.setModel(new javax.swing.SpinnerNumberModel(1, 1, 3, 1));

        jLabel3.setText("Nota:");

        btnEnviar.setText("Avaliar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        txtFilme.setEnabled(false);

        jLabel5.setText("Filme");

        javax.swing.GroupLayout jpnAvaliarLayout = new javax.swing.GroupLayout(jpnAvaliar);
        jpnAvaliar.setLayout(jpnAvaliarLayout);
        jpnAvaliarLayout.setHorizontalGroup(
            jpnAvaliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnAvaliarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnAvaliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnAvaliarLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(numNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEnviar))
                    .addGroup(jpnAvaliarLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtFilme)))
                .addGap(14, 14, 14))
        );
        jpnAvaliarLayout.setVerticalGroup(
            jpnAvaliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnAvaliarLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jpnAvaliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnAvaliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnEnviar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btnLstFilmes.setText("Listar Filmes");
        btnLstFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLstFilmesActionPerformed(evt);
            }
        });

        btnRecomendar.setText("Recomendacao De Filme");
        btnRecomendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecomendarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(121, 121, 121))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jpnAvaliar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addComponent(txtServidor)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLstFilmes, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSolicitarFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRecomendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSolicitarFilme)
                    .addComponent(btnLstFilmes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecomendar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnAvaliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        String nota = numNota.getValue().toString();
        String msg = "";
        
        msg = "2;" + txtUsuario.getText().toUpperCase().trim() + ";" + txtFilme.getText().toUpperCase().trim() + ";" + nota;
        
        MeuClienteUDP cliente = new MeuClienteUDP();
        String resposta = cliente.enviarMensagem(msg);
        
        jTextArea1.setText(resposta);
        
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnSolicitarFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarFilmeActionPerformed
        String msg = "";
        
        msg = "1;" + txtUsuario.getText().toUpperCase();
        
        MeuClienteUDP cliente = new MeuClienteUDP();
        String resposta = cliente.enviarMensagem(msg);
        
        jpnAvaliar.setVisible(true);
        
        txtFilme.setText(resposta);
    }//GEN-LAST:event_btnSolicitarFilmeActionPerformed

    private void btnLstFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLstFilmesActionPerformed
        String msg = "";
        
        msg = "4;" + txtUsuario.getText().toUpperCase();
        
        MeuClienteUDP cliente = new MeuClienteUDP();
        String resposta = cliente.enviarMensagem(msg);
        
        jTextArea1.setText(resposta);
    }//GEN-LAST:event_btnLstFilmesActionPerformed

    private void btnRecomendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecomendarActionPerformed
        String msg = "";
        
        msg = "3;" + txtUsuario.getText().toUpperCase();
        
        MeuClienteUDP cliente = new MeuClienteUDP();
        String resposta = cliente.enviarMensagem(msg);
        
        jTextArea1.setText(resposta);
    }//GEN-LAST:event_btnRecomendarActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnLstFilmes;
    private javax.swing.JButton btnRecomendar;
    private javax.swing.JButton btnSolicitarFilme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel jpnAvaliar;
    private javax.swing.JSpinner numNota;
    private javax.swing.JTextField txtFilme;
    private javax.swing.JTextField txtServidor;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
