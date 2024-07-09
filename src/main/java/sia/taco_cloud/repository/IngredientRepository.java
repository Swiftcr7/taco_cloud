package sia.taco_cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.taco_cloud.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
