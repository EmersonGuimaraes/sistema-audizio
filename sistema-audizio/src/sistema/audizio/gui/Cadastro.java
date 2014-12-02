/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.audizio.gui;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.ActionMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import sistema.audizio.bean.Advogado;
import sistema.audizio.bean.Assessoria;
import sistema.audizio.bean.Bairro;
import sistema.audizio.bean.Cidade;
import sistema.audizio.bean.Cliente;
import sistema.audizio.bean.Financeiro;
import sistema.audizio.bean.Processo;
import sistema.audizio.dao.DaoAdvogado;
import sistema.audizio.dao.DaoAssessoria;
import sistema.audizio.dao.DaoBairro;
import sistema.audizio.dao.DaoCidade;
import sistema.audizio.dao.DaoCliente;
import sistema.audizio.dao.DaoFinanceiro;
import sistema.audizio.dao.DaoProcesso;

/**
 *
 * @author zipnet
 */
public class Cadastro extends javax.swing.JDialog {

    /**
     * Creates new form Cadastro
     */
     boolean listaCheia = false;
    DefaultComboBoxModel comboModelCidade,comboModelBairro,comboModelCidadeAssesoria,comboModelBairroAssesoria;
    
    public Cadastro() {
        setModal(true);
        initComponents();
         carregaCidades();
        mascaraValores();
        AtivarCliente(false);
        ativarCampoProcesso(false);
        ativarCampoAssessoria(false);
        ativarCampoFinanceiro(false);
        ativarCampoAdvogado(false);
        this.setFocusable(true);
    }
    
    private void carregaCidades(){
        ArrayList<Cidade> cidades = new ArrayList<>();
        DaoCidade daoCid = new DaoCidade();
        comboModelCidade = (DefaultComboBoxModel) comboCidade.getModel();
        comboModelCidadeAssesoria = (DefaultComboBoxModel) comboCidadeAssessoria.getModel();
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
         
    public void atalhos(){
            InputMap imap = painelCliente.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW); 
            
            imap.put(KeyStroke.getKeyStroke("F1"), "panel.buttonF1press");    
            imap.put(KeyStroke.getKeyStroke("F2"), "panel.buttonF1press");  
            imap.put(KeyStroke.getKeyStroke("F3"), "panel.buttonF1press");
            imap.put(KeyStroke.getKeyStroke("F4"), "panel.buttonF1press");
            imap.put(KeyStroke.getKeyStroke("F5"), "panel.buttonF1press");
            
            ActionMap amap = painelCliente.getActionMap();
            
            /*amap.put("panel.buttonF1press", new DaoCliente().Cadastrar("1"));
            amap.put("panel.buttonF1press", new DaoProcesso().Cadastrar("1"));
            amap.put("panel.buttonF1press", new DaoFinanceiro().Cadastrar("1"));
            
            amap.put("panel.buttonF2press", new SaveAction());     
            amap.put("panel.buttonF3press", new ClearAction()); */
    }
    public void mascaraValores(){
        tfValor.setDocument(new LimitadorMoeda());
        tfValorDespesa.setDocument(new LimitadorMoeda());
        tfDesconto.setDocument(new LimitadorMoeda());
        //tfTotal.setDocument(new LimitadorMoeda());
        tfTotal.setText("000");
        tfValor.setText("000");
        tfValorDespesa.setText("000");
        tfDesconto.setText("000");
    }
    public void calcularTotal(String valor,String despesa,String desconto){
        //float novoValor,novaDespesa,novoDesconto,novoTotal;
        try {
            /*novoValor = Float.parseFloat(valor);
            novaDespesa = Float.parseFloat(despesa);
            novoDesconto = Float.parseFloat(desconto);*/
            
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));  
            Double novoValor = nf.parse(valor).doubleValue();  
            Double novaDespesa = nf.parse(valor).doubleValue();
            Double novoDesconto = nf.parse(valor).doubleValue();
           
            
          
