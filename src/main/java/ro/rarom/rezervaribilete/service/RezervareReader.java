package ro.rarom.rezervaribilete.service;

import org.springframework.stereotype.Repository;
import ro.rarom.rezervaribilete.model.IntervalOrar;
import ro.rarom.rezervaribilete.model.Rezervare;
import ro.rarom.rezervaribilete.model.Spectacol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class RezervareReader {
    private String filerezervariPath;

    public static int rezervareId = 0;

//    public List<Rezervare> getRezervari() {
//        //citesc date din fisier
//        try {
//            return Files.lines(Path.of("src/main/resources/rezervari.txt"))
//                    .map(this::lineToRezervare)
//                    .collect(Collectors.toList());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    private Rezervare lineToRezervare(String line) {
//        String[] rezervareParts = line.split("\\|");
//        return new Rezervare(rezervareId++,Integer.parseInt(rezervareParts[0]),rezervareParts[1],rezervareParts[2],(IntervalOrar) rezervareParts[3]);
//    }

    public Spectacol generateSpectacol(){
        Spectacol s = new Spectacol();
        s.setId(1);
        s.setNume("Primul Spectacol");
        s.setNrLocuri(20);
        s.setDataStart(LocalDate.now());
        s.setDataFinal(LocalDate.now().plusDays(2L));
        s.setIntervale(generateIntervalForSpectacol(s));
        return s;
    }

    private List<IntervalOrar> generateIntervalForSpectacol(Spectacol spectacol){
        List<IntervalOrar> list = new ArrayList<>();
        for (int day = 1; day <= 2 ; day++) {
            // pentru fiecare zi a spectacolului cream 3 intervale orare
            for (int i = 0; i < 3; i++) {
                IntervalOrar interval = new IntervalOrar();
                interval.setId(day+i);
                interval.setZi(LocalDate.now().plusDays(day - 1));
                interval.setRezervari(generateRezervariForInterval(interval, spectacol.getNrLocuri()));
                list.add(interval);
            }
        }
        return list;
    }

    private List<Rezervare> generateRezervariForInterval(IntervalOrar interval, int nrLocuriDisponibile){
        List<Rezervare> rezervari = new ArrayList<>();
        new Random().ints(0,nrLocuriDisponibile).limit(new Random().nextInt(10)).iterator()
                .forEachRemaining((IntConsumer) r -> {
                    rezervari.add(new Rezervare(r,r,"email@test.ro", "telefon"));
                });
        return rezervari;
    }
}
