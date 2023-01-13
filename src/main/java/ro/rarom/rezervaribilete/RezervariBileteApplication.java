package ro.rarom.rezervaribilete;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.rarom.rezervaribilete.model.Spectacol;
import ro.rarom.rezervaribilete.service.RezervareReader;

import java.io.File;
import java.nio.file.Path;

@SpringBootApplication
public class RezervariBileteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RezervariBileteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RezervareReader reader = new RezervareReader();
		Spectacol spectacol = reader.generateSpectacol();
		File json = new File(Path.of("src/main/resources/spectacol.json").toUri());
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.writeValue(json ,spectacol);
	}

}
