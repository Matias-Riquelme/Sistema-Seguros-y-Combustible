package gestion_vehiculos_combustible.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import gestion_vehiculos_combustible.Model.Combustible;

@Repository
public interface CombustibleRepository extends JpaRepository<Combustible, Long> {

    // Listar todas las bases
    @Override
    @NonNull
    List<Combustible> findAll();

}
