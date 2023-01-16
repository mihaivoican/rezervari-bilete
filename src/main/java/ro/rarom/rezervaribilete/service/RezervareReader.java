package ro.rarom.rezervaribilete.service;

import org.springframework.stereotype.Repository;
import ro.rarom.rezervaribilete.model.IntervalOrar;
import ro.rarom.rezervaribilete.model.Rezervare;
import ro.rarom.rezervaribilete.model.Spectacol;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntConsumer;

@Repository
public class RezervareReader {


    public List<Spectacol> generateSpectacole() {
        List<Spectacol> lista = new ArrayList<>();
        for (int nr = 1; nr < 4; nr++) {
            Spectacol s = new Spectacol();
//            s.setId(1);
            s.setNume("Spectacol " + nr);
            s.setNrLocuri(20);
            s.setDataStart(LocalDate.now().plusDays(nr));
            s.setDataFinal(LocalDate.now().plusDays(nr+2L));
            s.setIntervale(generateIntervalForSpectacol(s,nr));
            lista.add(s);
        }
        return lista;
    }

    private List<IntervalOrar> generateIntervalForSpectacol(Spectacol spectacol, int nr) {
        List<IntervalOrar> list = new ArrayList<>();
        //aflu cate zile ruleaza spectacolul
        Period period = Period.between(spectacol.getDataStart(), spectacol.getDataFinal());
        int nrZile = period.getDays() + 1;
        int day = 1;
        while (day <= nrZile) {
            // pentru fiecare zi a spectacolului cream 3 intervale orare
            for (int i = 0; i < 3; i++) {
                IntervalOrar interval = new IntervalOrar();
//                interval.setId(day + i);
                interval.setZi(LocalDate.now().plusDays(  day - 1 +nr));
                interval.setOra(String.valueOf(10 + i * 2));
                interval.setRezervari(generateRezervariForInterval(interval, spectacol.getNrLocuri()));
                list.add(interval);
            }
            day++;
        }
        return list;
    }

    private List<Rezervare> generateRezervariForInterval(IntervalOrar interval, int nrLocuriDisponibile) {
        List<Rezervare> rezervari = new ArrayList<>();
        new Random().ints(0, nrLocuriDisponibile).limit(new Random().nextInt(10)).iterator()
                .forEachRemaining((IntConsumer) r -> {
                    rezervari.add(new Rezervare(null, r, "email@test.ro", "telefon"));
                });
        return rezervari;
    }
}
