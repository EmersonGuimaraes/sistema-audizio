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
       }
       
        public void editarSenha(Usuario usuario){
           sql = "UPDATE tb_admin SET senha = '"+usuario.getSenha()+"'";
           ConsultarSQL(sql, false);
       }
       
    
}
