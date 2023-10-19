package SistemaSME.Repository;

import SistemaSME.Models.ProcessoSeletivoCadastro;
import org.springframework.data.repository.CrudRepository;

public interface ProcessoSeletivoRepository extends CrudRepository<ProcessoSeletivoCadastro, String> {
   ProcessoSeletivoCadastro findByCodigo(long codigo);



}
