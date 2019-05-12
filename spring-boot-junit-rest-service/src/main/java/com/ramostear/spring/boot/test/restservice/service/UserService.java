package com.ramostear.spring.boot.test.restservice.service;

import com.ramostear.spring.boot.test.restservice.model.Role;
import com.ramostear.spring.boot.test.restservice.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class UserService {

    private static Map<String,User> userRepo = new HashMap<>();

    private static Map<String,Role> roleRepo = new HashMap<>();

    @PostConstruct
    public void init(){
        User user = new User();
        user.setId("1001");
        user.setName("ramostear");
        user.setAlias("谭朝红");
        userRepo.put(user.getId(),user);

        Role role = new Role();
        role.setId("1001");
        role.setName("admin");
        role.setDescription("all permissions for this role.");
        roleRepo.put(role.getId(),role);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);

    }

    /**
     * 检索所有的用户数据
     * @return  users
     */
    public List<User> findAllUsers(){
        Set<String> keys = userRepo.keySet();
        List<User> users = new ArrayList<>();
        keys.forEach(key->users.add(userRepo.get(key)));
        return users;
    }

    /**
     * 根据用户ID检索用户信息
     * @param userId    用户ID
     * @return          user
     */
    public User findUserById(String userId){
        return userRepo.get(userId);
    }

    /**
     * 获取某个用户的所有角色信息
     * @param userId        用户的ID
     * @return              角色集合
     */
    public List<Role> findUserAllRoles(String userId){
        return userRepo.get(userId).getRoles();
    }

    /**
     * 设置用户的角色
     * @param userId        用户ID
     * @param role          角色
     * @return              添加的角色
     */
    public Role addUserRole(String userId,Role role){
        User user = userRepo.get(userId);
        List<Role> userRoles = user.getRoles();
        userRoles.add(role);
        userRepo.put(user.getId(),user);
        return role;
    }
}
