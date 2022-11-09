package StartAtGoogle.week4.springBoot.controller;


import StartAtGoogle.week4.springBoot.Entity.User;
import StartAtGoogle.week4.springBoot.Utils;
import StartAtGoogle.week4.springBoot.service.AuthenticationService;
import StartAtGoogle.week4.springBoot.service.UserService;

import java.io.IOException;
import java.security.InvalidParameterException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    AuthenticationService authService;
    @Autowired
    UserService userService;

    public UserController() {
        this.authService = AuthenticationService.getInstance();
        this.userService = UserService.getInstance();
    }

    public boolean updateEmail(String mail, String token) throws IOException {
        try{
            Utils.checkEmail(mail);
        }catch (InvalidParameterException ip){
            throw new InvalidParameterException("Email not in correct format");
        }
        User user = authService.validate(token);
        boolean status = userService.updateEmail(user, mail);
        if (status) {
            authService.reloadUser(mail, token);
        }
        return status;
    }

    public boolean updateName(String name, String token) throws IOException {
        try{
            Utils.checkName(name);
        }catch (InvalidParameterException ip){
            throw new InvalidParameterException("Name not in correct format");
        }
        User user = authService.validate(token);
        boolean status = userService.updateName(user, name);
        if (status) {
            authService.reloadUser(user.getEmail(), token);
        }
        return status;
    }
    public boolean updatePassword(String password, String token) throws IOException {
        try{
            Utils.checkPassword(password);
        }catch (InvalidParameterException ip){
            throw new InvalidParameterException("Email not in correct format");
        }
        User user = authService.validate(token);
        boolean status = userService.updatePassword(user, password);
        if (status) {
            authService.reloadUser(user.getEmail(), token);
        }
        return status;
    }

    public boolean deleteUser(String token){
        User user = authService.validate(token);
        boolean status = userService.deleteUser(user);
        if (status) {
            authService.removeToken(token);
        }
        return status;
    }

}

// @RequestMapping(value = "xxx",method = RequestMethod.POST)
// Public ResponseEntity<User> createUser(@RequestBody User user){