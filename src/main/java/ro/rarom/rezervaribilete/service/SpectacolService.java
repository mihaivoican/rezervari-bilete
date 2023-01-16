package ro.rarom.rezervaribilete.service;

import org.springframework.stereotype.Service;
import ro.rarom.rezervaribilete.exception.ResourceNotFoundException;
import ro.rarom.rezervaribilete.model.Spectacol;

import java.util.List;

@Service
public class SpectacolService {
    private final SpectacolRepository spectacolRepository;


    public SpectacolService(SpectacolRepository spectacolRepository,RezervareReader rezervareReader) {
        this.spectacolRepository = spectacolRepository;
        //salvare in baza de date
        spectacolRepository.saveAll(rezervareReader.generateSpectacole());
        System.out.println("Terminat salvat spectacole");
    }

    public List<Spectacol> getAllSpectacole() {
        return spectacolRepository.findAll();
    }

    public Spectacol getById(long id) {
        return spectacolRepository.findById( id)
                .orElseThrow(() -> new ResourceNotFoundException("Spectacolul nu exista",id));
    }
}
