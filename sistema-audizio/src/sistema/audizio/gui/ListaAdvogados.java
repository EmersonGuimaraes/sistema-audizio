/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.audizio.gui;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema.audizio.bean.Advogado;
import sistema.audizio.bean.Cliente;
import sistema.audizio.dao.DaoAdvogado;
import sistema.audizio.dao.DaoCliente;

/**
 *
 * @author zipnet
 */
public class ListaAdvogados extends javax.swing.JDialog {

    /**
     * Creates new form ListaClientes
     */
    Boolean concluido = false;
    public ListaAdvogados() {
        initComponents();
        setModal(true);
        preencheTabela();
        tbListaAdvogados.setFocusable(true);
    }
    
    public boolean isConcluido(){
        return this.concluido;
    }
    public String ConsultaCodigo(){
        String idCliente = null;
        try {
           
            idCliente = tbListaAdvogados.getValueAt(tbListaAdvogados.getSelectedRow(),0).toString();
            
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SELECIONE UM CLIENTE PARA VER E/OU EDITAR.");
            System.err.println("Erro\n"+e);
        }
        
        return idCliente;
    }
    private DefaultTableModel modeloTabela;
    public void preencheTabela(){
        ArrayList<Advogado> advogados = new ArrayList<>();
        DaoAdvogado dao = new DaoAdvogado();
        advogados = dao.Consultar("");
        modeloTabela = (DefaultTableModel) tbListaAdvogados.getModel();
       for(Advogado advo:advogados){
           modeloTabela.addRow(new Object[] {advo.getCod(),advo.getNome()});
        }
       tbListaAdvogados.getTableHeader().setReorderingAllowed(false);   
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListaAdvogados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Ubuntu Condensed", 1, 36)); // NOI18N
        jLabel1.setText("ADVOGADOS");

        tbListaAdvogados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbListaAdvogados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListaAdvogadosMouseClicked(evt);
            }
        });
        tbListaAdvogados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbListaAdvogadosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbListaAdvogados);
        if (tbListaAdvogados.getColumnModel().getColumnCount() > 0) {
            tbListaAdvogados.getColumnModel().getColumn(0).setMinWidth(-100);
            tbListaAdvogados.getColumnModel().getColumn(0).setPreferredWidth(-70);
        }

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jLabel2.setText("(Espaço) - Escolher   --   (F5) - Atualizar  --  (ESC) - Sair");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel1)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbListaAdvogadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbListaAdvogadosKeyReleased
       System.out.println("Clicando");
       if(evt.getKeyCode() == KeyEvent.VK_SPACE ){
           try {
               concluido = true;
               this.dispose();
               
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "SELECIONE UM CLIENTE!");
           }
           
       }
       
       if(evt.getKeyCode() == KeyEvent.VK_F5 ){
              int x = modeloTabela.getRowCount();  
            for(int a = 0; a < x; a++){  
                modeloTabela.removeRow(0);  
            } 
           preencheTabela();
       }
       
       if(evt.getKeyCode() == KeyEvent.VK_ESCAPE ){
           this.dispose();
       }
        
    }//GEN-LAST:event_tbListaAdvogadosKeyReleased

    private void tbListaAdvogadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListaAdvogadosMouseClicked
        if (evt.getClickCount() > 1) { 
                try {
               concluido = true;
               this.dispose();
               
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "SELECIONE UM ADVOGADO!");
           }
        }
    }//GEN-LAST:event_tbListaAdvogadosMouseClicked

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
            java.util.logging.Logger.getLogger(ListaAdvogados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaAdvogados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaAdvogados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaAdvogados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaAdvogados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbListaAdvogados;
    // End of variables declaration//GEN-END:variables
}
