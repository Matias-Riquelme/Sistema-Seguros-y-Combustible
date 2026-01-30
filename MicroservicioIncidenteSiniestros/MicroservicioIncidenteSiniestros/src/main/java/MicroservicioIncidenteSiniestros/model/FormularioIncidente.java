package MicroservicioIncidenteSiniestros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Formulario_Incidente")
public class FormularioIncidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_form")
    private Integer idForm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion")
    private UbicacionIncidente ubicacion;

    @Column(name = "id_usuario") // ID de Keycloak (id_user en tabla Usuario)
    private String idUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_incidente")
    private TipoIncidente tipoIncidente;

    @Column(name = "f_ingreso_form")
    private LocalDateTime fIngresoForm;

    @Column(name = "fecha_hora_incidente")
    private LocalDateTime fechaHoraIncidente;

    @Column(name = "relato_form", length = 500)
    private String relatoForm;

    @Column(name = "patente_1", length = 20)
    private String patente1;

    @Column(name = "patente_2", length = 20)
    private String patente2;

    @Column(name = "nombre_conductor", length = 100)
    private String nombreConductor;

    @Column(name = "rut_conductor", length = 20)
    private String rutConductor;

    @Column(name = "base", length = 100)
    private String base;

    @Column(name = "operacion", length = 100)
    private String operacion;

    @Column(name = "lugar_carga", length = 100)
    private String lugarCarga;

    @Column(name = "fecha_ini_transporte_carga")
    private LocalDateTime fechaIniTransporteCarga;

    @Column(name = "destino_carga", length = 100)
    private String destinoCarga;
}
