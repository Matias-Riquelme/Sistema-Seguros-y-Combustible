package MicroservicioIncidenteSiniestros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Tipo_Incidente")
public class TipoIncidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_incidente")
    private Integer idTipoIncidente;

    @Column(name = "nombre_tipo_incidente", nullable = false, length = 100)
    private String nombreTipoIncidente;
}
