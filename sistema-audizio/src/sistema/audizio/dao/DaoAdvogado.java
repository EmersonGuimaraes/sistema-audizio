

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
     
        sql = "INSERT INTO tb_advogado VALUES(null,'"+advogado.getNome()+"','"+advogado.getCelular()+"','"+advogado.getCod()+"')";
        ConsultarSQL(sql, false);
        
    }
    
    public void Editar(Advogado advogado){
      
        sql = "UPDATE tb_advogado SET nome = '"+advogado.getNome()+"', cel = '"+advogado.getCelular()+"' WHERE cod = '"+advogado.getIdAdvogado()+"'";
    }
    public void Deletar(Advogado advogado){
        
        sql = "DELETE FROM tb_advogado WHERE cod = '"+advogado.getIdAdvogado()+"'";
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
                            advogado.setCelular(rs.getString("cel"));
                            advogado.setCod(rs.getInt("cod"));
                            advogados.add(advogado);

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(DaoAdvogado.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }else{
                    try {
                        ConsultarSQL("SELECT * FROM tb_advogado WHERE cod = '"+id+"'", true);
                        while (rs.next()) {

                            Advogado advogado = new Advogado();
                            advogado.setIdAdvogado(rs.getString("id"));
                            advogado.setNome(rs.getString("nome"));
                            advogado.setCelular(rs.getString("cel"));
                            advogado.setCod(rs.getInt("cod"));
                            advogados.add(advogado);

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(DaoAdvogado.class.getName()).log(Level.SEVERE, null, ex);
                    }
               
           }
       
         return advogados;
        
    }
    
    public int retornaCod(){
       int codA = 0;
        String sql= "SELECT * FROM tb_advogado ORDER BY cod DESC LIMIT 1";
        try {
            ConsultarSQL(sql, true);
           
            while (rs.next()) {
                codA = rs.getInt("cod");
            }
            
            System.out.println("cod :"+codA);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na consulta do cod");
            Logger.getLogger(DaoAdvogado.class.getName()).log(Level.SEVERE, null, ex);
           codA = 1;
        }
         System.out.println("cod2 :"+codA);
        return codA;
    }
}
