package SistemaSME.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String role;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Collection<Usuario> usuarios;



}