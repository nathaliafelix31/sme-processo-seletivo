package SistemaSME.repositories;

import SistemaSME.models.ProcessoSeletivoCadastro;
import org.springframework.data.repository.CrudRepository;

public interface ProcessoSeletivoRepository extends CrudRepository<ProcessoSeletivoCadastro, String> {
   ProcessoSeletivoCadastro findByCodigo(long codigo);



}
