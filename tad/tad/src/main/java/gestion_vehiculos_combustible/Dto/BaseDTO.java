package gestion_vehiculos_combustible.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO {
    private Long id;
    private String nombre;
    private String ubicacion;
}
