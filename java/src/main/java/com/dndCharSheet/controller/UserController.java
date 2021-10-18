package com.dndCharSheet.controller;

import com.dndCharSheet.dao.UserDao;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {
    private UserDao userDao;

    public UserController(UserDao userDao){
        this.userDao = userDao;
    }

    @DeleteMapping("/user/delete/{id}")
    public void delete(@PathVariable int id){
        userDao.delete(id);
    }
}
