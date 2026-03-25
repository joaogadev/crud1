package com.api.crup1.Controller;

import com.api.crup1.Model.UserModel;
import com.api.crup1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService us;

    @GetMapping
    public List<UserModel> listar() {
        return us.findAllUsers();
    }
    @PostMapping
    public UserModel adicionar(@RequestBody UserModel user) {
        return us.save(user);
    }
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        us.delete(id);
    }
    @GetMapping("/email")
    public UserModel procurarEmail(@RequestParam String email) {
        return us.findByEmail(email);
    }
    @GetMapping("/{id}")
    public UserModel procurarId(@PathVariable Long id) {
        return us.findByID(id);
    }
    @PutMapping("/{id}")
    public UserModel atualizar(@PathVariable Long id, @RequestBody UserModel user) {
        user.setId(id);
        return us.update(user);
    }

}
