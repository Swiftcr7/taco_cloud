package sia.taco_cloud;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.List;

@Data
public class TacoOrder {
    @NotBlank(message = "Name is not specified")
    private String deliveryName;
    @NotBlank(message = "Delivery street is not specified")
    private String deliveryStreet;
    @NotBlank(message = "Delivery city is not specified")
    private String deliveryCity;
    @NotBlank(message = "Delivery state is not specified")
    private String deliveryState;
    @NotBlank(message = "Delivery zip is not specified")
    private String deliveryZip;
    @Digits(integer=16, fraction=0, message="Not a valid credit card number")
    private String ccNumber;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco){
        tacos.add(taco);
    }

}
