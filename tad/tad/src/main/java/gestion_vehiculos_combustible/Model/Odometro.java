package gestion_vehiculos_combustible.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Entity
@Table(name = "odometro")
@NoArgsConstructor
@AllArgsConstructor
public class Odometro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_odo;
    private Long odoActual;
    private Date f_toma_odo;
    private Date r_reg_odo;
}
