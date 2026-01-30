package gestion_vehiculos_combustible.mapper;

import gestion_vehiculos_combustible.dto.BaseDTO;
import gestion_vehiculos_combustible.model.Base;
import org.springframework.stereotype.Component;

@Component
public class BaseMapper {

    public BaseDTO toDTO(Base base) {
        if (base == null)
            return null;
        BaseDTO dto = new BaseDTO();
        dto.setId(base.getId());
        dto.setNombre(base.getNombre());
        return dto;
    }

    public Base toEntity(BaseDTO dto) {
        if (dto == null)
            return null;
        Base entity = new Base();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        return entity;
    }
}
