package com.ramostear.spring.boot.exception.handing.user;/**
 * @author and @date : Created by Tan Chaohong on 2019/5/19 0019.
 */

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ramostear
 * @create-time 2019/5/19 0019-15:10
 * @modify by :
 * @since:
 */
public class UserCollection {

    public static List<Long> getIds(String userIdsStr){
        String[] idsArray = userIdsStr.split("-");
        List<Long> userIds = new ArrayList<>();
        for(String id:idsArray){
            userIds.add(Long.parseLong(id));
        }
        return userIds;
    }

}
