package projet.librairie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import projet.librairie.models.Livre;
import projet.librairie.repository.LibrairieRepository;

@CrossOrigin(origins = "*")
@RestController
public class LibrairieController {

    @Autowired
    private LibrairieRepository repository;
    
    @GetMapping("/livres")
    public List<Livre> getAllLivres(){
        return repository.findAll();
    }
    
}
