package projet.librairie.repository;

import org.springframework.data.repository.CrudRepository;

import projet.librairie.models.Livre;

public interface LibrairieRepository extends CrudRepository<Livre, Long>{
    

}
