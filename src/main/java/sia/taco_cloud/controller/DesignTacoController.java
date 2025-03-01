package sia.taco_cloud.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import sia.taco_cloud.model.Ingredient;
import sia.taco_cloud.repository.IngredientRepository;
import sia.taco_cloud.model.Taco;
import sia.taco_cloud.model.TacoOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@SessionAttributes("tacoOrder")
@RequestMapping("/design")
public class DesignTacoController {
    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping
    public String tacoGet() {
        return "design";
    }

    @PostMapping
    public String tacoPost(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) {
        tacoOrder.addTaco(taco);
        if (errors.hasErrors()) {
            return "design";
        }
        log.info("Processing taco {}", taco);
        return "redirect:/orders/current";
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder tacoOrder() {
        return new TacoOrder();
    }

    @ModelAttribute
    public void addIngredient(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        log.info(String.valueOf(ingredients));
        Ingredient.Type[] types = Ingredient.Type.values();
        for (var type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }

    }

    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}