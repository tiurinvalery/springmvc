package com.valery.Site.Service;

import com.valery.Site.Entities.User;
import com.valery.Site.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;



    @Override
    public void save(User user) {
        user.setPassword(user.getPassword());}
    @Override
    public User findByUsername(String username) {
        return userService.findByUsername(username);
    }
}
