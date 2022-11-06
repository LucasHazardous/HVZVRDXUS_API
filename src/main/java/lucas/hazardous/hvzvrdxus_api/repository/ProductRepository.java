package lucas.hazardous.hvzvrdxus_api.repository;

import lucas.hazardous.hvzvrdxus_api.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> getAllProducts() {
        return jdbcTemplate.query("SELECT * FROM product", BeanPropertyRowMapper.newInstance(Product.class));
    }

    public Product getProductById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM product WHERE id=?", BeanPropertyRowMapper.newInstance(Product.class), id);
    }

    public int deleteProductById(int id) {
        return jdbcTemplate.update("DELETE FROM product WHERE id = ?", id);
    }

    public int addProducts(LinkedList<Product> products) {
        var res = 0;
        for (Product product: products) {
            try {
                var success = jdbcTemplate.update("INSERT INTO product(name, price, description, category) VALUES (?, ?, ?, ?)", product.getName(), product.getPrice(), product.getDescription(), product.getCategory());
                if (success == 1) res++;
            } catch (Exception ignored) {

            }
        }
        return res;
    }

    public int updateProduct(int id, Product product) {
        return jdbcTemplate.update("UPDATE product SET name=?, price=?, description=?, category=? WHERE id = ?", product.getName(), product.getPrice(), product.getDescription(), product.getCategory(), id);
    }
}