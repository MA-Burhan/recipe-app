package maburhan.recipeapp.services;

import lombok.extern.slf4j.Slf4j;
import maburhan.recipeapp.model.Recipe;
import maburhan.recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("In the recipe service..");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().forEach(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(long id) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        return recipeOptional.orElseThrow(() -> new RuntimeException("Recipe Not Found"));
    }
}
