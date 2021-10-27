package maburhan.recipeapp.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class UnitOfMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
