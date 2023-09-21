package SistemaSME.Repository;

import SistemaSME.Models.ProcessoSeletivoCadastro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProcessoSeletivoRepository extends CrudRepository<ProcessoSeletivoCadastro, String> {
   ProcessoSeletivoCadastro findByCodigo(long codigo);



}
