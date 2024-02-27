package projet.librairie.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projet.librairie.service.LivreService;

@RestController
@RequestMapping
public class LivreController {

    private final LivreService livreService;

    public LivreController(LivreService googleBooksService) {
        this.livreService = googleBooksService;
    }

    @GetMapping("/books")
    public ResponseEntity<String> getLivres() {
        return livreService.getAllLivres();
    }
}
