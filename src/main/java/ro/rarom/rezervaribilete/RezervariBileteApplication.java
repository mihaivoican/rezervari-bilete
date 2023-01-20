package ro.rarom.rezervaribilete;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ro.rarom.rezervaribilete.model.Spectacol;
import ro.rarom.rezervaribilete.service.RezervareReader;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

@SpringBootApplication
public class RezervariBileteApplication implements CommandLineRunner {
//public class RezervariBileteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RezervariBileteApplication.class, args);
	}



	//pt umplerea cu date a claselor din modelul de date; vezi si cod la
	@Override
	public void run(String... args) throws Exception {
		RezervareReader reader = new RezervareReader();
		List<Spectacol> listaSpectacole = reader.generateSpectacole();
		File json = new File(Path.of("src/main/resources/spectacol.json").toUri());
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.writeValue(json ,listaSpectacole);
	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("GET", "POST", "PUT","PATCH", "DELETE");
			}
		};
	}

}
