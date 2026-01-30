package gestion_vehiculos_combustible.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
    private double KMinicial;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private double kilometros;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private double KMFinal;

    private int anio;
    private int anioRegistro;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private double consumos;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private double rendimiento;
}
