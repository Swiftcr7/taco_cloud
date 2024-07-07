package sia.taco_cloud;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;


import java.util.ArrayList;

@Data
public class Taco {
    @Size(min = 5, message = "Uncorrect name, minimum number of characters 5")
    @NotNull
    private String name;

    @NotNull
    @Size(min = 1, message = "Uncorrect ingredients, minimum number of ingredient 1")
    private ArrayList<Ingredient> ingredients;
}
