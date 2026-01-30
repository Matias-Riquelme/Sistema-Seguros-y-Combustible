package gestion_vehiculos_combustible.mapper;

import gestion_vehiculos_combustible.dto.CombustibleDTO;
import gestion_vehiculos_combustible.model.Combustible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CombustibleMapper {

    @Autowired
    private VehiculoMapper vehiculoMapper;

    public CombustibleDTO toDTO(Combustible combustible) {
        if (combustible == null)
            return null;
        CombustibleDTO dto = new CombustibleDTO();
        dto.setId(combustible.getId());
        dto.setVehiculo(vehiculoMapper.toDTO(combustible.getVehiculo()));
        dto.setPrecio(combustible.getPrecio());
        dto.setUsoPropio(combustible.isUsoPropio());
        dto.setSInicial(combustible.getSInicial());
        dto.setSFinal(combustible.getSFinal());
        dto.setKmVehiculoInicial(combustible.getKmVehiculoInicial());
        dto.setKmVehiculoFinal(combustible.getKmVehiculoFinal());
        dto.setKilometros(combustible.getKilometros());
        dto.setConsumos(combustible.getConsumos());
        dto.setRendimiento(combustible.getRendimiento());
        dto.setMes(combustible.getMes());
        dto.setMes2(combustible.getMes2());
        dto.setEstanque(combustible.getEstanque());
        return dto;
    }

    public Combustible toEntity(CombustibleDTO dto) {
        if (dto == null)
            return null;
        Combustible entity = new Combustible();
        entity.setId(dto.getId());
        entity.setVehiculo(vehiculoMapper.toEntity(dto.getVehiculo()));
        entity.setPrecio(dto.getPrecio());
        entity.setUsoPropio(dto.isUsoPropio());
        entity.setSInicial(dto.getSInicial());
        entity.setSFinal(dto.getSFinal());
        entity.setKmVehiculoInicial(dto.getKmVehiculoInicial());
        entity.setKmVehiculoFinal(dto.getKmVehiculoFinal());
        entity.setKilometros(dto.getKilometros());
        entity.setConsumos(dto.getConsumos());
        entity.setRendimiento(dto.getRendimiento());
        entity.setMes(dto.getMes());
        entity.setMes2(dto.getMes2());
        entity.setEstanque(dto.getEstanque());
        return entity;
    }
}
