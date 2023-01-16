package ro.rarom.rezervaribilete.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IntervalOrar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate zi;
    private String ora;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Rezervare> rezervari;
//    @ManyToOne
//    @JsonIgnore
//    private Spectacol spectacol;
}
