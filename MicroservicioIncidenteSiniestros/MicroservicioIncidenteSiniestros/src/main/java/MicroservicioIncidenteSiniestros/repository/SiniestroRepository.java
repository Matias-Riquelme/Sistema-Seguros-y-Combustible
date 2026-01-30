package MicroservicioIncidenteSiniestros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import MicroservicioIncidenteSiniestros.model.Siniestro;

@Repository
public interface SiniestroRepository extends JpaRepository<Siniestro, Integer> {
}
