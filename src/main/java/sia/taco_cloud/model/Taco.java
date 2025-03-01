package sia.taco_cloud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.util.Date;
import java.util.List;


@Data
@Entity
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 5, message = "Uncorrect name, minimum number of characters 5")
    @NotNull
    private String name;

    private Date createdAt = new Date();

    @NotNull
    @Size(min = 1, message = "Uncorrect ingredients, minimum number of ingredient 1")
    @ManyToMany()
    private List<Ingredient> ingredients;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
