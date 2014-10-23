/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.dao;

import javax.swing.JOptionPane;
import sistema.audizio.bean.Financeiro;

/**
 *
 * @author ZipNet
 */
public class DaoFinanceiro extends Conexao{
    String sql;
    public DaoFinanceiro() {
    }
    
    public void Cadastrar(Financeiro financeiro){
        
        sql="INSERT INTO tb_financeiro VALUES(null,'"+financeiro.getCobranca()+"','"+financeiro.getDescricao()+"','"+financeiro.getDespesas()+"',"
                + "'"+financeiro.getData_pagamento()+"','"+financeiro.getValor()+"')";
        ConsultarSQL(sql, false);
        JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!");
    }
    public void Editar(Financeiro financeiro){
        System.out.println("Id financeiro no dao:"+financeiro.getIdProcesso());
        sql="UPDATE tb_financeiro SET cobranca = '"+financeiro.getCobranca()+"',descricao = '"+financeiro.getDescricao()+"',despesas = '"+financeiro.getDespesas()+"',"
                + "data_pagamento = '"+financeiro.getData_pagamento()+"',valor = '"+financeiro.getValor()+"' WHERE id = '"+financeiro.getIdProcesso()+"'";
        ConsultarSQL(sql, false);
    }
    
    public void Deletar(Financeiro financeiro){
        
        sql="DELETE FROM tb_financeiro WHERE id = '"+financeiro.getIdProcesso()+"'";
    }
       
}
