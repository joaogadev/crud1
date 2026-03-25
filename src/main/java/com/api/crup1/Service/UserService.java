package com.api.crup1.Service;

import com.api.crup1.Exception.ObjectNotFoundException;
import com.api.crup1.Model.UserModel;
import com.api.crup1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public UserModel save(UserModel user) {
        return repo.save(user);
    }
    public List<UserModel> findAllUsers() {
        return repo.findAll();
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }

    public UserModel update(UserModel user) {
        if (repo.existsById(user.getId())) {
            user = repo.save(user);
        } else {
            throw new ObjectNotFoundException("User not found with id: " + user.getId());
        }
        return user;
    }

    public UserModel findByID(Long id) {
        return repo.findById(id).get();
    }

    public UserModel findByEmail(String email) {
        return repo.findAll().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst().orElse(null);
    }
}
