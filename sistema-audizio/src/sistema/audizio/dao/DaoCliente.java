
package sistema.audizio.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.audizio.bean.Cliente;

/**
 *
 * @author emerson
 */
public class DaoCliente extends Conexao{
    String sql;
    
    public void Cadastrar(Cliente cliente){
        sql = "INSERT INTO tb_cliente VALUES(null,'"+cliente.getNome()+"','"+cliente.getNascimento()+"','"+cliente.getRg()+"',"
                + "'"+cliente.getOrgao_exp()+"','"+cliente.getData_exp()+"','"+cliente.getCpf()+"','"+cliente.getNacionalidade()+"',"
                + "'"+cliente.getProfisao()+"','"+cliente.getEstado_civil()+"','"+cliente.getCep()+"','"+cliente.getEndereco()+"',"
                + "'"+cliente.getEstado()+"','"+cliente.getCidade()+"','"+cliente.getBairro()+"','"+cliente.getFone()+"','"+cliente.getEmail()+"')";
        ConsultarSQL(sql, false);
        JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!");
    }
    
    public void Editar(Cliente cliente){
       
        sql = "UPDATE FROM tb_cliente SET nome = '"+cliente.getNome()+"',nascimento = '"+cliente.getNascimento()+"',rg = '"+cliente.getRg()+"',"
                + "orgao_exp = '"+cliente.getOrgao_exp()+"',data_exp = '"+cliente.getData_exp()+"',cpf = '"+cliente.getCpf()+"',nacionalidade = '"+cliente.getNascimento()+"',"
                + "profissao = '"+cliente.getProfisao()+"',estado_civil = '"+cliente.getEstado_civil()+"',cep = '"+cliente.getCep()+"',endereco = '"+cliente.getEndereco()+"',"
                + "estado = '"+cliente.getEstado()+"',cidade = '"+cliente.getCidade()+"',bairro = '"+cliente.getBairro()+"',telefone = '"+cliente.getFone()+"',"
                + "email = '"+cliente.getEmail()+"' WHERE nome = '"+cliente.getNome()+"'";
        ConsultarSQL(sql, false);
    }
    public void Deletar(Cliente cliente){
        sql = "DELETE FROM tb_cliente WHERE nome = '"+cliente.getNome()+"'";
        ConsultarSQL(sql, false);
    }
    public ArrayList<String> Consultar(){
        ArrayList<String> dados = new ArrayList();
        try {
            ConsultarSQL("SELECT id,nome,email,telefone FROM tb_cliente",true);
            rs.first();
            while (rs.next()) {
                dados.add(rs.getString("id"));
                dados.add(rs.getString("nome"));
                dados.add(rs.getString("telefone"));
                dados.add(rs.getString("email"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dados;
    
    }
  }



