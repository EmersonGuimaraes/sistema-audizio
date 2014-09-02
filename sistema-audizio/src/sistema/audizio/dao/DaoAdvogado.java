

package sistema.audizio.dao;

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
        EstabelecerConexao();
        sql = "INSERT INTO tb_advogado VALUES('"+advogado.getNome()+"','"+advogado.getOab()+"','"+advogado.getArea_atuacao()+"')";
    }
    
    public void Editar(Advogado advogado){
        EstabelecerConexao();
        sql = "UPDATE tb_advogado SET nome = '"+advogado.getNome()+"', oab = '"+advogado.getOab()+"','"+advogado.getArea_atuacao()+"' WHERE oab = '"+advogado.getOab()+"'";
    }
    public void Deletar(Advogado advogado){
        EstabelecerConexao();
        sql = "DELETE FROM tb_advogado WHERE oab = '"+advogado.getOab()+"'";
    } 
}
