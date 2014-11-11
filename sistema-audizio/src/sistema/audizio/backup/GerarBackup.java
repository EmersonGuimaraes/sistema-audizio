/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.audizio.backup;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
/**
 *
 * @author emerson
 */
public class GerarBackup {
     
        String novonome = null;  
        int numerodobackup = 0;
        String pasta = "C:/sistema/backup";
        //String pasta = "/home/zipnet/SisAudizio/bkp";
        String arq = "C:/sistema/backup/bkp_"+getData()+".sql";
        //String arq = "/home/zipnet/SisAudizio/bkp/bkp_sisAudizio.sql";
        
        private String getData() {
	Calendar cal = new GregorianCalendar();
            int dia = cal.get(Calendar.DATE);
            int mes = cal.get(Calendar.MONTH) + 1;
            int ano = cal.get(Calendar.YEAR);
            int diaSemana = cal.get(Calendar.DAY_OF_WEEK);
            int diaMes = cal.get(Calendar.DAY_OF_MONTH);
            int diaAno = cal.get(Calendar.DAY_OF_YEAR);
            
            String data = String.valueOf(dia+"/"+mes+"/"+ano);
        return data;
 
    }

        public GerarBackup(){
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
                    ProcessBuilder pb = new ProcessBuilder(comando, "--user=root", "--password=5215052", "audizio", "--result-file="+arq);  
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
