/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.gui;

import sistema.audizio.ultilitarios.RemoveMascara;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import sistema.audizio.bean.Bairro;
import sistema.audizio.bean.Cidade;
import sistema.audizio.bean.Cliente;
import sistema.audizio.dao.DaoBairro;
import sistema.audizio.dao.DaoCidade;
import sistema.audizio.dao.DaoCliente;

/**
 *
 * @author Emerson Guimarães
 */
public class CadastroCliente extends javax.swing.JDialog {
    boolean listaCheia = false;
    DefaultComboBoxModel comboModelCidade,comboModelBairro;
    /**
     * Creates new form CadastroCliente
     */
    public CadastroCliente() {
        initComponents();
        carregaCidades();
        setModal(true);
       
    }

     private void carregaCidades(){
        ArrayList<Cidade> cidades = new ArrayList<>();
        DaoCidade daoCid = new DaoCidade();
        comboModelCidade = (DefaultComboBoxModel) comboCidade.getModel();
        cidades = daoCid.consultar("");
        
        comboModelCidade.removeAllElements();
        comboModelCidade.addElement("Selecionar ...");
        
        for (int linha = 0; linha < cidades.size(); linha++){
            Cidade cidade = cidades.get(linha);
            comboModelCidade.addElement(cidade.getNome());
        }
        
    }
     private void carregaBairros(){
         if(comboCidade.getSelectedItem().toString().equals("Selecionar ...")){
             System.out.println("Nenhuma cidade selecionada");
         }else{
             System.out.println("Carregando bairros...");
                String cod = String.valueOf(comboCidade.getSelectedIndex());
                
               comboModelBairro = (DefaultComboBoxModel) comboBairro.getModel();
              
               comboModelBairro.removeAllElements();
              
               ArrayList<Bairro> bairros = new ArrayList<>();
                DaoBairro daoBairro = new DaoBairro();
               bairros = daoBairro.consultar(cod);

               comboModelBairro.addElement("Selecionar ...");
               
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
                            comboModelBairro.addElement(bairro.getNome());
                        }
                }
         }
         
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfEndereco = new javax.swing.JTextField();
        lbBairro = new javax.swing.JLabel();
        comboCidade = new javax.swing.JComboBox();
        comboBairro = new javax.swing.JComboBox();
        lbEndereco = new javax.swing.JLabel();
        lbNuemro = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        lbTelefone = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JFormattedTextField();
        lbCelular = new javax.swing.JLabel();
        tfCelular = new javax.swing.JFormattedTextField();
        btCancelar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfCep = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        tfEstado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        tfCpf = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        tfWhats = new javax.swing.JFormattedTextField();
        lbCelular1 = new javax.swing.JLabel();
        cWhats = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        lbNome.setText("NOME");

        lbBairro.setText("BAIRRO");

        comboCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar...." }));
        comboCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                comboCidadeMouseExited(evt);
            }
        });
        comboCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCidadeActionPerformed(evt);
            }
        });

        comboBairro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar..." }));
        comboBairro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboBairroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                comboBairroMouseEntered(evt);
            }
        });
        comboBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBairroActionPerformed(evt);
            }
        });

        lbEndereco.setText("ENDEREÇO");
        lbEndereco.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbNuemro.setText("NÚMERO");
        lbNuemro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbTelefone.setText("TELEFONE");
        lbTelefone.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTelefoneActionPerformed(evt);
            }
        });

        lbCelular.setText("CELULAR");
        lbCelular.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        try {
            tfCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCelularKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCelularKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCelularKeyTyped(evt);
            }
        });

        btCancelar.setText("CANCELAR");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btSalvar.setText("SALVAR");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        jLabel5.setText("CPF");

        jLabel9.setText("CEP");

        try {
            tfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCepActionPerformed(evt);
            }
        });

        jLabel10.setText("ESTADO");

        jLabel11.setText("E-MAIL");

        try {
            tfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel12.setText("CIDADE");

        try {
            tfWhats.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbCelular1.setText("WhatsApp");
        lbCelular1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cWhats.setSelected(true);
        cWhats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cWhatsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(375, 375, 375)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(375, 375, 375)
                                        .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTelefone))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCelular)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cWhats)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbBairro)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(119, 119, 119))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfWhats, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbCelular1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNome)
                            .addComponent(jLabel12)
                            .addComponent(lbEndereco))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbNuemro)
                                        .addGap(85, 85, 85)
                                        .addComponent(jLabel9)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(73, 73, 73))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNome)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lbEndereco))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbNuemro)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(comboBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTelefone)
                    .addComponent(lbCelular)
                    .addComponent(lbCelular1)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfWhats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cWhats, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTelefoneActionPerformed

    private void tfCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCepActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
         Cliente cliente = new Cliente();
         DaoCliente daoCliente = new DaoCliente();
         RemoveMascara mask = new RemoveMascara();
         if(tfNome.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!");
         }else{
            int codA=1,codB,codC;
            codB = daoCliente.retornaCod();
            codC = codA+codB;
            
            cliente.setNome(tfNome.getText());
            cliente.setCpf(mask.removeMascara(tfCpf.getText()));
            cliente.setCep(mask.removeMascara(tfCep.getText()));
            cliente.setEndereco(tfEndereco.getText());
            cliente.setEstado(tfEstado.getText());
            cliente.setCidade(String.valueOf(comboCidade.getSelectedIndex()));
            cliente.setBairro(String.valueOf(comboBairro.getSelectedIndex()));
            cliente.setFone(mask.removeMascara(tfTelefone.getText()));
            cliente.setCelular(mask.removeMascara(tfCelular.getText()));
            cliente.setEmail(tfEmail.getText());
            cliente.setWhatsapp(mask.removeMascara(tfWhats.getText()));
            cliente.setNum(tfNumero.getText());
            cliente.setCod(codC);
               
            daoCliente.Cadastrar(cliente);
            
            tfNome.setText(null);
            tfNumero.setText(null);
            tfCpf.setText(null);
            tfCep.setText(null);
            tfEmail.setText(null);
            tfEndereco.setText(null);
            tfEstado.setText(null);
            tfTelefone.setText(null);
            tfCelular.setText(null);
            tfWhats.setText(null);
            comboCidade.setSelectedIndex(0);
            comboBairro.setSelectedIndex(0);
            
         }
         
    }//GEN-LAST:event_btSalvarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String c = "C";
        new CadastroBairroCidade(c, "CIDADE", null, 0).setVisible(true);
        carregaCidades();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String item = String.valueOf(comboModelCidade.getSelectedItem());
        if(item == "Selecionar ..."){
           JOptionPane.showMessageDialog(null, "SELECIONE UMA CIDADE!");
        } else {
             String b = "B";
             int cod = comboCidade.getSelectedIndex();
             System.out.println("codigo: "+cod);
             new CadastroBairroCidade(b, "BAIRRO", item, cod).show();
             carregaBairros();
           
        }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCidadeActionPerformed
       String item = String.valueOf(comboModelCidade.getSelectedItem());
       
       if(item.equals("Selecionar ...") || item == "null"){
           System.out.println("Olá");
           if(listaCheia == true){
               comboModelBairro.removeAllElements();
               comboModelBairro.addElement("Selecionar ...");
           }
           comboBairro.setSelectedIndex(0);
       }else{
           System.out.println("Carregando bairros!");
           carregaBairros();
           listaCheia = true;
       }
    }//GEN-LAST:event_comboCidadeActionPerformed

    private void comboBairroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBairroMouseClicked
        listaCheia = true;
    }//GEN-LAST:event_comboBairroMouseClicked

    private void comboCidadeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCidadeMouseExited
        
    }//GEN-LAST:event_comboCidadeMouseExited

    private void comboBairroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBairroMouseEntered
       
    }//GEN-LAST:event_comboBairroMouseEntered

    private void comboBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBairroActionPerformed

    private void cWhatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cWhatsActionPerformed
        if(cWhats.isSelected()){
                RemoveMascara mask = new RemoveMascara();
                tfWhats.setText(mask.removeMascara(tfCelular.getText()));
            }else{
                tfWhats.setText(null);
            }
        
    }//GEN-LAST:event_cWhatsActionPerformed

    private void tfCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCelularKeyTyped
       
    }//GEN-LAST:event_tfCelularKeyTyped

    private void tfCelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCelularKeyPressed
        
    }//GEN-LAST:event_tfCelularKeyPressed

    private void tfCelularKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCelularKeyReleased
        if(cWhats.isSelected()){
           RemoveMascara mask = new RemoveMascara();
           tfWhats.setText(mask.removeMascara(tfCelular.getText()));
       }else{
            tfWhats.setText(null);
       }
    }//GEN-LAST:event_tfCelularKeyReleased

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JCheckBox cWhats;
    private javax.swing.JComboBox comboBairro;
    private javax.swing.JComboBox comboCidade;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbCelular;
    private javax.swing.JLabel lbCelular1;
    private javax.swing.JLabel lbEndereco;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNuemro;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JFormattedTextField tfCelular;
    private javax.swing.JFormattedTextField tfCep;
    private javax.swing.JFormattedTextField tfCpf;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfEstado;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JFormattedTextField tfTelefone;
    private javax.swing.JFormattedTextField tfWhats;
    // End of variables declaration//GEN-END:variables
}
