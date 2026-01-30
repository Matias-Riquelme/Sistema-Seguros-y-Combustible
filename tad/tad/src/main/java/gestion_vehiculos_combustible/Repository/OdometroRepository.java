package gestion_vehiculos_combustible.repository;

import gestion_vehiculos_combustible.model.Odometro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdometroRepository extends JpaRepository<Odometro, Long> {
}
