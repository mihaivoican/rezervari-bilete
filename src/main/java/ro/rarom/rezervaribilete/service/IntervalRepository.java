package ro.rarom.rezervaribilete.service;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.rarom.rezervaribilete.model.IntervalOrar;

public interface IntervalRepository extends JpaRepository<IntervalOrar, Long> {

}
