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
    DefaultComboBoxModel comboModel, comboModelAdv, comboModelAss;
    DaoCliente daoCli = new DaoCliente();
    DaoAdvogado daoAdv = new DaoAdvogado();
    DaoAssessoria daoAss = new DaoAssessoria();
    /**
     * Creates new form CadastroProcesso
     */
    String idProcesso;
    public EditarProcesso(String id) {
        this.idProcesso = id;
        initComponents();
        carregaComboCliente();
        carregaComboAdvogado();
        preencheCampos(idProcesso);
        setModal(true);
    }

    private void carregaComboCliente(){
        comboModel = (DefaultComboBoxModel) comboCliente.getModel();
        comboModel.removeAllElements();
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes = daoCli.Consultar("");
        
        comboModel.addElement("Selecionar...");
        for (int linha = 0; linha < clientes.size(); linha++){
            Cliente cliente = clientes.get(linha);
            comboModel.addElement(cliente.getNome());
        }
        
    }
    private void carregaComboAdvogado(){
        comboModelAdv = (DefaultComboBoxModel) comboAdvogado.getModel();
        comboModelAdv.removeAllElements();
        ArrayList<Advogado> advogados = new ArrayList<>();
        advogados = daoAdv.Consultar("");
        
        comboModelAdv.addElement("Selecionar...");
        for (int linha = 0; linha < advogados.size(); linha++){
            Advogado advogado = advogados.get(linha);
            comboModelAdv.addElement(advogado.getNome());
        }
        
    }
    
    public void preencheCampos(String id){
        DaoProcesso daoProcesso = new DaoProcesso();
        DaoVeiculo daoVeiculo = new DaoVeiculo();
        ArrayList<Processo> processos = new DaoProcesso().Consultar(id);
        ArrayList<Veiculo> veiculos = new DaoVeiculo().Consultar(id);
        
        int idAdvogado=0,idCliente=0,idAssessoria = 0;
        String estado = null;
        for (Processo pro:processos) {
            //Setando dados do processo
            tfProcesso.setText(pro.getProcesso());
            taSituacaoAtual.setText(pro.getSituacao_atual());
            tfVara.setText(pro.getVara());
            tfAcao.setText(pro.getAcao());
            tfComarca.setText(pro.getComarca());
            tfReboqueiro.setText(pro.getReboqueiro());
            tfDataInicio.setText(pro.getData_inicio());
            tfDataFim.setText(pro.getData_termino());
            idAdvogado = pro.getIdAdvogado();
            idCliente = pro.getIdCliente();
            idAssessoria = Integer.parseInt(pro.getIdAssessoria());
        }
        carregaComboCliente();
        comboCliente.setSelectedIndex(idCliente);
        carregaComboAdvogado();
        comboAdvogado.setSelectedIndex(idAdvogado);
        carregaAssessoria(idAssessoria);
        
        for (Veiculo veic:veiculos) {
            //Setando dados do veiculo
            tfMarca.setText(veic.getMarca());
            tfModelo.setText(veic.getModelo());
            tfCor.setText(veic.getCor());
            tfPlaca.setText(veic.getPlaca());
            tfAnoFabricacao.setText(veic.getAnoFabricacao());
            tfAnoModelo.setText(veic.getAnoModelo());
            tfRenavam.setText(veic.getRenavam());
            tfChassi.setText(veic.getChassi());
            estado = veic.getEstado();
        }
        comoEstado.setSelectedItem(estado);
    }
    public void carregaAssessoria(int id){
       comboModelAss = (DefaultComboBoxModel) cbAssessoria.getModel();
        comboModelAss.removeAllElements();
        ArrayList<Assessoria> assessorias = new ArrayList<>();
        assessorias = daoAss.consultar("");
        
        comboModelAss.addElement("Selecionar...");
        for (int linha = 0; linha < assessorias.size(); linha++){
            Assessoria assessoria = assessorias.get(linha);
            comboModelAss.addElement(assessoria.getNome());
            System.out.println("Assessoria: "+assessoria.getNome());
        }
        cbAssessoria.setSelectedIndex(id);
    }
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
        btEditar = new javax.swing.JButton();
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
        tfAnoFabricacao = new javax.swing.JFormattedTextField();
        tfAnoModelo = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        tfChassi = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tfRenavam = new javax.swing.JTextField();
        tfDataInicio = new javax.swing.JFormattedTextField();
        tfDataFim = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taSituacaoAtual = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        tfVara = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        tfComarca = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        comoEstado = new javax.swing.JComboBox();
        btCancelar1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbAssessoria = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Processo");

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do veículo"));

        jLabel9.setText("MARCA");

        jLabel10.setText("MODELO");

        jLabel11.setText("COR");

        jLabel12.setText("PLACA");

        tfMarca.setEnabled(false);

        tfModelo.setEnabled(false);

        tfCor.setEnabled(false);

        tfPlaca.setEnabled(false);

        jLabel13.setText("ANO DE FABRICAÇÃO E MODELO");

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

        jLabel17.setText("RENAVAM");

        tfRenavam.setEnabled(false);

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addGap(59, 59, 59))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfPlaca)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(tfAnoFabricacao)
                                .addGap(18, 18, 18)
                                .addComponent(tfAnoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(tfRenavam, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel17)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addGap(25, 25, 25))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(tfChassi)
                                .addContainerGap())))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfChassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfAnoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfRenavam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfAnoFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        jLabel16.setText("SITUAÇÃO ATUAL");

        taSituacaoAtual.setColumns(20);
        taSituacaoAtual.setRows(5);
        taSituacaoAtual.setEnabled(false);
        jScrollPane1.setViewportView(taSituacaoAtual);

        jLabel14.setText("VARA");

        tfVara.setEnabled(false);

        jLabel18.setText("Veículo foi:");

        tfComarca.setEnabled(false);

        jLabel19.setText("COMARCA");

        jButton1.setText("+");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("+");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        comoEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar...", "Aberto", "Apreendido", "Não Encontrado", "Localizado" }));
        comoEstado.setEnabled(false);

        btCancelar1.setText("CANCELAR");
        btCancelar1.setEnabled(false);
        btCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar1ActionPerformed(evt);
            }
        });

        jLabel6.setText("ASSESSORIA");

        cbAssessoria.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(comoEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfReboqueiro)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
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
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbAssessoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addGap(161, 161, 161))
                                        .addComponent(tfVara, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                    .addComponent(tfAcao, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19)
                                    .addComponent(tfComarca, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(comboAdvogado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(comboCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfVara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfComarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboAdvogado, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfReboqueiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        comboCliente.setEnabled(true);
        comboAdvogado.setEnabled(true);
        comoEstado.setEnabled(true);
        tfProcesso.setEnabled(true);
        tfDataInicio.setEnabled(true);
        tfDataFim.setEnabled(true);
        taSituacaoAtual.setEnabled(true);
        tfVara.setEnabled(true);
        tfAcao.setEnabled(true);
        tfComarca.setEnabled(true);
        tfReboqueiro.setEnabled(true);
        tfMarca.setEnabled(true);
        tfModelo.setEnabled(true);
        tfCor.setEnabled(true);
        tfPlaca.setEnabled(true);
        tfAnoFabricacao.setEnabled(true);
        tfAnoModelo.setEnabled(true);
        tfRenavam.setEnabled(true);
        tfChassi.setEnabled(true);
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        btCancelar1.setEnabled(true);
        btSalvar.setEnabled(true);
        cbAssessoria.setEnabled(true);
    }//GEN-LAST:event_btEditarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
         Processo processo = new Processo();
         Veiculo veiculo = new Veiculo();
         DaoProcesso daoProcesso = new DaoProcesso();
         DaoVeiculo daoVeiculo = new DaoVeiculo();
         RemoveMascara mask = new RemoveMascara();
         
         //Seta os valores do processo
         processo.setProcesso(tfProcesso.getText());
         processo.setCliente(String.valueOf(comboCliente.getSelectedItem()));
         processo.setIdCliente(comboCliente.getSelectedIndex());
         processo.setData_inicio(mask.removeMascara(tfDataInicio.getText()));
         processo.setData_termino(mask.removeMascara(tfDataFim.getText()));
         processo.setAdvogado(String.valueOf(comboAdvogado.getSelectedItem()));
         processo.setIdAdvogado(comboAdvogado.getSelectedIndex());
         processo.setAcao(tfAcao.getText());
         processo.setReboqueiro(tfReboqueiro.getText());
         processo.setVara(tfVara.getText());
         processo.setComarca(tfComarca.getText());
         processo.setSituacao_atual(taSituacaoAtual.getText());
         processo.setIdAssessoria(String.valueOf(cbAssessoria.getSelectedIndex()));
         processo.setIdProcesso(idProcesso);
         
        //Seta os valores do veiculo
         veiculo.setMarca(tfMarca.getText());
         veiculo.setModelo(tfModelo.getText());
         veiculo.setAnoFabricacao(mask.removeMascara(tfAnoFabricacao.getText()));
         veiculo.setAnoModelo(mask.removeMascara(tfAnoModelo.getText()));
         veiculo.setCor(tfCor.getText());
         veiculo.setPlaca(tfPlaca.getText());
         veiculo.setChassi(tfChassi.getText());
         veiculo.setRenavam(tfRenavam.getText());
         veiculo.setId(idProcesso);
         String estado = String.valueOf(comoEstado.getSelectedItem());
         System.out.println("Estado: "+estado);
         veiculo.setEstado(estado);
         
         
         
        daoProcesso.Editar(processo);
        daoVeiculo.Editar(veiculo);
        
        comboCliente.setEnabled(false);
        comboAdvogado.setEnabled(false);
        comoEstado.setEnabled(false);
        tfProcesso.setEnabled(false);
        tfDataInicio.setEnabled(false);
        tfDataFim.setEnabled(false);
        taSituacaoAtual.setEnabled(false);
        tfVara.setEnabled(false);
        tfAcao.setEnabled(false);
        tfComarca.setEnabled(false);
        tfReboqueiro.setEnabled(false);
        tfMarca.setEnabled(false);
        tfModelo.setEnabled(false);
        tfCor.setEnabled(false);
        tfPlaca.setEnabled(false);
        tfAnoFabricacao.setEnabled(false);
        tfAnoModelo.setEnabled(false);
        tfRenavam.setEnabled(false);
        tfChassi.setEnabled(false);
        
        btEditar.setEnabled(true);
        btCancelar1.setEnabled(false);
        btSalvar.setEnabled(false);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        cbAssessoria.setEnabled(false);
        preencheCampos(idProcesso);
        
    }//GEN-LAST:event_btSalvarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new CadastroAdvogado().setVisible(true);
        carregaComboAdvogado();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       new CadastroCliente().setVisible(true);
       carregaComboCliente();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar1ActionPerformed
       comboCliente.setEnabled(false);
        comboAdvogado.setEnabled(false);
        comoEstado.setEnabled(false);
        tfProcesso.setEnabled(false);
        tfDataInicio.setEnabled(false);
        tfDataFim.setEnabled(false);
        taSituacaoAtual.setEnabled(false);
        tfVara.setEnabled(false);
        tfAcao.setEnabled(false);
        tfComarca.setEnabled(false);
        tfReboqueiro.setEnabled(false);
        tfMarca.setEnabled(false);
        tfModelo.setEnabled(false);
        tfCor.setEnabled(false);
        tfPlaca.setEnabled(false);
        tfAnoFabricacao.setEnabled(false);
        tfAnoModelo.setEnabled(false);
        tfRenavam.setEnabled(false);
        tfChassi.setEnabled(false);
        cbAssessoria.setEnabled(false);
        
        btEditar.setEnabled(true);
        btCancelar1.setEnabled(false);
        btSalvar.setEnabled(false);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        preencheCampos(idProcesso);
    }//GEN-LAST:event_btCancelar1ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar1;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbAssessoria;
    private javax.swing.JComboBox comboAdvogado;
    private javax.swing.JComboBox comboCliente;
    private javax.swing.JComboBox comoEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taSituacaoAtual;
    private javax.swing.JTextField tfAcao;
    private javax.swing.JFormattedTextField tfAnoFabricacao;
    private javax.swing.JFormattedTextField tfAnoModelo;
    private javax.swing.JTextField tfChassi;
    private javax.swing.JTextField tfComarca;
    private javax.swing.JTextField tfCor;
    private javax.swing.JFormattedTextField tfDataFim;
    private javax.swing.JFormattedTextField tfDataInicio;
    private javax.swing.JTextField tfMarca;
    private javax.swing.JTextField tfModelo;
    private javax.swing.JTextField tfPlaca;
    private javax.swing.JTextField tfProcesso;
    private javax.swing.JTextField tfReboqueiro;
    private javax.swing.JTextField tfRenavam;
    private javax.swing.JFormattedTextField tfVara;
    // End of variables declaration//GEN-END:variables
}
