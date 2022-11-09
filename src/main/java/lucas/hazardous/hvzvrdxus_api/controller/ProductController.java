package lucas.hazardous.hvzvrdxus_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lucas.hazardous.hvzvrdxus_api.model.Product;
import lucas.hazardous.hvzvrdxus_api.repository.ProductRepository;

import java.util.LinkedList;
import java.util.List;

@RequestMapping("/api/products")
@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("")
    public List<Product> getUsers() {
        return productRepository.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") int id) {
        return productRepository.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public int deleteProductById(@PathVariable("id") int id) {
        return productRepository.deleteProductById(id);
    }

    @PostMapping("")
    public int addProducts(@RequestBody LinkedList<Product> products) {
        return productRepository.addProducts(products);
    }

    @PutMapping("/{id}")
    public int updateAllDataProduct(@PathVariable("id") int id, @RequestBody Product product) {
        Product productCheck = productRepository.getProductById(id);

        if(productCheck != null) {
            product.setId(id);
            productRepository.updateProduct(id, product);
            return 1;
        }
        return -1;
    }

    @PatchMapping("/{id}")
    public int updateUser(@PathVariable("id") int id, @RequestBody Product product) {
        Product productCheck = productRepository.getProductById(id);

        if(productCheck != null) {
            if(product.getName() == null) product.setName(productCheck.getName());
            if(product.getPrice() == 0f) product.setPrice(productCheck.getPrice());
            if(product.getCategory() == 0) product.setCategory(productCheck.getCategory());
            if(product.getDescription() == null) product.setDescription(productCheck.getDescription());
            if(product.getImage() == null) product.setImage(productCheck.getImage());
            product.setId(id);

            productRepository.updateProduct(id, product);
            return 1;
        }
        return -1;
    }
}