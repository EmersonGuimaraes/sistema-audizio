
package sistema.audizio.dao;

import sistema.audizio.bean.Cliente;

/**
 *
 * @author emerson
 */
public class DaoCliente extends Conexao{
    String sql;
    public DaoCliente() {
        
    }
    
    public void Cadastrar(Cliente cliente){
        EstabelecerConexao();
        sql = "INSERT INTO tb_cliente VALUES('"+cliente.getNome()+"','"+cliente.getNascimento()+"','"+cliente.getRg()+"',"
                + "'"+cliente.getOrgao_exp()+"','"+cliente.getData_exp()+"','"+cliente.getCpf()+"','"+cliente.getNacionalidade()+"',"
                + "'"+cliente.getProfisao()+"','"+cliente.getEstado_civil()+"','"+cliente.getCep()+"','"+cliente.getEndereco()+"',"
                + "'"+cliente.getEstado()+"','"+cliente.getCidade()+"','"+cliente.getBairro()+"','"+cliente.getFone()+"','"+cliente.getEmail()+"')";
    }
    
    public void Editar(Cliente cliente){
        EstabelecerConexao();
        sql = "";
    }
    public void Deletar(Cliente cliente){
        EstabelecerConexao();
        sql = "DELETE FROM tb_cliente WHERE nome = '"+cliente.getNome()+"'";
    }
  }



