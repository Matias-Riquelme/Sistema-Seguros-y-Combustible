package MicroservicioIncidenteSiniestros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MicroservicioIncidenteSiniestros.model.FormularioIncidente;
import MicroservicioIncidenteSiniestros.services.FormularioIncidenteServices;

@RestController
@RequestMapping("/api/formulario-incidente")
@CrossOrigin(origins = "*")
public class FormularioIncidenteController {

    @Autowired
    private FormularioIncidenteServices formularioIncidenteServices;

    @GetMapping("/listar")
    public List<FormularioIncidente> listar() {
        return formularioIncidenteServices.listarFormularios();
    }

    @GetMapping("/obtener/{id}")
    public FormularioIncidente obtener(@PathVariable Integer id) {
        return formularioIncidenteServices.obtenerFormularioPorId(id);
    }

    @PostMapping("/crear")
    public FormularioIncidente crear(@RequestBody FormularioIncidente formulario) {
        return formularioIncidenteServices.crearFormulario(formulario);
    }

    @PutMapping("/actualizar/{id}")
    public FormularioIncidente actualizar(@PathVariable Integer id, @RequestBody FormularioIncidente formulario) {
        return formularioIncidenteServices.actualizarFormulario(id, formulario);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        formularioIncidenteServices.eliminarFormulario(id);
    }

    // obtener los formularios por siniestro
    @GetMapping("/por-siniestro/{siniestroId}")
    public List<FormularioIncidente> listarPorSiniestro(@PathVariable Integer siniestroId) {
        return formularioIncidenteServices.findBySiniestroId(siniestroId);
    }

    // contar cuantos incidentes fueron asociados a un siniestro
    @GetMapping("/contar-por-siniestro/{siniestroId}")
    public Long contarPorSiniestro(@PathVariable Integer siniestroId) {
        return formularioIncidenteServices.countBySiniestroId(siniestroId);
    }
}
