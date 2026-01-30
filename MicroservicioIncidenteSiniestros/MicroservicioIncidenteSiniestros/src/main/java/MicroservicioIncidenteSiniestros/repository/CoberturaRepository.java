package MicroservicioIncidenteSiniestros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import MicroservicioIncidenteSiniestros.model.Cobertura;

@Repository
public interface CoberturaRepository extends JpaRepository<Cobertura, Integer> {
}
