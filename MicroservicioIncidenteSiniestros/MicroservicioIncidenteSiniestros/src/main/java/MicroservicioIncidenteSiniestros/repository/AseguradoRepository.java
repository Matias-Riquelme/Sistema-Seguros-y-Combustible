package MicroservicioIncidenteSiniestros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import MicroservicioIncidenteSiniestros.model.Asegurado;

@Repository
public interface AseguradoRepository extends JpaRepository<Asegurado, Integer> {
}
