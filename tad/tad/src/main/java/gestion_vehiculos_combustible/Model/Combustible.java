package gestion_vehiculos_combustible.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "combustibles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Combustible {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;
    private double precio;
    private boolean usoPropio;
    // Datos de la Máquina (solo si usoPropio es true)
    private double SInicial;
    private double SFinal;
    // Datos del Vehículo (Excel)
    private double kmVehiculoInicial;
    private double kmVehiculoFinal;
    private double kilometros;
    private double consumos;
    private double rendimiento;
    private String mes;
    private Date mes2;
    private int estanque;

}
