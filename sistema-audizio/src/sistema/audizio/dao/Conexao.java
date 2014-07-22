/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ZipNet
 */
public class Conexao {
     public Connection con = null;
	String serverName = "127.0.0.1";
	String usuario ="admin"; //usuario
	String senha = "admin";      //senha de acesso ao DB
	String db ="sis_audisio"; //nome Banco de Dados
    String driver = "com.mysql.jdbc.Driver"; //Conector jdbc
    String url = "jdbc:mysql://" + serverName + "/" + db; //url de acesso ao banco
    public java.sql.PreparedStatement stmt;
	public ResultSet rs;
 
	public void EstabelecerConexao(){ 
	        try {  
	            // Carregando o Driver JDBC
	            Class.forName(driver);  
	            // Configurando a conexão com o banco de dados//  
	            con = DriverManager.getConnection(url, usuario, senha);  
	            System.out.println("Conexão realizada com sucesso");
	        }  catch (ClassNotFoundException e) {
	        	//Driver não encontrado  
	            System.out.println("O driver expecificado nao foi encontrado."); 
	        } catch (SQLException e) {  
	            //Não conseguindo se conectar ao banco de dados
	            JOptionPane.showMessageDialog(null,"Nao foi possivel conectar ao Banco de Dados"+ e.toString());  
	        } 

	}

}
