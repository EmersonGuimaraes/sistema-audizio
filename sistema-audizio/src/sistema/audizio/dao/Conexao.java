package sistema.audizio.dao;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {
  
    
    public Connection con;
    public Statement stmt;
    public ResultSet rs;
    //String url = "jdbc:mysql://localhost/sis_audisio";
    String url = "jdbc:mysql://localhost/audizio";
    String driver = "com.mysql.jdbc.Driver";
    String usuario = "root";
    String senha = "5215052";
    
    public void estabelecerConexao(){
        //IP();
        try {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null,"Sistema não pode \"Encontrar"
                        + " o Banco de dados\".\nVer o Driver-Mysql");
            }
            con = DriverManager.getConnection(url, usuario,senha);
            stmt = con.createStatement();
            System.out.println("Conectado ao Banco!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Não Conectado ao Banco de dados.\n [IP: 127.0.0.1]");
        }
    }
    
    public boolean ConsultarSQL(String sql,boolean tipo){
        try {
            estabelecerConexao();
            stmt = con.createStatement();
            if(tipo == false){
                //Inserir, Editar ou Excluir.
                stmt.executeUpdate(sql);
            }else{
                //Consultar
                rs = stmt.executeQuery(sql);
                
                
            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro na Consulta ao Banco.\n"+e);
        }
        return false;
    }
    
    
   
}
