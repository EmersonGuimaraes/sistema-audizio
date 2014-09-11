/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.gui;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import sistema.audizio.bean.Cliente;
import sistema.audizio.bean.Processo;
import sistema.audizio.dao.DaoCliente;
import sistema.audizio.dao.DaoProcesso;

/**
 *
 * @author emerson
 */
public class ListarProcessos extends javax.swing.JFrame {

    /**
     * Creates new form ListarClientes
     */
    DefaultTableModel modeloTabela;
    public ListarProcessos(String situacao) {
        initComponents();
        carregarTabela(situacao);
        if(situacao.equals("aberto")){
            rbAberto.setSelected(true);
        }else if(situacao.equals("arquivado")){
            rbArquivados.setSelected(true);
        }else{
            rbTodos.setSelected(true);
        }
    }

    public void carregarTabela(String situacao){
                 tbListarProcessos.updateUI();
                DaoProcesso dao = new DaoProcesso();
                ArrayList<Processo> processos = new ArrayList();  
                processos = dao.Consultar(situacao);
                // System.out.println("Tamanho do array "+clientes.size());
                modeloTabela = (DefaultTableModel) tbListarProcessos.getModel();
                for(Processo pro:processos){
                    modeloTabela.addRow(new Object[] {pro.getIdProcesso(), pro.getCliente(),pro.getProcesso(), pro.getSituacao()});
                }
      
    }
    public void removerLinhas(){
         if (modeloTabela.getRowCount() > 0) {
            for (int i = modeloTabela.getRowCount() - 1; i > -1; i--) {
                modeloTabela.removeRow(i);
            }
        }
    }
    
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoRadio = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListarProcessos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        rbTodos = new javax.swing.JRadioButton();
        rbAberto = new javax.swing.JRadioButton();
        rbArquivados = new javax.swing.JRadioButton();
        btEditar = new javax.swing.JButton();
        btArquivar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("NOVO PROCESSO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tbListarProcessos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CLIENTE", "PROCESSO", "SITUAÇÃO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbListarProcessos);
        if (tbListarProcessos.getColumnModel().getColumnCount() > 0) {
            tbListarProcessos.getColumnModel().getColumn(0).setPreferredWidth(5);
            tbListarProcessos.getColumnModel().getColumn(1).setPreferredWidth(80);
            tbListarProcessos.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbListarProcessos.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        jPanel2.setBorder(null);

        grupoRadio.add(rbTodos);
        rbTodos.setSelected(true);
        rbTodos.setText("TODOS");
        rbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodosActionPerformed(evt);
            }
        });

        grupoRadio.add(rbAberto);
        rbAberto.setText("EM ABERTO");
        rbAberto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAbertoActionPerformed(evt);
            }
        });

        grupoRadio.add(rbArquivados);
        rbArquivados.setText("ARQUIVADOS");
        rbArquivados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbArquivadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbAberto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbArquivados)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTodos)
                    .addComponent(rbAberto)
                    .addComponent(rbArquivados))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btEditar.setText("VER/EDITAR");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btArquivar.setText("ARQUIVAR");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btArquivar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEditar)
                    .addComponent(btArquivar))
                .addGap(5, 5, 5))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new CadastroProcesso().show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rbAbertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAbertoActionPerformed
        removerLinhas();
        carregarTabela("aberto");
        btArquivar.setEnabled(true);
    }//GEN-LAST:event_rbAbertoActionPerformed

    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
        removerLinhas();
        carregarTabela("");
        btArquivar.setEnabled(false);
    }//GEN-LAST:event_rbTodosActionPerformed

    private void rbArquivadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbArquivadosActionPerformed
        removerLinhas();
        carregarTabela("arquivado");
        btArquivar.setEnabled(false);
    }//GEN-LAST:event_rbArquivadosActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
       String idProcesso;
       idProcesso = tbListarProcessos.getValueAt(tbListarProcessos.getSelectedRow(),0).toString();
       System.out.println("ID DO PROCESSO:"+idProcesso);
       
       new EditarProcesso(idProcesso).show();
       this.dispose();
    }//GEN-LAST:event_btEditarActionPerformed

    private void btArquivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btArquivarActionPerformed
       String idProcesso;
       idProcesso = tbListarProcessos.getValueAt(tbListarProcessos.getSelectedRow(),0).toString();
       System.out.println("ID DO PROCESSO:"+idProcesso);
       
       DaoProcesso dao = new DaoProcesso();
       dao.arquivarProcesso(idProcesso);
       modeloTabela.removeRow(tbListarProcessos.getSelectedRow());
    }//GEN-LAST:event_btArquivarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btArquivar;
    private javax.swing.JButton btEditar;
    private javax.swing.ButtonGroup grupoRadio;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbAberto;
    private javax.swing.JRadioButton rbArquivados;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTable tbListarProcessos;
    // End of variables declaration//GEN-END:variables
}
