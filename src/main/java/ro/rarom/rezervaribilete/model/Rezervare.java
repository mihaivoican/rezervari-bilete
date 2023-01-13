package ro.rarom.rezervaribilete.model;

import lombok.*;

import javax.persistence.*;

//@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rezervare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer nrLoc;
    private String email;
    private String telefon;
}
