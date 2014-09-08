
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
        System.out.println("cpf:"+cliente.getCpf());
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
    public ArrayList<Cliente> Consultar(){
        ArrayList<Cliente> clientes = new ArrayList();
        try {
            ConsultarSQL("SELECT id,nome,email,telefone FROM tb_cliente",true);
            rs.first();
            while (rs.next()) {
              Cliente cliente = new Cliente();
              cliente.setNome(rs.getString("nome"));
              cliente.setFone(rs.getString("telefone"));
              cliente.setEmail(rs.getString("email"));
              
              clientes.add(cliente);
                
            }
            for(Cliente cli:clientes){
                System.out.println(cli.getNome());
                System.out.println(cli.getFone());
                System.out.println(cli.getEmail());
                               
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    
    }
  }



