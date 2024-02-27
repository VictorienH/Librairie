package projet.librairie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.librairie.models.Livre;

public interface LibrairieRepository extends JpaRepository<Livre, Long>{
    
    

}
