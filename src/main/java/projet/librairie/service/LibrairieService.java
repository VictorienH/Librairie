package projet.librairie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.librairie.models.Livre;
import projet.librairie.repository.LibrairieRepository;

@Service

public class LibrairieService {

    @Autowired
    private LibrairieRepository librairieRepository;
    
    public List<Livre> getLivres(){
        List<Livre> livres = new ArrayList<>();
        librairieRepository.findAll().forEach(livre -> {
            livres.add(livre);
        });
        return livres;
    }

    public Livre getLivre(long id) {
        return librairieRepository.findById(id).orElse(null);
    }

    public void deleteLivre(long id) {
        librairieRepository.deleteById(id);
    }

    public void addLivre(Livre livre) {
        librairieRepository.save(livre);
    }

    public void updateLivre(Livre livre, long id) {

        librairieRepository.save(livre);
    }
}
