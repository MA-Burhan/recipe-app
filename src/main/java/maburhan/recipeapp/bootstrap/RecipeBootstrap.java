package maburhan.recipeapp.bootstrap;

import lombok.extern.slf4j.Slf4j;
import maburhan.recipeapp.model.*;
import maburhan.recipeapp.repositories.CategoryRepository;
import maburhan.recipeapp.repositories.RecipeRepository;
import maburhan.recipeapp.repositories.UnitOfMeasurementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Component
public class RecipeBootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasurementRepository unitOfMeasurementRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasurementRepository unitOfMeasurementRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasurementRepository = unitOfMeasurementRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        recipeRepository.saveAll(getRecipes());
        log.debug("Loading bootstrap data");
    }

    private List<Recipe> getRecipes(){

        List<Recipe> recipes = new ArrayList<>(2);

        /* get unit of measurements */
        UnitOfMeasurement eachUom = unitOfMeasurementRepository.findByName("Each").orElseThrow(() -> new NoSuchElementException("UOM 'Each' Not Found"));
        UnitOfMeasurement tablespoonUom = unitOfMeasurementRepository.findByName("Tablespoon").orElseThrow(() -> new NoSuchElementException("UOM 'Tablespoon' Not Found"));
        UnitOfMeasurement teaspoonUom = unitOfMeasurementRepository.findByName("Teaspoon").orElseThrow(() -> new NoSuchElementException("UOM 'Teaspoon' Not Found"));
        UnitOfMeasurement dashUom = unitOfMeasurementRepository.findByName("Dash").orElseThrow(() -> new NoSuchElementException("UOM 'Dash' Not Found"));
        UnitOfMeasurement pintUom = unitOfMeasurementRepository.findByName("Pint").orElseThrow(() -> new NoSuchElementException("UOM 'Pint' Not Found"));
        UnitOfMeasurement cupUom = unitOfMeasurementRepository.findByName("Cup").orElseThrow(() -> new NoSuchElementException("UOM 'Cup' Not Found"));

        /* get categories */
        Category americanCategory = categoryRepository.findByName("American").orElseThrow(() -> new NoSuchElementException("Category 'American' Not Found"));
        Category mexicanCategory = categoryRepository.findByName("Mexican").orElseThrow(() -> new NoSuchElementException("Category 'Mexican' Not Found"));


        /* Create recipes */

        /* Gucamole recipe*/

        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.setName("Perfect Guacamole");
        guacamoleRecipe.setPrepTime(10);
        guacamoleRecipe.setCookTime(45);
        guacamoleRecipe.setDifficulty(Difficulty.EASY);

        guacamoleRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");

        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.");
        guacamoleRecipe.setNotes(guacamoleNotes);

        //redundant in this case
        guacamoleNotes.setRecipe(guacamoleRecipe);


        /* add ingredients */

        addIngredient(guacamoleRecipe, "ripe avocados", 2, eachUom );
        addIngredient(guacamoleRecipe, "kosher salt", 5, teaspoonUom );
        addIngredient(guacamoleRecipe, "fresh lime juice or lemon juice", 2, tablespoonUom );
        addIngredient(guacamoleRecipe, "minced red onion or thinly sliced green onion", 2, tablespoonUom );
        addIngredient(guacamoleRecipe, "serrano chiles, stems and seeds removed, minced", 2, eachUom );
        addIngredient(guacamoleRecipe, "Cilantro", 2, tablespoonUom );
        addIngredient(guacamoleRecipe, "freshly grated black pepper", 2, dashUom );
        addIngredient(guacamoleRecipe, "ripe tomato, seeds and pulp removed, chopped", 0.5, eachUom );

        /* Add categories*/

        guacamoleRecipe.addCategory(mexicanCategory);
        guacamoleRecipe.addCategory(americanCategory);

        guacamoleRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamoleRecipe.setServings(4);
        guacamoleRecipe.setSource("Simply Recipes");

        recipes.add(guacamoleRecipe);

        return recipes;
    }

    private void addIngredient(Recipe recipe, String ingredientName, double amount, UnitOfMeasurement unitOfMeasurement){
        BigDecimal bigDecimalAmount = new BigDecimal(amount);
        Ingredient ingredient = new Ingredient(ingredientName, bigDecimalAmount, unitOfMeasurement);
        ingredient.setRecipe(recipe);
        recipe.addIngredient(ingredient);
    }


}
