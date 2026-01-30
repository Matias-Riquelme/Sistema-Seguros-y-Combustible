package gestion_vehiculos_combustible.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vehiculo;
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
