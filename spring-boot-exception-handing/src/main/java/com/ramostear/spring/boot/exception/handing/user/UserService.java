package com.ramostear.spring.boot.exception.handing.user;/**
 * @author and @date : Created by Tan Chaohong on 2019/5/19 0019.
 */

import com.ramostear.spring.boot.exception.handing.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ramostear
 * @create-time 2019/5/19 0019-14:12
 * @modify by :
 * @since:
 */
@Service("userService")
public class UserService {

    private UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUser(Long userId) throws UserNotFoundException{
        Optional<User> optional = userRepository.findById(userId);
        if(!optional.isPresent()){
            throw new UserNotFoundException(User.class,"id",userId.toString());
        }
        return optional.get();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getUsers(String userIds) throws UserNotFoundException{
        List<User> users = new ArrayList<>();
        List<Long> ids = UserCollection.getIds(userIds);
        if(ids.isEmpty()){
            throw new UserNotFoundException(User.class,"id","");
        }
        for (Long userId:ids){
            Optional<User> optional = userRepository.findById(userId);
            if(!optional.isPresent()){
                throw new UserNotFoundException(User.class,"id",userId.toString());
            }
            users.add(optional.get());
        }
        return users;
    }

}
