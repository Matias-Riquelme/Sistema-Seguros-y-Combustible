package MicroservicioIncidenteSiniestros.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import MicroservicioIncidenteSiniestros.model.Poliza;
import MicroservicioIncidenteSiniestros.repository.PolizaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PolizaServices {

    @Autowired
    private PolizaRepository polizaRepository;

    // Listar polizas
    public List<Poliza> listarPolizas() {
        return polizaRepository.findAll();
    }

    // Obtener poliza por id
    public Poliza obtenerPolizaPorId(Integer idPol) {
        return polizaRepository.findById(idPol).orElse(null);
    }

    // Crear poliza
    public Poliza crearPoliza(Poliza poliza) {
        return polizaRepository.save(poliza);
    }

    // Actualizar poliza
    public Poliza actualizarPoliza(Integer idPol, Poliza poliza) {
        Poliza polizaExistente = polizaRepository.findById(idPol).orElse(null);
        if (polizaExistente != null) {
            polizaExistente.setNombrePol(poliza.getNombrePol());
            polizaExistente.setNumeroPol(poliza.getNumeroPol());
            polizaExistente.setFechaEmiPol(poliza.getFechaEmiPol());
            polizaExistente.setFechaIniPol(poliza.getFechaIniPol());
            polizaExistente.setFechaFinPol(poliza.getFechaFinPol());
            polizaExistente.setFechaVencPol(poliza.getFechaVencPol());
            polizaExistente.setPrimaPol(poliza.getPrimaPol());
            polizaExistente.setAseguradosAdi(poliza.getAseguradosAdi());
            polizaExistente.setTipoPoliza(poliza.getTipoPoliza());
            polizaExistente.setAsegurado(poliza.getAsegurado());
            polizaExistente.setContratante(poliza.getContratante());
            return polizaRepository.save(polizaExistente);
        }
        return null;
    }

    // Eliminar poliza
    public void eliminarPoliza(Integer idPol) {
        polizaRepository.deleteById(idPol);
    }

    // Obtener poliza asociada a un siniestro
    public Poliza obtenerPolizaAsociadaASiniestro(Integer idSin) {
        return polizaRepository.findBySiniestroIdSin(idSin).orElse(null);
    }

    // Contar siniestros por poliza
    public Long contarSiniestrosPorPoliza(Integer polizaId) {
        return polizaRepository.countByPolizaId(polizaId);
    }
}
