package gestion_vehiculos_combustible.mapper;

import gestion_vehiculos_combustible.dto.TipoRegOdoDTO;
import gestion_vehiculos_combustible.model.TipoRegOdo;
import org.springframework.stereotype.Component;

@Component
public class TipoRegOdoMapper {

    public TipoRegOdoDTO toDTO(TipoRegOdo entity) {
        if (entity == null)
            return null;
        TipoRegOdoDTO dto = new TipoRegOdoDTO();
        dto.setId_tipo_reg_odo(entity.getId_tipo_reg_odo());
        dto.setTipo_reg_odo(entity.getTipo_reg_odo());
        return dto;
    }

    public TipoRegOdo toEntity(TipoRegOdoDTO dto) {
        if (dto == null)
            return null;
        TipoRegOdo entity = new TipoRegOdo();
        entity.setId_tipo_reg_odo(dto.getId_tipo_reg_odo());
        entity.setTipo_reg_odo(dto.getTipo_reg_odo());
        return entity;
    }
}
