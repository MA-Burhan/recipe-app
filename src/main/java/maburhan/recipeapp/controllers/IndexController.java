package maburhan.recipeapp.controllers;

import maburhan.recipeapp.model.Category;
import maburhan.recipeapp.model.UnitOfMeasurement;
import maburhan.recipeapp.repositories.CategoryRepository;
import maburhan.recipeapp.repositories.UnitOfMeasurementRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasurementRepository unitOfMeasurementRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasurementRepository unitOfMeasurementRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasurementRepository = unitOfMeasurementRepository;
    }

    @RequestMapping({"", "/index"})
    public String getIndexPage(){

        Optional<Category> categoryOptional = categoryRepository.findByName("American");
        Optional<UnitOfMeasurement> unitOfMeasurementOptional = unitOfMeasurementRepository.findByName("Teaspoon");


        categoryOptional.ifPresent(c -> System.out.println(c.getName()));
        unitOfMeasurementOptional.ifPresent(u -> System.out.println(u.getName()));

        return "index";
    }
}
