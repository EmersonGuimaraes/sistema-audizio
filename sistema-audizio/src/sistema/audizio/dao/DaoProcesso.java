/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.dao;

import javax.swing.JOptionPane;
import sistema.audizio.bean.Processo;

/**
 *
 * @author emerson
 */
public class DaoProcesso extends Conexao{
    String sql;
    public DaoProcesso() {
    }
    
    public void Cadastrar(Processo processo){
        
        sql="INSERT INTO tb_processo VALUES(null,'"+processo.getProcesso()+"','"+processo.getData_inicio()+"','"+processo.getData_termino()+"',"
                + "'"+processo.getCliente()+"','"+processo.getAdvogado()+"','"+processo.getValor()+"','"+processo.getAcao()+"','"+processo.getReboqueiro()+"')";
        ConsultarSQL(sql, false);
        JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!");
    }
    public void Editar(Processo processo){
   
        sql="UPDATE tb_processo SET processo = '"+processo.getProcesso()+"',data_inicio = '"+processo.getData_inicio()+"',data_termino = '"+processo.getData_termino()+"',"
                + "cliente = '"+processo.getCliente()+"',advogado = '"+processo.getAdvogado()+"',valor = '"+processo.getValor()+"',"
                + "acao = '"+processo.getAcao()+"',reboqueiro = '"+processo.getReboqueiro()+"' WHERE processo = '"+processo.getProcesso()+"'";
    }
    
    public void Deletar(Processo processo){
        
        sql="DELETE FROM tb_processo WHERE processo = '"+processo.getProcesso()+"'";
    }
    
    
}
