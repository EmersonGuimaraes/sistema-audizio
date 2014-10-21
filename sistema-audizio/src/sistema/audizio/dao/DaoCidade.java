/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.audizio.bean.Cidade;

/**
 *
 * @author emerson
 */
public class DaoCidade extends Conexao{
    String sql;
    public void cadastrar(Cidade cidade){
       sql = "INSERT INTO tb_cidade VALUES(null,'"+cidade.getNome()+"')";
        ConsultarSQL(sql, false);
        JOptionPane.showMessageDialog(null, "CIDADE CADASTRADA COM SUCESSO!");
    }
    public void editar(Cidade cidade){
        sql = "UPDATE tb_cidade SET cidade = '"+cidade.getNome()+"' WHERE cod='"+cidade.getCod()+"'";
        ConsultarSQL(sql, false);
    }
    public ArrayList<Cidade> consultar(String id){
        ArrayList<Cidade> cidades = new ArrayList<>();
        try {
            sql = "SELECT * FROM tb_cidade";
            ConsultarSQL(sql, true);
            
            while (rs.next()) {
               Cidade cidade = new Cidade();
               cidade.setCod(rs.getString("id"));
               cidade.setNome(rs.getString("cidade"));
              
               cidades.add(cidade);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoCidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cidades;
    }
    
    
}