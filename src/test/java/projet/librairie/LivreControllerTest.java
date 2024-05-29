package projet.librairie;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import projet.librairie.controller.LivreController;
import projet.librairie.service.LivreService;

public class LivreControllerTest {

    @Mock
    private LivreService livreService;

    @InjectMocks
    private LivreController livreController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(livreController).build();
    }

    @Test
    public void testGetLivres() throws Exception {
        when(livreService.getAllLivres()).thenReturn(new ResponseEntity<>("[]", HttpStatus.OK));

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));

        verify(livreService, times(1)).getAllLivres();
    }

    @Test
    public void testGetLivresByName() throws Exception {
        String title = "Test Title";
        String jsonResponse = "{\"items\":[{\"volumeInfo\":{\"title\":\"Test Title\",\"authors\":[\"Author 1\"],\"publishedDate\":\"2020-01-01\",\"description\":\"Description\",\"language\":\"en\",\"imageLinks\":{\"thumbnail\":\"http://example.com/image.jpg\"}}}]}";
        when(livreService.getLivresByName(title)).thenReturn(new ResponseEntity<>(jsonResponse, HttpStatus.OK));

        mockMvc.perform(get("/books/{title}", title))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Test Title"))
                .andExpect(jsonPath("$[0].author").value("Author 1"))
                .andExpect(jsonPath("$[0].publishedDate").value("2020-01-01"))
                .andExpect(jsonPath("$[0].description").value("Description"))
                .andExpect(jsonPath("$[0].language").value("en"))
                .andExpect(jsonPath("$[0].photoUrl").value("http://example.com/image.jpg"));

        verify(livreService, times(1)).getLivresByName(title);
    }

    @Test
    public void testGetLivresByAuthor() throws Exception {
        String author = "Test Author";
        String jsonResponse = "{\"items\":[{\"volumeInfo\":{\"title\":\"Test Book\",\"authors\":[\"Test Author\"],\"publishedDate\":\"2020-01-01\",\"description\":\"Description\",\"imageLinks\":{\"thumbnail\":\"http://example.com/image.jpg\"}}}]}";
        when(livreService.getLivresByAuthor(author)).thenReturn(new ResponseEntity<>(jsonResponse, HttpStatus.OK));

        mockMvc.perform(get("/auteur/{author}", author))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Test Book"))
                .andExpect(jsonPath("$[0].author").value("Test Author"))
                .andExpect(jsonPath("$[0].publishedDate").value("2020-01-01"))
                .andExpect(jsonPath("$[0].description").value("Description"))
                .andExpect(jsonPath("$[0].photoUrl").value("http://example.com/image.jpg"));

        verify(livreService, times(1)).getLivresByAuthor(author);
    }

    @Test
    public void testGetLivreByCategorie() throws Exception {
        String categorie = "Test Category";
        String jsonResponse = "{\"items\":[{\"volumeInfo\":{\"title\":\"Test Book\",\"authors\":[\"Author 1\"],\"publishedDate\":\"2020-01-01\",\"description\":\"Description\",\"categories\":[\"Test Category\"],\"imageLinks\":{\"thumbnail\":\"http://example.com/image.jpg\"}}}]}";
        when(livreService.getLivresByCategorie(categorie)).thenReturn(new ResponseEntity<>(jsonResponse, HttpStatus.OK));

        mockMvc.perform(get("/categories/{categorie}", categorie))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Test Book"))
                .andExpect(jsonPath("$[0].author").value("Author 1"))
                .andExpect(jsonPath("$[0].publishedDate").value("2020-01-01"))
                .andExpect(jsonPath("$[0].description").value("Description"))
                .andExpect(jsonPath("$[0].categories").value("Test Category"))
                .andExpect(jsonPath("$[0].photoUrl").value("http://example.com/image.jpg"));

        verify(livreService, times(1)).getLivresByCategorie(categorie);
    }
}
