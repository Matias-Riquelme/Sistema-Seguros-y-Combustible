package MicroservicioIncidenteSiniestros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Deducible")
public class Deducible {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dedu")
    private Integer idDedu;

    @Column(name = "nombre_dedu", length = 100)
    private String nombreDedu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pol")
    private Poliza poliza;
}
