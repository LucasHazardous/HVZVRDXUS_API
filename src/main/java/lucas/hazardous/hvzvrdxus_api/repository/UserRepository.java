package lucas.hazardous.hvzvrdxus_api.repository;

import lucas.hazardous.hvzvrdxus_api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM users", BeanPropertyRowMapper.newInstance(User.class));
    }

    public User getUserById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", BeanPropertyRowMapper.newInstance(User.class), id);
    }

    public int addUser(User user) {
        return jdbcTemplate.update("INSERT INTO users(name, surname, email, role, password) VALUES (?, ?, ?, ? ,?)", user.getName(), user.getSurname(), user.getEmail(), user.getRole(), user.getPassword());
    }

    public int deleteUserById(int id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    public int updateUser(int id, User user) {
        return jdbcTemplate.update("UPDATE users SET name=?, surname=?, email=?, role=?, password=? WHERE id = ?", user.getName(), user.getSurname(), user.getEmail(), user.getRole(), user.getPassword(), id);
    }
}
