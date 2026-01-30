package MicroservicioIncidenteSiniestros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import MicroservicioIncidenteSiniestros.model.TipoSiniestro;

@Repository
public interface TipoSiniestroRepository extends JpaRepository<TipoSiniestro, Integer> {
}
