package MicroservicioIncidenteSiniestros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import MicroservicioIncidenteSiniestros.model.FormularioIncidente;

@Repository
public interface FormularioIncidenteRepository extends JpaRepository<FormularioIncidente, Integer> {
}
