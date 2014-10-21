/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.gui;

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
 * @author Emerson
 */
public class CadastroCliente extends javax.swing.JFrame {
    boolean listaCheia = false;
    DefaultComboBoxModel comboModelCidade,comboModelBairro;
    /**
     * Creates new form CadastroCliente
     */
    public CadastroCliente() {
        initComponents();
        carregaCidades();
       
    }

     private void carregaCidades(){
        ArrayList<Cidade> cidades = new ArrayList<>();
        DaoCidade daoCid = new DaoCidade();
        comboModelCidade = (DefaultComboBoxModel) comboCidade.getModel();
       
        comboModelCidade.removeAllElements();
        
        
         
        cidades = daoCid.consultar("");
        
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
        jLabel1 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        tfDataNasci = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfRg = new javax.swing.JTextField();
        tfOrgaoExp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfCep = new javax.swing.JFormattedTextField();
        tfNacionalidade = new javax.swing.JTextField();
        tfProfissao = new javax.swing.JTextField();
        tfEstadoCivil = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfEstado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        tfCpf = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        tfDataExp = new javax.swing.JFormattedTextField();
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCelularKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCelularKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCelularKeyReleased(evt);
            }
        });

        btCancelar.setText("CANCELAR");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("DATA.NASC");

        btSalvar.setText("SALVAR");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        try {
            tfDataNasci.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataNasci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDataNasciActionPerformed(evt);
            }
        });

        jLabel2.setText("RG");

        jLabel3.setText("ORGÃO EXPEDITOR");

        jLabel4.setText("DATA DE EXPEDIÇÃO");

        tfRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRgActionPerformed(evt);
            }
        });

        jLabel5.setText("CPF");

        jLabel6.setText("NACIONALIDADE");

        jLabel7.setText("PROFISSÃO");

        jLabel8.setText("ESTA. CIVIL");

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
            tfDataExp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfProfissao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTelefone)
                                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cWhats))
                                    .addComponent(lbCelular)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbCelular1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel11)))
                                .addGap(80, 80, 80))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfWhats, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tfDataExp, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(comboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbBairro)
                                        .addComponent(comboBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap(208, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbEndereco)
                                        .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(45, 45, 45)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbNuemro)
                                        .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel5)
                                        .addComponent(tfDataNasci))))
                            .addGap(32, 32, 32)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(tfRg, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(tfOrgaoExp, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(lbNome)
                            .addComponent(jLabel6))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataNasci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfOrgaoExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEndereco)
                    .addComponent(lbNuemro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTelefone)
                    .addComponent(lbCelular)
                    .addComponent(jLabel11)
                    .addComponent(lbCelular1))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfWhats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cWhats, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTelefoneActionPerformed

    private void tfDataNasciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDataNasciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDataNasciActionPerformed

    private void tfRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRgActionPerformed

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
         if(tfNome.getText().equals("") || tfTelefone.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!");
         }else{
            cliente.setNome(tfNome.getText());
            cliente.setNascimento(mask.removeMascara(tfDataNasci.getText()));
            cliente.setRg(tfRg.getText());
            cliente.setOrgao_exp(tfOrgaoExp.getText());
            cliente.setData_exp(mask.removeMascara(tfDataExp.getText()));
            cliente.setCpf(mask.removeMascara(tfCpf.getText()));
            cliente.setNacionalidade(tfNacionalidade.getText());
            cliente.setProfisao(tfProfissao.getText());
            cliente.setEstado_civil(tfEstadoCivil.getText());
            cliente.setCep(mask.removeMascara(tfCep.getText()));
            cliente.setEndereco(tfEndereco.getText());
            cliente.setEstado(tfEstado.getText());
            cliente.setCidade(String.valueOf(comboCidade.getSelectedIndex()));
            cliente.setBairro(String.valueOf(comboBairro.getSelectedIndex()));
            cliente.setFone(mask.removeMascara(tfTelefone.getText()));
            cliente.setCelular(mask.removeMascara(tfCelular.getText()));
            cliente.setEmail(tfEmail.getText());
            
         
            daoCliente.Cadastrar(cliente);
            
            tfNome.setText(null);
            tfNumero.setText(null);
            tfRg.setText(null);
            tfOrgaoExp.setText(null);
            tfDataExp.setText(null);
            tfCpf.setText(null);
            tfCep.setText(null);
            tfDataNasci.setText(null);
            tfEmail.setText(null);
            tfEndereco.setText(null);
            tfEstado.setText(null);
            tfEstadoCivil.setText(null);
            tfNacionalidade.setText(null);
            tfProfissao.setText(null);
            tfTelefone.setText(null);
            tfCelular.setText(null);
            
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
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JCheckBox cWhats;
    private javax.swing.JComboBox comboBairro;
    private javax.swing.JComboBox comboCidade;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JFormattedTextField tfDataExp;
    private javax.swing.JFormattedTextField tfDataNasci;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfEstado;
    private javax.swing.JTextField tfEstadoCivil;
    private javax.swing.JTextField tfNacionalidade;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfOrgaoExp;
    private javax.swing.JTextField tfProfissao;
    private javax.swing.JTextField tfRg;
    private javax.swing.JFormattedTextField tfTelefone;
    private javax.swing.JFormattedTextField tfWhats;
    // End of variables declaration//GEN-END:variables
}
