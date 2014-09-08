/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.dao;

import sistema.audizio.bean.Veiculo;

/**
 *
 * @author Emerson
 */
public class DaoVeiculo extends Conexao{
    String sql;
    public void Cadastrar(Veiculo veiculo){
        sql = "INSERT INTO tb_veiculo VALUES(null,'"+veiculo.getMarca()+"','"+veiculo.getModelo()+"',"
                + "'"+veiculo.getCor()+"','"+veiculo.getAnoFabricacao()+"','"+veiculo.getAnoModelo()+"','"+veiculo.getPlaca()+"','"+veiculo.getChassi()+"')";
        
        ConsultarSQL(sql, false);
    }
    
    public void Editar(Veiculo veiculo){
        sql = "UPDATE tb_veiculo SET marca='"+veiculo.getMarca()+"',modelo='"+veiculo.getMarca()+"',"
                + "cor='"+veiculo.getMarca()+"',ano_fabricacao='"+veiculo.getMarca()+"',ano_modelo='"+veiculo.getMarca()+"',"
                + "placa='"+veiculo.getMarca()+"',chassi='"+veiculo.getMarca()+"'";
        
        ConsultarSQL(sql, false);
    }
    
    public void Deletar(Veiculo veiculo){
        sql = "DELETE FROM tb_veiculo WHERE placa = '"+veiculo.getPlaca()+"'";
        
        ConsultarSQL(sql, false);
    }
    
}
