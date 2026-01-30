package gestion_vehiculos_combustible.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaquinaDTO {
    private Long id;
    private double KMinicial;
    private double KMFinal;
    private double KMTotales;
    private double litros;
}
