package projet.librairie.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "commentaire")
public class Commentaire {
     
    @Id
    @GeneratedValue
    @Column(name = "id_commentaire")
    private Long id_commentaire;

    @Column(name = "commentaire")
    private String commentaire;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Livre livres;
    
}
