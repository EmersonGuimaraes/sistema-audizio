/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.audizio.gui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import sistema.audizio.bean.Financeiro;
import sistema.audizio.dao.DaoFinanceiro;

/**
 *
 * @author Internet
 * @Editado Emerson Guimarães
 */
public class EditarContaReceber extends javax.swing.JDialog {
    String idProcesso;
    public EditarContaReceber(String id) {
        this.idProcesso = id;
       initComponents();
        setModal(true);
       
        tfValor.setDocument(new LimitadorMoeda());
        tfValorDespesa.setDocument(new LimitadorMoeda());
        tfDesconto.setDocument(new LimitadorMoeda());
        carregaCampos(id);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void carregaCampos(String id){
        ArrayList<Financeiro> financas = new DaoFinanceiro().consultarFinancas(id);
        for(Financeiro f:financas){
            labelCliente.setText(f.getCliente());
            labelProcesso.setText(f.getProcesso());
            
            tfValor.setText(f.getValor());
            tfValorDespesa.setText(f.getValor_despesa());
            tfDesconto.setText(f.getDesconto());
            tfTotal.setText(f.getValor_total());
            tfDescDespesa.setText(f.getDesc_despesa());        
            tfDataVencimento.setText(f.getVencimento());
            comboSituacao.setSelectedItem(f.getSituacao());
        }
    }
    
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
        btEditar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EDITAR CONTA");
        setResizable(false);

        jLabel1.setText("PROCESSO");

        jLabel2.setText("CLIENTE");

        jLabel3.setText("VALOR");

        jLabel4.setText("DESPESAS");

        tfDescDespesa.setColumns(20);
        tfDescDespesa.setRows(5);
        tfDescDespesa.setEnabled(false);
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
        tfDataVencimento.setEnabled(false);

        jLabel9.setText("SITUAÇÃO");

        comboSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PENDENTE", "QUITADO" }));
        comboSituacao.setEnabled(false);
        comboSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSituacaoActionPerformed(evt);
            }
        });

        btCadastrar.setText("SALVAR EDIÇÃO");
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

        tfDesconto.setEnabled(false);

        tfValor.setEnabled(false);

        tfValorDespesa.setEnabled(false);

        btCalcular.setText("CALC");
        btCalcular.setEnabled(false);
        btCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcularActionPerformed(evt);
            }
        });

        btEditar.setText("EDITAR");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btCancelar.setText("CANCELAR");
        btCancelar.setEnabled(false);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
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
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel7)
                                .addGap(171, 171, 171))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btEditar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btCancelar))
                                    .addComponent(btCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelProcesso, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                                    .addComponent(labelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(28, 28, 28))))
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
                    .addComponent(tfTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(btCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btEditar)
                            .addComponent(btCancelar))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
            
            f.setId(Integer.parseInt(idProcesso));
            
            f.setValor(valor);
            f.setValor_despesa(despesa);
            f.setDesconto(desconto);
            f.setValor_total(total);
            f.setDesc_despesa(descDespesa);
            f.setVencimento(data);
            f.setSituacao(situacao);
            
            daoF.editar(f);
            
            tfValor.setDocument(new LimitadorMoeda());
            tfValorDespesa.setDocument(new LimitadorMoeda());
            tfDesconto.setDocument(new LimitadorMoeda());
            carregaCampos(idProcesso);
            
            
       } 
       
        tfDataVencimento.setEnabled(false);
        tfDescDespesa.setEnabled(false);
        tfDesconto.setEnabled(false);
        tfTotal.setEnabled(false);
        tfValor.setEnabled(false);
        tfValorDespesa.setEnabled(false);
        btCadastrar.setEnabled(false);
        btCancelar.setEnabled(false);
        btEditar.setEnabled(true);
        comboSituacao.setEnabled(false);
        btCalcular.setEnabled(false);
        
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void comboSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSituacaoActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        tfDataVencimento.setEnabled(true);
        tfDescDespesa.setEnabled(true);
        tfDesconto.setEnabled(true);
        tfTotal.setEnabled(true);
        tfValor.setEnabled(true);
        tfValorDespesa.setEnabled(true);
        btCancelar.setEnabled(true);
        btEditar.setEnabled(false);
        btCalcular.setEnabled(true);
        comboSituacao.setEnabled(false);
    }//GEN-LAST:event_btEditarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        tfDataVencimento.setEnabled(false);
        tfDescDespesa.setEnabled(false);
        tfDesconto.setEnabled(false);
        tfTotal.setEnabled(false);
        tfValor.setEnabled(false);
        tfValorDespesa.setEnabled(false);
        btCadastrar.setEnabled(false);
        btCancelar.setEnabled(false);
        btEditar.setEnabled(true);
        btCalcular.setEnabled(true);
        comboSituacao.setEnabled(false);
    }//GEN-LAST:event_btCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(EditarContaReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarContaReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarContaReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarContaReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btCalcular;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
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
