/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.relatorio;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GerarRelatorio {
public static void main(String[] args) throws DocumentException, IOException {
Document document = new Document();


//PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\ZipNet\\Desktop\\testes\\teste2.pdf"));
PdfWriter.getInstance(document, new FileOutputStream("\\home\\zipnet\\teste2.pdf"));
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
document.add(new Paragraph("   "));
document.add(new Paragraph("NOME:"));
document.add(new Paragraph(" "));
document.add(new Paragraph("RG:"));
document.add(new Paragraph(" "));
document.add(new Paragraph("CEP:"));
document.add(new Paragraph(" "));
document.add(new Paragraph("CPF:"));
document.add(new Paragraph(" "));
document.add(new Paragraph("UF:"));
document.add(new Paragraph(" "));
document.add(new Paragraph("ENDEREÇO:"));
document.add(new Paragraph(" "));
document.add(new Paragraph("E-MAIL:"));
document.add(veiculo);
document.add(new Paragraph("______________________________________________________________________________"));
document.add(new Paragraph(" "));
document.add(new Paragraph("MARCA:"));
document.add(new Paragraph(" "));
document.add(new Paragraph("Modelo"));
document.add(new Paragraph(" "));
document.add(new Paragraph("PLACA:"));
document.add(new Paragraph(" "));
document.add(new Paragraph("ESTADO:"));
document.add(processo);
document.add(new Paragraph("______________________________________________________________________________"));
document.add(new Paragraph(" "));
document.add(new Paragraph("PROCESSO:"));
document.add(new Paragraph(" "));
document.add(new Paragraph("DATA INICIO:"));
document.add(new Paragraph(" "));
document.add(new Paragraph("DATA TERMINO"));
document.add(new Paragraph(" "));
document.add(new Paragraph("ADVOGADO:"));
document.add(new Paragraph(" "));
document.add(new Paragraph("REBOQUEIRO:"));
document.add(new Paragraph(" "));
document.add(new Paragraph("COMARCA:"));
document.add(new Paragraph(" "));
document.add(new Paragraph("VARA:"));

//document.add(titulo);
document.close();
}
}

