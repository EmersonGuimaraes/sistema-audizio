/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.relatorio;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import sistema.audizio.bean.Bairro;
import sistema.audizio.bean.Cidade;
import sistema.audizio.bean.Cliente;
import sistema.audizio.bean.Processo;
import sistema.audizio.bean.Veiculo;
/**
 * 
 * @author zipnet
 * @Aperfeiçoado por Emerson Guimarães
 */
public class Relatorio {

    
    public void gerar(ArrayList <Cliente> cliente, ArrayList <Processo> processo , ArrayList <Veiculo> veiculo, ArrayList<Cidade> cidade, ArrayList<Bairro> bairro) throws DocumentException, FileNotFoundException{
                String local;
                JFileChooser file = new JFileChooser();
                file.setSelectedFile(new File(cliente.get(0).getNome()+".pdf")); 
                file.setFileSelectionMode(JFileChooser.FILES_ONLY);
                file.setDialogTitle("Selecione um local para salvar o arquivo");
                int retorno = file.showSaveDialog(null);
                File arquivo = file.getSelectedFile();
                local = arquivo.getPath();
                
             
                if (retorno == JFileChooser.APPROVE_OPTION) {
                        Document document = new Document();
                        //PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\ZipNet\\Desktop\\Pdf's\\teste.pdf"));
                        PdfWriter.getInstance(document, new FileOutputStream(local));
                        document.open();
                        Paragraph Veiculoulo = new Paragraph("VEICULO");
                        Paragraph Clienteente = new Paragraph("CLIENTE");
                        Paragraph Processocesso = new Paragraph("PROCESSO");
                        Veiculoulo.setAlignment(Paragraph.ALIGN_CENTER);
                        Clienteente.setAlignment(Paragraph.ALIGN_CENTER);
                        Processocesso.setAlignment(Paragraph.ALIGN_CENTER);
                        document.add(Clienteente);
                        document.add(new Paragraph("______________________________________________________________________________"));

                        document.add(new Paragraph("NOME: - "+cliente.get(0).getNome()));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("RG: - "+cliente.get(0).getRg()));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("CEP: - "+cliente.get(0).getCep()));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("CPF: "+cliente.get(0).getCpf()));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("UF: - "+cliente.get(0).getEstado()));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("ENDEREÇO: - "+cliente.get(0).getEndereco()+", "+cliente.get(0).getNum()+", "+bairro.get(0).getNome()+", "+cidade.get(0).getNome()));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("E-MAIL: - "+cliente.get(0).getEmail()));
                        document.add(Veiculoulo);
                        document.add(new Paragraph("______________________________________________________________________________"));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("MARCA: - "+veiculo.get(0).getMarca()));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("MODELO: - "+veiculo.get(0).getModelo()));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("PLACA: - "+veiculo.get(0).getPlaca()));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("ESTADO: - "+veiculo.get(0).getEstado()));
                        document.add(Processocesso);
                        document.add(new Paragraph("______________________________________________________________________________"));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("PROCESSO: - "+processo.get(0).getProcesso()));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("DATA INICIO: - "+processo.get(0).getData_inicio()));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("DATA TERMINO: - "+processo.get(0).getData_termino()));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("ADVOGADO: "+processo.get(0).getAdvogado()));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("REBOQUEIRO: - "+processo.get(0).getReboqueiro()));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("COMARCA: - "+processo.get(0).getComarca()));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph("VARA: - "+processo.get(0).getVara()));
                        document.close();
                        JOptionPane.showMessageDialog(null, "RELATÓRIO CRIADO COM SUCESSO!");
                }
               
       
                



                
                
    }
   
}


