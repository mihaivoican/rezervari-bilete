package ro.rarom.rezervaribilete.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Spectacol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nume;
    private int nrLocuri;
    private LocalDate dataStart;
    private LocalDate dataFinal;
//    @OneToMany(mappedBy = "spectacol",  cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
   @OneToMany(cascade=CascadeType.ALL)
    private List<IntervalOrar> intervale;

}
