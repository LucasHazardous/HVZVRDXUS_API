package lucas.hazardous.hvzvrdxus_api.controller;

import lucas.hazardous.hvzvrdxus_api.model.Order;
import lucas.hazardous.hvzvrdxus_api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/orders")
@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @PostMapping("")
    public int addProduct(@RequestBody Order order) {
        return orderRepository.addOrder(order);
    }
}
