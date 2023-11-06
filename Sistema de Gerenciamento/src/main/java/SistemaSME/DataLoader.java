package SistemaSME;

import SistemaSME.Repository.UsuarioRepository;
import SistemaSME.Models.Role;
import SistemaSME.Models.Usuario;
import SistemaSME.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
    
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        javax.management.relation.Role adminRole = roleRepository.findByRole("ADMIN");
        javax.management.relation.Role userRole = roleRepository.findByRole("USER");

        Usuario usuario = new Usuario("admin@code.com", passwordEncoder.encode("1234"),"Admin", "Super",true,"admin");
        usuario.setRoles(Arrays.asList(adminRole));
        usuarioRepository.save(usuario);

        usuario = new Usuario("user@code.com", passwordEncoder.encode("1234"),"User", "Super",true,"user");
        usuario.setRoles(Arrays.asList(userRole));
        usuarioRepository.save(usuario);

    }
}