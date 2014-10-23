/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.gui;

import java.util.ArrayList;
import sistema.audizio.bean.Processo;
import sistema.audizio.bean.Veiculo;
import sistema.audizio.dao.DaoProcesso;
import sistema.audizio.dao.DaoVeiculo;

/**
 *
 * @author emerson
 */
public class EditarProcesso extends javax.swing.JFrame { 

    /**
     * Creates new form CadastroProcesso
     */
    String idProcesso;
    ArrayList<Processo> processos = new ArrayList<>();
     ArrayList<Veiculo> veiculos = new ArrayList<>();
     
    public EditarProcesso(String id) {
        this.idProcesso = id;
        initComponents();
        preencheCampos();
        
      /*tfAcao.setEnabled(false);
        comboAdvogado.setEnabled(false);
        comboCliente.setEnabled(false);
        tfAnoFabricacao.setEnabled(false);
        tfAnoModelo.setEnabled(false);
        tfChassi.setEnabled(false);
        tfCor.setEnabled(false);
        tfDataFim.setEnabled(false);
        tfDataInicio.setEnabled(false);
        tfMarca.setEnabled(false);
        tfModelo.setEnabled(false);
        tfPlaca.setEnabled(false);
        tfProcesso.setEnabled(false);
        tfReboqueiro.setEnabled(false);
        tfValor.setEnabled(false);
        */
    }

    public void preencheCampos(){
        DaoProcesso dao = new DaoProcesso();
        processos = dao.Consultar(idProcesso);
        
        for(Processo pro:processos){
            tfProcesso.setText(pro.getProcesso());
            tfDataInicio.setText(pro.getData_inicio());
            tfDataFim.setText(pro.getData_termino());
            comboCliente.setSelectedIndex(pro.getCliente());
            comboAdvogado.setSelectedIndex(pro.getAdvogado());
            tfAcao.setText(pro.getAcao());
            //tfCor.setText(pro.getCor());
            tfReboqueiro.setText(pro.getReboqueiro());
           
            
            //PREENCHER CAMPOS VEICULO
            
           
            DaoVeiculo daoV = new DaoVeiculo();
            veiculos = daoV.Consultar(idProcesso);
            System.out.println("Tamanho:"+veiculos.size());
            for(Veiculo veic:veiculos){
            tfMarca.setText(veic.getMarca());
            tfModelo.setText(veic.getModelo());
            tfCor.setText(veic.getCor());
            tfPlaca.setText(veic.getPlaca());
            tfAnoFabricacao.setText(veic.getAnoFabricacao());
            tfAnoModelo.setText(veic.getAnoModelo());
            tfChassi.setText(String.valueOf(veic.getChassi()));
            //System.out.println("Modelo:"+veic.getModelo());
           
            }
        }
          
    }
    /*public void preencheCamposVeiculos(){
         
        
    }*/
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboCliente = new javax.swing.JComboBox();
        tfProcesso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboAdvogado = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfAcao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfReboqueiro = new javax.swing.JTextField();
        btCancelar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfMarca = new javax.swing.JTextField();
        tfModelo = new javax.swing.JTextField();
        tfCor = new javax.swing.JTextField();
        tfPlaca = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfAnoFabricacao = new javax.swing.JFormattedTextField();
        tfAnoModelo = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        tfChassi = new javax.swing.JTextField();
        tfDataInicio = new javax.swing.JFormattedTextField();
        tfDataFim = new javax.swing.JFormattedTextField();
        btEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("PROCESSO");

        jLabel2.setText("CLIENTE");

        comboCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar . . ." }));
        comboCliente.setEnabled(false);

        tfProcesso.setEnabled(false);

        jLabel3.setText("DATA INÍCIO");

        jLabel4.setText("DATA TÉRMINO");

        comboAdvogado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar . . ." }));
        comboAdvogado.setEnabled(false);

        jLabel5.setText("ADVOGADO");

        jLabel7.setText("AÇÃO");

        tfAcao.setEnabled(false);

        jLabel8.setText("REBOQUEIRO");

        tfReboqueiro.setEnabled(false);

        btCancelar.setText("CANCELAR");
        btCancelar.setEnabled(false);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btSalvar.setText("SALVAR");
        btSalvar.setEnabled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do veículo"));

        jLabel9.setText("MARCA");

        jLabel10.setText("MODELO");

        jLabel11.setText("COR");

        jLabel12.setText("PLACA");

        tfMarca.setEnabled(false);

        tfModelo.setEnabled(false);

        tfCor.setEnabled(false);

        tfPlaca.setEnabled(false);

        jLabel13.setText("ANO DE FABRICAÇÃO");

        jLabel14.setText("ANO DO MODELO");

