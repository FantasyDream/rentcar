package com.example.rentcar.service.impl;

import com.example.rentcar.dao.UserDao;
import com.example.rentcar.model.User;
import com.example.rentcar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public boolean exits(String username) {
        if(userDao.findByUsername(username)==null)
            return false;
        else
            return true;
    }

    @Override
    public User loginCheck(User user) {
            return userDao.findByUsernameAndUserpwd(user.getUsername(),user.getUserpwd());
    }

    @Override
    public boolean register(User user) {
        if (exits(user.getUsername())==true)
            return false;
        else{
            if (userDao.save(user)==null){
                return false;
            }else{
                return true;
            }

        }
    }
}
