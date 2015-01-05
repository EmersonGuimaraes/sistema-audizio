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
import java.util.ArrayList;
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
                String local = "c:/sistema/relatorios/"+cliente.getNome()+".pdf";
                
            
                        Document document = new Document();
                        //PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\ZipNet\\Desktop\\Pdf's\\teste.pdf"));
                        PdfWriter.getInstance(document, new FileOutputStream(local));
                        document.open();
                        Paragraph Veiculoulo = new Paragraph("VEICULO");
                        Paragraph Clienteente = new Paragraph("CLIENTE");
                        Paragraph Processocesso = new Paragraph("PROCESSO");
                         Font f = new Font(FontFamily.COURIER, 20, Font.NORMAL);
                        Veiculoulo.setAlignment(Paragraph.ALIGN_CENTER);
                        Clienteente.setAlignment(Paragraph.ALIGN_CENTER);
                        Processocesso.setAlignment(Paragraph.ALIGN_CENTER);
                        document.add(Clienteente);
                        document.add(new Paragraph("______________________________________________________________________________"));

                        document.add(new Paragraph("NOME::: "+cliente.getNome(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("CELULAR ::: "+cliente.getCelular(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("CEP ::: "+cliente.getCep(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("CPF ::: "+cliente.getCpf(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("UF ::: "+cliente.getEstado(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("ENDEREÇO ::: "+cliente.getEndereco()+", "+cliente.getNum()+", "+bairro.getNome()+", "+cidade.getNome(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("E-MAIL ::: "+cliente.getEmail(),f));
                        document.add(Veiculoulo);
                        document.add(new Paragraph("______________________________________________________________________________"));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("MARCA ::: "+veiculo.getMarca(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("MODELO ::: "+veiculo.getModelo(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("PLACA ::: "+veiculo.getPlaca(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("ESTADO ::: "+veiculo.getEstado(),f));
                        document.add(Processocesso);
                        document.add(new Paragraph("______________________________________________________________________________"));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("PROCESSO ::: "+processo.getProcesso(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("DATA ÍNICIO ::: "+processo.getData_inicio(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("DATA TÉRMINO ::: "+processo.getData_termino(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("ADVOGADO ::: "+processo.getAdvogado(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("REBOQUEIRO ::: "+processo.getReboqueiro(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("COMARCA ::: "+processo.getComarca(),f));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("VARA ::: "+processo.getVara(),f));
                        document.close();
                        JOptionPane.showMessageDialog(null, "RELATÓRIO CRIADO COM SUCESSO!\n"+local);
             
               
       
                



                
                
    }
   
}


