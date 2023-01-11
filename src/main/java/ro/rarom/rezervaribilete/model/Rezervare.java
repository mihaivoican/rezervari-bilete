package ro.rarom.rezervaribilete.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rezervare {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Integer nrLoc;
    @Column
    private String email;
    @Column
    private String telefon;
    @ManyToOne
    private IntervalOrar intervalOrar;
}
