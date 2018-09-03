package com.example.rentcar.service.impl;

import com.example.rentcar.dao.UserDao;
import com.example.rentcar.model.User;
import com.example.rentcar.service.UserService;
import com.example.rentcar.utils.AppMD5Util;
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
        String md5=AppMD5Util.MD5(user.getUserpwd());
        return userDao.findByUsernameAndUserpwd(user.getUsername(),md5);
    }

    @Override
    public boolean register(User user) {
        if (exits(user.getUsername())==true)
            return false;
        else{
            user.setUserpwd(AppMD5Util.MD5(user.getUserpwd()));
            if (userDao.save(user)==null){
                return false;
            }else{
                return true;
            }

        }
    }
}
