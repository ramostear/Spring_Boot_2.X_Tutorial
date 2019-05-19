package com.ramostear.spring.boot.exception.handing.data;/**
 * @author and @date : Created by Tan Chaohong on 2019/5/19 0019.
 */

import com.ramostear.spring.boot.exception.handing.user.UserCreator;
import com.ramostear.spring.boot.exception.handing.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author ramostear
 * @create-time 2019/5/19 0019-14:59
 * @modify by :
 * @since:
 */
@Component
@AllArgsConstructor
public class SampleUserData {

    private UserRepository userRepository;

    void createSampleUserData(){
        userRepository.save(UserCreator.create());
    }

}
