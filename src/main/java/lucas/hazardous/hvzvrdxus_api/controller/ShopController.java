package lucas.hazardous.hvzvrdxus_api.controller;

import lucas.hazardous.hvzvrdxus_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String productList(Model model) {
        model.addAttribute("products", productRepository.getAllProducts());
        return "shop";
    }
}
