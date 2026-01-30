package MicroservicioIncidenteSiniestros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import MicroservicioIncidenteSiniestros.model.Cierre;

@Repository
public interface CierreRepository extends JpaRepository<Cierre, Integer> {
}
