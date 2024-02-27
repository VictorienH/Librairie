package projet.librairie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import projet.librairie.models.Livre;

@Service
public class LivreService {

    private final String OPEN_LIBRARY_URL = "https://openlibrary.org/search.json?q=pokemon";

    @Autowired
    private RestTemplate restTemplate;

    public Livre[] getAllLivres() {
        return restTemplate.getForObject(OPEN_LIBRARY_URL, Livre[].class);
    }
}
