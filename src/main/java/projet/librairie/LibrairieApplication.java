package projet.librairie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
(exclude = { SecurityAutoConfiguration.class})
public class LibrairieApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrairieApplication.class, args);
	}
	
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

}
