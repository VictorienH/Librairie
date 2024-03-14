package projet.librairie.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    public ResponseEntity<String> getLivresByName(@PathVariable String title) {
        String jsonResponse = livreService.getLivresByName(title).getBody();

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode rootNode = mapper.readTree(jsonResponse);
            JsonNode itemsNode = rootNode.path("items");

            if (itemsNode.isArray() && itemsNode.size() > 0) {
                List<JsonNode> filteredBooks = new ArrayList<>();
                for (JsonNode bookNode : itemsNode) {
                    String bookTitle = bookNode.path("volumeInfo").path("title").asText();
                    String bookAuthor = bookNode.path("volumeInfo").path("authors").get(0).asText();
                    String publishedDate = bookNode.path("volumeInfo").path("publishedDate").asText();
                    String description = bookNode.path("volumeInfo").path("description").asText();
                    String language = bookNode.path("volumeInfo").path("language").asText();
                    String photoUrl = null;
                    if (bookNode.path("volumeInfo").has("imageLinks")) {
                        photoUrl = bookNode.path("volumeInfo").path("imageLinks").path("thumbnail").asText();
                    }
                    
                    if (language.equalsIgnoreCase("en")) {
                        JsonNode filteredBook = mapper.createObjectNode()
                        .put("title", bookTitle)
                        .put("author", bookAuthor)
                        .put("publishedDate", publishedDate)
                        .put("description", description)
                        .put("language", language)
                        .put("photoUrl", photoUrl);
                        
                        filteredBooks.add(filteredBook);
                    }
                }
                System.out.println("here");
                String test = "";
                // if(filteredBooks != null || !filteredBooks.isEmpty()){
                    // test = mapper.writeValueAsString(filteredBooks);
                // }
                    return ResponseEntity.ok(test);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la récupération des données.");
        }
    }

    @GetMapping("/auteur/{author}")
    public ResponseEntity<String> getLivresByAuthor(@PathVariable String author) {
        String jsonResponse = livreService.getLivresByAuthor(author).getBody();

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode rootNode = mapper.readTree(jsonResponse);
            JsonNode itemsNode = rootNode.path("items");

            if (itemsNode.isArray() && itemsNode.size() > 0) {
                List<JsonNode> filteredBooks = new ArrayList<>();
                for (JsonNode bookNode : itemsNode) {
                    String bookTitle = bookNode.path("volumeInfo").path("title").asText();
                    String bookAuthor = bookNode.path("volumeInfo").path("authors").get(0).asText();
                    String publishedDate = bookNode.path("volumeInfo").path("publishedDate").asText();
                    String description = bookNode.path("volumeInfo").path("description").asText();

                    String photoUrl = null;
                    if (bookNode.path("volumeInfo").has("imageLinks")) {
                        photoUrl = bookNode.path("volumeInfo").path("imageLinks").path("thumbnail").asText();
                    }

                    if (bookAuthor.equalsIgnoreCase(author)) {
                        JsonNode filteredBook = mapper.createObjectNode()
                                .put("title", bookTitle)
                                .put("author", bookAuthor)
                                .put("publishedDate", publishedDate)
                                .put("description", description)
                                .put("photoUrl", photoUrl);

                        filteredBooks.add(filteredBook);
                    }
                }

                return ResponseEntity.ok(mapper.writeValueAsString(filteredBooks));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la récupération des données.");
        }
    }

    @GetMapping("/categories/{categorie}")
    public ResponseEntity<String> getLivreByCategorie(@PathVariable String categorie) {
        String jsonResponse = livreService.getLivresByCategorie(categorie).getBody();

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode rootNode = mapper.readTree(jsonResponse);
            JsonNode itemsNode = rootNode.path("items");

            if (itemsNode.isArray() && itemsNode.size() > 0) {
                List<JsonNode> filteredBooks = new ArrayList<>();
                for (JsonNode bookNode : itemsNode) {
                    // Récupérer les informations requises pour chaque livre
                    String bookTitle = bookNode.path("volumeInfo").path("title").asText();
                    String bookAuthor = bookNode.path("volumeInfo").path("authors").get(0).asText();
                    String publishedDate = bookNode.path("volumeInfo").path("publishedDate").asText();
                    String description = bookNode.path("volumeInfo").path("description").asText();
                    String categories = bookNode.path("volumeInfo").path("categories").asText();

                    String photoUrl = null;
                    if (bookNode.path("volumeInfo").has("imageLinks")) {
                        photoUrl = bookNode.path("volumeInfo").path("imageLinks").path("thumbnail").asText();
                    }

                    if (bookNode.path("volumeInfo").has("categories")) {
                        JsonNode categoriesNode = bookNode.path("volumeInfo").path("categories");
                        for (JsonNode categoryNode : categoriesNode) {
                            if (categoryNode.asText().equalsIgnoreCase(categorie)) {
                                JsonNode filteredBook = mapper.createObjectNode()
                                        .put("title", bookTitle)
                                        .put("author", bookAuthor)
                                        .put("categories", categories)
                                        .put("publishedDate", publishedDate)
                                        .put("description", description)
                                        .put("photoUrl", photoUrl);

                                filteredBooks.add(filteredBook);
                                break;
                            }
                        }
                    }
                }

                return ResponseEntity.ok(mapper.writeValueAsString(filteredBooks));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la récupération des données.");
        }
    }

}
