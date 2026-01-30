package MicroservicioIncidenteSiniestros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import MicroservicioIncidenteSiniestros.model.UbicacionIncidente;

@Repository
public interface UbicacionIncidenteRepository extends JpaRepository<UbicacionIncidente, Integer> {
}
