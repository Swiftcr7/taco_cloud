package sia.taco_cloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;
import sia.taco_cloud.Ingredient;
import sia.taco_cloud.repository.IngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    @Autowired
    private IngredientRepository ingredientRepository;


    @Override
    public Ingredient convert(String id) {

        return ingredientRepository.findById(id).orElse(null);
    }

}
