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
import sistema.audizio.bean.Processo;

/**
 *
 * @author emerson
 */
public class DaoProcesso extends Conexao{
    String sql;
    public DaoProcesso() {
    }
    
    public void Cadastrar(Processo processo){
        System.out.println("Processo: "+processo.getProcesso());
        sql="INSERT INTO tb_processo VALUES(null,'"+processo.getProcesso()+"','"+processo.getData_inicio()+"','"+processo.getData_termino()+"',"
                + "'"+processo.getIdCliente()+"','"+processo.getIdAdvogado()+"','"+processo.getAcao()+"','"+processo.getSituacao()+"',"
                + "'"+processo.getSituacao_atual()+"','"+processo.getVara()+"','"+processo.getComarca()+"','"+processo.getAssessoria()+"')";
        ConsultarSQL(sql, false);
    }
    public void Editar(Processo processo){
        System.out.println("Id processo no dao:"+processo.getIdProcesso());
        sql="UPDATE tb_processo SET processo = '"+processo.getProcesso()+"',data_inicio = '"+processo.getData_inicio()+"',data_termino = '"+processo.getData_termino()+"',"
                + "acao = '"+processo.getAcao()+"',situacao = '"+processo.getSituacao()+"',situacao_atual = '"+processo.getSituacao_atual()+"',"
                + "vara = '"+processo.getVara()+"',comarca = '"+processo.getComarca()+"' WHERE id = '"+processo.getIdProcesso()+"'";
        ConsultarSQL(sql, false);
        
    }
    
    public void Deletar(Processo processo){
        
        sql="DELETE FROM tb_processo WHERE processo = '"+processo.getProcesso()+"'";
    }
    
    public ArrayList<Processo> Consultar(String situacao){
        //("") - Pesquisa sem precisar de id.
        ArrayList<Processo> processos = new ArrayList();
        try {
            
            if(situacao.equals("")){
                String sql = "SELECT id,cliente,processo,situacao FROM tb_processo";
                ConsultarSQL(sql,true);
                while (rs.next()) {
                    Processo processo = new Processo();
                    processo.setIdProcesso(rs.getString("id"));
                    processo.setProcesso(rs.getString("processo"));
                    processo.setCliente(rs.getString("cliente"));
                    processo.setSituacao(rs.getString("situacao"));
                    
                    processos.add(processo);

                }
            }else if(situacao.equals("aberto")){
                String sql = "SELECT id,cliente,processo,situacao FROM tb_processo WHERE situacao = '"+situacao+"'";
                ConsultarSQL(sql,true);
                
                while (rs.next()) {
                    Processo processo = new Processo();
                    processo.setIdProcesso(rs.getString("id"));
                    processo.setProcesso(rs.getString("processo"));
                    processo.setCliente(rs.getString("cliente"));
                    processo.setSituacao(rs.getString("situacao"));
                    
                    processos.add(processo);

                }
                
            }else if(situacao.equals("arquivado")){
                
                String sql = "SELECT id,cliente,processo,situacao FROM tb_processo WHERE situacao = '"+situacao+"'";
                ConsultarSQL(sql,true);
                
                while (rs.next()) {
                    Processo processo = new Processo();
                    processo.setIdProcesso(rs.getString("id"));
                    processo.setProcesso(rs.getString("processo"));
                    processo.setCliente(rs.getString("cliente"));
                    processo.setSituacao(rs.getString("situacao"));
                    
                    processos.add(processo);

                }
                
            }else{
                System.out.println("Entrou no método! "+situacao);
                String sql = "SELECT * FROM tb_processo WHERE id = '"+situacao+"'";
                ConsultarSQL(sql,true);
                while (rs.next()) {
                    Processo processo = new Processo();
                    processo.setIdProcesso(rs.getString("id"));
                    processo.setProcesso(rs.getString("processo"));
                    processo.setData_inicio(rs.getString("data_inicio"));
                    processo.setData_termino(rs.getString("data_termino"));
                    processo.setIdCliente(rs.getInt("id_cliente"));
                    processo.setIdAdvogado(rs.getInt("id_advogado"));
                    processo.setAcao(rs.getString("acao"));
                    processo.setSituacao(rs.getString("situacao"));
                    processo.setSituacao_atual(rs.getString("situacao_atual"));
                    processo.setVara(rs.getString("vara"));
                    processo.setComarca(rs.getString("comarca"));
                    processo.setAssessoria(rs.getString("assessoria"));
                    processos.add(processo);
                }
                return processos;
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return processos;
    
    }
    
    public void arquivarProcesso(String id){
        sql = "UPDATE tb_processo SET situacao = 'ARQUIVADO' WHERE id = '"+id+"'";
        ConsultarSQL(sql, false);
        
    }
    
    
}
