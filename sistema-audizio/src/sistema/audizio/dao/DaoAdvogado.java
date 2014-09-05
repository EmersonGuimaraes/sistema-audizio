

package sistema.audizio.dao;

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
      
        sql = "UPDATE tb_advogado SET nome = '"+advogado.getNome()+"', oab = '"+advogado.getOab()+"','"+advogado.getArea_atuacao()+"' WHERE oab = '"+advogado.getOab()+"'";
    }
    public void Deletar(Advogado advogado){
        
        sql = "DELETE FROM tb_advogado WHERE oab = '"+advogado.getOab()+"'";
    } 
}
