package projet.librairie.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/books/{title}")
    public ResponseEntity<String> getLivreByName(@PathVariable String title ) {
        return livreService.getLivresByName(title);
    }

    @GetMapping("/auteur/{author}")
    public ResponseEntity<String> getLivreByAuthor(@PathVariable String author ) {
        return livreService.getLivresByAuthor(author);
    }

    
}
