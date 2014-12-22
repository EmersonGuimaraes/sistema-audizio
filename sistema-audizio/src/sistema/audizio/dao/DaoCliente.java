
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
        sql = "INSERT INTO tb_cliente VALUES(null,'"+cliente.getNome()+"','"+cliente.getNascimento()+"',"
                + "'"+cliente.getCpf()+"','"+cliente.getNacionalidade()+"','"+cliente.getProfisao()+"',"
                + "'"+cliente.getEstado_civil()+"','"+cliente.getCep()+"','"+cliente.getEndereco()+"',"
                + "'"+cliente.getNum()+"','"+cliente.getEstado()+"','"+cliente.getCidade()+"','"+cliente.getBairro()+"',"
                + "'"+cliente.getFone()+"','"+cliente.getCelular()+"','"+cliente.getEmail()+"','"+cliente.getWhatsapp()+"','"+cliente.getCod()+"')";

        ConsultarSQL(sql, false);
        
    }
    
    public void Editar(Cliente cliente){
        System.out.println("ID CLIENTE UPDATE = "+cliente.getIdCliente());
      sql = "UPDATE tb_cliente SET nome='"+cliente.getNome()+"',nascimento='"+cliente.getNascimento()+"',"
              + "cpf='"+cliente.getCpf()+"',"
              + "nacionalidade='"+cliente.getNacionalidade()+"',profissao='"+cliente.getProfisao()+"',"
              + "estado_civil='"+cliente.getEstado_civil()+"',cep='"+cliente.getCep()+"',"
              + "endereco='"+cliente.getEndereco()+"',numero='"+cliente.getNum()+"',estado='"+cliente.getEstado()+"',"
              + "cidade='"+cliente.getCidade()+"',bairro='"+cliente.getBairro()+"',telefone='"+cliente.getFone()+"',"
              + "celular='"+cliente.getCelular()+"',email='"+cliente.getEmail()+"',whatsapp='"+cliente.getWhatsapp()+"' WHERE id = '"+cliente.getIdCliente()+"'";
        ConsultarSQL(sql, false);
        
    }
    public void Deletar(Cliente cliente){
        sql = "DELETE FROM tb_cliente WHERE id = '"+cliente.getIdCliente()+"'";
        ConsultarSQL(sql, false);
    }
    
    public ArrayList<Cliente> Consultar(String id){
        //("") - Pesquisa sem precisar de id.
        ArrayList<Cliente> clientes = new ArrayList();
        try {
            
            if(id.equals("")){
                String sql = "SELECT id,nome,email,telefone,cod FROM tb_cliente";
                ConsultarSQL(sql,true);
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(rs.getString("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setFone(rs.getString("telefone"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setCod(rs.getInt("cod"));

                    clientes.add(cliente);
                }
            }else{
                String sql = "SELECT * FROM tb_cliente WHERE id = '"+id+"'";
                ConsultarSQL(sql,true);
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(rs.getString("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setNascimento(rs.getString("nascimento"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setNacionalidade(rs.getString("nacionalidade"));
                    cliente.setProfisao(rs.getString("profissao"));
                    cliente.setEstado_civil(rs.getString("estado_civil"));
                    cliente.setCep(rs.getString("cep"));
                    cliente.setEndereco(rs.getString("endereco"));
                    cliente.setCidade(rs.getString("cidade"));
                    cliente.setBairro(rs.getString("bairro"));
                    cliente.setFone(rs.getString("telefone"));
                    cliente.setCelular(rs.getString("celular"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setEstado(rs.getString("estado"));
                    cliente.setNum(rs.getString("numero"));
                    cliente.setWhatsapp(rs.getString("whatsapp"));
                    cliente.setCod(rs.getInt("cod"));
                    clientes.add(cliente);
             }
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return clientes;
    
    }
    
    public int retornaCod(){
       int codA = 0;
        String sql= "SELECT * FROM tb_cliente ORDER BY cod DESC LIMIT 1";
        try {
            ConsultarSQL(sql, true);
           
            while (rs.next()) {
                codA = rs.getInt("cod");
            }
            System.out.println("cod :"+codA);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na consulta do cod");
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
           codA = 1;
        }
         System.out.println("cod2 :"+codA);
        return codA;
    }
    
    public static void main(String[] args) {
      
        new DaoCliente().retornaCod();
        
        }
  
}



