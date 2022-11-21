package lucas.hazardous.hvzvrdxus_api.repository;

import lucas.hazardous.hvzvrdxus_api.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int addOrder(Order order) {
        int res = 0;
        for (int product_id : order.getProduct_ids()) {
            int status = jdbcTemplate.update("INSERT INTO orders(user_id, product_id, address) VALUES (?, ?, ?)", order.getUser_id(), product_id, order.getAddress());
            res += Math.max(status, 0);
        }
        return res;
    }
}
