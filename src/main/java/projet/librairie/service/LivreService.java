package projet.librairie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LivreService {

    private final String OPEN_LIBRARY_URL = "https://www.googleapis.com/books/v1/volumes?q=search+terms";

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> getAllLivres() {
        return restTemplate.exchange(
                OPEN_LIBRARY_URL,
                HttpMethod.GET,
                null,
                String.class
        );
    }
}
