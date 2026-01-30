package gestion_vehiculos_combustible.mapper;

import gestion_vehiculos_combustible.dto.OperacionesDTO;
import gestion_vehiculos_combustible.model.Operaciones;
import org.springframework.stereotype.Component;

@Component
public class OperacionesMapper {

    public OperacionesDTO toDTO(Operaciones operaciones) {
        if (operaciones == null)
            return null;
        OperacionesDTO dto = new OperacionesDTO();
        dto.setId(operaciones.getId());
        dto.setNombre(operaciones.getNombre());
        return dto;
    }

    public Operaciones toEntity(OperacionesDTO dto) {
        if (dto == null)
            return null;
        Operaciones entity = new Operaciones();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        return entity;
    }
}
