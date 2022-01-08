package maburhan.recipeapp.services;

import maburhan.recipeapp.model.Recipe;
import maburhan.recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

class RecipeServiceImplTest {

    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void findById(){
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepository, times(1)).findById(anyLong());
    }
    @Test
    void getRecipes() {
        Recipe recipe = new Recipe();
        Set<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);
    }
}