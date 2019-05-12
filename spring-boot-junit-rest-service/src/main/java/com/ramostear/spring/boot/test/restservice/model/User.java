package com.ramostear.spring.boot.test.restservice.model;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private String id;

    private String name;

    private String alias;

    private List<Role> roles;
}
