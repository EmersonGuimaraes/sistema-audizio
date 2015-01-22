/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.audizio.gui;

import com.sun.imageio.plugins.common.I18N;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import sistema.audizio.bean.Assessoria;
import sistema.audizio.bean.Bairro;
import sistema.audizio.bean.Cidade;
import sistema.audizio.dao.DaoAssessoria;
import sistema.audizio.dao.DaoBairro;
import sistema.audizio.dao.DaoCidade;

/**
 *
 * @author zipnet
 */
public class EditarAssessoria extends javax.swing.JDialog {

    /**
     * Creates new form CadastrarAssessoria
     */
    boolean listaCheia = false;
    DefaultComboBoxModel comboModelBairroAssesoria, comboModelCidadeAssesoria;
    String idAssessoria = null;
    public EditarAssessoria(String id) {
        idAssessoria = id;
        initComponents();
        preencheAssessoria(id);
        setModal(true);
        carregaCidadesAssessoria();
    }

    private void carregaBairrosAssesoria(String idCidade){
         if(comboCidadeAssessoria.getSelectedItem().toString().equals("Selecionar....")){
             System.out.println("Nenhuma cidade selecionada");
         }else{
             System.out.println("Carregando bairros...");
                //String cod = String.valueOf(comboCidadeAssessoria.getSelectedIndex());
                
               comboModelBairroAssesoria = (DefaultComboBoxModel) comboBairroAssessoria.getModel();
              
               comboModelBairroAssesoria.removeAllElements();
              
               ArrayList<Bairro> bairros = new ArrayList<>();
                DaoBairro daoBairro = new DaoBairro();
               bairros = daoBairro.consultar(idCidade);

               comboModelBairroAssesoria.addElement("Selecionar....");
               
               if (bairros.isEmpty()) {
                   JOptionPane.showMessageDialog(null, "ESSA CIDADE NÃO TEM BAIRROS CADASTRADOS!");
                }else{
                        System.out.println("Carregando bairros...");
                        //percorrendo a lista para inserir os valores no combo
                        for (int linha = 0; linha < bairros.size(); linha++){
                            //pegando a categoria da lista
                            Bairro bairro = bairros.get(linha);
                            //adicionando a categoria no combo
                            System.out.println("Bairros: "+bairro.getNome());
                            comboModelBairroAssesoria.addElement(bairro.getNome());
                        }
                }
         }
     }
    
    private void carregaCidadesAssessoria(){
        ArrayList<Cidade> cidades = new ArrayList<>();
        DaoCidade daoCid = new DaoCidade();
        comboModelCidadeAssesoria = (DefaultComboBoxModel) comboCidadeAssessoria.getModel();
        cidades = daoCid.consultar("");
        
        comboModelCidadeAssesoria.removeAllElements();
        comboModelCidadeAssesoria.addElement("Selecionar....");
        
        for (int linha = 0; linha < cidades.size(); linha++){
            Cidade cidade = cidades.get(linha);
            comboModelCidadeAssesoria.addElement(cidade.getNome());
        }  
    }
    
    public void salvar(){
        Assessoria assessoria = new Assessoria();
        DaoAssessoria daoass = new DaoAssessoria();
        assessoria.setNome(tfNomeAssessoria.getText());
        assessoria.setCidade(String.valueOf(String.valueOf(comboCidadeAssessoria.getSelectedIndex())));
        assessoria.setBairro(String.valueOf(comboBairroAssessoria.getSelectedIndex()));
        assessoria.setEndereco(tfEnderecoAssessoria.getText());
        assessoria.setId(idAssessoria);
        
        daoass.editar(assessoria);
        
    }
    
