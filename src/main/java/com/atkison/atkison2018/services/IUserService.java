package com.atkison.atkison2018.services;

import com.atkison.atkison2018.models.User;

public interface IUserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
