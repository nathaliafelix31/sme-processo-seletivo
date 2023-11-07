package SistemaSME.repositories;

import SistemaSME.models.FormularioRecurso;
import org.springframework.data.repository.CrudRepository;

public interface FormularioRecursoRepository extends CrudRepository<FormularioRecurso, String> {
    FormularioRecurso findByCodigo(long codigo);
}
