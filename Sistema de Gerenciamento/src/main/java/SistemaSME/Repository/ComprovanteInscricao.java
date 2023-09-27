package SistemaSME.Repository;

import SistemaSME.Models.ProcessoSeletivoCadastro;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ComprovanteInscricao implements Comprovantes {

    private ProcessoSeletivoCadastro processoSeletivoCadastro;
    private Document documentoPDF;
    private String comprovante = "comprovantes/ComprovanteInscricaoPDF.pdf";

    public ComprovanteInscricao(ProcessoSeletivoCadastro processoSeletivoCadastro){
        this.processoSeletivoCadastro = processoSeletivoCadastro;
        this.documentoPDF = new Document();
        try {
            PdfWriter.getInstance(this.documentoPDF, new FileOutputStream(comprovante));
            this.documentoPDF.open();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void gerarCabecalho() {
        Paragraph paragrafoTitulo = new Paragraph();
        paragrafoTitulo.setAlignment(Element.ALIGN_CENTER);
        paragrafoTitulo.add(new Chunk("COMPROVANTE DE INSCRIÇÃO PARA CADASTRO DE RESERVA - 2024",
                new Font(Font.HELVETICA, 24)
                ));
        this.documentoPDF.add(paragrafoTitulo);
        this.documentoPDF.add(new Paragraph(" "));

        Paragraph paragrafoData = new Paragraph();
        paragrafoData.setAlignment(Element.ALIGN_CENTER);
        paragrafoData.add(new Chunk(this.processoSeletivoCadastro.getDataCriacao().toString()));
        this.documentoPDF.add(paragrafoData);
        this.documentoPDF.add(new Paragraph(" "));//paragrafos vazios
        this.documentoPDF.add(new Paragraph(" "));

    }

    @Override
    public void gerarCorpo() {
        Paragraph paragraphCandidato = new Paragraph();
        paragraphCandidato.setAlignment(Element.ALIGN_JUSTIFIED);
        paragraphCandidato.add(
                new Chunk(
                        "Número de Inscrição: "+ this.processoSeletivoCadastro.getCodigo(),
                        new Font(Font.BOLD,14)
                )
        );
        this.documentoPDF.add(paragraphCandidato);
    }

    @Override
    public void gerarRodape() {

    }

    @Override
    public void imprimir() {
        if(this.documentoPDF != null && this.documentoPDF.isOpen()){
            this.documentoPDF.close();
        }
    }
}
