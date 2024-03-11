package projet.librairie.models;


import jakarta.persistence.Column;
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
public class Commentaire {
     
    @Id
    @GeneratedValue
    @Column(name = "id_commentaire")
    private Long id_commentaire;

    @Column(name = "commentaire")
    private String commentaire;
    
}
