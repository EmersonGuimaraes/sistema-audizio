/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.audizio.gui;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
/**
 *
 * @author emerson
 */
public class RestaurarBackup {
     
        String novonome = null;  
        int numerodobackup = 0;
        String pasta = "C:/KRCsistemas/bck";
        String arq = "C:/SisAudizio/bkp/bkp_sisAudizio.sql";
        


        public RestaurarBackup(){
            File diretorio = new File(pasta);  
            File bck = new File(arq);
            
            if (!diretorio.isDirectory()) {  
                new File(pasta).mkdir();  
            } else {  
            }  
            // Cria Arquivo de Backup    
            try {  
                if (!bck.isFile()) {  
                    String comando = "C:/Program Files/MySQL/MySQL Server 5.5/bin/mysqldump.exe";  
                    ProcessBuilder pb = new ProcessBuilder(comando, "--user=root", "--password=twe123", "ge", "--result-file="+arq);  
                    pb.start();  
                    JOptionPane.showMessageDialog(null, "Cópia de segurança realizada com sucesso", "Backup", JOptionPane.CLOSED_OPTION);  
      
                } else {  
                   
                    JOptionPane.showMessageDialog(null, "Você já realizou o backup hoje!", "Backup", JOptionPane.CLOSED_OPTION);  
                    //dispose();  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
      
                JOptionPane.showMessageDialog(null, "Copia de segurança não realizada!", "Backup", JOptionPane.CLOSED_OPTION);  
            }
            
        }   
}