    public void preencheAssessoria(String id){
        int idCid = 0, idBarr = 0;
        ArrayList<Assessoria> ass = new DaoAssessoria().consultar(id);
        
        for(Assessoria a:ass){
            tfNomeAssessoria.setText(a.getNome());
            tfEnderecoAssessoria.setText(a.getEndereco());
            idCid = Integer.parseInt(a.getCidade());
            idBarr = Integer.parseInt(a.getBairro());
        }
            System.out.println("ID CIDADE: "+idCid+" ID BAIRRO:"+idBarr );
            
            //comboCidadeAssessoria.setSelectedIndex(idCid);
            //carregaBairrosAssesoria(String.valueOf(idCid));
            //comboBairroAssessoria.setSelectedIndex(idBarr);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btCadastrar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        tfNomeAssessoria = new javax.swing.JTextField();
        comboCidadeAssessoria = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        btNovaCidadeAssessoria = new javax.swing.JButton();
        comboBairroAssessoria = new javax.swing.JComboBox();
        lbBairro1 = new javax.swing.JLabel();
        btNovoBairroAssessoria = new javax.swing.JButton();
        tfEnderecoAssessoria = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btCadastrar.setText("SALVAR EDIÇÃO");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel21.setText("NOME");

        comboCidadeAssessoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar...." }));
        comboCidadeAssessoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                comboCidadeAssessoriaMouseExited(evt);
            }
        });
        comboCidadeAssessoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCidadeAssessoriaActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel22.setText("CIDADE");

        btNovaCidadeAssessoria.setText("+");
        btNovaCidadeAssessoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovaCidadeAssessoriaActionPerformed(evt);
            }
        });

        comboBairroAssessoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar...." }));
        comboBairroAssessoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboBairroAssessoriaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                comboBairroAssessoriaMouseEntered(evt);
            }
        });
        comboBairroAssessoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBairroAssessoriaActionPerformed(evt);
            }
        });

        lbBairro1.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbBairro1.setText("BAIRRO");

        btNovoBairroAssessoria.setText("+");
        btNovoBairroAssessoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoBairroAssessoriaActionPerformed(evt);
            }
        });

        jLabel17.setText("ENDEREÇO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboCidadeAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btNovaCidadeAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBairroAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btNovoBairroAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(267, 267, 267)
                            .addComponent(lbBairro1))
                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfNomeAssessoria, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfEnderecoAssessoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNomeAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBairro1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBairroAssessoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(btNovaCidadeAssessoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboCidadeAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btNovoBairroAssessoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEnderecoAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
            salvar();
        
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboCidadeAssessoriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCidadeAssessoriaMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCidadeAssessoriaMouseExited

    private void comboCidadeAssessoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCidadeAssessoriaActionPerformed
       String item = String.valueOf(comboModelCidadeAssesoria.getSelectedItem());
       
       if(item.equals("Selecionar....") || item == "null"){
           System.out.println("Olá");
           if(listaCheia == true){
               comboModelBairroAssesoria.removeAllElements();
               comboModelBairroAssesoria.addElement("Selecionar....");
           }
           comboBairroAssessoria.setSelectedIndex(0);
       }else{
           System.out.println("Carregando bairros!");
           String idc = String.valueOf(comboCidadeAssessoria.getSelectedIndex());
           carregaBairrosAssesoria(idc);
           listaCheia = true;
       }
    }//GEN-LAST:event_comboCidadeAssessoriaActionPerformed

    private void btNovaCidadeAssessoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaCidadeAssessoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btNovaCidadeAssessoriaActionPerformed

    private void comboBairroAssessoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBairroAssessoriaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBairroAssessoriaMouseClicked

    private void comboBairroAssessoriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBairroAssessoriaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBairroAssessoriaMouseEntered

    private void comboBairroAssessoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBairroAssessoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBairroAssessoriaActionPerformed

    private void btNovoBairroAssessoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoBairroAssessoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btNovoBairroAssessoriaActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btNovaCidadeAssessoria;
    private javax.swing.JButton btNovoBairroAssessoria;
    private javax.swing.JComboBox comboBairroAssessoria;
    private javax.swing.JComboBox comboCidadeAssessoria;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel lbBairro1;
    private javax.swing.JTextField tfEnderecoAssessoria;
    private javax.swing.JTextField tfNomeAssessoria;
    // End of variables declaration//GEN-END:variables
}
