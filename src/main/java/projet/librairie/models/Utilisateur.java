package projet.librairie.models;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "utilisateur")
public class Utilisateur {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name = "listlivres",
        joinColumns = {@JoinColumn(name = "id")},
        inverseJoinColumns = {@JoinColumn(name = "id_livre")}
    )
    private Set<Livre> livres = new HashSet <>();

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private Set<Commentaire> commentaires = new HashSet<>();

}

