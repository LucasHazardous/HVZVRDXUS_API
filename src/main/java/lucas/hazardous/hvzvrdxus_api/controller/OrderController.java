package lucas.hazardous.hvzvrdxus_api.controller;

import lucas.hazardous.hvzvrdxus_api.model.CartOrder;
import lucas.hazardous.hvzvrdxus_api.model.Order;
import lucas.hazardous.hvzvrdxus_api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/orders")
@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @PostMapping("")
    public int addOrder(@RequestBody CartOrder cartOrder) {
        return orderRepository.addOrder(cartOrder);
    }

    @GetMapping("")
    public List<Order> getOrders() {
        return orderRepository.getAllOrders();
    }
}
