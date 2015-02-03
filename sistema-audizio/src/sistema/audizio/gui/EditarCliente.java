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
import sistema.audizio.bean.Processo;
import sistema.audizio.dao.DaoBairro;
import sistema.audizio.dao.DaoCidade;
import sistema.audizio.dao.DaoCliente;
import sistema.audizio.dao.DaoProcesso;

/**
 *
 * @author Emerson Guimarães
 */
public class EditarCliente extends javax.swing.JDialog {
    boolean listaCheia = false;
    DefaultComboBoxModel comboModelCidade,comboModelBairro;
    String idCidade, idBairro;
    /**
     * Creates new form CadastroCliente
     */
    String idCliente;
    ArrayList<Cliente> clientes = new ArrayList<>();
    public EditarCliente(String id) {
        System.out.println("Editar Cliente");
        this.idCliente = id;
        initComponents();
        preencheCampos();
        carregaCidades();
        setModal(true);
        ativarTextFild(false);
    }
    
    public void preencheCampos(){
        DaoCliente dao = new DaoCliente();
        clientes = dao.Consultar(idCliente);
        int idCid = 0, idBarr = 0;
        
        
        for(Cliente cli:clientes){
            tfNome.setText(cli.getNome());
            tfDataNasci.setText(cli.getNascimento());
            tfCpf.setText(cli.getCpf());
            tfNacionalidade.setText(cli.getNacionalidade());
            tfProfissao.setText(cli.getProfisao());
            tfEstadoCivil.setText(cli.getEstado_civil());
            tfCep.setText(cli.getCep());
            tfEndereco.setText(cli.getEndereco());
            tfTelefone.setText(cli.getFone());
            tfCelular.setText(cli.getCelular());
            tfEmail.setText(cli.getEmail());
            tfEstado.setText(cli.getEstado());
            tfWhats.setText(cli.getWhatsapp());
            tfNumero.setText(cli.getNum());
            
            idCid = Integer.parseInt(cli.getCidade());
            idBarr = Integer.parseInt(cli.getBairro());
        }
        
           
            //comboCidade.setSelectedIndex(idCid);
            //carregaBairros(String.valueOf(idCid));
            //comboBairro.setSelectedIndex(idBarr);
    }
    
    public void ativarTextFild(boolean tipo){
        tfCelular.setEditable(tipo);
        tfCep.setEditable(tipo);
        tfCpf.setEditable(tipo);
        tfDataNasci.setEditable(tipo);
        tfEmail.setEditable(tipo);
        tfEndereco.setEditable(tipo);
        tfEstado.setEditable(tipo);
        tfEstadoCivil.setEditable(tipo);
        tfNacionalidade.setEditable(tipo);
        tfNome.setEditable(tipo);
        tfNumero.setEditable(tipo);
        tfProfissao.setEditable(tipo);
        tfTelefone.setEditable(tipo);
        tfWhats.setEditable(tipo);
        
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
    
    
    public void carregaBairros(String codCid){
                if(comboCidade.getSelectedItem().toString().equals("Selecionar ...")){
             System.out.println("Nenhuma cidade selecionada");
         }else{
                    System.out.println("Carregando bairros...");
                    
                    comboModelBairro = (DefaultComboBoxModel) comboBairro.getModel();
                    comboModelBairro.removeAllElements();

                    ArrayList<Bairro> bairros = new ArrayList<>();
                    DaoBairro daoBairro = new DaoBairro();
                    bairros = daoBairro.consultar(codCid);

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
                           // System.out.println("Bairros: "+bairro.getNome());
                            comboModelBairro.addElement(bairro.getNome());
                        }
                    }
                }
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNome = new javax.swing.JLabel();
        lbCidade = new javax.swing.JLabel();
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
        btEditar = new javax.swing.JButton();
        lbCelular1 = new javax.swing.JLabel();
        tfWhats = new javax.swing.JFormattedTextField();
        btNovoBairro = new javax.swing.JButton();
        btNovaCidade = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        lbNome.setText("NOME");

        lbCidade.setText("CIDADE");

        lbBairro.setText("BAIRRO");

        comboCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar...." }));
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

        btCancelar.setText("CANCELAR");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("DATA.NASC");

        btSalvar.setText("SALVAR EDIÇÃO");
        btSalvar.setEnabled(false);
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

