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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import sistema.audizio.bean.Cliente;
import sistema.audizio.bean.Processo;
import sistema.audizio.bean.Veiculo;

public class Relatorio {

    public Relatorio() {
    }
    
    public void gerar(Cliente cli,Processo pro, Veiculo veic) throws DocumentException, FileNotFoundException{
                Document document = new Document();

                //PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\ZipNet\\Desktop\\testes\\teste2.pdf"));
                PdfWriter.getInstance(document, new FileOutputStream("/home/emerson/Documentos/teste.pdf"));
                document.open();
                Paragraph veiculo = new Paragraph("VEICULO");
                Paragraph cliente = new Paragraph("CLIENTE");
                Paragraph processo = new Paragraph("PROCESSO");
                veiculo.setAlignment(Paragraph.ALIGN_CENTER);
                cliente.setAlignment(Paragraph.ALIGN_CENTER);
                processo.setAlignment(Paragraph.ALIGN_CENTER);
                //Paragraph titulo = new Paragraph("Cliente: ");
                //titulo.setAlignment(Paragraph.ALIGN_CENTER);
                document.add(cliente);
                document.add(new Paragraph("______________________________________________________________________________"));

                document.add(new Paragraph("NOME: "+cli.getNome()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("RG: "+cli.getRg()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("CEP: "+cli.getCep()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("CPF: "+cli.getCpf()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("UF: "+cli.getEstado()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("ENDEREÇO: "+cli.getEndereco()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("E-MAIL: "+cli.getEmail()));
                document.add(veiculo);
                document.add(new Paragraph("______________________________________________________________________________"));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("MARCA: "+veic.getMarca()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("MODELO: "+veic.getModelo()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("PLACA: "+veic.getPlaca()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("ESTADO: "+veic.getEstado()));
                document.add(processo);
                document.add(new Paragraph("______________________________________________________________________________"));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("PROCESSO: "+pro.getProcesso()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("DATA INICIO: "+pro.getData_inicio()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("DATA TERMINO: "+pro.getData_termino()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("ADVOGADO: "+pro.getAdvogado()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("REBOQUEIRO: "+pro.getReboqueiro()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("COMARCA: "+pro.getComarca()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("VARA: "+pro.getVara()));

                //document.add(titulo);
                document.close();
                System.out.println("Relatório Criado");
    }
   
    public static void main(String[] args) throws DocumentException, IOException {

    }
}


