package MicroservicioIncidenteSiniestros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import MicroservicioIncidenteSiniestros.model.Contratante;

@Repository
public interface ContratanteRepository extends JpaRepository<Contratante, Integer> {
}
