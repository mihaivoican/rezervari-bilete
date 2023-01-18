package ro.rarom.rezervaribilete.service;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.rarom.rezervaribilete.model.Rezervare;

public interface RezervareRepository extends JpaRepository<Rezervare, Long> {
}
