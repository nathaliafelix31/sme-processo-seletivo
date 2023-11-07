package SistemaSME.repositories;

import SistemaSME.models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository <Usuario, Long> {
    Usuario findByUsername(String username);
}