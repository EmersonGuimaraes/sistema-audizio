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
import javax.swing.JOptionPane;
import sistema.audizio.bean.Financeiro;
import sistema.audizio.bean.Processo;

/**
 *
 * @author Emerson
 */
public class DaoFinanceiro extends Conexao{
    String sql;
     public void cadastrar(Financeiro f){
         sql = "INSERT INTO tb_financeiro VALUES(null,'"+f.getId_cliente()+"',"
                 + "'"+f.getProcesso()+"','"+f.getCliente()+"','"+f.getValor()+"','"+f.getValor_despesa()+"',"
                 + "'"+f.getDesconto()+"','"+f.getVencimento()+"','"+f.getSituacao()+"','"+f.getValor_total()+"',"
                 + "'"+f.getDesc_despesa()+"')";
         ConsultarSQL(sql, false);
         JOptionPane.showMessageDialog(null, "CONTA CADASTRADA COM SUCESSO!");
     }
     
     public ArrayList<Financeiro> consultarFinancas(String situacao){
         ArrayList<Financeiro> financas = new ArrayList<>();
         try {
            
            if(situacao.equals("")){
                String sql = "SELECT * FROM tb_financeiro";
                ConsultarSQL(sql,true);
                while (rs.next()) {
                    Financeiro f = new Financeiro();
                    f.setId(rs.getInt("id"));
                    f.setId_cliente(rs.getInt("id_cliente"));
                    f.setProcesso(rs.getString("processo"));
                    f.setCliente(rs.getString("cliente"));
                    f.setValor(rs.getString("valor"));
                    f.setValor_despesa(rs.getString("valor_despesa"));
                    f.setDesconto(rs.getString("desconto"));
                    f.setVencimento(rs.getString("vencimento"));
                    f.setSituacao(rs.getString("situacao"));
                    f.setValor_total(rs.getString("valor_total"));
                    f.setDesc_despesa(rs.getString("desc_despesa"));
                    financas.add(f);

                }
            }else if(situacao.equals("Pendente")){
               String sql = "SELECT * FROM tb_financeiro WHERE situacao = '"+situacao+"'";
                ConsultarSQL(sql,true);
                
                while (rs.next()) {
                   Financeiro f = new Financeiro();
                    f.setId(rs.getInt("id"));
                    
                    f.setId_cliente(rs.getInt("id_cliente"));
                    f.setProcesso(rs.getString("processo"));
                    f.setCliente(rs.getString("cliente"));
                    f.setVencimento(rs.getString("vencimento"));
                    f.setSituacao(rs.getString("situacao"));
                    f.setValor_total(rs.getString("valor_total"));
                    financas.add(f);

                }
                
            }else if(situacao.equals("Quitato")){
                
                String sql = "SELECT * FROM tb_financeiro WHERE situacao = '"+situacao+"'";
                ConsultarSQL(sql,true);
                
                while (rs.next()) {
                    Financeiro f = new Financeiro();
                    f.setId(rs.getInt("id"));
                    
                    f.setId_cliente(rs.getInt("id_cliente"));
                    f.setProcesso(rs.getString("processo"));
                    f.setCliente(rs.getString("cliente"));
                    f.setVencimento(rs.getString("vencimento"));
                    f.setSituacao(rs.getString("situacao"));
                    f.setValor_total(rs.getString("valor_total"));
                    financas.add(f);

                }
                
            }else{
                String sql = "SELECT * FROM tb_financeiro WHERE id = '"+situacao+"'";
                ConsultarSQL(sql,true);
                while (rs.next()) {
                    Financeiro f = new Financeiro();
                    f.setId(rs.getInt("id"));
                    
                    f.setId_cliente(rs.getInt("id_cliente"));
                    f.setProcesso(rs.getString("processo"));
                    f.setCliente(rs.getString("cliente"));
                    f.setValor(rs.getString("valor"));
                    f.setValor_despesa(rs.getString("valor_despesa"));
                    f.setDesconto(rs.getString("desconto"));
                    f.setVencimento(rs.getString("vencimento"));
                    f.setSituacao(rs.getString("situacao"));
                    f.setValor_total(rs.getString("valor_total"));
                    f.setDesc_despesa(rs.getString("desc_despesa"));
                    financas.add(f);
                }
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
         return financas;
     }
    
       
}
