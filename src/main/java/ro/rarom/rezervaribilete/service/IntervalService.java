package ro.rarom.rezervaribilete.service;

import org.springframework.stereotype.Service;
import ro.rarom.rezervaribilete.exception.ResourceNotFoundException;
import ro.rarom.rezervaribilete.model.IntervalOrar;
import ro.rarom.rezervaribilete.model.Rezervare;

@Service
public class IntervalService {
    private final IntervalRepository intervalRepository;

    public IntervalService(IntervalRepository intervalRepository) {
        this.intervalRepository = intervalRepository;
    }

    //cautare dupa Id
    public IntervalOrar getByIdInterval(long id){
        return intervalRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Intervalul orar nu exista",id));
    }

    //adaugare rezervare la interval orar
    public IntervalOrar addRezervareToInterval(long id, Rezervare rezervare){
        IntervalOrar intervalCautat = getByIdInterval(id);
        intervalCautat.getRezervari().add(rezervare);
        return intervalRepository.save(intervalCautat);
    }

    public IntervalOrar deleteByIdInterval(long id) {
        IntervalOrar intervalCautat = getByIdInterval(id);
        intervalRepository.deleteById(id);
        return  intervalCautat;
    }
}
