package projet.librairie.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "livre")
public class Livre {
    
    @Id
    @GeneratedValue
    @Column(name = "id_livre")
    private Long idLivre;

    @Column(name = "titre")
    private String titre;

    @Column(name = "auteur")
    private String auteur;

    @Column(name = "annee_publication")
    private Date anneePublication;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "couverture")
    private String couverture;


 


}
