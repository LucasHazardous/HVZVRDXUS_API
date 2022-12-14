package lucas.hazardous.hvzvrdxus_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private byte role;


}
