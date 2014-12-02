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
import sistema.audizio.bean.Bairro;

/**
 *
 * @author emerson
 */
public class DaoBairro extends Conexao{
     String sql;
    public void cadastrar(Bairro bairro){
       sql = "INSERT INTO tb_bairro VALUES(null,'"+bairro.getNome()+"','"+bairro.getCod_cidade()+"')";
        ConsultarSQL(sql, false);
        
    }
    public void editar(Bairro bairro){
        sql = "UPDATE tb_bairro SET bairro = '"+bairro.getNome()+"' WHERE cod='"+bairro.getCod()+"'";
        ConsultarSQL(sql, false);
    }
    
     public ArrayList<Bairro> consultar(String idCidade){
         
        ArrayList<Bairro> bairros = new ArrayList<>();
        try {
            sql = "SELECT * FROM tb_bairro WHERE id_cidade = '"+idCidade+"'";
            ConsultarSQL(sql, true);
            
            while (rs.next()) {
               Bairro bairro = new Bairro();
               bairro.setCod(rs.getString("id"));
               bairro.setNome(rs.getString("bairro"));
               bairro.setCod_cidade(rs.getString("id_cidade"));
              
               bairros.add(bairro);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoCidade.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro bairros");
        }
        return bairros;
    }
     
     public ArrayList<Bairro> consultar2(String idCidade){
        ArrayList<Bairro> bairros = new ArrayList<>();
        
        try {
            sql = "SELECT * FROM tb_bairro WHERE id_cidade = '"+idCidade+"'";
            ConsultarSQL(sql, true);
            
            while (rs.next()) {
               Bairro bairro = new Bairro();
               bairro.setNome(rs.getString("bairro"));
              
               bairros.add(bairro);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoCidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bairros;
    }
}
