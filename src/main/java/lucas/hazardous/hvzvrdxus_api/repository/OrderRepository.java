package lucas.hazardous.hvzvrdxus_api.repository;

import lucas.hazardous.hvzvrdxus_api.model.CartOrder;
import lucas.hazardous.hvzvrdxus_api.model.Order;
import lucas.hazardous.hvzvrdxus_api.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int addOrder(CartOrder cartOrder) {
        int res = 0;
        for (int product_id : cartOrder.getProduct_ids()) {
            int status = jdbcTemplate.update("INSERT INTO orders(user_id, product_id, address) VALUES (?, ?, ?)", cartOrder.getUser_id(), product_id, cartOrder.getAddress());
            res += Math.max(status, 0);
        }
        return res;
    }

    public List<Order> getAllOrders() {
        return jdbcTemplate.query("SELECT * FROM orders", BeanPropertyRowMapper.newInstance(Order.class));
    }

}
