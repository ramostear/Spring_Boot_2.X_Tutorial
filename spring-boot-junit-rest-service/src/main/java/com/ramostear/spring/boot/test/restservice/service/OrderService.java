package com.ramostear.spring.boot.test.restservice.service;

import com.ramostear.spring.boot.test.restservice.entity.Order;
import com.ramostear.spring.boot.test.restservice.entity.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: ramostear
 * @email: ramostear@163.com
 * @create-time: 2019/4/24 0024-20:11
 * @desc: [一句话说明该文件的功能]
 * @since: V 0.0.1
 * @company： www.taolicloud.com
 */
@Component
public class OrderService {

    private static List<Order> orders = new ArrayList<>();

    @PostConstruct
    public void init(){
        Product pd1 = new Product ( UUID.randomUUID ().toString (),"《Java核心思想》",88.00f,"Java编程工具书");
        Product pd2 = new Product ( UUID.randomUUID ().toString (),"Mac book Pro",10000.00f,"很好用的笔记本电脑" );
        Product pd3 = new Product ( UUID.randomUUID ().toString (),"Hua wei P10",3500.00f,"不错的国产手机");
        Product pd4 = new Product ( UUID.randomUUID ().toString (),"Hua wei P10",3500.00f,"不错的国产手机");
    }

}
