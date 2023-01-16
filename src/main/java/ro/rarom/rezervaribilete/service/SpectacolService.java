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

    //caut toate spectacolele
    public List<Spectacol> getAllSpectacole() {
        return spectacolRepository.findAll();
    }

    //caut dupa Id
    public Spectacol getById(long id) {
        return spectacolRepository.findById( id)
                .orElseThrow(() -> new ResourceNotFoundException("Spectacolul nu exista",id));
    }

    //sterg spectacol dupa id
    public Spectacol deleteById(long id) {
        Spectacol spectacolDeSters = getById(id);
        spectacolRepository.deleteById(id);
        return spectacolDeSters;
    }

    //adaugare spectacol
    public Spectacol add(Spectacol spectacol) {
        return spectacolRepository.save(spectacol);
    }

    //actualizare spectacol (update)
    public Spectacol update(long id, Spectacol spectacol) {
        Spectacol spectacolDeActualizat = getById(id);
        spectacolDeActualizat.setNume(spectacol.getNume());
        spectacolDeActualizat.setDataStart(spectacol.getDataStart());
        spectacolDeActualizat.setDataFinal(spectacol.getDataFinal());
        spectacolDeActualizat.setNrLocuri(spectacol.getNrLocuri());
        return spectacolRepository.save(spectacolDeActualizat);
    }








}
