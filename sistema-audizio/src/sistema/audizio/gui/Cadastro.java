/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.audizio.gui;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sistema.audizio.bean.Advogado;
import sistema.audizio.bean.Assessoria;
import sistema.audizio.bean.Bairro;
import sistema.audizio.bean.Cidade;
import sistema.audizio.bean.Cliente;
import sistema.audizio.bean.Financeiro;
import sistema.audizio.bean.Processo;
import sistema.audizio.bean.Veiculo;
import sistema.audizio.dao.DaoAdvogado;
import sistema.audizio.dao.DaoAssessoria;
import sistema.audizio.dao.DaoBairro;
import sistema.audizio.dao.DaoCidade;
import sistema.audizio.dao.DaoCliente;
import sistema.audizio.dao.DaoFinanceiro;
import sistema.audizio.dao.DaoProcesso;
import sistema.audizio.dao.DaoVeiculo;
import sistema.audizio.ultilitarios.LimitadorMoeda;
import sistema.audizio.ultilitarios.NumeroDocument;
import sistema.audizio.ultilitarios.RemoveMascara;
import sistema.audizio.ultilitarios.Validacao;
import sistema.audizio.relatorio.Relatorio;

/**
 *
 * @author zipnet
 */
public class Cadastro extends javax.swing.JDialog {
    private DefaultTableModel modeloTabela;
    RemoveMascara rm = new RemoveMascara();
    String idCliente = null, idProcesso = null, idAdvogado = null, idAssessoria=null;
    String codigoCliente, codigoAdvogado, codigoAssessoria;
    boolean boxCliente = false, boxAdvogado = false, boxAssessoria = false;
    /**
     * Creates new form Cadastro
     */
     boolean listaCheia = false;
    DefaultComboBoxModel comboModelCidade,comboModelBairro,comboModelCidadeAssesoria,comboModelBairroAssesoria;
    boolean estadoBotao = false; //False - Cadastra, True = Atualiza
    public Cadastro(int idPainel, boolean novo) {
        setModal(true);
        initComponents();
        
        carregaCidadesCliente();
        carregaCidadesAssessoria();
        mascararValores();
        AtivarCliente(false);
        ativarCampoProcesso(false);
        ativarCampoAssessoria(false);
        ativarCampoFinanceiro(false);
        ativarCampoAdvogado(false);
        ativaCampoVeiculo(false);
        this.setFocusable(true);
        carregarTabela(null);
        int idAba = 0;
        idAba = idPainel;
        PainelAbas.setSelectedIndex(idAba);
        
        if(novo == true){
            btnovo();
        }
    }
    
