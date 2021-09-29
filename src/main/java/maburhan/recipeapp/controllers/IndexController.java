package maburhan.recipeapp.controllers;

import maburhan.recipeapp.model.Category;
import maburhan.recipeapp.model.UnitOfMeasurement;
import maburhan.recipeapp.repositories.CategoryRepository;
import maburhan.recipeapp.repositories.UnitOfMeasurementRepository;
import maburhan.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@Controller
public class IndexController {


    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/index"})
    public String getIndexPage(){


        return "index";
    }
}
