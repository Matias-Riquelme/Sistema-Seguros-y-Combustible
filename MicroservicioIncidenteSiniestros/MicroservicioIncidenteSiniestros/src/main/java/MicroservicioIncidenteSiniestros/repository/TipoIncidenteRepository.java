package MicroservicioIncidenteSiniestros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import MicroservicioIncidenteSiniestros.model.TipoIncidente;

@Repository
public interface TipoIncidenteRepository extends JpaRepository<TipoIncidente, Integer> {
}
