package gestion_vehiculos_combustible.Dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CombustibleDTO {
    private Long id;
    private String nombre;
    private double precio;
    private double consumos;
    private double kilometraje;
    private double rendimiento;
    private String mes;
    private Date mes2;
    private int estanque;
}
