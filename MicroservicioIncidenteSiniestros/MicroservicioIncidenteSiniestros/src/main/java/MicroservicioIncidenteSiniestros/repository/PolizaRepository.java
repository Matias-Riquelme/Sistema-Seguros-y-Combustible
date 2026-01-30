package MicroservicioIncidenteSiniestros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import MicroservicioIncidenteSiniestros.model.Poliza;
import java.util.Optional;

@Repository
public interface PolizaRepository extends JpaRepository<Poliza, Integer> {

    @Query("SELECT s.poliza FROM Siniestro s WHERE s.idSin = :idSin")
    Optional<Poliza> findBySiniestroIdSin(@Param("idSin") Integer idSin);
}
