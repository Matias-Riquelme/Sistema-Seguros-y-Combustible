package gestion_vehiculos_combustible.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CombustibleDTO {
    private Long id;
    private VehiculoDTO vehiculo;
    private double precio;
    private boolean usoPropio;
    private double SInicial;
    private double SFinal;
    private double kmVehiculoInicial;
    private double kmVehiculoFinal;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private double kilometros;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private double consumos;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private double rendimiento;

    private String mes;
    private Date mes2;
    private int estanque;
}
