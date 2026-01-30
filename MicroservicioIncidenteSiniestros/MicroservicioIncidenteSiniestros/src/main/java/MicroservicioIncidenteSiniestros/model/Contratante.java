package MicroservicioIncidenteSiniestros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Contratante")
public class Contratante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contratante")
    private Integer idContratante;

    @Column(name = "razon_social_contra", length = 150)
    private String razonSocialContra;

    @Column(name = "rut_contra", length = 20)
    private String rutContra;
}
