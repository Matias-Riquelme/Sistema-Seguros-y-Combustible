package gestion_vehiculos_combustible.repository;

import gestion_vehiculos_combustible.model.TipoRegOdo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRegOdoRepository extends JpaRepository<TipoRegOdo, Long> {
}
