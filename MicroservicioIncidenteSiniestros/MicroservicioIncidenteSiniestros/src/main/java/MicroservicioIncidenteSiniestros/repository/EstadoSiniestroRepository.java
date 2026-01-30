package MicroservicioIncidenteSiniestros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import MicroservicioIncidenteSiniestros.model.EstadoSiniestro;

@Repository
public interface EstadoSiniestroRepository extends JpaRepository<EstadoSiniestro, Integer> {
}
