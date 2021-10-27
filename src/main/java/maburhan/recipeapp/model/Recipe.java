package maburhan.recipeapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    @Lob
    private Byte[] image;

    @JoinColumn(name = "notes_id")
    @OneToOne(cascade = {CascadeType.ALL})
    private Notes notes;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @JoinTable(name = "category_recipes",
            joinColumns = @JoinColumn(name = "recipes_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @ManyToMany
    private Set<Category> categories = new HashSet<>();


    public boolean addIngredient(Ingredient ingredient){
        return ingredients.add(ingredient);
    }

    public boolean addCategory(Category category){
        return categories.add(category);
    }

}


