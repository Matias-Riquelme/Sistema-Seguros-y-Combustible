package gestion_vehiculos_combustible.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import gestion_vehiculos_combustible.Model.Conductor;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Long> {

    Optional<Conductor> findByRut(@NonNull String rut);

    // Listar todas las bases
    @Override
    @NonNull
    List<Conductor> findAll();

}
