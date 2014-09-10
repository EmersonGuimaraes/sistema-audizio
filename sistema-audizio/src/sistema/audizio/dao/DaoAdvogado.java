

package sistema.audizio.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.audizio.bean.Advogado;

/**
 *
 * @author emerson
 */
public class DaoAdvogado extends Conexao{
    String sql;

    public DaoAdvogado() {
    }
    
    public void Cadastrar(Advogado advogado){
     
        sql = "INSERT INTO tb_advogado VALUES(null,'"+advogado.getNome()+"','"+advogado.getOab()+"','"+advogado.getArea_atuacao()+"')";
        ConsultarSQL(sql, false);
        JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!");
    }
    
    public void Editar(Advogado advogado){
      
        sql = "UPDATE tb_advogado SET nome = '"+advogado.getNome()+"', oab = '"+advogado.getOab()+"','"+advogado.getArea_atuacao()+"' WHERE id = '"+advogado.getIdAdvogado()+"'";
    }
    public void Deletar(Advogado advogado){
        
        sql = "DELETE FROM tb_advogado WHERE oab = '"+advogado.getOab()+"'";
    } 
    
    public ArrayList<Advogado> Consultar(String id){
        ArrayList<Advogado> advogados = new ArrayList<>();
        
        
            if(id.equals("")){
            try {
                ConsultarSQL("SELECT * FROM tb_advogado", true);
                while (rs.next()) {
                    
                    Advogado advogado = new Advogado();
                    advogado.setIdAdvogado(rs.getString("id"));
                    advogado.setNome(rs.getString("nome"));
                    advogado.setOab(rs.getString("oab"));
                    advogado.setArea_atuacao(rs.getString("area_atuacao"));
                    
                    advogados.add(advogado);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoAdvogado.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else{
            try {
                ConsultarSQL("SELECT * FROM tb_advogado WHERE id = '"+id+"'", true);
                while (rs.next()) {
                    
                    Advogado advogado = new Advogado();
                    advogado.setIdAdvogado(rs.getString("id"));
                    advogado.setNome(rs.getString("nome"));
                    advogado.setOab(rs.getString("oab"));
                    advogado.setArea_atuacao(rs.getString("area_atuacao"));
                    
                    advogados.add(advogado);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoAdvogado.class.getName()).log(Level.SEVERE, null, ex);
            }
               
           }
       
         return advogados;
        
    }
}
