package gestion_vehiculos_combustible.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import gestion_vehiculos_combustible.model.Combustible;

@Repository
public interface CombustibleRepository extends JpaRepository<Combustible, Long> {

    // Listar todas las bases
    @NonNull
    List<Combustible> findAll();

    Optional<Combustible> findFirstByVehiculoIdOrderByIdDesc(Long id);

    List<Combustible> findByVehiculoId(Long id);
}