        btEditar.setText("EDITAR");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        lbCelular1.setText("WhatsApp");
        lbCelular1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        try {
            tfWhats.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btNovoBairro.setText("+");
        btNovoBairro.setEnabled(false);
        btNovoBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoBairroActionPerformed(evt);
            }
        });

        btNovaCidade.setText("+");
        btNovaCidade.setEnabled(false);
        btNovaCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovaCidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(53, 53, 53))
                                    .addComponent(tfNacionalidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(75, 75, 75))
                                    .addComponent(tfProfissao, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(14, 14, 14)
                                            .addComponent(jLabel8))
                                        .addComponent(tfEstadoCivil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNome)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbTelefone)
                                                .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(21, 21, 21)
                                                    .addComponent(lbCelular)))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tfWhats, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(3, 3, 3)
                                                    .addComponent(lbCelular1)))
                                            .addGap(30, 30, 30)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel11)
                                                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfDataNasci, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbCidade)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(comboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btNovaCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbBairro)
                                                .addGap(174, 174, 174))
                                            .addComponent(comboBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btNovoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbEndereco, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfEndereco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lbNuemro)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabel1)
                        .addGap(86, 86, 86))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDataNasci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4)
                        .addComponent(tfNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(10, 10, 10)
                        .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbNuemro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbEndereco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCidade))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btNovoBairro)
                            .addComponent(btNovaCidade))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTelefone)
                            .addComponent(lbCelular)
                            .addComponent(jLabel11))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                            .addComponent(btEditar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbCelular1)
                        .addGap(10, 10, 10)
                        .addComponent(tfWhats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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

    private void tfCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCepActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        ativarTextFild(false);
        
        btEditar.setEnabled(true);
        btSalvar.setEnabled(false);
        btNovaCidade.setEnabled(false);
        btNovoBairro.setEnabled(false);
        preencheCampos();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
         Cliente cliente = new Cliente();
         DaoCliente daoCliente = new DaoCliente();
         RemoveMascara mask = new RemoveMascara();
         
         if(tfNome.getText().equals("") || tfTelefone.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!");
         }else{
            
            String id = idCliente;
            System.out.println("ID = "+id);
            cliente.setIdCliente(id);
            cliente.setNome(tfNome.getText());
            cliente.setNascimento(mask.removeMascara(tfDataNasci.getText()));
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
            cliente.setWhatsapp(mask.removeMascara(tfWhats.getText()));
            cliente.setNum(tfNumero.getText());
           
            System.out.println("ID CLIENTE = "+idCliente);
            daoCliente.Editar(cliente);
             
             
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            
            btEditar.setEnabled(true);
             
            tfNome.setEnabled(false);
            tfDataNasci.setEnabled(false);
            tfCpf.setEnabled(false);
            tfNacionalidade.setEnabled(false);
            tfProfissao.setEnabled(false);
            tfEstadoCivil.setEnabled(false);
            tfCep.setEnabled(false);
            comboCidade.setEnabled(false);
            comboBairro.setEnabled(false);
            tfEstado.setEnabled(false);
            tfEndereco.setEnabled(false);
            tfNumero.setEnabled(false);
            tfTelefone.setEnabled(false);
            tfCelular.setEnabled(false);
            tfEmail.setEnabled(false);
            tfWhats.setEnabled(false);
            btNovaCidade.setEnabled(false);
            btNovoBairro.setEnabled(false);
            preencheCampos();
         }
         
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        ativarTextFild(true);
        
        btEditar.setEnabled(false);
        btSalvar.setEnabled(true);
        btNovaCidade.setEnabled(true);
        btNovoBairro.setEnabled(true);
       
        
    }//GEN-LAST:event_btEditarActionPerformed

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
           String idCid = null;
           idCid = String.valueOf(comboCidade.getSelectedIndex());
           carregaBairros(idCid);
           listaCheia = true;
       }
       
    }//GEN-LAST:event_comboCidadeActionPerformed

    private void comboBairroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBairroMouseClicked
         listaCheia = true;
    }//GEN-LAST:event_comboBairroMouseClicked

    private void btNovaCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaCidadeActionPerformed
        String c = "C";
        new CadastroBairroCidade(c, "CIDADE", null, 0).setVisible(true);
        carregaCidades();
    }//GEN-LAST:event_btNovaCidadeActionPerformed

    private void btNovoBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoBairroActionPerformed
        String item = String.valueOf(comboModelCidade.getSelectedItem());
        if(item == "Selecionar ..."){
           JOptionPane.showMessageDialog(null, "SELECIONE UMA CIDADE!");
        } else {
             String b = "B";
             int cod = comboCidade.getSelectedIndex();
             System.out.println("codigo: "+cod);
             new CadastroBairroCidade(b, "BAIRRO", item, cod).show();
             carregaBairros(String.valueOf(cod));
           
        }
    }//GEN-LAST:event_btNovoBairroActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btNovaCidade;
    private javax.swing.JButton btNovoBairro;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox comboBairro;
    private javax.swing.JComboBox comboCidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbCelular;
    private javax.swing.JLabel lbCelular1;
    private javax.swing.JLabel lbCidade;
    private javax.swing.JLabel lbEndereco;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNuemro;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JFormattedTextField tfCelular;
    private javax.swing.JFormattedTextField tfCep;
    private javax.swing.JFormattedTextField tfCpf;
    private javax.swing.JFormattedTextField tfDataNasci;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfEstado;
    private javax.swing.JTextField tfEstadoCivil;
    private javax.swing.JTextField tfNacionalidade;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfProfissao;
    private javax.swing.JFormattedTextField tfTelefone;
    private javax.swing.JFormattedTextField tfWhats;
    // End of variables declaration//GEN-END:variables
}