    private void carregaCidadesCliente(){
        ArrayList<Cidade> cidades = new ArrayList<>();
        DaoCidade daoCid = new DaoCidade();
        comboModelCidade = (DefaultComboBoxModel) comboCidade.getModel();
        cidades = daoCid.consultar("");
        
        comboModelCidade.removeAllElements();
        comboModelCidade.addElement("Selecionar....");
        
        for (int linha = 0; linha < cidades.size(); linha++){
            Cidade cidade = cidades.get(linha);
            comboModelCidade.addElement(cidade.getNome());
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
    
     private void carregaBairrosCliente(String idCli){
         if(comboCidade.getSelectedItem().toString().equals("Selecionar....")){
             System.out.println("Nenhuma cidade selecionada");
         }else{
             
                String cod = String.valueOf(comboCidade.getSelectedIndex());
                
               comboModelBairro = (DefaultComboBoxModel) comboBairro.getModel();
              
               comboModelBairro.removeAllElements();
              
               ArrayList<Bairro> bairros = new ArrayList<>();
                DaoBairro daoBairro = new DaoBairro();
                if(idCli.equals("")){
                    bairros = daoBairro.consultar(cod);
                }else{
                    bairros = daoBairro.consultar(idCli);
                }
               

               comboModelBairro.addElement("Selecionar....");
               
               if (bairros.isEmpty()) {
                   JOptionPane.showMessageDialog(null, "ESSA CIDADE NÃO TEM BAIRROS CADASTRADOS!");
                }else{
                        
                        //percorrendo a lista para inserir os valores no combo
                        for (int linha = 0; linha < bairros.size(); linha++){
                            //pegando a categoria da lista
                            Bairro bairro = bairros.get(linha);
                            //adicionando a categoria no combo
                            
                            comboModelBairro.addElement(bairro.getNome());
                        }
                }
         }
     }
     
     private void carregaBairrosAssesoria(String idCli){
         if(comboCidadeAssessoria.getSelectedItem().toString().equals("Selecionar....")){
             System.out.println("Nenhuma cidade selecionada");
         }else{
            
                String cod = String.valueOf(comboCidadeAssessoria.getSelectedIndex());
                
               comboModelBairroAssesoria = (DefaultComboBoxModel) comboBairroAssessoria.getModel();
              
               comboModelBairroAssesoria.removeAllElements();
              
               ArrayList<Bairro> bairros = new ArrayList<>();
                DaoBairro daoBairro = new DaoBairro();
                
               if(idCli.equals("")){
                    bairros = daoBairro.consultar(cod);
                }else{
                    bairros = daoBairro.consultar(idCli);
                }

               comboModelBairroAssesoria.addElement("Selecionar....");
               
               if (bairros.isEmpty()) {
                   JOptionPane.showMessageDialog(null, "ESSA CIDADE NÃO TEM BAIRROS CADASTRADOS!");
                }else{
                        
                        //percorrendo a lista para inserir os valores no combo
                        for (int linha = 0; linha < bairros.size(); linha++){
                            //pegando a categoria da lista
                            Bairro bairro = bairros.get(linha);
                            //adicionando a categoria no combo
                            
                            comboModelBairroAssesoria.addElement(bairro.getNome());
                        }
                }
         }
     }
       
    public void mascararValores(){
        
       tfValor.setDocument(new NumeroDocument(7,2));
       tfValorDespesa.setDocument(new NumeroDocument(7,2));
       tfDesconto.setDocument(new NumeroDocument(7,2));
       //tfTotal.setDocument(new NumeroDocument(7,2));
    }
    public void calcularTotal(String valor,String despesa,String desconto){
        DecimalFormat formatador = new DecimalFormat("###,##0.00");
        try {
           
            Locale locBrazil = new Locale("pt", "BR");  
            NumberFormat nf = NumberFormat.getInstance(locBrazil);
            
            Number valorP = nf.parse(valor);
            Number valorDesc = nf.parse(desconto);
            Number valorDesp = nf.parse(despesa);
            
            double n1,n2,n3, total;
            
            n1 = valorP.doubleValue();
            n2 = valorDesp.doubleValue();
            n3 = valorDesc.doubleValue();
            
            total = (n1+n2)-n3;
            
            
            String nTotal = String.valueOf(total);
            tfTotal.setText(nTotal);
                        

        } catch (Exception e) {
            System.err.println(e);
        }
        
        //String totalGeral = NumberFormat.getCurrencyInstance().format(novoTotal);
        //tfTotal.setText(totalGeral);
    }
    public boolean validarFormCliente(){
        boolean estado = false;
        
        return estado;
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
   public void ativaCampoVeiculo(Boolean condicao){
       tfMarca.setEditable(condicao);
       tfModelo.setEditable(condicao);
       tfCor.setEditable(condicao);
       tfPlaca.setEditable(condicao);
       tfAnoFabricacao.setEditable(condicao);
       tfAnoModelo.setEditable(condicao);
       tfChassi.setEditable(condicao);
       tfRenavam.setEditable(condicao);
       cbEstadoVeiculo.setEnabled(condicao);
   }

   
    public void btnovo(){
        estadoBotao = false;
        AtivarCliente(true);
        ativarCampoProcesso(true);
        ativarCampoAssessoria(true);
        ativarCampoFinanceiro(true);
        ativarCampoAdvogado(true);
        ativaCampoVeiculo(true);
        
        btSalvar.setEnabled(true);
        btCancelar.setEnabled(true);
        btNovo.setEnabled(false);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
        
        
    }
    
    public void btcancelar(){
        AtivarCliente(false);
        ativarCampoProcesso(false);
        ativarCampoAssessoria(false);
        ativarCampoFinanceiro(false);
        ativarCampoAdvogado(false);
        ativaCampoVeiculo(false);
        btSalvar.setEnabled(false);
        btCancelar.setEnabled(false);
        
        btNovo.setEnabled(true);
        //btAlterar.setEnabled(true);
        //btExcluir.setEnabled(true);
    }
    Validacao v = new Validacao();
    public void btsalvar( Object[] clie, Object[] proc, Object[] Adv, Object[] asses, Object[] fin, Object[] vei){
         if (v.ValidatField(clie)){
             if(v.ValidatField(proc)){
                if(v.ValidatField(Adv)){
                    if(v.ValidatField(asses)){
                        if (v.ValidatField(fin)) {
                            if (v.ValidatField(vei)) {
                                        
                                            RemoveMascara rm = new RemoveMascara();
                                            btSalvar.setEnabled(false);
                                            btNovo.setEnabled(true);
                                            
                                            
                                                    Cliente cli = new Cliente();
                                                    DaoCliente daoc = new DaoCliente();
                                                    /*GERA UM CÓDIGO ÚNICO PARA CADA CLIENTE*/
                                                    int codA=1,codB,codC;
                                                    codB = daoc.retornaCod();
                                                    codC = codA+codB;
                                                    
                                                    cli.setNome(tfNome.getText());
                                                    cli.setNascimento(rm.removeMascara(tfDataNasci.getText()));
                                                    cli.setCpf(rm.removeMascara(tfCpf.getText()));
                                                    cli.setNacionalidade(tfNacionalidade.getText());
                                                    cli.setProfisao(tfProfissao.getText());
                                                    cli.setEstado_civil(tfEstadoCivil.getText());
                                                    cli.setCep(rm.removeMascara(tfCep.getText()));
                                                    cli.setEndereco(tfEndereco.getText());
                                                    cli.setNum(tfNumero.getText());
                                                    cli.setEstado(tfEstado.getText());
                                                    cli.setCidade(String.valueOf(comboCidade.getSelectedIndex()));
                                                    cli.setBairro(String.valueOf(comboBairro.getSelectedIndex()));
                                                    cli.setFone(rm.removeMascara(tfTelefone.getText()));
                                                    cli.setCelular(rm.removeMascara(tfCelular.getText()));
                                                    cli.setEmail(tfEmail.getText());
                                                    cli.setWhatsapp(rm.removeMascara(tfWhats.getText()));
                                                    cli.setIdCliente(idCliente);
                                                    cli.setCod(codC);
                                           
                                            
                                            Processo  processo = new Processo();

                                                processo.setProcesso(tfProcesso.getText());
                                                processo.setData_inicio(rm.removeMascara(tfDataInicio.getText()));
                                                processo.setData_termino(rm.removeMascara(tfDataFim.getText()));
                                                processo.setAcao(tfAcao.getText());
                                                processo.setSituacao(String.valueOf(comboSituacaoProcesso.getSelectedItem()));
                                                processo.setSituacao_atual(tfsituacaoatual.getText());
                                                processo.setVara(tfVara.getText());
                                                processo.setComarca(tfComarca.getText());
                                                processo.setIdProcesso(idProcesso);
                                                processo.setCliente(tfNome.getText());
                                                
                                                try{
                                                    if(boxCliente == true){
                                                        int codigocli = Integer.parseInt(codigoCliente);
                                                        processo.setIdCliente(codigocli);
                                                    }else{
                                                        processo.setIdCliente(codC);
                                                    }
                                                }catch(NumberFormatException e){
                                                    System.err.println(e.getMessage());
                                                }
                                                
                                            
                                                    Advogado advogado = new Advogado();
                                                    DaoAdvogado daoa = new DaoAdvogado();
                                                    
                                                    int codA1=1,codB1,codC1;
                                                    
                                                    codB1 = daoa.retornaCod();
                                                    codC1 = codA1+codB1;
                                                        advogado.setNome(tfNomeAdvogado.getText());
                                                        advogado.setCelular(rm.removeMascara(tfCelAdvogado.getText()));
                                                        advogado.setCod(codC1);
                                                        
                                                    try {
                                                        if(boxAdvogado == true){
                                                            int codigoadv = Integer.parseInt(codigoAdvogado);
                                                            processo.setIdAdvogado(codigoadv);
                                                        }else{
                                                            processo.setIdAdvogado(codC1);
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.err.println(e.getStackTrace());
                                                    }
                                                    
                                            
                                                    
                                                    Assessoria assessoria = new Assessoria();
                                                    DaoAssessoria daoass = new DaoAssessoria();
                                                    
                                                    int codA2=1,codB2,codC2;
                                                    
                                                    codB2 = daoass.retornaCod();
                                                    codC2 = codA2+codB2;

                                                        assessoria.setNome(tfNomeAssessoria.getText());
                                                        assessoria.setCidade(String.valueOf(String.valueOf(comboCidadeAssessoria.getSelectedIndex())));
                                                        assessoria.setBairro(String.valueOf(comboBairroAssessoria.getSelectedIndex()));
                                                        assessoria.setEndereco(tfEnderecoAssessoria.getText());
                                                        assessoria.setId(idAssessoria);
                                                        assessoria.setCod(codC2);
                                                        try {
                                                            if(boxAssessoria == true){
                                                                int codigoass = Integer.parseInt(codigoAssessoria);
                                                                processo.setIdAssessoria(codigoass);
                                                            }else{
                                                                processo.setIdAssessoria(codC2);
                                                            }
                                                        } catch (NumberFormatException e) {
                                                            System.err.println(e.getStackTrace());
                                                        }
                                                        
                                            
                                               
                                            Financeiro financeiro = new Financeiro();
                                                calcularTotal(tfValor.getText(), tfValorDespesa.getText(), tfDesconto.getText());
                                                financeiro.setProcesso(tfProcesso.getText());
                                                financeiro.setCliente(tfNome.getText());
                                                financeiro.setValor(rm.removeMascara(tfValor.getText()));
                                                financeiro.setValor_despesa(rm.removeMascara(tfValorDespesa.getText()));
                                                financeiro.setDesconto(rm.removeMascara(tfDesconto.getText()));
                                                financeiro.setVencimento(rm.removeMascara(tfDataVencimento.getText()));
                                                financeiro.setSituacao(String.valueOf(comboSituacaofinanceiro.getSelectedItem()));
                                                financeiro.setValor_total(tfTotal.getText());
                                                financeiro.setDesc_despesa(tfDescDespesa.getText());
                                                financeiro.setId(idCliente);
                                                //financeiro.setData_pagamento(tfda.getText());
                                                try{
                                                    if(boxCliente == true){
                                                        int codigocli = Integer.parseInt(codigoCliente);
                                                        financeiro.setIdCliente(codigocli);
                                                    }else{
                                                        financeiro.setIdCliente(codC);
                                                    }
                                                }catch(NumberFormatException e){
                                                    System.err.println(e.getMessage());
                                                }

                                            Veiculo v = new Veiculo();
                                                v.setMarca(tfMarca.getText());
                                                v.setModelo(tfModelo.getText());
                                                v.setCor(tfCor.getText());
                                                v.setAnoFabricacao(tfAnoFabricacao.getText());
                                                v.setAnoModelo(tfAnoModelo.getText());
                                                v.setModelo(tfAnoModelo.getText());
                                                v.setPlaca(tfPlaca.getText());
                                                v.setChassi(tfChassi.getText());
                                                v.setRenavam(tfRenavam.getText());
                                                v.setEstado(cbEstadoVeiculo.getSelectedItem().toString());
                                                v.setId(idCliente);
                                           
                                           DaoCliente daocli = new DaoCliente();
                                           DaoProcesso daoprocesso = new DaoProcesso();
                                           DaoAdvogado daoadv = new DaoAdvogado();
                                           DaoAssessoria daoassessoria = new DaoAssessoria();
                                           DaoFinanceiro daofinanceiro = new DaoFinanceiro();
                                           DaoVeiculo daoVeiculo = new DaoVeiculo();
                                           if(estadoBotao==false){
                                               
                                                    try {

                                                         if(boxCliente == false){daocli.Cadastrar(cli);}
                                                         daoprocesso.Cadastrar(processo);
                                                         if(boxAdvogado == false){daoadv.Cadastrar(advogado);}
                                                         if(boxAssessoria == false){daoassessoria.cadastrar(assessoria);}
                                                         daofinanceiro.cadastrar(financeiro);
                                                         daoVeiculo.Cadastrar(v);
                                                         JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");

                                                         
                                                         limpaTela();
                                                         


                                                 } catch (Exception e) {
                                                         System.out.println("Não foi possivel realizar o cadastro, por favor verifique se os campos foram preenchidos corretamente e tente novamente.");
                                                 }
                                           }else{
                                               
                                                try {
                                                         daocli.Editar(cli);
                                                         daoprocesso.Editar(processo);
                                                         daoadv.Editar(advogado);
                                                         daoassessoria.editar(assessoria);
                                                         daofinanceiro.editar(financeiro);
                                                         daoVeiculo.Editar(v);
                                                         JOptionPane.showMessageDialog(null, "Edição realizada com sucesso");

                                               } catch (Exception e) {
                                                   System.out.println("Não foi possivel atualizar os dados, por favor verifique os campos e tente novamente.");
                                               }

                                           }
                                                carregarTabela(null);
                                                
                                
                                
                            }
                            
                        }
                    
                    }
                }  
        
        }
      }
    }
    
    public void limpaTela(){
            Object[] listaObjetos = {
                tfNome,tfCpf,tfCep,tfEndereco,tfNumero,tfEstado,tfCelular,
                tfNomeAdvogado,tfCelAdvogado,
                tfNomeAssessoria,tfEnderecoAssessoria,
                tfValor,tfValorDespesa,tfDataVencimento,tfDesconto,
                tfProcesso,tfDataInicio,tfDataFim,tfAcao,tfsituacaoatual,tfVara,tfComarca,
                tfMarca,tfModelo,tfCor,tfPlaca,tfAnoModelo,tfAnoFabricacao,tfRenavam,tfChassi
            };
          
            for (int i = 0; i <= listaObjetos.length; i++) {
                JTextField nTF = (JTextField)listaObjetos[i];
                JFormattedTextField nfTF = (JFormattedTextField)listaObjetos[i];
                nTF.setText(null);
                nTF.setEditable(false);
                
                nfTF.setText(null);
                nfTF.setEditable(false);
            }
          
    }
    public void btAlterar(){
        estadoBotao = true;
        AtivarCliente(true);
        ativarCampoProcesso(true);
        ativarCampoAssessoria(true);
        ativarCampoFinanceiro(true);
        ativarCampoAdvogado(true);
        ativaCampoVeiculo(true);
        btSalvar.setEnabled(true);
        btCancelar.setEnabled(true);
        
        btNovo.setEnabled(false);
        btExcluir.setEnabled(false);
        
    }
    ArrayList<Processo> processos = new ArrayList(); 
    public void carregarTabela(ArrayList<Processo> processo){
       DaoProcesso pro = new DaoProcesso();
        
      
       if(processo == null){
           processos = pro.Consultar(""); 
              
      }else{
           processos = processo;
      }  
        
       modeloTabela = (DefaultTableModel) tbListarProcesso.getModel();
       modeloTabela.setNumRows(0);
       for(Processo p:processos){
           modeloTabela.addRow(new Object[] {p.getIdProcesso(), p.getCliente(),p.getProcesso(), p.getIdCliente(), p.getIdAdvogado(), p.getIdAssessoria()});
        }
           tbListarProcesso.getTableHeader().setReorderingAllowed(false);   
    }
    
    public void carregamentoDinamico(String campo, String valor){
        DaoProcesso pro = new DaoProcesso();
        
       
        processos = pro.pesquisaDinamica(campo, valor);
        modeloTabela = (DefaultTableModel) tbListarProcesso.getModel();
        modeloTabela.setNumRows(0);
       
       for(Processo p:processos){
           modeloTabela.addRow(new Object[] {p.getIdProcesso(), p.getCliente(),p.getProcesso(), p.getIdCliente(), p.getIdAdvogado(), p.getIdAssessoria()});
        }
           tbListarProcesso.getTableHeader().setReorderingAllowed(false);
    }
    
    public void preencheClientes(String idCliente){
        ArrayList<Cliente> clientes = new ArrayList<>();
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
           
            comboCidade.setSelectedIndex(idCid);
            carregaBairrosCliente(String.valueOf(idCid));
            comboBairro.setSelectedIndex(idBarr);
    }
    
    //Carrega dados do processo
    public void preencheProcessos(String id){
        DaoProcesso daoProcesso = new DaoProcesso();
        ArrayList<Processo> processos = new DaoProcesso().Consultar(id);
        
        
        for (Processo pro:processos) {
            //Setando dados do processo
            tfProcesso.setText(pro.getProcesso());
            tfVara.setText(pro.getVara());
            tfAcao.setText(pro.getAcao());
            tfComarca.setText(pro.getComarca());
            tfDataInicio.setText(pro.getData_inicio());
            tfDataFim.setText(pro.getData_termino());
            tfsituacaoatual.setText(pro.getSituacao_atual());
            
            
        }  
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
            comboCidadeAssessoria.setSelectedIndex(idCid);
            carregaBairrosAssesoria(String.valueOf(String.valueOf(idCid)));
            comboBairroAssessoria.setSelectedIndex(idBarr);
    }
     
    public void preencheFinanceiro(String id){
        tfValor.setDocument(new LimitadorMoeda());
        tfValorDespesa.setDocument(new LimitadorMoeda());
        tfDesconto.setDocument(new LimitadorMoeda());
        
        ArrayList<Financeiro> financas = new DaoFinanceiro().consultarFinancas(id);
        for(Financeiro f:financas){
            tfValor.setText(f.getValor());
            tfValorDespesa.setText(f.getValor_despesa());
            tfDesconto.setText(f.getDesconto());
            tfTotal.setText(f.getValor_total());
            tfDescDespesa.setText(f.getDesc_despesa());        
            tfDataVencimento.setText(f.getVencimento());
            
        }
    }
    
    public void preencheAdvogado(String id){
        System.out.println("CONSULTA ADVOGADO ID: "+id);
        ArrayList<Advogado> advogados = new DaoAdvogado().Consultar(id);
         for(Advogado a: advogados){
             
             tfNomeAdvogado.setText(a.getNome());
             tfCelAdvogado.setText(a.getCelular());
             
         }
    }
    
    public void preencheVeiculo(String id){
        ArrayList<Veiculo> veiculo = new DaoVeiculo().Consultar(id);
        for(Veiculo v:veiculo){
            tfMarca.setText(v.getMarca());
            tfModelo.setText(v.getModelo());
            tfCor.setText(v.getCor());
            tfAnoFabricacao.setText(v.getAnoFabricacao());
            tfAnoModelo.setText(v.getAnoModelo());
            tfPlaca.setText(v.getPlaca());
            tfChassi.setText(v.getChassi());
            tfRenavam.setText(v.getRenavam());
            cbEstadoVeiculo.setSelectedItem(v.getEstado());
        }
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
        PainelAbas = new javax.swing.JTabbedPane();
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
        boxUsarCliente = new javax.swing.JCheckBox();
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
        boxUsarAdvogado = new javax.swing.JCheckBox();
        painelAssessoria = new javax.swing.JPanel();
        tfEnderecoAssessoria = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tfNomeAssessoria = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbBairro1 = new javax.swing.JLabel();
        boxUsarAssessoria = new javax.swing.JCheckBox();
        comboCidadeAssessoria = new javax.swing.JComboBox();
        btNovaCidadeAssessoria = new javax.swing.JButton();
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
        jCheckBox1 = new javax.swing.JCheckBox();
        painelConsultar = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        tfMarca = new javax.swing.JTextField();
        tfModelo = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        tfCor = new javax.swing.JTextField();
        tfPlaca = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        tfChassi = new javax.swing.JTextField();
        tfRenavam = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        tfAnoModelo = new javax.swing.JFormattedTextField();
        tfAnoFabricacao = new javax.swing.JFormattedTextField();
        jLabel39 = new javax.swing.JLabel();
        cbEstadoVeiculo = new javax.swing.JComboBox();
        painelOrdenar = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        comboFiltro = new javax.swing.JComboBox();
        btImprimir = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        tfPesquisa = new javax.swing.JTextField();
        btPequisar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbListarProcesso = new javax.swing.JTable();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        painelMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btNovo.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btNovo.setText("Novo (F1)");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        btNovo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btNovoKeyPressed(evt);
            }
        });

        btAlterar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btAlterar.setForeground(new java.awt.Color(210, 196, 0));
        btAlterar.setText("Alterar (F2)");
        btAlterar.setEnabled(false);
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btExcluir.setForeground(new java.awt.Color(255, 106, 0));
        btExcluir.setText("Excluir (F4)");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btCancelar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btCancelar.setForeground(new java.awt.Color(254, 13, 13));
        btCancelar.setText("Cancelar (F5)");
        btCancelar.setEnabled(false);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btSalvar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btSalvar.setForeground(new java.awt.Color(12, 122, 13));
        btSalvar.setText("Salvar (F3)");
        btSalvar.setEnabled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        btSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btSalvarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout painelMenuLayout = new javax.swing.GroupLayout(painelMenu);
        painelMenu.setLayout(painelMenuLayout);
        painelMenuLayout.setHorizontalGroup(
            painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, Short.MAX_VALUE)
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

        PainelAbas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                PainelAbasStateChanged(evt);
            }
        });

        lbNome.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
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

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel1.setText("DATA.NASC");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel5.setText("CPF");

        try {
            tfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel6.setText("NACIONALIDADE");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel7.setText("PROFISSÃO");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel8.setText("ESTA. CIVIL");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel10.setText("UF");

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

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel12.setText("CIDADE");

        comboBairro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar...." }));
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

        lbBairro.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
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

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel9.setText("CEP");

        lbNuemro.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        lbNuemro.setText("NÚMERO");
        lbNuemro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbEndereco.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
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

        lbTelefone.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        lbTelefone.setText("TELEFONE");
        lbTelefone.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbCelular.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        lbCelular.setText("CELULAR");
        lbCelular.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        try {
            tfCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCelularActionPerformed(evt);
            }
        });
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

        lbCelular1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        lbCelular1.setText("WhatsApp");
        lbCelular1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel11.setText("E-MAIL");

        try {
            tfEstado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        boxUsarCliente.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        boxUsarCliente.setText("USAR CLIENTE CADASTRADO");
        boxUsarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxUsarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelClienteLayout = new javax.swing.GroupLayout(painelCliente);
        painelCliente.setLayout(painelClienteLayout);
        painelClienteLayout.setHorizontalGroup(
            painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelClienteLayout.createSequentialGroup()
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addComponent(tfEstado)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelClienteLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel10)
                                        .addGap(19, 19, 19))))
                            .addGroup(painelClienteLayout.createSequentialGroup()
                                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNome)
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(tfDataNasci)))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(93, 93, 93))
                    .addGroup(painelClienteLayout.createSequentialGroup()
                        .addComponent(boxUsarCliente)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGap(24, 24, 24)
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelClienteLayout.createSequentialGroup()
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(painelClienteLayout.createSequentialGroup()
                                .addComponent(lbEndereco)
                                .addGap(33, 33, 33))
                            .addGroup(painelClienteLayout.createSequentialGroup()
                                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbNuemro)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(9, 9, 9)
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btNovaCidade)))
                    .addGroup(painelClienteLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btNovoBairro)
                            .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbCelular1)
                        .addComponent(jLabel11))
                    .addComponent(lbTelefone)
                    .addComponent(lbCelular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfWhats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cWhats, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxUsarCliente))
        );

        PainelAbas.addTab("CLIENTE", painelCliente);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("Nº PROCESSO");

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel14.setText("VARA");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("DATA INÍCIO");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("DATA TÉRMINO");

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
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

        jLabel19.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel19.setText("COMARCA");

        jLabel30.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel30.setText("SITUAÇÃO");

        comboSituacaoProcesso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ABERTO", "ARQUIVADO" }));

        jLabel31.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PainelAbas.addTab("PROCESSO", painelProcesso);

        jLabel15.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel15.setText("NOME");

        jLabel16.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel16.setText("Celular");

        try {
            tfCelAdvogado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        boxUsarAdvogado.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        boxUsarAdvogado.setText("USAR ADVOGADO CADASTRADO");
        boxUsarAdvogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxUsarAdvogadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelAdvogadoLayout = new javax.swing.GroupLayout(painelAdvogado);
        painelAdvogado.setLayout(painelAdvogadoLayout);
        painelAdvogadoLayout.setHorizontalGroup(
            painelAdvogadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAdvogadoLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(painelAdvogadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boxUsarAdvogado)
                    .addGroup(painelAdvogadoLayout.createSequentialGroup()
                        .addGroup(painelAdvogadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(tfNomeAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(painelAdvogadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16)
                            .addComponent(tfCelAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boxUsarAdvogado)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        PainelAbas.addTab("ADVOGADO", painelAdvogado);

        jLabel17.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel17.setText("ENDEREÇO");

        jLabel21.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel21.setText("NOME");

        jLabel22.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel22.setText("CIDADE");

        lbBairro1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lbBairro1.setText("BAIRRO");

        boxUsarAssessoria.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        boxUsarAssessoria.setText("USAR ASSESSORIA CADASTRADA");
        boxUsarAssessoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxUsarAssessoriaActionPerformed(evt);
            }
        });

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
                .addGroup(painelAssessoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelAssessoriaLayout.createSequentialGroup()
                        .addComponent(comboCidadeAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btNovaCidadeAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBairroAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btNovoBairroAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(boxUsarAssessoria)
                    .addGroup(painelAssessoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel17)
                        .addComponent(jLabel22)
                        .addGroup(painelAssessoriaLayout.createSequentialGroup()
                            .addGap(267, 267, 267)
                            .addComponent(lbBairro1))
                        .addComponent(jLabel21)
                        .addComponent(tfNomeAssessoria)
                        .addComponent(tfEnderecoAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelAssessoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBairroAssessoria, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btNovaCidadeAssessoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelAssessoriaLayout.createSequentialGroup()
                        .addComponent(comboCidadeAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btNovoBairroAssessoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEnderecoAssessoria, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boxUsarAssessoria)
                .addGap(41, 41, 41))
        );

        PainelAbas.addTab("ASSESSORIA", painelAssessoria);

        jLabel18.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel18.setText("VALOR");

        jLabel20.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel20.setText("DESPESAS");

        tfValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfValorKeyReleased(evt);
            }
        });

        tfValorDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfValorDespesaActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel23.setText("VALOR DESPESAS");

        tfDescDespesa.setColumns(20);
        tfDescDespesa.setRows(5);
        jScrollPane1.setViewportView(tfDescDespesa);

        jLabel24.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel24.setText("VENCIMENTO");

        jLabel25.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
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

        jLabel26.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel26.setText("SITUAÇÃO");

        tfTotal.setEditable(false);
        tfTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tfTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfTotal.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tfTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTotalActionPerformed(evt);
            }
        });

        btCalcular.setText("CALCULAR");
        btCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcularActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel27.setText("VALOR TOTAL");

        jCheckBox1.setText("Pago");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
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
                        .addComponent(jCheckBox1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(painelFinanceiroLayout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(jLabel27)))
                    .addComponent(btCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        painelFinanceiroLayout.setVerticalGroup(
            painelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFinanceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFinanceiroLayout.createSequentialGroup()
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
                        .addGap(18, 18, 18)
                        .addGroup(painelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(painelFinanceiroLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)))
                .addGroup(painelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfDataVencimento, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboSituacaofinanceiro, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );

        PainelAbas.addTab("FINANCEIRO", painelFinanceiro);

        jLabel32.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel32.setText("MARCA");

        jLabel33.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel33.setText("MODELO");

        jLabel34.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel34.setText("COR");

        jLabel35.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel35.setText("PLACA");

        jLabel36.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel36.setText("CHASSSI");

        jLabel37.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel37.setText("RENAVAM");

        jLabel38.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel38.setText("ANO DE FABRICAÇÃO E MODELO");

        try {
            tfAnoModelo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tfAnoFabricacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel39.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel39.setText("ESTADO DO VEÍCULO: ");

        cbEstadoVeiculo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar...", "Encontrado", "Não Encontrado", "Apreendido" }));

        javax.swing.GroupLayout painelConsultarLayout = new javax.swing.GroupLayout(painelConsultar);
        painelConsultar.setLayout(painelConsultarLayout);
        painelConsultarLayout.setHorizontalGroup(
            painelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelConsultarLayout.createSequentialGroup()
                        .addGroup(painelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(painelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(tfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCor, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addGroup(painelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelConsultarLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                                .addComponent(jLabel35)
                                .addGap(47, 47, 47))
                            .addGroup(painelConsultarLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfPlaca))))
                    .addGroup(painelConsultarLayout.createSequentialGroup()
                        .addGroup(painelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelConsultarLayout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbEstadoVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(painelConsultarLayout.createSequentialGroup()
                                .addGroup(painelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel38)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelConsultarLayout.createSequentialGroup()
                                        .addComponent(tfAnoFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfAnoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(painelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelConsultarLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(tfRenavam, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(painelConsultarLayout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel37)))))
                        .addGroup(painelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelConsultarLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel36)
                                .addGap(13, 13, 13))
                            .addGroup(painelConsultarLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(tfChassi)))))
                .addContainerGap())
        );
        painelConsultarLayout.setVerticalGroup(
            painelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultarLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(painelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35))
                .addGap(7, 7, 7)
                .addGroup(painelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(painelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfAnoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfRenavam, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfAnoFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfChassi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(painelConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEstadoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addContainerGap())
        );

        PainelAbas.addTab("VEÍCULO", painelConsultar);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel28.setText("FILTRAR POR:");

        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "CLIENTE", "PROCESSO" }));
        comboFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiltroActionPerformed(evt);
            }
        });

        btImprimir.setText("RELATÓRIO");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

        jLabel29.setText("PESQUISAR");

        tfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPesquisaKeyReleased(evt);
            }
        });

        btPequisar.setText("Pesquisar");
        btPequisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPequisarActionPerformed(evt);
            }
        });

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
                        .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 150, Short.MAX_VALUE))
                    .addComponent(tfPesquisa))
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
                    .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btImprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPequisar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbListarProcesso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CLIENTE", "PROCESSO", "C", "A", "AS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbListarProcesso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbListarProcessoMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListarProcessoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbListarProcesso);
        if (tbListarProcesso.getColumnModel().getColumnCount() > 0) {
            tbListarProcesso.getColumnModel().getColumn(0).setMinWidth(50);
            tbListarProcesso.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbListarProcesso.getColumnModel().getColumn(0).setMaxWidth(-20);
            tbListarProcesso.getColumnModel().getColumn(2).setMinWidth(150);
            tbListarProcesso.getColumnModel().getColumn(2).setPreferredWidth(150);
            tbListarProcesso.getColumnModel().getColumn(2).setMaxWidth(-20);
            tbListarProcesso.getColumnModel().getColumn(3).setMinWidth(50);
            tbListarProcesso.getColumnModel().getColumn(3).setPreferredWidth(50);
            tbListarProcesso.getColumnModel().getColumn(3).setMaxWidth(-20);
            tbListarProcesso.getColumnModel().getColumn(4).setMinWidth(50);
            tbListarProcesso.getColumnModel().getColumn(4).setPreferredWidth(50);
            tbListarProcesso.getColumnModel().getColumn(4).setMaxWidth(-20);
            tbListarProcesso.getColumnModel().getColumn(5).setMinWidth(50);
            tbListarProcesso.getColumnModel().getColumn(5).setPreferredWidth(50);
            tbListarProcesso.getColumnModel().getColumn(5).setMaxWidth(-20);
        }

        javax.swing.GroupLayout painelOrdenarLayout = new javax.swing.GroupLayout(painelOrdenar);
        painelOrdenar.setLayout(painelOrdenarLayout);
        painelOrdenarLayout.setHorizontalGroup(
            painelOrdenarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelOrdenarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelOrdenarLayout.setVerticalGroup(
            painelOrdenarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelOrdenarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PainelAbas.addTab("ORDENAR", painelOrdenar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PainelAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PainelAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
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
       
       if(item.equals("Selecionar....") || item == "null"){
           
           if(listaCheia == true){
               comboModelBairro.removeAllElements();
               comboModelBairro.addElement("Selecionar....");
           }
           comboBairro.setSelectedIndex(0);
       }else{
          
           carregaBairrosCliente("");
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
        carregaCidadesCliente();
        
    }//GEN-LAST:event_btNovaCidadeActionPerformed

    private void btNovoBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoBairroActionPerformed
        String item = String.valueOf(comboModelCidade.getSelectedItem());
        if(item == "Selecionar...."){
           JOptionPane.showMessageDialog(null, "SELECIONE UMA CIDADE!");
        } else {
             String b = "B";
             int cod = comboCidade.getSelectedIndex();
             new CadastroBairroCidade(b, "BAIRRO", item, cod).show();
             carregaBairrosCliente("");
             carregaBairrosAssesoria("");
           
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
           
    private void comboSituacaofinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSituacaofinanceiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSituacaofinanceiroActionPerformed

    private void btCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcularActionPerformed
        calcularTotal(tfValor.getText(), tfValorDespesa.getText(), tfDesconto.getText());
    }//GEN-LAST:event_btCalcularActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        
        btnovo();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
           btcancelar();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void tfNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyReleased
       
    }//GEN-LAST:event_tfNomeKeyReleased

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
       
    }//GEN-LAST:event_formKeyReleased

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        Object[] listaCliente = {tfNome,tfCpf,tfCep,tfEndereco,tfNumero,tfEstado,tfCelular};
        Object[] listaAdv = {tfNomeAdvogado,tfCelAdvogado};
        Object[] listaAcess = {tfNomeAssessoria,tfEnderecoAssessoria};
        Object[] listaFinanceiro = {tfValor,tfValorDespesa,tfDataVencimento};
        Object[] listaProcesso = {tfProcesso,tfDataInicio,tfDataFim,tfAcao,tfsituacaoatual,tfVara,tfComarca};
        Object[] listaVeiculo = {tfMarca,tfModelo,tfCor,tfPlaca,tfAnoModelo,tfAnoFabricacao,tfRenavam,tfChassi};
        
        Object[] listaCb = {comboCidade,comboBairro,comboCidadeAssessoria,
            comboBairroAssessoria,comboSituacaofinanceiro,comboSituacaoProcesso};
        
        btsalvar(listaCliente,listaProcesso,listaAdv,listaAcess,listaFinanceiro,listaVeiculo);
        
        
            
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tfValorDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValorDespesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfValorDespesaActionPerformed

    private void tfWhatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfWhatsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfWhatsActionPerformed

    private void btNovoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btNovoKeyPressed
               
    }//GEN-LAST:event_btNovoKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
         if(evt.getKeyCode() == evt.VK_F1){   
                            btnovo();
}
         if(evt.getKeyCode() == evt.VK_F2){   
                            btAlterar();
         }
         if(evt.getKeyCode() == evt.VK_F3){   
                            
             Object[] listaCliente = {tfNome,tfCpf,tfCep,tfEndereco,tfNumero,tfEstado,tfCelular};
        Object[] listaAdv = {tfNomeAdvogado,tfCelAdvogado};
        Object[] listaAcess = {tfNomeAssessoria,tfEnderecoAssessoria};
        Object[] listaFinanceiro = {tfValor,tfValorDespesa,tfDataVencimento};
        Object[] listaProcesso = {tfProcesso,tfDataInicio,tfDataFim,tfAcao,tfsituacaoatual,tfVara,tfComarca};
        Object[] listaVeiculo = {tfMarca,tfModelo,tfCor,tfPlaca,tfAnoModelo,tfAnoFabricacao,tfRenavam,tfChassi};
        
        Object[] listaCb = {comboCidade,comboBairro,comboCidadeAssessoria,
            comboBairroAssessoria,comboSituacaofinanceiro,comboSituacaoProcesso};
        
        btsalvar(listaCliente,listaProcesso,listaAdv,listaAcess,listaFinanceiro,listaVeiculo);
        
             
}
        
         
    }//GEN-LAST:event_formKeyPressed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        
        btAlterar();
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        
    }//GEN-LAST:event_btExcluirActionPerformed

    private void tbListarProcessoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListarProcessoMouseReleased
        
    }//GEN-LAST:event_tbListarProcessoMouseReleased

    private void tfCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCelularActionPerformed

    private void tbListarProcessoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListarProcessoMouseClicked
        if (evt.getClickCount() > 1) {  
           //btcancelar();
            
            btExcluir.setEnabled(true);
            btAlterar.setEnabled(true);
            
            
            
            try {
            
            idProcesso = tbListarProcesso.getValueAt(tbListarProcesso.getSelectedRow(),0).toString();
            idCliente =  tbListarProcesso.getValueAt(tbListarProcesso.getSelectedRow(),3).toString();
            idAdvogado =  tbListarProcesso.getValueAt(tbListarProcesso.getSelectedRow(),4).toString();
            idAssessoria =  tbListarProcesso.getValueAt(tbListarProcesso.getSelectedRow(),5).toString();
            
            System.out.println("ID CLIENTE: "+idCliente);
            System.out.println("ID ADVOGADO: "+idAdvogado);
            System.out.println("ID ASSESSORIA: "+idAssessoria);
            
                
                preencheAssessoria(idAssessoria);
                preencheAdvogado(idAdvogado);
                preencheVeiculo(idProcesso);
                preencheFinanceiro(idProcesso);
                preencheProcessos(idProcesso);
                preencheClientes(idCliente);
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SELECIONE UM CLIENTE PARA VER OU EDITAR");
        }
           
        }
    }//GEN-LAST:event_tbListarProcessoMouseClicked

    private void tfValorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfValorKeyReleased
            
    }//GEN-LAST:event_tfValorKeyReleased

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void tfTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTotalActionPerformed

    private void tfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaKeyReleased
        
        
    }//GEN-LAST:event_tfPesquisaKeyReleased

    private void PainelAbasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_PainelAbasStateChanged
            carregarTabela(null);
    }//GEN-LAST:event_PainelAbasStateChanged

    private void boxUsarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxUsarClienteActionPerformed
        // TODO add your handling code here:
        if(boxUsarCliente.isSelected()){
            boxCliente = true;
            //new ListaClientes().setVisible(true);
            ListaClientes lista = new ListaClientes();
           
           
            lista.setVisible(true);
            if(lista.isConcluido()){
                codigoCliente = lista.ConsultaCodigo();
                preencheClientes(codigoCliente);
                AtivarCliente(false);
               
            }else{
                boxUsarCliente.setSelected(false);
            }
        }else{
            boxCliente = false;
        }
    }//GEN-LAST:event_boxUsarClienteActionPerformed

    private void boxUsarAdvogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxUsarAdvogadoActionPerformed
        if(boxUsarAdvogado.isSelected()){
            boxAdvogado = true;
            //new ListaClientes().setVisible(true);
            ListaAdvogados lista = new ListaAdvogados();
           
           
            lista.setVisible(true);
            if(lista.isConcluido()){
                codigoAdvogado = lista.ConsultaCodigo();
                preencheAdvogado(codigoAdvogado);
                ativarCampoAdvogado(false);
                
            }else{
                boxUsarAdvogado.setSelected(false);
            }
        }else{
            boxAdvogado = false;
        }
    }//GEN-LAST:event_boxUsarAdvogadoActionPerformed

    private void boxUsarAssessoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxUsarAssessoriaActionPerformed
        if(boxUsarAssessoria.isSelected()){
            boxAssessoria = true;
            //new ListaClientes().setVisible(true);
            ListaAssessoria lista = new ListaAssessoria();
           
           
            lista.setVisible(true);
            if(lista.isConcluido()){
                codigoAssessoria = lista.ConsultaCodigo();
                preencheAssessoria(codigoAssessoria);
                ativarCampoAssessoria(false);
                
            }else{
                boxUsarAssessoria.setSelected(false);
            }
        }else{
            boxAssessoria = false;
        }
    }//GEN-LAST:event_boxUsarAssessoriaActionPerformed

    private void comboCidadeAssessoriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCidadeAssessoriaMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCidadeAssessoriaMouseExited

    private void comboCidadeAssessoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCidadeAssessoriaActionPerformed
        
        String item = String.valueOf(comboModelCidadeAssesoria.getSelectedItem());
       
       if(item.equals("Selecionar....") || item == "null"){
           
           if(listaCheia == true){
               comboModelBairroAssesoria.removeAllElements();
               comboModelBairroAssesoria.addElement("Selecionar....");
           }
           comboBairroAssessoria.setSelectedIndex(0);
       }else{
           
           carregaBairrosAssesoria("");
           listaCheia = true;
       }
    }//GEN-LAST:event_comboCidadeAssessoriaActionPerformed

    private void btNovaCidadeAssessoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaCidadeAssessoriaActionPerformed
        String c = "C";
        new CadastroBairroCidade(c, "CIDADE", null, 0).setVisible(true);
        carregaCidadesAssessoria();
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
        String item = String.valueOf(comboModelCidadeAssesoria.getSelectedItem());
        if(item == "Selecionar...."){
           JOptionPane.showMessageDialog(null, "SELECIONE UMA CIDADE!");
        } else {
             String b = "B";
             int cod = comboCidadeAssessoria.getSelectedIndex();
             new CadastroBairroCidade(b, "BAIRRO", item, cod).show();
             carregaBairrosCliente("");
             carregaBairrosAssesoria("");
           
        }
    }//GEN-LAST:event_btNovoBairroAssessoriaActionPerformed

    private void comboFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltroActionPerformed
      
    }//GEN-LAST:event_comboFiltroActionPerformed

    private void btPequisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPequisarActionPerformed
        
    }//GEN-LAST:event_btPequisarActionPerformed

    private void btSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btSalvarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSalvarKeyPressed

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed

        
        DaoCliente dao = new DaoCliente();
        DaoCidade daocid = new DaoCidade();
        Relatorio relatorio = new Relatorio();
        String id = String.valueOf(tbListarProcesso.getValueAt(0,0));
        String codCliente = String.valueOf(tbListarProcesso.getValueAt(0,3));
        String codAdvogado = String.valueOf(tbListarProcesso.getValueAt(0,4));
        String codAssesoria = String.valueOf(tbListarProcesso.getValueAt(0,5));
        
        ArrayList<Cliente> cli = dao.Consultar(codCliente);
        ArrayList<Processo> procesos = new DaoProcesso().Consultar(id);
        ArrayList<Veiculo> veiculo = new DaoVeiculo().Consultar(id);
        ArrayList<Cidade> cidades = daocid.consultar(codCliente);
         DaoBairro daoBairro = new DaoBairro();
        ArrayList<Bairro> bairros = daoBairro.consultar(cli.get(0).getBairro());
        
        
        try {
            
            relatorio.gerar(cli.get(0), processos.get(0), veiculo.get(0), cidades.get(0),bairros.get(0));
            
        } catch (DocumentException | FileNotFoundException ex) {
            
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            
       
        

    }//GEN-LAST:event_btImprimirActionPerformed
     
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
            @Override
            public void run() {
               // new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane PainelAbas;
    private javax.swing.JCheckBox boxUsarAdvogado;
    private javax.swing.JCheckBox boxUsarAssessoria;
    private javax.swing.JCheckBox boxUsarCliente;
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
    private javax.swing.JComboBox cbEstadoVeiculo;
    private javax.swing.JComboBox comboBairro;
    private javax.swing.JComboBox comboBairroAssessoria;
    private javax.swing.JComboBox comboCidade;
    private javax.swing.JComboBox comboCidadeAssessoria;
    private javax.swing.JComboBox comboFiltro;
    private javax.swing.JComboBox comboSituacaoProcesso;
    private javax.swing.JComboBox comboSituacaofinanceiro;
    private javax.swing.JCheckBox jCheckBox1;
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
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JTable tbListarProcesso;
    private javax.swing.JTextField tfAcao;
    private javax.swing.JFormattedTextField tfAnoFabricacao;
    private javax.swing.JFormattedTextField tfAnoModelo;
    private javax.swing.JFormattedTextField tfCelAdvogado;
    private javax.swing.JFormattedTextField tfCelular;
    private javax.swing.JFormattedTextField tfCep;
    private javax.swing.JTextField tfChassi;
    private javax.swing.JTextField tfComarca;
    private javax.swing.JTextField tfCor;
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
    private javax.swing.JTextField tfMarca;
    private javax.swing.JTextField tfModelo;
    private javax.swing.JTextField tfNacionalidade;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNomeAdvogado;
    private javax.swing.JTextField tfNomeAssessoria;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfPesquisa;
    private javax.swing.JTextField tfPlaca;
    private javax.swing.JTextField tfProcesso;
    private javax.swing.JTextField tfProfissao;
    private javax.swing.JTextField tfRenavam;
    private javax.swing.JFormattedTextField tfTelefone;
    private javax.swing.JFormattedTextField tfTotal;
    private javax.swing.JFormattedTextField tfValor;
    private javax.swing.JFormattedTextField tfValorDespesa;
    private javax.swing.JFormattedTextField tfVara;
    private javax.swing.JFormattedTextField tfWhats;
    private javax.swing.JTextField tfsituacaoatual;
    // End of variables declaration//GEN-END:variables
}
