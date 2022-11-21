package lucas.hazardous.hvzvrdxus_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    private int user_id;
    private List<Integer> product_ids;
    private String address;
}
