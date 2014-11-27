/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.audizio.dao;

import javax.swing.JOptionPane;
import sistema.audizio.bean.Banco;

/**
 *
 * @author Emerson Guimarães
 */
public class DaoBanco extends Conexao{
    public void cadastrar(Banco banco){
        String sql = "INSERT INTO tb_banco VALUES (null,'"+banco.getNome()+"')";
        ConsultarSQL(sql, false);
        
    }
    
}
