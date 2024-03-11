package projet.librairie.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import projet.librairie.models.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

    
}