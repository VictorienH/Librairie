package projet.librairie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import projet.librairie.models.Livre;
import projet.librairie.repository.LibrairieRepository;


@RestController
@RequestMapping
public class LibrairieController {

    @Autowired
    private LibrairieRepository repository;
    
    @GetMapping(path="/getAllLivres")
    public Iterable<Livre> getAllLivres(){
        return repository.findAll();
    }
}
