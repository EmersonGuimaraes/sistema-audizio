package sistema.audizio.ultilitarios;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import sistema.audizio.dao.Conexao;

public class Validacao {
    Conexao con = new Conexao();
    RemoveMascara mask = new RemoveMascara();    
    
    public String pastaImagens = "c:/KRCsistemas/imagens/";
    public String pastaRelatorios = "c:/KRCsistemas/relatorios/";
    public String Gerente;
    
    public boolean ValidaCombo(Object[] ob){
        boolean bo = true;
        int i;
        int n= ob.length;
        for(i=0;i<n;i++){
            JComboBox jcb = (JComboBox)ob[i];
            int x = jcb.getSelectedIndex();
            if(x==0){
                jcb.grabFocus();
                bo = false;
            }
        }
        return bo;
    }
    
    public boolean ValidatField(Object[] tf){
        boolean bo = true;
        int i;
        int n = tf.length;
        for(i=0;i<n;i++){
            JTextField nTF = (JTextField)tf[i];
            String str = nTF.getText();
            if(str.equals("")){
                nTF.grabFocus();
                bo = false;
                break;
            }
        }
        return bo;
    }
    
    public String getCB(JComboBox cb){
        String a = "0";
        if(cb.isEnabled()){
            InseriIdCombobox i = (InseriIdCombobox) cb.getSelectedItem();
            a = i.id;
        }
        return a;
    }
    
    public String tfMai(JTextField tf){
        String str = tf.getText().toUpperCase();
        return str;
    }
    
    /*public void tfNum(JTextField tf){
        tf.setDocument(new Numeros());
    }*/
    
    public String tf(JTextField tf){
      return tf.getText();
    }
    
     public String tfMod(JTextField tf){
       return mask.removeMascara(tf.getText());
    }
    
    public void cb(JComboBox cb,String a,String id){
        con.ConsultarSQL("SELECT id,"+a+" FROM "+a,true);
       try {
           con.rs.first();
           cb.addItem("Selecionar....");
           int index = 0;
           do{
               index++;
               cb.addItem(new InseriIdCombobox(con.rs.getString("id"), con.rs.getString(a)));
               if(con.rs.getString("id").equals(id)){
                   cb.setSelectedItem(cb.getItemAt(index));
               }
           }while(con.rs.next());
           
           int as = Integer.parseInt(id);
           cb.setSelectedItem(as);
           
       } catch (SQLException ex) {
           System.out.println("erro na tb");
       }
    }
    
    public class InseriIdCombobox{
        String nome;
        String id;
        
        public InseriIdCombobox(String id,String nome){
            this.id = id;
            this.nome = nome;
        }
        
        @Override
        public String toString(){
            return this.nome;
        }
        
        public String getId() {
            return id;
        }
    }
    
    public void SetImagemForm(JFrame f){
        ImageIcon imagemTituloJanela = new ImageIcon(pastaImagens+"icone.png");  
        f.setIconImage(imagemTituloJanela.getImage());
    }
    
    public boolean Autorizar(){
        JPasswordField pass = new JPasswordField(10);
        pass.setEchoChar('*');
        JPanel p = new JPanel();
        p.add(pass);
        try {
            con.ConsultarSQL("select id,senha from tb_usuarios where funcao = 1",true);
            con.rs.first();
            JOptionPane.showMessageDialog(null, p, "Autorização", JOptionPane.PLAIN_MESSAGE);
            pass.grabFocus();
            do{
                if(pass.getText().equals(con.rs.getString("senha"))){
                    Gerente = con.rs.getString("id");
                    return true;
                }
            }while(con.rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(Validacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
