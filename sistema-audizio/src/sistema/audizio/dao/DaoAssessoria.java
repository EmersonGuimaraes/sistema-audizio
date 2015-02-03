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
import sistema.audizio.bean.Assessoria;

/**
 *
 * @author zipnet
 */
public class DaoAssessoria extends Conexao{
    String sql;
    public void cadastrar(Assessoria a){
       sql ="INSERT INTO tb_assessoria VALUES(null,'"+a.getNome()+"','"+a.getCidade()+"','"+a.getBairro()+"','"+a.getEndereco()+"',"
               + "'"+a.getNome_advogado()+"','"+a.getTelefone_assessoria()+"','"+a.getCod()+"')";
        ConsultarSQL(sql, false);
        
    }
    
    public void editar(Assessoria a){
        sql = "UPDATE tb_assessoria SET nome = '"+a.getNome()+"', cidade = '"+a.getCidade()+"',"
                + "bairro = '"+a.getBairro()+"', endereco = '"+a.getEndereco()+"', nome_advogado = '"+a.getNome_advogado()+"', telefone = '"+a.getTelefone_assessoria()+"' WHERE cod = '"+a.getId()+"'";
        
        ConsultarSQL(sql, false);
        
    }
    
    public ArrayList<Assessoria> consultar(String id){
        ArrayList<Assessoria> ass = new ArrayList<>();
        try {
            
            if(id.equals("")){
                sql="SELECT * FROM tb_assessoria;";
            }else{
                sql="SELECT * FROM tb_assessoria WHERE cod = '"+id+"';";
            }
            ConsultarSQL(sql, true);
            while (rs.next()) {
                Assessoria a = new Assessoria();
                a.setId(rs.getString("id"));
                a.setCod(rs.getInt("cod"));
                a.setNome(rs.getString("nome"));
                a.setCidade(rs.getString("cidade"));
                a.setBairro(rs.getString("bairro"));
                a.setEndereco(rs.getString("endereco"));
                a.setNome_advogado(rs.getString("nome_advogado"));
                a.setTelefone_assessoria(rs.getString("telefone"));
                System.out.println("Ass: "+rs.getString("nome"));
                ass.add(a);
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(DaoAssessoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ass;
    }
    
     public int retornaCod(){
       int codA = 0;
        String sql= "SELECT * FROM tb_assessoria ORDER BY cod DESC LIMIT 1";
        try {
            ConsultarSQL(sql, true);
           
            while (rs.next()) {
                codA = rs.getInt("cod");
            }
            
            System.out.println("cod :"+codA);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na consulta do cod");
            Logger.getLogger(DaoAssessoria.class.getName()).log(Level.SEVERE, null, ex);
           codA = 1;
        }
         System.out.println("cod2 :"+codA);
        return codA;
    }
}