             Double novoTotal = nf.parse(valor).doubleValue();
            // Double novoTotal = ((novoValor+novaDespesa)-novoDesconto);
             System.out.println(novoTotal);
             String totalis = String.valueOf(novoTotal);
             System.out.println(totalis);
             tfTotal.setText(totalis);
        } catch (Exception e) {
            System.err.println("Fudeu\n"+e);
        }
       
      
    }
    
    public void AtivarCliente(Boolean condicao){
        tfNome.setEditable(condicao);
        tfDataNasci.setEditable(condicao);
        tfCpf.setEditable(condicao);
        tfNacionalidade.setEditable(condicao);
        tfProfissao.setEditable(condicao);
        tfEstadoCivil.setEditable(condicao);
        tfCep.setEditable(condicao);
        comboCidade.setEnabled(condicao);
        comboBairro.setEnabled(condicao);
        tfEndereco.setEditable(condicao);
        tfNumero.setEditable(condicao);
        tfTelefone.setEditable(condicao);
        tfCelular.setEditable(condicao);
        tfEmail.setEditable(condicao);
        tfWhats.setEditable(condicao);
        tfEstado.setEditable(condicao);
        btNovaCidade.setEnabled(condicao);
        btNovoBairro.setEnabled(condicao);
        cWhats.setEnabled(condicao);
     }
    public void ativarCampoProcesso(Boolean condicao){
        tfProcesso.setEditable(condicao);
        tfDataInicio.setEditable(condicao);
        tfDataFim.setEditable(condicao);
        tfVara.setEditable(condicao);
        tfAcao.setEditable(condicao);
        tfComarca.setEditable(condicao);
        comboSituacaoProcesso.setEnabled(condicao);
    }
    public void ativarCampoAssessoria(Boolean condicao){
        tfNomeAssessoria.setEditable(condicao);
        tfEnderecoAssessoria.setEditable(condicao);
        comboBairroAssessoria.setEnabled(condicao);
        comboCidadeAssessoria.setEnabled(condicao);
        btNovaCidadeAssessoria.setEnabled(condicao);
        btNovoBairroAssessoria.setEnabled(condicao);
    }
   public void ativarCampoFinanceiro(Boolean condicao){
       tfValor.setEditable(condicao);
       tfValorDespesa.setEditable(condicao);
       tfDataVencimento.setEditable(condicao);
       tfDesconto.setEditable(condicao);
       comboSituacaofinanceiro.setEnabled(condicao);
       tfDescDespesa.setEditable(condicao);
       btCalcular.setEnabled(condicao);
   }
   
   public void ativarCampoAdvogado(Boolean condicao){
       tfNomeAdvogado.setEditable(condicao);
       tfCelAdvogado.setEditable(condicao);
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        painelMenu = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        painelCliente = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfDataNasci = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfCpf = new javax.swing.JFormattedTextField();
        tfNacionalidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfProfissao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfEstadoCivil = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboCidade = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        comboBairro = new javax.swing.JComboBox();
        btNovaCidade = new javax.swing.JButton();
        lbBairro = new javax.swing.JLabel();
        btNovoBairro = new javax.swing.JButton();
        tfCep = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        lbNuemro = new javax.swing.JLabel();
        tfEndereco = new javax.swing.JTextField();
        lbEndereco = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JFormattedTextField();
        lbTelefone = new javax.swing.JLabel();
        lbCelular = new javax.swing.JLabel();
        tfCelular = new javax.swing.JFormattedTextField();
        cWhats = new javax.swing.JCheckBox();
        tfWhats = new javax.swing.JFormattedTextField();
        lbCelular1 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfEstado = new javax.swing.JFormattedTextField();
        painelProcesso = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfAcao = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tfProcesso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfDataFim = new javax.swing.JFormattedTextField();
        tfDataInicio = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        tfComarca = new javax.swing.JTextField();
        tfVara = new javax.swing.JFormattedTextField();
        jLabel30 = new javax.swing.JLabel();
        comboSituacaoProcesso = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        tfsituacaoatual = new javax.swing.JTextField();
        painelAdvogado = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        tfNomeAdvogado = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tfCelAdvogado = new javax.swing.JFormattedTextField();
        painelAssessoria = new javax.swing.JPanel();
        tfEnderecoAssessoria = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tfNomeAssessoria = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        comboCidadeAssessoria = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        btNovaCidadeAssessoria = new javax.swing.JButton();
        lbBairro1 = new javax.swing.JLabel();
        comboBairroAssessoria = new javax.swing.JComboBox();
        btNovoBairroAssessoria = new javax.swing.JButton();
        painelFinanceiro = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tfValor = new javax.swing.JFormattedTextField();
        tfValorDespesa = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfDescDespesa = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        tfDesconto = new javax.swing.JFormattedTextField();
        tfDataVencimento = new javax.swing.JFormattedTextField();
        comboSituacaofinanceiro = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        tfTotal = new javax.swing.JFormattedTextField();
        btCalcular = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        painelConsultar = new javax.swing.JPanel();
        painelOrdenar = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        btImprimir = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btPequisar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        painelMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btNovo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btNovo.setText("Novo (F1)");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btAlterar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btAlterar.setText("Alterar (F2)");
        btAlterar.setEnabled(false);

        btExcluir.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btExcluir.setText("Excluir (F4)");

        btCancelar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btCancelar.setText("Cancelar (F5)");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar (F3)");
        btSalvar.setEnabled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelMenuLayout = new javax.swing.GroupLayout(painelMenu);
        painelMenu.setLayout(painelMenuLayout);
        painelMenuLayout.setHorizontalGroup(
            painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painelMenuLayout.setVerticalGroup(
            painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMenuLayout.createSequentialGroup()
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        lbNome.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbNome.setText("NOME");

        tfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNomeKeyReleased(evt);
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

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel1.setText("DATA.NASC");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel5.setText("CPF");

        try {
            tfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel6.setText("NACIONALIDADE");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel7.setText("PROFISSÃO");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel8.setText("ESTA. CIVIL");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel10.setText("ESTADO");

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

        jLabel12.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel12.setText("CIDADE");

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

        btNovaCidade.setText("+");
        btNovaCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovaCidadeActionPerformed(evt);
            }
        });

        lbBairro.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbBairro.setText("BAIRRO");

        btNovoBairro.setText("+");
        btNovoBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoBairroActionPerformed(evt);
            }
        });

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

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel9.setText("CEP");

        lbNuemro.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbNuemro.setText("NÚMERO");
        lbNuemro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbEndereco.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbEndereco.setText("ENDEREÇO");
        lbEndereco.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        lbTelefone.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbTelefone.setText("TELEFONE");
        lbTelefone.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbCelular.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
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

        cWhats.setSelected(true);
        cWhats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cWhatsActionPerformed(evt);
            }
        });

        try {
            tfWhats.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfWhats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfWhatsActionPerformed(evt);
            }
        });

        lbCelular1.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbCelular1.setText("WhatsApp");
        lbCelular1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel11.setText("E-MAIL");

        try {
            tfEstado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout painelClienteLayout = new javax.swing.GroupLayout(painelCliente);
        painelCliente.setLayout(painelClienteLayout);
        painelClienteLayout.setHorizontalGroup(
            painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelClienteLayout.createSequentialGroup()
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCpf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelClienteLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel5)
                                .addGap(1, 1, 1)))
                        .addGap(18, 18, 18)
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNacionalidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(tfProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(painelClienteLayout.createSequentialGroup()
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTelefone)
                            .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelClienteLayout.createSequentialGroup()
                                .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cWhats))
                            .addComponent(lbCelular))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfWhats, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCelular1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelClienteLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfEmail)))
                    .addGroup(painelClienteLayout.createSequentialGroup()
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelClienteLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lbEndereco)
                                .addGap(307, 307, 307))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelClienteLayout.createSequentialGroup()
                                .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNuemro)
                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(tfCep)))
                    .addGroup(painelClienteLayout.createSequentialGroup()
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(painelClienteLayout.createSequentialGroup()
                                .addComponent(comboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btNovaCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbBairro)
                                    .addComponent(comboBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btNovoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(tfEstado)))
                    .addGroup(painelClienteLayout.createSequentialGroup()
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNome)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(tfDataNasci))))
                .addGap(93, 93, 93))
        );
        painelClienteLayout.setVerticalGroup(
            painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClienteLayout.createSequentialGroup()
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelClienteLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelClienteLayout.createSequentialGroup()
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(painelClienteLayout.createSequentialGroup()
                                .addComponent(lbNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelClienteLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDataNasci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(painelClienteLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelClienteLayout.createSequentialGroup()
                                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(painelClienteLayout.createSequentialGroup()
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(painelClienteLayout.createSequentialGroup()
                                .addComponent(lbEndereco)
                                .addGap(33, 33, 33))
                            .addGroup(painelClienteLayout.createSequentialGroup()
                                .addComponent(lbNuemro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelClienteLayout.createSequentialGroup()
                                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(9, 9, 9)
                                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btNovaCidade)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelClienteLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(36, 36, 36))))
                    .addGroup(painelClienteLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btNovoBairro)
                            .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTelefone)
                    .addComponent(lbCelular)
                    .addComponent(lbCelular1)
                    .addComponent(jLabel11))
                .addGap(10, 10, 10)
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfWhats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cWhats, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CLIENTE", painelCliente);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel2.setText("Nº PROCESSO");

        jLabel14.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel14.setText("VARA");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel3.setText("DATA INÍCIO");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel4.setText("DATA TÉRMINO");

        jLabel13.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel13.setText("AÇÃO");

        try {
            tfDataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tfDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDataInicioActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel19.setText("COMARCA");

        jLabel30.setText("SITUAÇÃO");

        comboSituacaoProcesso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ABERTO", "ARQUIVADO" }));

        jLabel31.setText("SITUAÇÃO ATUAL");

        javax.swing.GroupLayout painelProcessoLayout = new javax.swing.GroupLayout(painelProcesso);
        painelProcesso.setLayout(painelProcessoLayout);
        painelProcessoLayout.setHorizontalGroup(
            painelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProcessoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(painelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelProcessoLayout.createSequentialGroup()
                        .addGroup(painelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(tfAcao, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(painelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(tfDataInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74)
                        .addGroup(painelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(tfDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelProcessoLayout.createSequentialGroup()
                        .addGroup(painelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addGroup(painelProcessoLayout.createSequentialGroup()
                                .addGroup(painelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGroup(painelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelProcessoLayout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel14))
                                    .addGroup(painelProcessoLayout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(tfVara, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(tfsituacaoatual, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelProcessoLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(painelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(tfComarca, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(painelProcessoLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(painelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboSituacaoProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30))))))
                .addContainerGap())
        );
        painelProcessoLayout.setVerticalGroup(
            painelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProcessoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(painelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelProcessoLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfComarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelProcessoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelProcessoLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfVara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(painelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelProcessoLayout.createSequentialGroup()
                        .addGroup(painelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelProcessoLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(painelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfsituacaoatual, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSituacaoProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PROCESSO", painelProcesso);

        jLabel15.setText("NOME");

        jLabel16.setText("Celular");

        try {
            tfCelAdvogado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout painelAdvogadoLayout = new javax.swing.GroupLayout(painelAdvogado);
        painelAdvogado.setLayout(painelAdvogadoLayout);
        painelAdvogadoLayout.setHorizontalGroup(
            painelAdvogadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAdvogadoLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(painelAdvogadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(tfNomeAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelAdvogadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16)
                    .addComponent(tfCelAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        painelAdvogadoLayout.setVerticalGroup(
            painelAdvogadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAdvogadoLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(painelAdvogadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelAdvogadoLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCelAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelAdvogadoLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNomeAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(180, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ADVOGADO", painelAdvogado);

        jLabel17.setText("ENDEREÇO");

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

        lbBairro1.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbBairro1.setText("BAIRRO");

        comboBairroAssessoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar..." }));
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

        btNovoBairroAssessoria.setText("+");
        btNovoBairroAssessoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoBairroAssessoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelAssessoriaLayout = new javax.swing.GroupLayout(painelAssessoria);
        painelAssessoria.setLayout(painelAssessoriaLayout);
        painelAssessoriaLayout.setHorizontalGroup(
            painelAssessoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAssessoriaLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(painelAssessoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17)
                    .addComponent(jLabel22)
                    .addGroup(painelAssessoriaLayout.createSequentialGroup()
                        .addComponent(comboCidadeAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btNovaCidadeAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelAssessoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBairro1)
                            .addGroup(painelAssessoriaLayout.createSequentialGroup()
                                .addComponent(comboBairroAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btNovoBairroAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel21)
                    .addComponent(tfNomeAssessoria)
                    .addComponent(tfEnderecoAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        painelAssessoriaLayout.setVerticalGroup(
            painelAssessoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAssessoriaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNomeAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(painelAssessoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBairro1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(9, 9, 9)
                .addGroup(painelAssessoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btNovoBairroAssessoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelAssessoriaLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(comboCidadeAssessoria))
                    .addComponent(comboBairroAssessoria)
                    .addComponent(btNovaCidadeAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEnderecoAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ASSESSORIA", painelAssessoria);

        jLabel18.setText("VALOR");

        jLabel20.setText("DESPESAS");

        tfValorDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfValorDespesaActionPerformed(evt);
            }
        });

        jLabel23.setText("VALOR DESPESAS");

        tfDescDespesa.setColumns(20);
        tfDescDespesa.setRows(5);
        jScrollPane1.setViewportView(tfDescDespesa);

        jLabel24.setText("VENCIMENTO");

        jLabel25.setText("DESCONTOS");

        try {
            tfDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        comboSituacaofinanceiro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PENDENTE", "QUITADO" }));
        comboSituacaofinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSituacaofinanceiroActionPerformed(evt);
            }
        });

        jLabel26.setText("SITUAÇÃO");

        tfTotal.setEditable(false);
        tfTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tfTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfTotal.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        btCalcular.setText("CALC");
        btCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcularActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel27.setText("VALOR TOTAL");

        javax.swing.GroupLayout painelFinanceiroLayout = new javax.swing.GroupLayout(painelFinanceiro);
        painelFinanceiro.setLayout(painelFinanceiroLayout);
        painelFinanceiroLayout.setHorizontalGroup(
            painelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFinanceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFinanceiroLayout.createSequentialGroup()
                        .addGroup(painelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18)
                            .addComponent(jLabel25)
                            .addComponent(tfValor)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfValorDespesa)
                            .addComponent(tfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                            .addGroup(painelFinanceiroLayout.createSequentialGroup()
                                .addComponent(tfDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboSituacaofinanceiro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(painelFinanceiroLayout.createSequentialGroup()
                                .addGroup(painelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addGroup(painelFinanceiroLayout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel26)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(painelFinanceiroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelFinanceiroLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel27)))
                .addGap(8, 8, 8))
        );
        painelFinanceiroLayout.setVerticalGroup(
            painelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFinanceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(6, 6, 6)
                .addGroup(painelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFinanceiroLayout.createSequentialGroup()
                        .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfValorDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(painelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFinanceiroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTotal))
                        .addContainerGap())
                    .addGroup(painelFinanceiroLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(painelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfDataVencimento)
                            .addComponent(comboSituacaofinanceiro)
                            .addComponent(tfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("FINANCEIRO", painelFinanceiro);

        javax.swing.GroupLayout painelConsultarLayout = new javax.swing.GroupLayout(painelConsultar);
        painelConsultar.setLayout(painelConsultarLayout);
        painelConsultarLayout.setHorizontalGroup(
            painelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );
        painelConsultarLayout.setVerticalGroup(
            painelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("CONSULTAR", painelConsultar);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel28.setText("FILTRAR POR:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CÓDIGO", "NOME", "ENDEREÇO" }));

        btImprimir.setText("IMPRIMIR");
        btImprimir.setEnabled(false);

        jLabel29.setText("PESQUISAR");

        btPequisar.setText("Pesquisar");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(btPequisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btImprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPequisar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOME", "ENDEREÇO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout painelOrdenarLayout = new javax.swing.GroupLayout(painelOrdenar);
        painelOrdenar.setLayout(painelOrdenarLayout);
        painelOrdenarLayout.setHorizontalGroup(
            painelOrdenarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painelOrdenarLayout.setVerticalGroup(
            painelOrdenarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelOrdenarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("ORDENAR", painelOrdenar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfDataNasciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDataNasciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDataNasciActionPerformed

    private void comboCidadeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCidadeMouseExited

    }//GEN-LAST:event_comboCidadeMouseExited

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

    private void comboBairroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBairroMouseEntered

    }//GEN-LAST:event_comboBairroMouseEntered

    private void comboBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBairroActionPerformed

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
             carregaBairros();
           
        }

    }//GEN-LAST:event_btNovoBairroActionPerformed

    private void tfCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCepActionPerformed

    private void tfTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTelefoneActionPerformed

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

    private void cWhatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cWhatsActionPerformed
        if(cWhats.isSelected()){
            RemoveMascara mask = new RemoveMascara();
            tfWhats.setText(mask.removeMascara(tfCelular.getText()));
        }else{
            tfWhats.setText(null);
        }

    }//GEN-LAST:event_cWhatsActionPerformed

    private void tfDataInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDataInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDataInicioActionPerformed

    private void comboCidadeAssessoriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCidadeAssessoriaMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCidadeAssessoriaMouseExited

    private void comboCidadeAssessoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCidadeAssessoriaActionPerformed
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
    }//GEN-LAST:event_comboCidadeAssessoriaActionPerformed

    private void btNovaCidadeAssessoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaCidadeAssessoriaActionPerformed
        String c = "C";
        new CadastroBairroCidade(c, "CIDADE", null, 0).setVisible(true);
        carregaCidades();
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
    }//GEN-LAST:event_btNovoBairroAssessoriaActionPerformed

    private void comboSituacaofinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSituacaofinanceiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSituacaofinanceiroActionPerformed

    private void btCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcularActionPerformed
        calcularTotal(tfValor.getText(), tfValorDespesa.getText(), tfDesconto.getText());
    }//GEN-LAST:event_btCalcularActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        AtivarCliente(true);
        ativarCampoProcesso(true);
        ativarCampoAssessoria(true);
        ativarCampoFinanceiro(true);
        ativarCampoAdvogado(true);
        
        btSalvar.setEnabled(true);
        btCancelar.setEnabled(true);
        btNovo.setEnabled(false);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        AtivarCliente(false);
        ativarCampoProcesso(false);
        ativarCampoAssessoria(false);
        ativarCampoFinanceiro(false);
        ativarCampoAdvogado(false);
        
        btSalvar.setEnabled(false);
        btCancelar.setEnabled(false);
        btNovo.setEnabled(true);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void tfNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyReleased
       
    }//GEN-LAST:event_tfNomeKeyReleased

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
       
    }//GEN-LAST:event_formKeyReleased

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (tfAcao.getText().trim().equals("") || tfCelAdvogado.getText().trim().equals("") || tfCelular.getText().trim().equals("") || tfAcao.getText().trim().equals("") || tfCelAdvogado.getText().trim().equals("") || tfCelular.getText().trim().equals("")
            || tfCep.getText().trim().equals("") || tfComarca.getText().trim().equals("") || tfCpf.getText().trim().equals("") || tfDataFim.getText().trim().equals("")
                || tfDataInicio.getText().trim().equals("") || tfDataNasci.getText().trim().equals("") || tfDataVencimento.getText().trim().equals("")
                || tfDescDespesa.getText().trim().equals("") || tfDesconto.getText().trim().equals("") || tfEmail.getText().trim().equals("")
                || tfEndereco.getText().trim().equals("") || tfEnderecoAssessoria.getText().trim().equals("") || tfEstado.getText().trim().equals("")
                || tfEstadoCivil.getText().trim().equals("") || tfNacionalidade.getText().trim().equals("") || tfNome.getText().trim().equals("") || tfNomeAdvogado.getText().trim().equals("")
                || tfNomeAssessoria.getText().trim().equals("") || tfNumero.getText().trim().equals("") || tfProcesso.getText().trim().equals("") || tfProfissao.getText().trim().equals("")
                || tfTelefone.getText().trim().equals("") || tfTotal.getText().trim().equals("") || tfValor.getText().equals(null) || tfValorDespesa.getText().trim().equals("")
                || tfVara.getText().trim().equals("") || tfWhats.getText().trim().equals("") || tfsituacaoatual.getText().trim().equals(""))
        {
         
            JOptionPane.showMessageDialog(null, "Verifique se todos os campos foram preenchidos e tente novamente.");
            
        }else{
            
        btSalvar.setEnabled(false);
        btNovo.setEnabled(true);
        
        Cliente cli = new Cliente();
            cli.setNome(tfNome.getText());
            cli.setNascimento(tfDataNasci.getText());
            cli.setCpf(tfCpf.getText());
            cli.setNacionalidade(tfNacionalidade.getText());
            cli.setProfisao(tfProfissao.getText());
            cli.setEstado_civil(tfEstadoCivil.getText());
            cli.setCep(tfCep.getText());
            cli.setEndereco(tfEndereco.getText());
            cli.setNum(tfNumero.getText());
            cli.setEstado(tfEstado.getText());
            cli.setCidade(String.valueOf(comboCidade.getSelectedItem()));
            cli.setBairro(String.valueOf(comboBairro.getSelectedItem()));
            cli.setFone(tfTelefone.getText());
            cli.setCelular(tfCelular.getText());
            cli.setEmail(tfEmail.getText());
            cli.setWhatsapp(tfWhats.getText());
            
        Processo  processo = new Processo();
       
            processo.setProcesso(tfProcesso.getText());
            processo.setData_inicio(tfDataInicio.getText());
            processo.setData_termino(tfDataFim.getText());
            processo.setAcao(tfAcao.getText());
            processo.setSituacao(String.valueOf(comboSituacaofinanceiro.getSelectedItem()));
            processo.setSituacao_atual(tfsituacaoatual.getText());
            processo.setVara(tfVara.getText());
            processo.setComarca(tfComarca.getText());
        
            
        Advogado advogado = new Advogado();
            
            advogado.setNome(tfNomeAdvogado.getText());
            advogado.setCelular(tfCelAdvogado.getText());
            
            
        Assessoria assessoria = new Assessoria();
        
            assessoria.setNome(tfNomeAssessoria.getText());
            assessoria.setCidade(String.valueOf(comboCidadeAssessoria.getSelectedItem()));
            assessoria.setBairro(String.valueOf(comboBairroAssessoria.getSelectedItem()));
            assessoria.setEndereco(tfEndereco.getText());
        
        Financeiro financeiro = new Financeiro();
        
            financeiro.setProcesso(tfProcesso.getText());
            financeiro.setCliente(tfNome.getText());
            financeiro.setValor(tfValor.getText());
            financeiro.setValor_despesa(tfValorDespesa.getText());
            financeiro.setDesconto(tfDesconto.getText());
            financeiro.setVencimento(tfDataVencimento.getText());
            financeiro.setSituacao(String.valueOf(comboSituacaofinanceiro.getSelectedItem()));
            financeiro.setValor_total(tfTotal.getText());
            financeiro.setDesc_despesa(tfDescDespesa.getText());
            //financeiro.setData_pagamento(tfda.getText());
       DaoCliente daocli = new DaoCliente();
       DaoProcesso daoprocesso = new DaoProcesso();
       DaoAdvogado daoadv = new DaoAdvogado();
       DaoAssessoria daoassessoria = new DaoAssessoria();
       DaoFinanceiro daofinanceiro = new DaoFinanceiro();
        
            try {
                
            daocli.Cadastrar(cli);
            daoprocesso.Cadastrar(processo);
             daoadv.Cadastrar(advogado);
              daoassessoria.cadastrar(assessoria);
               daofinanceiro.cadastrar(financeiro);
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
                
                tfAcao.setText(null);
                tfCelAdvogado.setText(null);
                tfCelular.setText(null);
                tfCep.setText(null);
                tfComarca.setText(null);
                tfCpf.setText(null);
                tfDataFim.setText(null);
                tfDataInicio.setText(null);
                tfDataNasci.setText(null);
                tfDataVencimento.setText(null);
                tfDescDespesa.setText(null);
                tfEmail.setText(null);
                tfEndereco.setText(null);
                tfEnderecoAssessoria.setText(null);
                tfEstado.setText(null);
                tfEstadoCivil.setText(null);
                tfNacionalidade.setText(null);
                tfNome.setText(null);
                tfNomeAdvogado.setText(null);
                tfNomeAssessoria.setText(null);
                tfNumero.setText(null);
                tfProcesso.setText(null);
                tfProfissao.setText(null);
                tfTelefone.setText(null);
                tfVara.setText(null);
                tfWhats.setText(null);
                tfsituacaoatual.setText(null);
                tfTotal.setText("000");
                tfValor.setText("000");
                tfValorDespesa.setText("000");
                tfDesconto.setText("000");
                
               
        } catch (Exception e) {
                System.out.println("Não foi possivel realizar o cadastro, por favor verifique se os campos foram preenchidos corretamente e tente novamente.");
        
            
            }
        
        }
            
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tfValorDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValorDespesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfValorDespesaActionPerformed

    private void tfWhatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfWhatsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfWhatsActionPerformed

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
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCalcular;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btNovaCidade;
    private javax.swing.JButton btNovaCidadeAssessoria;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btNovoBairro;
    private javax.swing.JButton btNovoBairroAssessoria;
    private javax.swing.JButton btPequisar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JCheckBox cWhats;
    private javax.swing.JComboBox comboBairro;
    private javax.swing.JComboBox comboBairroAssessoria;
    private javax.swing.JComboBox comboCidade;
    private javax.swing.JComboBox comboCidadeAssessoria;
    private javax.swing.JComboBox comboSituacaoProcesso;
    private javax.swing.JComboBox comboSituacaofinanceiro;
    private javax.swing.JComboBox jComboBox1;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbBairro1;
    private javax.swing.JLabel lbCelular;
    private javax.swing.JLabel lbCelular1;
    private javax.swing.JLabel lbEndereco;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNuemro;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JPanel painelAdvogado;
    private javax.swing.JPanel painelAssessoria;
    private javax.swing.JPanel painelCliente;
    private javax.swing.JPanel painelConsultar;
    private javax.swing.JPanel painelFinanceiro;
    private javax.swing.JPanel painelMenu;
    private javax.swing.JPanel painelOrdenar;
    private javax.swing.JPanel painelProcesso;
    private javax.swing.JTextField tfAcao;
    private javax.swing.JFormattedTextField tfCelAdvogado;
    private javax.swing.JFormattedTextField tfCelular;
    private javax.swing.JFormattedTextField tfCep;
    private javax.swing.JTextField tfComarca;
    private javax.swing.JFormattedTextField tfCpf;
    private javax.swing.JFormattedTextField tfDataFim;
    private javax.swing.JFormattedTextField tfDataInicio;
    private javax.swing.JFormattedTextField tfDataNasci;
    private javax.swing.JFormattedTextField tfDataVencimento;
    private javax.swing.JTextArea tfDescDespesa;
    private javax.swing.JFormattedTextField tfDesconto;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfEnderecoAssessoria;
    private javax.swing.JFormattedTextField tfEstado;
    private javax.swing.JTextField tfEstadoCivil;
    private javax.swing.JTextField tfNacionalidade;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNomeAdvogado;
    private javax.swing.JTextField tfNomeAssessoria;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfProcesso;
    private javax.swing.JTextField tfProfissao;
    private javax.swing.JFormattedTextField tfTelefone;
    private javax.swing.JFormattedTextField tfTotal;
    private javax.swing.JFormattedTextField tfValor;
    private javax.swing.JFormattedTextField tfValorDespesa;
    private javax.swing.JFormattedTextField tfVara;
    private javax.swing.JFormattedTextField tfWhats;
    private javax.swing.JTextField tfsituacaoatual;
    // End of variables declaration//GEN-END:variables
}
