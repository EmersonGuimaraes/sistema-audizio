/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.audizio.gui;

import javax.swing.JOptionPane;
import sistema.audizio.bean.Financeiro;
import sistema.audizio.dao.DaoFinanceiro;

/**
 *
 * @author Internet
 * @Editado Emerson Guimarães
 */
public class ContaReceber extends javax.swing.JDialog {

    /**
     * Creates new form ContaReceber
     */
    int idCli, idPro;
    String processo, cliente;
    public ContaReceber(String idCliente, String processo, String nomeCliente) {
        this.idCli = Integer.parseInt(idCliente);
        System.out.println("IdCliente: Processado: "+idCli);
        this.processo = processo;
        this.cliente = nomeCliente;
        //this.idPro = Integer.parseInt(idProcesso);
        initComponents();
        setModal(true);
        labelCliente.setText(nomeCliente);
        labelProcesso.setText(processo);
        tfValor.setDocument(new LimitadorMoeda());
        tfValorDespesa.setDocument(new LimitadorMoeda());
        tfDesconto.setDocument(new LimitadorMoeda());
        //tfTotal.setDocument(new LimitadorMoeda());
        tfTotal.setText("000");
        tfValor.setText("000");
        tfValorDespesa.setText("000");
        tfDesconto.setText("000");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void calcularTotal(String valor,String despesa,String desconto){
        double novoValor,novaDespesa,novoDesconto,novoTotal;
        novoValor = Double.parseDouble(valor);
        novaDespesa = Double.parseDouble(despesa);
        novoDesconto = Double.parseDouble(desconto);
        
        novoTotal = ((novoValor+novaDespesa)-novoDesconto);
        System.out.println(novoTotal);
        String totalis = String.valueOf(novoTotal);
        System.out.println(totalis);
        tfTotal.setText(totalis);
       btCadastrar.setEnabled(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfDescDespesa = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfDataVencimento = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        comboSituacao = new javax.swing.JComboBox();
        btCadastrar = new javax.swing.JButton();
        labelProcesso = new javax.swing.JLabel();
        labelCliente = new javax.swing.JLabel();
        tfTotal = new javax.swing.JFormattedTextField();
        tfDesconto = new javax.swing.JFormattedTextField();
        tfValor = new javax.swing.JFormattedTextField();
        tfValorDespesa = new javax.swing.JFormattedTextField();
        btCalcular = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("PROCESSO");

        jLabel2.setText("CLIENTE");

        jLabel3.setText("VALOR");

        jLabel4.setText("DESPESAS");

        tfDescDespesa.setColumns(20);
        tfDescDespesa.setRows(5);
        jScrollPane1.setViewportView(tfDescDespesa);

        jLabel5.setText("VALOR DESPESAS");

        jLabel6.setText("DESCONTOS");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setText("VALOR TOTAL");

        jLabel8.setText("VENCIMENTO");

        try {
            tfDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText("SITUAÇÃO");

        comboSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pendente", "Quitado" }));
        comboSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSituacaoActionPerformed(evt);
            }
        });

        btCadastrar.setText("CADASTRAR CONTA");
        btCadastrar.setEnabled(false);
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        labelProcesso.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelProcesso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelProcesso.setText("00000");
        labelProcesso.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelCliente.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCliente.setText("Teste ");
        labelCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfTotal.setEditable(false);
        tfTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tfTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfTotal.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        btCalcular.setText("CALC");
        btCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel7))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelProcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel6)
                                .addComponent(tfValor)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfValorDespesa)
                                .addComponent(tfDesconto))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tfDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(comboSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(58, 58, 58)
                                            .addComponent(jLabel9)))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(btCadastrar))))))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfValorDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfDataVencimento, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(comboSituacao)
                    .addComponent(tfDesconto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTotal)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcularActionPerformed
        calcularTotal(tfValor.getText(), tfValorDespesa.getText(), tfDesconto.getText());
    }//GEN-LAST:event_btCalcularActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
       String message = "DESEJA REALMENTE CADASTRAR ESSA CONTA?";
       int reply = JOptionPane.showConfirmDialog(null, message, "Confirmação", JOptionPane.YES_NO_OPTION);
       if (reply == JOptionPane.YES_OPTION){
           RemoveMascara mask = new RemoveMascara();
           Financeiro f = new Financeiro();
           DaoFinanceiro daoF = new DaoFinanceiro();
           
           String valor,despesa,descDespesa,desconto,total = null,data,situacao;
         
           
            valor = mask.removeMascara(tfValor.getText());
            despesa = mask.removeMascara(tfValorDespesa.getText());
            desconto = mask.removeMascara(tfDesconto.getText());
            data = mask.removeMascara(tfDataVencimento.getText());
            descDespesa = tfDescDespesa.getText();
            situacao = String.valueOf(comboSituacao.getSelectedItem());
            total = tfTotal.getText();
            
            System.out.println("IdCli: +"+idCli);
            f.setId_cliente(idCli);
            f.setProcesso(processo);
            f.setCliente(cliente);
            f.setValor(valor);
            f.setValor_despesa(despesa);
            f.setDesconto(desconto);
            f.setValor_total(total);
            f.setDesc_despesa(descDespesa);
            f.setVencimento(data);
            f.setSituacao(situacao);
            
            daoF.cadastrar(f);
            
            dispose();
            
       } 
        
        
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void comboSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSituacaoActionPerformed

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
            java.util.logging.Logger.getLogger(ContaReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContaReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContaReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContaReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btCalcular;
    private javax.swing.JComboBox comboSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelProcesso;
    private javax.swing.JFormattedTextField tfDataVencimento;
    private javax.swing.JTextArea tfDescDespesa;
    private javax.swing.JFormattedTextField tfDesconto;
    private javax.swing.JFormattedTextField tfTotal;
    private javax.swing.JFormattedTextField tfValor;
    private javax.swing.JFormattedTextField tfValorDespesa;
    // End of variables declaration//GEN-END:variables
}
