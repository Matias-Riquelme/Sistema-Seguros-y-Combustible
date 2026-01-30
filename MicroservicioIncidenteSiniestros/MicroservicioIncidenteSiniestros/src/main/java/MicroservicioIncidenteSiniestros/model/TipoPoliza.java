package MicroservicioIncidenteSiniestros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Tipo_Poliza")
public class TipoPoliza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_pol")
    private Integer idTipoPol;

    @Column(name = "nom_tipo_pol", nullable = false, length = 100)
    private String nomTipoPol;
}
