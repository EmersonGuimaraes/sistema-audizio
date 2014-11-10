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
                 + "'"+f.getDesc_despesa()+"','PENDENTE')";
         ConsultarSQL(sql, false);
         JOptionPane.showMessageDialog(null, "CONTA CADASTRADA COM SUCESSO!");
     }
     
     public void editar(Financeiro f){
         sql = "UPDATE tb_financeiro SET valor = '"+f.getValor()+"', valor_despesa = '"+f.getValor_despesa()+"',"
                 + "desconto = '"+f.getDesconto()+"', vencimento = '"+f.getVencimento()+"', situacao = '"+f.getSituacao()+"',"
                 + "valor_total = '"+f.getValor_total()+"', desc_despesa = '"+f.getDesc_despesa()+"' WHERE id = '"+f.getId()+"'";
         ConsultarSQL(sql, false);
         JOptionPane.showMessageDialog(null, "CONTA EDITADA COM SUCESSO!");
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
                    f.setData_pagamento(rs.getString("data_pagamento"));
                    financas.add(f);

                }
            }else if(situacao.equals("PENDENTE")){
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
                    f.setData_pagamento(rs.getString("data_pagamento"));
                    financas.add(f);

                }
                
            }else if(situacao.equals("QUITADO")){
                
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
                    f.setData_pagamento(rs.getString("data_pagamento"));
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
                    f.setData_pagamento(rs.getString("data_pagamento"));
                    financas.add(f);
                }
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
         return financas;
     }
     
     public ArrayList<Financeiro> consulta2(){
        ArrayList<Financeiro> financas = new ArrayList<>();
         try {
           String sql = "SELECT * FROM tb_financeiro ORDER BY id DESC LIMIT 1";
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
                f.setData_pagamento(rs.getString("data_pagamento"));
                financas.add(f);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoFinanceiro.class.getName()).log(Level.SEVERE, null, ex);
        }
         return financas;
     }
     public void quitarConta(String idConta,String data){
         sql = "UPDATE tb_financeiro SET situacao = 'QUITADO', data_pagamento='"+data+"' WHERE id = '"+idConta+"'";
         ConsultarSQL(sql, false);
         JOptionPane.showMessageDialog(null, "CONTA QUITADA COM SUCESSO!");
         
     }
    
       
}
