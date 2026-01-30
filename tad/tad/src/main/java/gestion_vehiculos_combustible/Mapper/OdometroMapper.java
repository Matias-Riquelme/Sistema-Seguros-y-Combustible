package gestion_vehiculos_combustible.mapper;

import gestion_vehiculos_combustible.dto.OdometroDTO;
import gestion_vehiculos_combustible.model.Odometro;
import org.springframework.stereotype.Component;

@Component
public class OdometroMapper {

    public OdometroDTO toDTO(Odometro entity) {
        if (entity == null)
            return null;
        OdometroDTO dto = new OdometroDTO();
        dto.setId_odo(entity.getId_odo());
        dto.setOdoActual(entity.getOdoActual());
        dto.setF_toma_odo(entity.getF_toma_odo());
        dto.setR_reg_odo(entity.getR_reg_odo());
        return dto;
    }

    public Odometro toEntity(OdometroDTO dto) {
        if (dto == null)
            return null;
        Odometro entity = new Odometro();
        entity.setId_odo(dto.getId_odo());
        entity.setOdoActual(dto.getOdoActual());
        entity.setF_toma_odo(dto.getF_toma_odo());
        entity.setR_reg_odo(dto.getR_reg_odo());
        return entity;
    }
}
