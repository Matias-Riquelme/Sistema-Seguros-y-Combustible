package gestion_vehiculos_combustible.Repository;

import java.util.List;

import org.springframework.lang.NonNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion_vehiculos_combustible.Model.Maquina;

@Repository
public interface MaquinaRepository extends JpaRepository<Maquina, Long> {

    // Listar todas las maquinas
    @Override
    @NonNull
    List<Maquina> findAll();

}
