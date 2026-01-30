package MicroservicioIncidenteSiniestros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Siniestro")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sin")
    private Integer idSin;

    @Column(name = "fecha_hora_sin")
    private LocalDateTime fechaHoraSin;

    @Column(name = "deducible_apli_sin", precision = 12, scale = 2)
    private BigDecimal deducibleApliSin;

    @Column(name = "indemnizacion_sin", precision = 12, scale = 2)
    private BigDecimal indemnizacionSin;

    @Column(name = "numero_sin")
    private Integer numeroSin;

    @Column(name = "costo_sin", precision = 12, scale = 2)
    private BigDecimal costoSin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pol")
    private Poliza poliza;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    private EstadoSiniestro estadoSiniestro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_sin")
    private TipoSiniestro tipoSiniestro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cierre")
    private Cierre cierre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_form")
    private FormularioIncidente formularioIncidente;
}
