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
    public DaoUsuario(){
        
    }
    
  
           public ArrayList<Usuario> Consultar(String user){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        
            if(user.equals("")){
            try {
                ConsultarSQL("SELECT * FROM tb_admin", true);
                while (rs.next()) {
                    
                    usuario = new Usuario();
                  
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEndereco(rs.getString("rua"));
                    usuario.setBairro(rs.getString("bairro"));
                    usuario.setCidade(rs.getString("cidade"));
                    usuario.setFone1(rs.getString("fone1"));
                    usuario.setFone2(rs.getString("fone2"));
                    usuario.setUsername(rs.getString("usuario"));
                    usuario.setSenha(rs.getString("senha"));
                    
                    usuarios.add(usuario);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else{
            try {
                ConsultarSQL("SELECT * FROM tb_usuario WHERE usuario = '"+user+"'", true);
                while (rs.next()) {
                    
                    usuario = new Usuario();
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEndereco(rs.getString("rua"));
                    usuario.setBairro(rs.getString("bairro"));
                    usuario.setCidade(rs.getString("cidade"));
                    usuario.setFone1(rs.getString("fone1"));
                    usuario.setFone2(rs.getString("fone2"));
                    usuario.setUsername(rs.getString("usuario"));
                    usuario.setSenha(rs.getString("senha"));
                    
                    
                    usuarios.add(usuario);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
               
           }
       
         return usuarios;
        
    }
        
    
}
