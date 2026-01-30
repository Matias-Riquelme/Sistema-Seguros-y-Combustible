package MicroservicioIncidenteSiniestros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MicroservicioIncidenteSiniestros.model.UbicacionIncidente;
import MicroservicioIncidenteSiniestros.services.UbicacionIncidenteServices;

@RestController
@RequestMapping("/api/ubicacion-incidente")
@CrossOrigin(origins = "*")
public class UbicacionIncidenteController {

    @Autowired
    private UbicacionIncidenteServices ubicacionIncidenteServices;

    @GetMapping("/listar")
    public List<UbicacionIncidente> listar() {
        return ubicacionIncidenteServices.listarUbicaciones();
    }

    @GetMapping("/obtener/{id}")
    public UbicacionIncidente obtener(@PathVariable Integer id) {
        return ubicacionIncidenteServices.obtenerUbicacionPorId(id);
    }

    @PostMapping("/crear")
    public UbicacionIncidente crear(@RequestBody UbicacionIncidente ubicacion) {
        return ubicacionIncidenteServices.crearUbicacion(ubicacion);
    }

    @PutMapping("/actualizar/{id}")
    public UbicacionIncidente actualizar(@PathVariable Integer id, @RequestBody UbicacionIncidente ubicacion) {
        return ubicacionIncidenteServices.actualizarUbicacion(id, ubicacion);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        ubicacionIncidenteServices.eliminarUbicacion(id);
    }
}
