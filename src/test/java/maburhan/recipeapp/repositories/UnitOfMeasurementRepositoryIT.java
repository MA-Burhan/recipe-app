package maburhan.recipeapp.repositories;

import maburhan.recipeapp.model.UnitOfMeasurement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UnitOfMeasurementRepositoryIT {

    UnitOfMeasurementRepository unitOfMeasurementRepository;

    @Autowired
    public UnitOfMeasurementRepositoryIT(UnitOfMeasurementRepository unitOfMeasurementRepository) {
        this.unitOfMeasurementRepository = unitOfMeasurementRepository;
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByName() {

        Optional<UnitOfMeasurement> unitOfMeasurementOptional = unitOfMeasurementRepository.findByName("Teaspoon");

        assertEquals("Teaspoon", unitOfMeasurementOptional.get().getName());
    }
}