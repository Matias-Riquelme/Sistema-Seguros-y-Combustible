package gestion_vehiculos_combustible.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaquinaDTO {
    private Long id;
    private double SInicial;
    private double SFinal;
    private double litros;
}
