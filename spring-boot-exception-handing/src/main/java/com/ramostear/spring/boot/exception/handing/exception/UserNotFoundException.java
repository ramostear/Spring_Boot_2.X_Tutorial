package com.ramostear.spring.boot.exception.handing.exception;/**
 * @author and @date : Created by Tan Chaohong on 2019/5/19 0019.
 */

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author ramostear
 * @create-time 2019/5/19 0019-14:44
 * @modify by :
 * @since:
 */
public class UserNotFoundException extends Exception {

    public UserNotFoundException(Class clz,String...searchParams){
        super(UserNotFoundException.generateMessage(clz.getSimpleName(),toMap(String.class,String.class,searchParams)));
    }

    private static String generateMessage(String entity, Map<String,String> searchParams){
        return StringUtils.capitalize(entity)+
                " was not found for parameters "+
                searchParams;
    }

    private static <K,V> Map<K,V> toMap(Class<K> key,Class<V> value,Object...entries){
        if(entries.length % 2 == 1){
            throw new IllegalArgumentException("Invalid entries");
        }
        return IntStream.range(0,entries.length/2).map(i->i*2)
                .collect(HashMap::new,
                        (m,i)->m.put(key.cast(entries[i]),value.cast(entries[i+1])),Map::putAll);
    }
}
