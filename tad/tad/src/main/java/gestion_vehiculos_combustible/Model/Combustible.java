package gestion_vehiculos_combustible.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String nombre;
    private double precio;
    private double consumos;
    private double kilometraje;
    private double rendimiento;
    private String mes;
    private Date mes2;
    private int estanque;

    public double calcularConsumo(double kilometrosRecorridos) {
        return kilometrosRecorridos / consumos;
    }

    public double calcularCoste(double kilometrosRecorridos) {
        return calcularConsumo(kilometrosRecorridos);
    }

    public double calcularRendimiento() {
        return kilometraje / consumos;
    }

}
