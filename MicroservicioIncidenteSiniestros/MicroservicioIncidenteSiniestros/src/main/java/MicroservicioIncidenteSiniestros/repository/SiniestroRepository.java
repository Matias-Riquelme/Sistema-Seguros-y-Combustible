package MicroservicioIncidenteSiniestros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import MicroservicioIncidenteSiniestros.model.Siniestro;

@Repository
public interface SiniestroRepository extends JpaRepository<Siniestro, Integer> {

    // Consulta para ver cuantos siniestros ocurrieron el mes
    public Long countByMonthAndYear(Integer month, Integer year);

    // Consulta para ver cuantos siniestros ocurrieron el año
    public Long countByYear(Integer year);

    // Consulta para ver la cantidad de polizas activadas de un siniestro
    public Long countByPolizaId(Integer polizaId);

    // Consulta para ver la cantidad de siniestros relacionado a un incidente
    public Long countByIncidenteId(Integer incidenteId);

}
