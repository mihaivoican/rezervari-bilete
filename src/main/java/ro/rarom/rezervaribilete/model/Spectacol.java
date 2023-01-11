package ro.rarom.rezervaribilete.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Spectacol {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String nume;
    @Column
    private int nrLocuri;
    @Column
    private LocalDate dataStart;
    @Column
    private LocalDate dataFinal;

}
