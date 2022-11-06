package lucas.hazardous.hvzvrdxus_api.controller;

import lucas.hazardous.hvzvrdxus_api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lucas.hazardous.hvzvrdxus_api.repository.UserRepository;

import java.util.LinkedList;
import java.util.List;

@RequestMapping("/api/users")
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public List<User> getUsers() {
        return userRepository.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userRepository.getUserById(id);
    }

    @PostMapping("")
    public int addUsers(@RequestBody LinkedList<User> users) {
        return userRepository.addUsers(users);
    }

    @DeleteMapping("/{id}")
    public int deleteUserById(@PathVariable("id") int id) {
        return userRepository.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public int updateAllDataUser(@PathVariable("id") int id, @RequestBody User user) {
        User userCheck = userRepository.getUserById(id);

        if(userCheck != null) {
            user.setId(id);
            userRepository.updateUser(id, user);
            return 1;
        }
        return -1;
    }

    @PatchMapping("/{id}")
    public int updateUser(@PathVariable("id") int id, @RequestBody User user) {
        User userCheck = userRepository.getUserById(id);

        if(userCheck != null) {
            if(user.getName() == null) user.setName(userCheck.getName());
            if(user.getSurname() == null) user.setSurname(userCheck.getSurname());
            if(user.getEmail() == null) user.setEmail(userCheck.getEmail());
            if(user.getPassword() == null) user.setPassword(userCheck.getPassword());
            if(user.getRole() == 0) user.setRole(userCheck.getRole());

            userRepository.updateUser(id, user);
            return 1;
        }
        return -1;
    }
}
