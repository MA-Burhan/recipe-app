package maburhan.recipeapp.controllers;

import maburhan.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/show/{id}")
    public String viewRecipeById(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));

        return "recipe/show";
    }
}
