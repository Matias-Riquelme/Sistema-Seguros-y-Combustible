package gestion_vehiculos_combustible.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoDTO {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private String tipo;
    private String rampla;
    private int anio;
    private int anioRegistro;
    private int num_motor_veh;
    private int num_chasis_veh;
}
