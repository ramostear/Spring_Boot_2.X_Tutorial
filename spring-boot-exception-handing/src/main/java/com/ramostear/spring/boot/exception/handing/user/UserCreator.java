package com.ramostear.spring.boot.exception.handing.user;/**
 * @author and @date : Created by Tan Chaohong on 2019/5/19 0019.
 */

/**
 * @author ramostear
 * @create-time 2019/5/19 0019-14:09
 * @modify by :
 * @since:
 */
public abstract class UserCreator {

    public static User create(){
        return User.builder()
                .username("ramostear")
                .age(28)
                .height(170)
                .build();
    }

}
