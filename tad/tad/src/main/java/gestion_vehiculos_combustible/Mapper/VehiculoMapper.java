package gestion_vehiculos_combustible.mapper;

import gestion_vehiculos_combustible.dto.VehiculoDTO;
import gestion_vehiculos_combustible.model.Vehiculo;
import org.springframework.stereotype.Component;

@Component
public class VehiculoMapper {

    public VehiculoDTO toDTO(Vehiculo vehiculo) {
        if (vehiculo == null)
            return null;

        VehiculoDTO dto = new VehiculoDTO();
        dto.setId(vehiculo.getId());
        dto.setPatente(vehiculo.getPatente());
        dto.setMarca(vehiculo.getMarca());
        dto.setModelo(vehiculo.getModelo());
        dto.setTipo(vehiculo.getTipo());
        dto.setRampla(vehiculo.getRampla());
        dto.setKMinicial(vehiculo.getKMinicial());
        dto.setKilometros(vehiculo.getKilometros());
        dto.setKMFinal(vehiculo.getKMFinal());
        dto.setAnio(vehiculo.getAnio());
        dto.setAnioRegistro(vehiculo.getAnioRegistro());
        dto.setConsumos(vehiculo.getConsumos());
        dto.setRendimiento(vehiculo.getRendimiento());
        return dto;
    }

    public Vehiculo toEntity(VehiculoDTO dto) {
        if (dto == null)
            return null;

        Vehiculo entity = new Vehiculo();
        entity.setId(dto.getId());
        entity.setPatente(dto.getPatente());
        entity.setMarca(dto.getMarca());
        entity.setModelo(dto.getModelo());
        entity.setTipo(dto.getTipo());
        entity.setRampla(dto.getRampla());
        entity.setKMinicial(dto.getKMinicial());
        entity.setKilometros(dto.getKilometros());
        entity.setKMFinal(dto.getKMFinal());
        entity.setAnio(dto.getAnio());
        entity.setAnioRegistro(dto.getAnioRegistro());
        entity.setConsumos(dto.getConsumos());
        entity.setRendimiento(dto.getRendimiento());
        return entity;
    }
}
