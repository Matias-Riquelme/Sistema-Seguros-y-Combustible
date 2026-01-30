package gestion_vehiculos_combustible.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoRegOdoDTO {
    private Long id_tipo_reg_odo;
    private String tipo_reg_odo;
}
