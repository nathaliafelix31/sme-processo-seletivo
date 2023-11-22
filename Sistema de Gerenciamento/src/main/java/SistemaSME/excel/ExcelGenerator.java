package SistemaSME.excel;

import java.io.IOException;
import java.util.List;

import SistemaSME.models.ProcessoSeletivoCadastro;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;


public class ExcelGenerator {

    private List<ProcessoSeletivoCadastro> processoSeletivoCadastroList;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelGenerator(List < ProcessoSeletivoCadastro > cadastroList) {
        this.processoSeletivoCadastroList = cadastroList;
        workbook = new XSSFWorkbook();
    }
    private void writeHeader() {
        sheet = workbook.createSheet("Lista de Candidatos do Processo Seletivo 2024");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(12);
        style.setFont(font);
        createCell(row, 0, "ID", style);
        createCell(row, 1, "Nome", style);
        createCell(row, 2, "CPF", style);
        createCell(row, 3, "RG", style);
        createCell(row, 4, "Data de Nascimento", style);
        createCell(row, 5, "Email", style);
        createCell(row, 6, "Telefone", style);
        createCell(row, 7, "Endereço", style);
        createCell(row, 8, "Cargo Pleitado", style);
        createCell(row, 9, "Disciplina", style);
        createCell(row, 10, "Tempo de Serviço", style);
        createCell(row, 11, "Aperfeiçoamento Profissional", style);
        createCell(row, 12, "Carga Horária", style);
        createCell(row, 13, "Pós Graduação", style);
        createCell(row, 14, "Habilitado", style);
        createCell(row, 15, "Cursando Licenciatura", style);
        createCell(row, 16, "Cursando Bacharelado", style);
        createCell(row, 17, "Curso Nivel Medio", style);
        createCell(row, 18, "Ensino Médio Completo", style);
        createCell(row, 19, "Ensino Médio Incompleto", style);
        createCell(row, 20, "Série do Ensino Médio Incompleto", style);
        createCell(row, 21, "Ano de Conclusão do Ensino Médio Incompleto", style);
        createCell(row, 22, "Ensino Fundamental Completo", style);
        createCell(row, 23, "Ensino Fundamental Incompleto", style);
        createCell(row, 24, "Série do Ensino Fundamental Incompleto", style);
        createCell(row, 25, "Ano de Conclusão do Fundamental Incompleto", style);
        createCell(row, 26, "Outro", style);
    }
    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if (valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
        } else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        } else {
            cell.setCellValue((Boolean) valueOfCell);
        }
        cell.setCellStyle(style);
    }
    private void write() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        for (ProcessoSeletivoCadastro record: processoSeletivoCadastroList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, record.getCodigo(), style);
            createCell(row, columnCount++, validateIsNull( record.getNome()), style);
            createCell(row, columnCount++, validateIsNull( record.getCpf()), style);
            createCell(row, columnCount++, validateIsNull( record.getRg()), style);
            createCell(row, columnCount++, validateIsNull( record.getDataNascimento()), style);
            createCell(row, columnCount++, validateIsNull( record.getEmail()), style);
            createCell(row, columnCount++, validateIsNull( record.getTelefone()), style);
            createCell(row, columnCount++, validateIsNull( record.getEndereco()), style);
            createCell(row, columnCount++, validateIsNull( record.getVaga()), style);
            createCell(row, columnCount++, validateIsNull( record.getDisciplina()), style);
            createCell(row, columnCount++, validateIsNull( String.valueOf(record.getTempoServico())), style);
            createCell(row, columnCount++, validateIsNull( record.getAperfeicoamentoProfissional()), style);
            createCell(row, columnCount++, validateIsNull( String.valueOf(record.getCargaHoraria())), style);
            createCell(row, columnCount++, validateIsNull( record.getPosGraduacao()), style);
            createCell(row, columnCount++, validateIsNull( record.getHabilitado()), style);
            createCell(row, columnCount++, validateIsNull( record.getCursandoLicenciatura()), style);
            createCell(row, columnCount++, validateIsNull( record.getCursandoBacharelado()), style);
            createCell(row, columnCount++, validateIsNull( record.getCursoNivelMedio()), style);
            createCell(row, columnCount++, validateIsNull( record.getEnsinoMedioCompleto()), style);
            createCell(row, columnCount++, validateIsNull( record.getEnsinoMedioIncompleto()), style);
            createCell(row, columnCount++, validateIsNull( record.getEscolaridadeMedioIncompleto()), style);
            createCell(row, columnCount++, validateIsNull( record.getAnoConclusaoEscolaridadeMedioIncompleto()), style);
            createCell(row, columnCount++, validateIsNull( record.getEnsinoFundamentalCompleto()), style);
            createCell(row, columnCount++, validateIsNull( record.getEnsinoFundamentalIncompleto()), style);
            createCell(row, columnCount++, validateIsNull( record.getEscolaridadeFundamentalIncompleto()), style);
            createCell(row, columnCount++, validateIsNull( record.getAnoConclusaoEscolaridadeFundamentalIncompleto()), style);
            createCell(row, columnCount++, validateIsNull( record.getOutro()), style);

        }
    }
    public void generateExcelFile(HttpServletResponse response) throws IOException {
        writeHeader();
        write();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    private String validateIsNull(String value) {

        if (StringUtils.isEmpty(value)) return "Não se Aplica";

        return value;

    }
}
