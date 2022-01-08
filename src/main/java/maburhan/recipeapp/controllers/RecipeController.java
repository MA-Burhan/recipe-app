package maburhan.recipeapp.controllers;

import maburhan.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
}
