package gestion_vehiculos_combustible.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OdometroDTO {
    private Long id_odo;
    private Long odoActual;
    private Date f_toma_odo;
    private Date r_reg_odo;
}
