/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.gui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema.audizio.bean.Cliente;
import sistema.audizio.dao.DaoCliente;

/**
 *
 * @author emerson
 */
public class ListarClientes extends javax.swing.JDialog {
    
    /**
     * Creates new form ListarClientes
     */
    private DefaultTableModel modeloTabela;
    DaoCliente daoCliente = new DaoCliente();
    public ListarClientes() {
        initComponents();
        carregarTabela();
        setModal(true);
    }
    public void carregarTabela(){
       DaoCliente dao = new DaoCliente();
       ArrayList<Cliente> clientes = new ArrayList();  
       clientes = dao.Consultar("");
      // System.out.println("Tamanho do array "+clientes.size());
       modeloTabela = (DefaultTableModel) tbListarCliente.getModel();
       for(Cliente cli:clientes){
           modeloTabela.addRow(new Object[] {cli.getCod(), cli.getNome(),cli.getFone(), cli.getEmail()});
        }
           tbListarCliente.getTableHeader().setReorderingAllowed(false);   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btNovoCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListarCliente = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btNovoCliente.setText("NOVO CLIENTE");
        btNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoClienteActionPerformed(evt);
            }
        });

        tbListarCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "TELEFONE", "E-MAIL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbListarCliente);
        if (tbListarCliente.getColumnModel().getColumnCount() > 0) {
            tbListarCliente.getColumnModel().getColumn(0).setResizable(false);
            tbListarCliente.getColumnModel().getColumn(0).setPreferredWidth(-5);
            tbListarCliente.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbListarCliente.getColumnModel().getColumn(2).setPreferredWidth(50);
            tbListarCliente.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        jButton1.setText("VER/EDITAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("EXCLUIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btNovoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btNovoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoClienteActionPerformed
        this.dispose();
         new Cadastro(0,true).setVisible(true);
    }//GEN-LAST:event_btNovoClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("Clicando");
        try {
            String idCliente;
            idCliente = tbListarCliente.getValueAt(tbListarCliente.getSelectedRow(),0).toString();
            System.out.println("Id Cliente: "+idCliente);
       
            new EditarCliente(idCliente).setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SELECIONE UM CLIENTE PARA VER E/OU EDITAR.");
            System.err.println("Erro\n"+e);
        }
       
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       DaoCliente dao = new DaoCliente();
       Cliente cliente = new Cliente();
       String idCliente;
       
       String message = "Deseja realmente excluir este Cliente?";
       String title = "Confirmação";

       int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
       if (reply == JOptionPane.YES_OPTION){
            System.out.println("Confirmado!");
            idCliente = tbListarCliente.getValueAt(tbListarCliente.getSelectedRow(),0).toString();
       
            cliente.setIdCliente(idCliente);
            dao.Deletar(cliente);
            modeloTabela.removeRow(tbListarCliente.getSelectedRow());
       
    }//GEN-LAST:event_jButton2ActionPerformed
    }
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btNovoCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbListarCliente;
    // End of variables declaration//GEN-END:variables
}
