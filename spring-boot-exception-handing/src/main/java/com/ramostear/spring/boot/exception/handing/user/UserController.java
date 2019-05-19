package com.ramostear.spring.boot.exception.handing.user;/**
 * @author and @date : Created by Tan Chaohong on 2019/5/19 0019.
 */

import com.ramostear.spring.boot.exception.handing.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ramostear
 * @create-time 2019/5/19 0019-15:03
 * @modify by :
 * @since:
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId) throws UserNotFoundException{
        return userService.getUser(userId);
    }

    @GetMapping
    public List<User> getUsers(@RequestParam(name = "userIds") String userIds) throws UserNotFoundException{
        return userService.getUsers(userIds);
    }

    @PostMapping
    public User createUser(@RequestBody @Valid User user){
        return userService.createUser(user);
    }


}
