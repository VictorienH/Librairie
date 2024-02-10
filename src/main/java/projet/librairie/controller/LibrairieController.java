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
import projet.librairie.service.LibrairieService;

@CrossOrigin(origins = "*")
@RestController
public class LibrairieController {

    @Autowired
    private LibrairieService librairieService;
    
    @GetMapping("/livres")
    public List<Livre> getAllLivres(){
        
        return librairieService.getLivres();
    }
    
    @GetMapping("/livre/{id}")

    public Livre getByIdLivre(@PathVariable long id){
        return librairieService.getLivre(id);
    }

    @DeleteMapping("/livre/{id}")
    public void deleteLivre(@PathVariable long id){
        librairieService.deleteLivre(id);
    }

    @PostMapping("/livres")
    public void addLivre(@RequestBody Livre livre){
        librairieService.addLivre(livre);
    }


    @PutMapping("/livre/{id}")

    public void updateLivre(@RequestBody Livre livre, @PathVariable long id){
        librairieService.updateLivre(livre, id);
    }
    
}

