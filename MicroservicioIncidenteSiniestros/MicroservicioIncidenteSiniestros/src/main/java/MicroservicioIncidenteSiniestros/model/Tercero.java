package MicroservicioIncidenteSiniestros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Tercero")
public class Tercero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tercero")
    private Integer idTercero;

    @Column(name = "nombre_ter", length = 100)
    private String nombreTer;

    @Column(name = "apellido_ter", length = 100)
    private String apellidoTer;

    @Column(name = "telefono_ter", length = 20)
    private String telefonoTer;

    @Column(name = "email_ter", length = 100)
    private String emailTer;

    @Column(name = "aseguradora_ter", length = 100)
    private String aseguradoraTer;

    @Column(name = "numero_sin_ter", length = 50)
    private String numeroSinTer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_form")
    private FormularioIncidente formularioIncidente;
}
