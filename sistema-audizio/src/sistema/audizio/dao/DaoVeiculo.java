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
import sistema.audizio.bean.Processo;
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
                + "placa='"+veiculo.getMarca()+"',chassi='"+veiculo.getMarca()+"' WHERE placa = '"+veiculo.getPlaca()+"'";
        
        ConsultarSQL(sql, false);
    }
    
    public void Deletar(Veiculo veiculo){
        sql = "DELETE FROM tb_veiculo WHERE placa = '"+veiculo.getPlaca()+"'";
        
        ConsultarSQL(sql, false);
    }
    
    public ArrayList<Veiculo> Consultar(String idVeiculo){
        //("") - Pesquisa sem precisar de id.
        ArrayList<Veiculo> veiculos = new ArrayList();
        
            try {
                String sql = "SELECT * FROM tb_veiculo WHERE id = '"+idVeiculo+"'";
                ConsultarSQL(sql,true);
                while (rs.next()) {
                    Veiculo veiculo = new Veiculo();
                    veiculo.setMarca(rs.getString("marca"));
                    veiculo.setModelo(rs.getString("modelo"));
                    veiculo.setAnoFabricacao(rs.getString("ano_fabricacao"));
                    veiculo.setAnoModelo(rs.getString("ano_modelo"));
                    veiculo.setPlaca(rs.getString("placa"));
                    veiculo.setChassi(rs.getInt("chassi"));
                    veiculo.setCor(rs.getString("cor"));
                }
                System.out.println("Modelo:"+rs.getString("modelo"));
            } catch (SQLException ex) {
                Logger.getLogger(DaoVeiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
      return veiculos;
    }
}
