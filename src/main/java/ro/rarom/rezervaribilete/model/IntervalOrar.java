package ro.rarom.rezervaribilete.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

//@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IntervalOrar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate zi;
    private String ora;
    @OneToMany
    private List<Rezervare> rezervari;
}
