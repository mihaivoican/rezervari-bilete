package ro.rarom.rezervaribilete.service;

import org.springframework.stereotype.Service;

@Service
public class SpectacolService {
    private final SpectacolRepository spectacolRepository;

    public SpectacolService(RezervareReader rezervareReader, SpectacolRepository spectacolRepository) {
        this.spectacolRepository = spectacolRepository;
        spectacolRepository.saveAll(rezervareReader.generateSpectacole());
    }
}
