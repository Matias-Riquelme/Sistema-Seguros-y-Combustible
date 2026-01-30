package gestion_vehiculos_combustible.repository;

import gestion_vehiculos_combustible.model.Tipovehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipovehiculoRepository extends JpaRepository<Tipovehiculo, Long> {
}
