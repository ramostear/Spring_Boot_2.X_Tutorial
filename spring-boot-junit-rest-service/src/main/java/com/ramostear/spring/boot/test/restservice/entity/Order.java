package com.ramostear.spring.boot.test.restservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author: ramostear
 * @email: ramostear@163.com
 * @create-time: 2019/4/24 0024-20:08
 * @desc: [一句话说明该文件的功能]
 * @since: V 0.0.1
 * @company： www.taolicloud.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String number;

    private Date time;

    private List<Product> products;

}
