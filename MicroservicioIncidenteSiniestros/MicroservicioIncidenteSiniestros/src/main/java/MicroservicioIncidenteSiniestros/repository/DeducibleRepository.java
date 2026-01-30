package MicroservicioIncidenteSiniestros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import MicroservicioIncidenteSiniestros.model.Deducible;

@Repository
public interface DeducibleRepository extends JpaRepository<Deducible, Integer> {
}
