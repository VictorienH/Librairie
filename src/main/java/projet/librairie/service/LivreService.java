package projet.librairie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class LivreService {

    private final String OPEN_LIBRARY_URL = "https://www.googleapis.com/books/v1/volumes";
    private final String LANGUAGE_FILTER = "en";

    @Autowired  
    private RestTemplate restTemplate;

    public ResponseEntity<String> getAllLivres() {
        return restTemplate.exchange(   
                "https://www.googleapis.com/books/v1/volumes?q=search+terms&maxResults=20",
                HttpMethod.GET,
                null,
                String.class
        );
    }

    public ResponseEntity<String> getLivresByName(String title) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(OPEN_LIBRARY_URL)
                .queryParam("q", "intitle:" + title)
                .queryParam("maxResults", 40)
                .queryParam("langRestrict", LANGUAGE_FILTER);

        String url = builder.toUriString();
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                String.class
        );
        
    }

    public ResponseEntity<String> getLivresByAuthor(String author) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(OPEN_LIBRARY_URL)
                .queryParam("q", "inauthor:" + author)
                .queryParam("maxResults", 40);


        String url = builder.toUriString();
        
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                String.class
        );
        
    }

    public ResponseEntity<String> getLivresByCategorie(String categorie) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(OPEN_LIBRARY_URL)
                .queryParam("q", "subject:" + categorie)
                .queryParam("maxResults", 40);

        

        String url = builder.toUriString();
        
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                String.class
        );
        
    }


    

    
}
