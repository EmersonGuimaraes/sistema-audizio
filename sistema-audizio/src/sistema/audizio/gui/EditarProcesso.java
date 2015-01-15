/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.gui;

import sistema.audizio.ultilitarios.RemoveMascara;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import sistema.audizio.bean.Advogado;
import sistema.audizio.bean.Assessoria;
import sistema.audizio.bean.Cliente;
import sistema.audizio.bean.Processo;
import sistema.audizio.bean.Veiculo;
import sistema.audizio.dao.DaoAdvogado;
import sistema.audizio.dao.DaoAssessoria;
import sistema.audizio.dao.DaoCliente;
import sistema.audizio.dao.DaoProcesso;
import sistema.audizio.dao.DaoVeiculo;

/**
 *
 * @author emerson
 */
public class EditarProcesso extends javax.swing.JDialog { 
   
    /**
     * Creates new form CadastroProcesso
     */
    String idProcesso;
    public EditarProcesso(String id) {
        this.idProcesso = id;
        initComponents();
        preencheCampos(idProcesso);
        setModal(true);
        tfCliente.setEditable(false);
        
        tfProcesso.setEditable(false);
        tfDataInicio.setEditable(false);
        tfDataFim.setEditable(false);
        taSituacaoAtual.setEditable(false);
        tfVara.setEditable(false);
        tfAcao.setEditable(false);
        tfComarca.setEditable(false);
        comboSituacao.setEnabled(false);
    }

    
  
    
    public void preencheCampos(String id){
        DaoProcesso daoProcesso = new DaoProcesso();
        ArrayList<Processo> processos = new DaoProcesso().Consultar(id);
        
        for (Processo pro:processos) {
            //Setando dados do processo
            tfProcesso.setText(pro.getProcesso());
            taSituacaoAtual.setText(pro.getSituacao_atual());
            tfVara.setText(pro.getVara());
            tfAcao.setText(pro.getAcao());
            tfComarca.setText(pro.getComarca());
            tfDataInicio.setText(pro.getData_inicio());
            tfDataFim.setText(pro.getData_termino());
            tfCliente.setText(pro.getCliente());
            comboSituacao.setSelectedItem(pro.getSituacao());
           // idAssessoria = Integer.parseInt(pro.getIdAssessoria());
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfProcesso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfAcao = new javax.swing.JTextField();
        btEditar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        tfDataInicio = new javax.swing.JFormattedTextField();
        tfDataFim = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taSituacaoAtual = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        tfVara = new javax.swing.JFormattedTextField();
        tfComarca = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btCancelar1 = new javax.swing.JButton();
        tfCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboSituacao = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Processo");

        jLabel1.setText("PROCESSO");

        jLabel3.setText("DATA INÍCIO");

        jLabel4.setText("DATA TÉRMINO");

        jLabel7.setText("AÇÃO");

        btEditar.setText("EDITAR");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btSalvar.setText("SALVAR");
        btSalvar.setEnabled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        try {
            tfDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tfDataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel16.setText("SITUAÇÃO ATUAL");

        taSituacaoAtual.setColumns(20);
        taSituacaoAtual.setRows(5);
        jScrollPane1.setViewportView(taSituacaoAtual);

        jLabel14.setText("VARA");

        jLabel19.setText("COMARCA");

        btCancelar1.setText("CANCELAR");
        btCancelar1.setEnabled(false);
        btCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar1ActionPerformed(evt);
            }
        });

        tfCliente.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        tfCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setText("SITUAÇÃO");

        comboSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ABERTO", "ARQUIVADO" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfCliente)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(175, 175, 175)
                                .addComponent(jLabel3)
                                .addGap(58, 58, 58)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(161, 161, 161))
                                    .addComponent(tfVara)
                                    .addComponent(jLabel7)
                                    .addComponent(tfAcao)
                                    .addComponent(jLabel19)
                                    .addComponent(tfComarca)
                                    .addComponent(jLabel2)
                                    .addComponent(comboSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfVara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfComarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                        .addComponent(btCancelar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
       
        tfProcesso.setEditable(true);
        tfDataInicio.setEditable(true);
        tfDataFim.setEditable(true);
        taSituacaoAtual.setEditable(true);
        tfVara.setEditable(true);
        tfAcao.setEditable(true);
        tfComarca.setEditable(true);
        comboSituacao.setEnabled(true);
        btCancelar1.setEnabled(true);
        btSalvar.setEnabled(true);
        btEditar.setEnabled(false);
               
    }//GEN-LAST:event_btEditarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
         Processo processo = new Processo();
         DaoProcesso daoProcesso = new DaoProcesso();
         RemoveMascara mask = new RemoveMascara();
         
         //Seta os valores do processo
         processo.setProcesso(tfProcesso.getText());processo.setData_inicio(mask.removeMascara(tfDataInicio.getText()));
         processo.setData_termino(mask.removeMascara(tfDataFim.getText()));
         processo.setAcao(tfAcao.getText());
         processo.setVara(tfVara.getText());
         processo.setComarca(tfComarca.getText());
         processo.setSituacao_atual(taSituacaoAtual.getText());
         processo.setSituacao(comboSituacao.getSelectedItem().toString());
         processo.setIdProcesso(idProcesso);
         
       
         
         
         
        daoProcesso.Editar(processo);
        
        tfProcesso.setEditable(false);
        tfDataInicio.setEditable(false);
        tfDataFim.setEditable(false);
        taSituacaoAtual.setEditable(false);
        tfVara.setEditable(false);
        tfAcao.setEditable(false);
        tfComarca.setEditable(false);
        comboSituacao.setEnabled(false);
        btEditar.setEnabled(true);
        btCancelar1.setEnabled(false);
        btSalvar.setEnabled(false);
        preencheCampos(idProcesso);
        
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar1ActionPerformed
       
        tfProcesso.setEditable(false);
        tfDataInicio.setEditable(false);
        tfDataFim.setEditable(false);
        taSituacaoAtual.setEditable(false);
        tfVara.setEditable(false);
        tfAcao.setEditable(false);
        tfComarca.setEditable(false);
        comboSituacao.setEnabled(false);
        
        btEditar.setEnabled(true);
        btCancelar1.setEnabled(false);
        btSalvar.setEnabled(false);
        preencheCampos(idProcesso);
    }//GEN-LAST:event_btCancelar1ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar1;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox comboSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taSituacaoAtual;
    private javax.swing.JTextField tfAcao;
    private javax.swing.JTextField tfCliente;
    private javax.swing.JTextField tfComarca;
    private javax.swing.JFormattedTextField tfDataFim;
    private javax.swing.JFormattedTextField tfDataInicio;
    private javax.swing.JTextField tfProcesso;
    private javax.swing.JFormattedTextField tfVara;
    // End of variables declaration//GEN-END:variables
}
