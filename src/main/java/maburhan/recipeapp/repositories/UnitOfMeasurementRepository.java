package maburhan.recipeapp.repositories;

import maburhan.recipeapp.model.UnitOfMeasurement;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UnitOfMeasurementRepository extends CrudRepository<UnitOfMeasurement, Long> {

    Optional<UnitOfMeasurement> findByName(String name);
}