        try {
            tfAnoFabricacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfAnoFabricacao.setEnabled(false);

        try {
            tfAnoModelo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfAnoModelo.setEnabled(false);

        jLabel15.setText("CHASSSI");

        tfChassi.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(tfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCor, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addGap(59, 59, 59))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfPlaca)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(tfAnoFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(tfAnoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfChassi))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAnoFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAnoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfChassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        try {
            tfDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataInicio.setEnabled(false);

        try {
            tfDataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataFim.setEnabled(false);

        btEditar.setText("EDITAR");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboAdvogado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboCliente, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfReboqueiro, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(tfAcao, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(tfProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(175, 175, 175)
                                .addComponent(jLabel3)
                                .addGap(58, 58, 58)
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfReboqueiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 
    
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
     tfAcao.setEnabled(false);
        comboAdvogado.setEnabled(false);
        comboCliente.setEnabled(false);
        tfAnoFabricacao.setEnabled(false);
        tfAnoModelo.setEnabled(false);
        tfChassi.setEnabled(false);
        tfCor.setEnabled(false);
        tfDataFim.setEnabled(false);
        tfDataInicio.setEnabled(false);
        tfMarca.setEnabled(false);
        tfModelo.setEnabled(false);
        tfPlaca.setEnabled(false);
        tfProcesso.setEnabled(false);
        tfReboqueiro.setEnabled(false);
        btSalvar.setEnabled(false);
        btEditar.setEnabled(true);
        btCancelar.setEnabled(false);
        
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
         Processo processo = new Processo();
         Veiculo veiculo = new Veiculo();
         
         DaoProcesso daoProcesso = new DaoProcesso();
         DaoVeiculo daoVeiculo = new DaoVeiculo();
         
         RemoveMascara mask = new RemoveMascara();
         
         //Seta os valores do processo
         System.out.println("id processo::"+idProcesso);
         processo.setIdProcesso(idProcesso);
         processo.setProcesso(tfProcesso.getText());
         processo.setCliente(comboCliente.getSelectedIndex()+1);
         processo.setData_inicio(mask.removeMascara(tfDataInicio.getText()));
         processo.setData_termino(mask.removeMascara(tfDataFim.getText()));
         processo.setAdvogado(comboAdvogado.getSelectedIndex()+1);
         processo.setAcao(tfAcao.getText());
         processo.setReboqueiro(tfReboqueiro.getText());
         daoProcesso.Editar(processo);
         
        //Seta os valores do veiculo
         veiculo.setMarca(tfMarca.getText());
         veiculo.setModelo(tfModelo.getText());
         veiculo.setAnoFabricacao(mask.removeMascara(tfAnoFabricacao.getText()));
         veiculo.setAnoModelo(mask.removeMascara(tfAnoModelo.getText()));
         veiculo.setCor(tfCor.getText());
         veiculo.setPlaca(tfPlaca.getText());
         int chassi = Integer.parseInt(tfChassi.getText());
         veiculo.setChassi(chassi);
         
         
         
        
        daoVeiculo.Editar(veiculo);
        
        tfAcao.setEnabled(false);
        tfAnoFabricacao.setEnabled(false);
        tfAnoModelo.setEnabled(false);
        tfChassi.setEnabled(false);
        tfCor.setEnabled(false);
        tfDataFim.setEnabled(false);
        tfDataInicio.setEnabled(false);
        tfMarca.setEnabled(false);
        tfModelo.setEnabled(false);
        tfPlaca.setEnabled(false);
        tfProcesso.setEnabled(false);
        tfReboqueiro.setEnabled(false);
        comboAdvogado.setEnabled(false);
        comboCliente.setEnabled(false);
        btSalvar.setEnabled(false);
        btEditar.setEnabled(true);
        btCancelar.setEnabled(false);
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        // TODO add your handling code here:
        tfAcao.setEnabled(true);
        tfAnoFabricacao.setEnabled(true);
        tfAnoModelo.setEnabled(true);
        tfChassi.setEnabled(true);
        tfCor.setEnabled(true);
        tfDataFim.setEnabled(true);
        tfDataInicio.setEnabled(true);
        tfMarca.setEnabled(true);
        tfModelo.setEnabled(true);
        tfPlaca.setEnabled(true);
        tfProcesso.setEnabled(true);
        tfReboqueiro.setEnabled(true);
        comboAdvogado.setEnabled(true);
        comboCliente.setEnabled(true);
        btSalvar.setEnabled(true);
        btEditar.setEnabled(false);
        btCancelar.setEnabled(true);
    }//GEN-LAST:event_btEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox comboAdvogado;
    private javax.swing.JComboBox comboCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfAcao;
    private javax.swing.JFormattedTextField tfAnoFabricacao;
    private javax.swing.JFormattedTextField tfAnoModelo;
    private javax.swing.JTextField tfChassi;
    private javax.swing.JTextField tfCor;
    private javax.swing.JFormattedTextField tfDataFim;
    private javax.swing.JFormattedTextField tfDataInicio;
    private javax.swing.JTextField tfMarca;
    private javax.swing.JTextField tfModelo;
    private javax.swing.JTextField tfPlaca;
    private javax.swing.JTextField tfProcesso;
    private javax.swing.JTextField tfReboqueiro;
    // End of variables declaration//GEN-END:variables

}
