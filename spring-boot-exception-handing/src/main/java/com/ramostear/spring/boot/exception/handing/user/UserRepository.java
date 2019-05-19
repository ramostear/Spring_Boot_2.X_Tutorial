package com.ramostear.spring.boot.exception.handing.user;

import org.springframework.data.repository.CrudRepository;

/**
 * @author and @date : Created by Tan Chaohong on 2019/5/19 0019.
 */
public interface UserRepository extends CrudRepository<User,Long> {
}
