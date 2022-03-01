package com.yrw.mvc.service;

import com.yrw.mvc.bean.User;
import com.yrw.mvc.dao.UserConnettion;

public class UserService {

    static public boolean UserSearchByUsername(User user){
            if (UserConnettion.searchUser(user)) return true;
            else return false;
    }

    static public void addUser(User user){
        UserConnettion.addUser(user);
    }
}
