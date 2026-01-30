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
        dto.setId_vehiculo(vehiculo.getId_vehiculo());
        dto.setPatente(vehiculo.getPatente());
        dto.setMarca(vehiculo.getMarca());
        dto.setModelo(vehiculo.getModelo());
        dto.setTipo(vehiculo.getTipo());
        dto.setRampla(vehiculo.getRampla());
        dto.setAnio(vehiculo.getAnio());
        dto.setAnioRegistro(vehiculo.getAnioRegistro());
        dto.setNum_motor_veh(vehiculo.getNum_motor_veh());
        dto.setNum_chasis_veh(vehiculo.getNum_chasis_veh());
        return dto;
    }

    public Vehiculo toEntity(VehiculoDTO dto) {
        if (dto == null)
            return null;

        Vehiculo entity = new Vehiculo();
        entity.setId_vehiculo(dto.getId_vehiculo());
        entity.setPatente(dto.getPatente());
        entity.setMarca(dto.getMarca());
        entity.setModelo(dto.getModelo());
        entity.setTipo(dto.getTipo());
        entity.setRampla(dto.getRampla());
        entity.setAnio(dto.getAnio());
        entity.setAnioRegistro(dto.getAnioRegistro());
        entity.setNum_motor_veh(dto.getNum_motor_veh());
        entity.setNum_chasis_veh(dto.getNum_chasis_veh());
        return entity;
    }
}
