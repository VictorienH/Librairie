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

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> getAllLivres() {
        return restTemplate.exchange(
                "https://www.googleapis.com/books/v1/volumes?q=search+terms",
                HttpMethod.GET,
                null,
                String.class
        );
    }

    public ResponseEntity<String> getLivresByName(String title) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(OPEN_LIBRARY_URL)
                .queryParam("q", "intitle:" + title);

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
                .queryParam("q", "inauthor:" + author);

        String url = builder.toUriString();
        
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                String.class
        );
        
    }

    
}
