/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.gui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema.audizio.bean.Bairro;
import sistema.audizio.bean.Cidade;
import sistema.audizio.bean.Cliente;
import sistema.audizio.bean.Financeiro;
import sistema.audizio.bean.Processo;
import sistema.audizio.bean.Veiculo;
import sistema.audizio.dao.DaoFinanceiro;
/**
 *
 * @author emerson
 */
public class ListarContas extends javax.swing.JDialog {

    /**
     * Creates new form ListarClientes
     */
    DefaultTableModel modeloTabela;
    ArrayList<Processo> processo;
    ArrayList<Cliente> cliente;
    ArrayList<Veiculo> veiculo;
    ArrayList<Bairro> bairro;
    ArrayList<Cidade> cidade;
    public ListarContas(String situacao) {
        initComponents();
        carregarTabela(situacao);
        setModal(true);
        if(situacao.equals("PENDENTE")){
            rbPendente.setSelected(true);
        }else if(situacao.equals("QUITADO")){
            rbQuitado.setSelected(true);
        }else{
            rbTodos.setSelected(true);
        }
    }

    public void carregarTabela(String situacao){
            ArrayList<Financeiro> financas = new DaoFinanceiro().consultarFinancas(situacao);
            // System.out.println("Tamanho do array "+clientes.size());
            modeloTabela = (DefaultTableModel) tbListarContas.getModel();
            for(Financeiro f:financas){
            modeloTabela.addRow(new Object[] {f.getId(), f.getCliente(),f.getProcesso(), f.getVencimento(), f.getValor_total(), f.getSituacao(),f.getData_pagamento()});
            System.out.println(f.getCliente());
            }
            tbListarContas.getTableHeader().setReorderingAllowed(false);
    }
    public void removerLinhas(){
         if (modeloTabela.getRowCount() > 0) {
            for (int i = modeloTabela.getRowCount() - 1; i > -1; i--) {
                modeloTabela.removeRow(i);
            }
        }
    }
    
    private String getData() {
	Calendar cal = new GregorianCalendar();
            int dia = cal.get(Calendar.DATE);
            int mes = cal.get(Calendar.MONTH) + 1;
            int ano = cal.get(Calendar.YEAR);
            int diaSemana = cal.get(Calendar.DAY_OF_WEEK);
            int diaMes = cal.get(Calendar.DAY_OF_MONTH);
            int diaAno = cal.get(Calendar.DAY_OF_YEAR);
            
            String data = String.valueOf(dia+"/"+mes+"/"+ano);
        return data;
 
    }




    
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoRadio = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListarContas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        rbTodos = new javax.swing.JRadioButton();
        rbPendente = new javax.swing.JRadioButton();
        rbQuitado = new javax.swing.JRadioButton();
        btEditar = new javax.swing.JButton();
        btArquivar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbListarContas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CLIENTE", "PROCESSO", "VENCIMENTO", "VALOR TOTAL", "PAGAMENTO", "DATA PAGA."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbListarContas);
        if (tbListarContas.getColumnModel().getColumnCount() > 0) {
            tbListarContas.getColumnModel().getColumn(0).setPreferredWidth(-10);
            tbListarContas.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbListarContas.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbListarContas.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        grupoRadio.add(rbTodos);
        rbTodos.setSelected(true);
        rbTodos.setText("TODOS");
        rbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodosActionPerformed(evt);
            }
        });

        grupoRadio.add(rbPendente);
        rbPendente.setText("PENDENTES");
        rbPendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPendenteActionPerformed(evt);
            }
        });

        grupoRadio.add(rbQuitado);
        rbQuitado.setText("QUITADOS");
        rbQuitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbQuitadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(rbTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbPendente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbQuitado)
                .addGap(65, 65, 65))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTodos)
                    .addComponent(rbPendente)
                    .addComponent(rbQuitado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btEditar.setText("VER/EDITAR");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btArquivar.setText("QUITAR");
        btArquivar.setEnabled(false);
        btArquivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btArquivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btArquivar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 361, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEditar)
                    .addComponent(btArquivar))
                .addGap(5, 5, 5))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbPendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPendenteActionPerformed
        removerLinhas();
        carregarTabela("PENDENTE");
        btArquivar.setEnabled(true);
    }//GEN-LAST:event_rbPendenteActionPerformed

    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
        removerLinhas();
        carregarTabela("");
        btArquivar.setEnabled(false);
    }//GEN-LAST:event_rbTodosActionPerformed

    private void rbQuitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbQuitadoActionPerformed
        removerLinhas();
        carregarTabela("QUITADO");
        btArquivar.setEnabled(false);
    }//GEN-LAST:event_rbQuitadoActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        try {
            String idContas;
            idContas = tbListarContas.getValueAt(tbListarContas.getSelectedRow(),0).toString();
            System.out.println("ID DA CONTA:"+idContas);
       
           new EditarContaReceber(idContas).setVisible(true);
            carregarTabela("");
           
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SELECIONE UMA CONTA PARA VER E/OU EDITAR.");
        }
        
       
    }//GEN-LAST:event_btEditarActionPerformed

    private void btArquivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btArquivarActionPerformed
       String message = "Deseja realmente quitar esta conta?";
       String title = "Confirmação";
       int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
      
       if (reply == JOptionPane.YES_OPTION){
            String idConta;
            idConta = tbListarContas.getValueAt(tbListarContas.getSelectedRow(),0).toString();
            System.out.println("ID DA CONTA:"+idConta);
            DaoFinanceiro dao = new DaoFinanceiro();
            dao.quitarConta(idConta,getData());
            modeloTabela.removeRow(tbListarContas.getSelectedRow());
       
        } 
       
      
    }//GEN-LAST:event_btArquivarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btArquivar;
    private javax.swing.JButton btEditar;
    private javax.swing.ButtonGroup grupoRadio;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbPendente;
    private javax.swing.JRadioButton rbQuitado;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTable tbListarContas;
    // End of variables declaration//GEN-END:variables
}
