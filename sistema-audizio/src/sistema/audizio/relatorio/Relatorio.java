/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.relatorio;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import sistema.audizio.bean.Bairro;
import sistema.audizio.bean.Cidade;
import sistema.audizio.bean.Cliente;
import sistema.audizio.bean.Processo;
import sistema.audizio.bean.Veiculo;
import sistema.audizio.bean.Assessoria;
import sistema.audizio.gui.Cadastro;
/**
 * 
 * @author zipnet

 */
public class Relatorio {

    
    public void gerar(Cliente cliente, Processo processo , Veiculo veiculo, Cidade cidade, Bairro bairro, Assessoria assesoria) throws DocumentException, FileNotFoundException, BadElementException, IOException{
               
            
                    String local = "c:\\sistema\\audisio\\relatorios\\"+cliente.getNome()+"-N° P-"+processo.getProcesso()+".pdf";
               
            
                        Document document = new Document();
                        //PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\ZipNet\\Desktop\\Pdf's\\teste.pdf"));
                        PdfWriter.getInstance(document, new FileOutputStream(local));
                        document.open();
                        
                        Font f = new Font(FontFamily.COURIER, 15, Font.NORMAL);
                        Font fgrande = new Font(FontFamily.HELVETICA, 25, Font.ITALIC);
                        
                          Image img = Image.getInstance("c:/sistema/audisio/imagens/relatorio.png");
                          img.setAlignment(Element.ALIGN_LEFT);
      
                                
                        Paragraph titulo = new Paragraph("Relatório de processo",fgrande);
                        Paragraph Clienteente = new Paragraph("DADOS CLIENTE");
                        Paragraph Processocesso = new Paragraph("DADOS PROCESSO");
                        Paragraph veiculolo = new Paragraph("DADOS VEÍCULO");
                     
                        
                        titulo.setAlignment(Paragraph.ALIGN_RIGHT);
                        Clienteente.setAlignment(Paragraph.ALIGN_CENTER);
                        Processocesso.setAlignment(Paragraph.ALIGN_CENTER);
                        veiculolo.setAlignment(Paragraph.ALIGN_CENTER);
                        
                        document.add(img);
                        document.add(titulo);
                        document.add(new Paragraph(" "));
                        document.add(Clienteente);
                        document.add(new Paragraph("______________________________________________________________________________"));

                        document.add(new Paragraph("Nome..: "+cliente.getNome(),f));
                        document.add(new Paragraph("Celular..: "+cliente.getCelular(),f));
                        document.add(new Paragraph("Cep..: "+cliente.getCep(),f));
                        document.add(new Paragraph("Cpf..: "+cliente.getCpf(),f));
                        document.add(new Paragraph("Uf: "+cliente.getEstado(),f));
                        document.add(new Paragraph("Endereço..: "+cliente.getEndereco()+", "+cliente.getNum()+", "+bairro.getNome()+", "+cidade.getNome(),f));
                        document.add(new Paragraph("E-mail..: "+cliente.getEmail(),f));
                        document.add(new Paragraph(" "));
                        document.add(veiculolo);
                        document.add(new Paragraph("______________________________________________________________________________"));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("Marca..: "+veiculo.getMarca(),f));
                        document.add(new Paragraph("Modelo..: "+veiculo.getModelo(),f));
                        document.add(new Paragraph("Placa..: "+veiculo.getPlaca(),f));
                        document.add(new Paragraph("Estado..: "+veiculo.getEstado(),f));
                        document.add(new Paragraph(" "));
                        document.add(Processocesso);
                        document.add(new Paragraph("______________________________________________________________________________"));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("Processo..: "+processo.getProcesso(),f));
                        document.add(new Paragraph("Data inicio..: "+processo.getData_inicio(),f));
                        document.add(new Paragraph("Data término..: "+processo.getData_termino(),f));
                        document.add(new Paragraph("Comarca..: "+processo.getComarca(),f));
                        document.add(new Paragraph("Vara..: "+processo.getVara(),f));
                        document.add(new Paragraph("Assesoria..: "+assesoria.getNome(),f));
                         document.add(new Paragraph("Advogado..: "+assesoria.getNome_advogado(),f));
                        document.close();
                        JOptionPane.showMessageDialog(null, "RELATÓRIO CRIADO COM SUCESSO!\n"+local);
                        
                        try {
                            java.awt.Desktop.getDesktop().open( new File( local ) );
                        } catch (IOException ex) {
                            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
                        }
    
             
               
       
                



                
                
    }
   
}


