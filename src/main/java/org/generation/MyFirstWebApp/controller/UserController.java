package org.generation.MyFirstWebApp.controller;

import org.generation.MyFirstWebApp.model.User;
import org.generation.MyFirstWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    final UserService userService;

    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
        userService.add( new User( 1, "Santiago", "Carrillo" ) );
        userService.add( new User( 2, "Vicente", "Maldonado" ) );
        userService.add( new User( 3, "Felix", "Perez" ) );
    }

    @GetMapping( "/user" )
    public User getUser()
    {
        return userService.getUser( 0 );
    }

    @GetMapping("/users/alls")
    public int totalUsers()
    {
        return userService.size();
    }

    @GetMapping( "/user/all_users" )
    public List<Users> getAll()
    {
        return userService.getUser( 0 );
    }

}
