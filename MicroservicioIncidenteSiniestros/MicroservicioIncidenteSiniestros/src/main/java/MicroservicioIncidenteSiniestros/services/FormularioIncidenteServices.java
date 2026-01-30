package MicroservicioIncidenteSiniestros.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import MicroservicioIncidenteSiniestros.model.FormularioIncidente;
import MicroservicioIncidenteSiniestros.repository.FormularioIncidenteRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class FormularioIncidenteServices {

    @Autowired
    private FormularioIncidenteRepository formularioIncidenteRepository;

    public List<FormularioIncidente> listarFormularios() {
        return formularioIncidenteRepository.findAll();
    }

    public FormularioIncidente obtenerFormularioPorId(Integer id) {
        return formularioIncidenteRepository.findById(id).orElse(null);
    }

    public FormularioIncidente crearFormulario(FormularioIncidente formulario) {
        return formularioIncidenteRepository.save(formulario);
    }

    public FormularioIncidente actualizarFormulario(Integer id, FormularioIncidente formulario) {
        FormularioIncidente existente = formularioIncidenteRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setUbicacion(formulario.getUbicacion());
            existente.setIdUsuario(formulario.getIdUsuario());
            existente.setTipoIncidente(formulario.getTipoIncidente());
            existente.setFechaIngresoForm(formulario.getFechaIngresoForm());
            existente.setFechaHoraIncidente(formulario.getFechaHoraIncidente());
            existente.setRelatoForm(formulario.getRelatoForm());
            existente.setPatente1(formulario.getPatente1());
            existente.setPatente2(formulario.getPatente2());
            existente.setNombreConductor(formulario.getNombreConductor());
            existente.setRutConductor(formulario.getRutConductor());
            existente.setBase(formulario.getBase());
            existente.setOperacion(formulario.getOperacion());
            existente.setLugarCarga(formulario.getLugarCarga());
            existente.setFechaIniTransporteCarga(formulario.getFechaIniTransporteCarga());
            existente.setDestinoCarga(formulario.getDestinoCarga());
            return formularioIncidenteRepository.save(existente);
        }
        return null;
    }

    public void eliminarFormulario(Integer id) {
        formularioIncidenteRepository.deleteById(id);
    }

    // Metodo para contar todos los registros asociados a un siniestro
    public List<FormularioIncidente> findBySiniestroId(Integer siniestroId) {
        return formularioIncidenteRepository.findBySiniestroId(siniestroId);
    }

    // Metodo para contar todos los registros asociados a un siniestro
    public Long countBySiniestroId(Integer siniestroId) {
        return formularioIncidenteRepository.countBySiniestroId(siniestroId);
    }

}
