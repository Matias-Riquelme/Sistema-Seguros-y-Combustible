package MicroservicioIncidenteSiniestros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import MicroservicioIncidenteSiniestros.model.FormularioIncidente;

@Repository
public interface FormularioIncidenteRepository extends JpaRepository<FormularioIncidente, Integer> {

    // Consulta para contar todo los registros asociados a un siniestro
    public Long countBySiniestroId(Integer siniestroId);

    // Consulta para obtener todos los registros asociados a un siniestro
    public List<FormularioIncidente> findBySiniestroId(Integer siniestroId);

}
