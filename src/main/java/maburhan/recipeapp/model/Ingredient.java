package maburhan.recipeapp.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal amount;

    @ManyToOne
    private UnitOfMeasurement unitOfMeasurement;

    @JoinColumn
    @ManyToOne
    private Recipe recipe;

    public Ingredient() {
    }

    public Ingredient(String name, BigDecimal amount, UnitOfMeasurement unitOfMeasurement) {
        this.name = name;
        this.amount = amount;
        this.unitOfMeasurement = unitOfMeasurement;
    }

}
