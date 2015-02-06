/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.relatorio;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.audizio.bean.Bairro;
import sistema.audizio.bean.Cidade;
import sistema.audizio.bean.Cliente;
import sistema.audizio.bean.Processo;
import sistema.audizio.bean.Veiculo;
/**
 * 
 * @author zipnet

 */
public class Relatorio {

    
    public void gerar(Cliente cliente, Processo processo , Veiculo veiculo, Cidade cidade, Bairro bairro) throws DocumentException, FileNotFoundException{
                
        System.out.println("ENTROU NO GERAR");
               
            
                    String local = "c:/sistema/audisio/relatorios/"+cliente.getNome()+".pdf";
                
            
                        Document document = new Document();
                        //PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\ZipNet\\Desktop\\Pdf's\\teste.pdf"));
                        PdfWriter.getInstance(document, new FileOutputStream(local));
                        document.open();
                        
                        Font f = new Font(FontFamily.COURIER, 15, Font.NORMAL);
                        Font fgrande = new Font(FontFamily.HELVETICA, 25, Font.ITALIC);
                        
                        Paragraph titulo = new Paragraph("Relatório de processo",fgrande);
                        Paragraph Clienteente = new Paragraph("CLIENTE");
                        Paragraph Processocesso = new Paragraph("PROCESSO");
                        
                     
                        
                        titulo.setAlignment(Paragraph.ALIGN_RIGHT);
                        Clienteente.setAlignment(Paragraph.ALIGN_CENTER);
                        Processocesso.setAlignment(Paragraph.ALIGN_CENTER);
                        
                        document.add(titulo);
                        document.add(new Paragraph("Dados cliente"));
                        document.add(new Paragraph("______________________________________________________________________________"));

                        document.add(new Paragraph("Nome..: "+cliente.getNome(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("Celular..: "+cliente.getCelular(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("Cep..: "+cliente.getCep(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("Cpf..: "+cliente.getCpf(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("Uf: "+cliente.getEstado(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("Endereço..: "+cliente.getEndereco()+", "+cliente.getNum()+", "+bairro.getNome()+", "+cidade.getNome(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("E-mail..: "+cliente.getEmail(),f));
                        document.add(new Paragraph("Dados veículo"));
                        document.add(new Paragraph("______________________________________________________________________________"));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("Marca..: "+veiculo.getMarca(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("Modelo..: "+veiculo.getModelo(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("Placa..: "+veiculo.getPlaca(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("Estado..: "+veiculo.getEstado(),f));
                        document.add(new Paragraph("Dados Processo"));
                        document.add(new Paragraph("______________________________________________________________________________"));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("Processo..: "+processo.getProcesso(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("Data inicio..: "+processo.getData_inicio(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("Data término..: "+processo.getData_termino(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("Advogado..: "+processo.getAdvogado(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("Reboqueiro..: "+processo.getReboqueiro(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("Comarca..: "+processo.getComarca(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("Vara..: "+processo.getVara(),f));
                        document.close();
                        JOptionPane.showMessageDialog(null, "RELATÓRIO CRIADO COM SUCESSO!\n"+local);
                        try {
                            Runtime.getRuntime().exec("c:/sistema/audisio/relatorios/");
                            Runtime.getRuntime().exec(local);
                        } catch (IOException ex) {
                            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
                        }
             
               
       
                



                
                
    }
   
}


