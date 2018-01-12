package com.valery.Site.Service;

import com.valery.Site.Entities.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
