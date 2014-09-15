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
import sistema.audizio.bean.Usuario;

/**
 *
 * @author zipnet
 */
public class DaoUsuario extends Conexao{
    String sql;
    Usuario usuario;
   
       public void editarUsuario(Usuario usuario){
           sql = "UPDATE tb_admin SET usuario = '"+usuario.getUsuario()+"'";
           ConsultarSQL(sql, false);
           JOptionPane.showMessageDialog(null, "Nome de usuário alterado\n com sucesso!");
       }
       
        public void editarSenha(Usuario usuario){
           sql = "UPDATE tb_admin SET senha = '"+usuario.getSenha()+"'";
           ConsultarSQL(sql, false);
           JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
       }
        
       public String consultarUsuario(){
           String usuario = null;
           String senha = null;
           
           ConsultarSQL("SELECT * FROM tb_admin", true);
        try {
            while (rs.next()) {
                usuario = rs.getString("usuario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
           return usuario;
       }
       
       public String consultarSenha(){
         
           String senha = null;
           
           ConsultarSQL("SELECT * FROM tb_admin", true);
        try {
            while (rs.next()) {
                senha = rs.getString("senha");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
           return senha;
       }
     
    
}
