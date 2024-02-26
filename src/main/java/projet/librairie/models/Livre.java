package projet.librairie.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Livre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Livre {
    
    @Id
    @Column(name = "id_livre")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_livre;

    @Column(name = "title")
    private String title;

    @Column(name = "auteur")
    private String auteur;

    @Column(name = "annee_publication")

    private String anneePublication;

    @Column(name = "isbn")

    private String isbn;

    @Column(name = "couverture")

    private String couverture;


 


}
