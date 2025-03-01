package sia.taco_cloud.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import sia.taco_cloud.model.User;
import sia.taco_cloud.repository.OrderRepository;
import sia.taco_cloud.model.TacoOrder;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderTacoController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/current")
    public String ordersGet() {
        return "orderForm";
    }

    @PostMapping
    public String ordersPost(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        tacoOrder.setUser(user);
        orderRepository.save(tacoOrder);
        for (var l : orderRepository.findAll()) {
            log.info(String.valueOf(l));
        }
        sessionStatus.setComplete();
        return "redirect:/";

    }

}
