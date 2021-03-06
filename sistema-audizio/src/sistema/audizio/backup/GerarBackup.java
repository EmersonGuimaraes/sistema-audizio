/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.audizio.backup;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author emerson
 */
public class GerarBackup {
     
        String novonome = null;  
        int numerodobackup = 0;
        String pasta = "C:/sistema/audisio/backups/";
        //String pasta = "/home/zipnet/SisAudizio/bkp";
        String arq = "C:/sistema/audisio/backups/backup_"+getData()+".sql";
        //String arq = "/home/zipnet/SisAudizio/bkp/bkp_sisAudizio.sql";
        
        private String getData() {
	Calendar cal = new GregorianCalendar();
            int dia = cal.get(Calendar.DATE);
            int mes = cal.get(Calendar.MONTH) + 1;
            int ano = cal.get(Calendar.YEAR);
            int diaSemana = cal.get(Calendar.DAY_OF_WEEK);
            int diaMes = cal.get(Calendar.DAY_OF_MONTH);
            int diaAno = cal.get(Calendar.DAY_OF_YEAR);
            
            String data = String.valueOf(dia+"-"+mes+"-"+ano);
        return data;
 
    }

        public GerarBackup(){
            File diretorio = new File(pasta);  
            File bck = new File(arq);
            
            if (!diretorio.isDirectory()) {
                System.out.println("Não Existe!");
                new File(pasta).mkdir();  
            } else {
                System.out.println("Existe!");
            }  
            // Cria Arquivo de Backup    
            try {  
                if (!bck.isFile()) {
                   
                    System.out.println("Arquivo Não Existe!");
                    String comando = "C:/Program Files/MySQL/MySQL Server 5.5/bin/mysqldump.exe";  
                    ProcessBuilder pb = new ProcessBuilder(comando, "--user=root", "--password=sistemaacic!@#", "audizio", "--result-file="+arq);  
                    pb.start();  
                    
                    
                  
                    JOptionPane.showMessageDialog(null, "Cópia de segurança realizada com sucesso\nLOCAL: "+arq, "Backup", JOptionPane.CLOSED_OPTION);
                    
                    
                } else {  
                   System.out.println("Arquivo Existe!");
                    JOptionPane.showMessageDialog(null, "Você já realizou o backup hoje!\nLOCAL: "+arq, "Backup", JOptionPane.CLOSED_OPTION);  
                    //dispose();  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
      
                JOptionPane.showMessageDialog(null, "Copia de segurança não realizada!", "Backup", JOptionPane.CLOSED_OPTION);  
            }
            
        }   
}
