package ro.rarom.rezervaribilete.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.rarom.rezervaribilete.model.Spectacol;

@Repository
public interface SpectacolRepository extends JpaRepository<Spectacol,Long> {

}
