package ro.rarom.rezervaribilete.service;

import org.springframework.stereotype.Service;

@Service
public class IntervalService {
    private final IntervalRepository intervalRepository;

    public IntervalService(IntervalRepository intervalRepository, RezervareReader rezervareReader) {
        this.intervalRepository = intervalRepository;
        intervalRepository.saveAll(rezervareReader.generateSpectacole());
        //nu stiu cum sa generez intervale orare si rezervari
    }
}
