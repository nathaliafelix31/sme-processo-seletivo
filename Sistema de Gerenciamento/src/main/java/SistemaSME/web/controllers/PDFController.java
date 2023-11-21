package SistemaSME.web.controllers;

import SistemaSME.models.ProcessoSeletivoCadastro;
import SistemaSME.pdf.PDFGenerator;
import SistemaSME.services.ProcessoSEletivoCadastroService;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class PDFController {

        @Autowired
        private ProcessoSEletivoCadastroService candidatosService;
        @GetMapping("/export-to-pdf")
        public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException
        {
            response.setContentType("application/pdf");
            DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
            String currentDateTime = dateFormat.format(new Date());
            String headerkey = "Content-Disposition";
            String headervalue = "attachment; filename=candidato" + currentDateTime + ".pdf";
            response.setHeader(headerkey, headervalue);
            List<ProcessoSeletivoCadastro> listofCandidatos = candidatosService.getTheListCandidatos();
            PDFGenerator generator = new PDFGenerator();
            generator.generate(listofCandidatos, response);
        }
    }

