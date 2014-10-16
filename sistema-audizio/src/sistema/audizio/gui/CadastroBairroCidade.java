/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.gui;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sistema.audizio.bean.Bairro;
import sistema.audizio.bean.Cidade;
import sistema.audizio.dao.DaoBairro;
import sistema.audizio.dao.DaoCidade;

/**
 *
 * @author emerson
 */
public class CadastroBairroCidade extends JDialog implements ActionListener{
    JLabel lbCidade = new JLabel("CIDADE");
    JLabel lbBairro = new JLabel("BAIRRO");
	
    JTextField tfCidade = new JTextField();
    JTextField tfBairro = new JTextField();
	
    JButton btCancelar = new JButton("CANCELAR");
    JButton btSalvar = new JButton("SALVAR");
    
    String titulo;
    String botao;
    String nomeCidade;
    String codCidade;
    
    public CadastroBairroCidade(String botao,String titulo,String cidade,int codCid) {
       
                this.botao = botao;
		this.titulo = titulo;
		this.nomeCidade = cidade;
		this.codCidade = String.valueOf(codCid);
		inicializa();
		tfBairro.setEnabled(false);
		tfCidade.setEnabled(false);
		
		
		if (botao.equals("C")) {
			tfCidade.setEnabled(true);
		}else{
			tfBairro.setEnabled(true);
			tfCidade.setText(nomeCidade);
		}
        
    }
    
    public void inicializa(){
                setTitle("Cadastro de "+titulo);
		setSize(558, 224);
		setLayout(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
                setModal(true);
     
                
		
		lbCidade.setBounds(20, -30, 124, 133);
		lbBairro.setBounds(300, -30, 124, 133);
		tfCidade.setBounds(20, 50, 216, 31);
		tfBairro.setBounds(300, 50, 216, 31);
		
		
		btCancelar.setBounds(20, 100, 216, 70);
		btSalvar.setBounds(300,100, 216, 70);
		btCancelar.addActionListener(this);
		btSalvar.addActionListener(this);
	
		
		add(lbCidade);
		add(lbBairro);
		add(tfCidade);
		add(tfBairro);
		add(btCancelar);
		add(btSalvar);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "CANCELAR") {
			this.dispose();
			
		}
		if (e.getActionCommand()=="SALVAR") {
			if(tfCidade.getText().equals("") && tfBairro.getText().equals("") ){
				JOptionPane.showMessageDialog(this, "PREENCHA OS CAMPOS CORRETAMENTE!");
			}else{
				if(botao.equals("C")){
                                        Cidade cidade = new Cidade();
					DaoCidade daoCidade = new DaoCidade();
                                        cidade.setNome(tfCidade.getText());
                                        daoCidade.cadastrar(cidade);
					this.dispose();
				}
				if (botao.equals("B")) {
					DaoBairro daoBairro = new DaoBairro();
                                        Bairro bairro = new Bairro();
                                        bairro.setNome(tfBairro.getText());
                                        bairro.setCod_cidade(codCidade);
                                        daoBairro.cadastrar(bairro);
					JOptionPane.showMessageDialog(null, "BAIRRO CADASTRADO COM SUCESSO!");
					this.dispose();
				}
				
				
			
				
			
			}
			
			
		}
    }
    
}
