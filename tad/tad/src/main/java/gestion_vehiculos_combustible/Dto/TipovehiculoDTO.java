package gestion_vehiculos_combustible.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipovehiculoDTO {
    private Long id_tipo_vehiculo;
    private String tipo_vehiculo;
}
