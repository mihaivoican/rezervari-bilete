package ro.rarom.rezervaribilete.service;

import org.springframework.stereotype.Repository;
import ro.rarom.rezervaribilete.model.IntervalOrar;
import ro.rarom.rezervaribilete.model.Rezervare;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RezervareReader {
    private String filerezervariPath;

    public static int rezervareId = 0;

    public List<Rezervare> getRezervari() {
        //citesc date din fisier
        try {
            return Files.lines(Path.of("src/main/resources/rezervari.txt"))
                    .map(this::lineToRezervare)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Rezervare lineToRezervare(String line) {
        String[] rezervareParts = line.split("\\|");
        return new Rezervare(rezervareId++,Integer.parseInt(rezervareParts[0]),rezervareParts[1],rezervareParts[2],(IntervalOrar) rezervareParts[3]);

    }
}
