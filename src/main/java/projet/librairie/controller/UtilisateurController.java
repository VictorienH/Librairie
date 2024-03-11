package projet.librairie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projet.librairie.models.Utilisateur;
import projet.librairie.repository.UtilisateurRepository;
import projet.librairie.service.LivreService;

@RestController
@RequestMapping
public class UtilisateurController {

    @Autowired
    private final UtilisateurRepository userRepo;

    public UtilisateurController(UtilisateurRepository userRepo) {
        this.userRepo = userRepo;
    }


    @GetMapping("/allUserss")
    public List<Utilisateur> getUsers() {
        return userRepo.findAll();
    }
    
}
