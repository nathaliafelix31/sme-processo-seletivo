package SistemaSME.web.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import SistemaSME.excel.ExcelGenerator;
import SistemaSME.models.ProcessoSeletivoCadastro;
import SistemaSME.services.ProcessoSEletivoCadastroService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



    @Controller
    public class ExcelController {
        @Autowired
        private ProcessoSEletivoCadastroService candidatosService;

        @GetMapping("/export-to-excel")
        public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
            response.setContentType("application/octet-stream");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentDateTime = dateFormatter.format(new Date());

            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=candidatos " + currentDateTime + ".xlsx";
            response.setHeader(headerKey, headerValue);

            List<ProcessoSeletivoCadastro> listOfCandidatos = candidatosService.getTheListCandidatos();
            ExcelGenerator generator = new ExcelGenerator(listOfCandidatos);
            generator.generateExcelFile(response);



        }
    }


