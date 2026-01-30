package MicroservicioIncidenteSiniestros.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import MicroservicioIncidenteSiniestros.model.Siniestro;
import MicroservicioIncidenteSiniestros.repository.SiniestroRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SiniestroServices {

    @Autowired
    private SiniestroRepository siniestroRepository;

    // Listar siniestros
    public List<Siniestro> listarSiniestros() {
        return siniestroRepository.findAll();
    }

    // Obtener siniestro por id
    public Siniestro obtenerSiniestroPorId(Integer idSin) {
        return siniestroRepository.findById(idSin).orElse(null);
    }

    // Crear siniestro
    public Siniestro crearSiniestro(Siniestro siniestro) {
        return siniestroRepository.save(siniestro);
    }

    // Actualizar siniestro
    public Siniestro actualizarSiniestro(Integer idSin, Siniestro siniestro) {
        Siniestro siniestroExistente = siniestroRepository.findById(idSin).orElse(null);
        if (siniestroExistente != null) {
            siniestroExistente.setFechaHoraSin(siniestro.getFechaHoraSin());
            siniestroExistente.setDeducibleApliSin(siniestro.getDeducibleApliSin());
            siniestroExistente.setIndemnizacionSin(siniestro.getIndemnizacionSin());
            siniestroExistente.setNumeroSin(siniestro.getNumeroSin());
            siniestroExistente.setCostoSin(siniestro.getCostoSin());
            siniestroExistente.setPoliza(siniestro.getPoliza());
            siniestroExistente.setEstadoSiniestro(siniestro.getEstadoSiniestro());
            siniestroExistente.setTipoSiniestro(siniestro.getTipoSiniestro());
            siniestroExistente.setCierre(siniestro.getCierre());
            siniestroExistente.setFormularioIncidente(siniestro.getFormularioIncidente());
            return siniestroRepository.save(siniestroExistente);
        }
        return null;
    }

    // Eliminar siniestro
    public void eliminarSiniestro(Integer idSin) {
        siniestroRepository.deleteById(idSin);
    }

    // Metodo para ver cuanto siniestros ocurrieron el mes
    public Long countByMonthAndYear(Integer month, Integer year) {
        return siniestroRepository.countByMonthAndYear(month, year);
    }

    // Metodo para ver cuanto siniestros ocurrieron el año
    public Long countByYear(Integer year) {
        return siniestroRepository.countByYear(year);
    }

    // Metodo para ver la cantidad de polizas activadas de un siniestro
    public Long countByPolizaId(Integer polizaId) {
        return siniestroRepository.countByPolizaId(polizaId);
    }

    // Metodo para ver la cantidad de siniestros relacionado a un incidente
    public Long countByIncidenteId(Integer incidenteId) {
        return siniestroRepository.countByIncidenteId(incidenteId);
    }

}
