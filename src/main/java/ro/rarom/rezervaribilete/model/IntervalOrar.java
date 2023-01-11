package ro.rarom.rezervaribilete.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IntervalOrar {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private LocalDate zi;
    @Column
    private String interval;
    @ManyToOne
    private Spectacol spectacol;
}
