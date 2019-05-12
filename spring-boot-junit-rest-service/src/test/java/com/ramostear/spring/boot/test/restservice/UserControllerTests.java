package com.ramostear.spring.boot.test.restservice;

import com.ramostear.spring.boot.test.restservice.controller.UserController;
import com.ramostear.spring.boot.test.restservice.model.Role;
import com.ramostear.spring.boot.test.restservice.model.User;
import com.ramostear.spring.boot.test.restservice.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class,secure = false)
public class UserControllerTests {
    private static Logger logger = LoggerFactory.getLogger(UserControllerTests.class);
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void findAllUsers() throws Exception{
        User user = new User();
        user.setId("1001");
        user.setName("ramostear");
        user.setAlias("谭朝红");

        Role role = new Role();
        role.setId("1001");
        role.setName("admin");
        role.setDescription("all permissions for this role.");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        List<User> users = new ArrayList<>();
        users.add(user);

        Mockito.when(userService.findAllUsers()).thenReturn(users);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[{\"id\":\"1001\",\"name\":\"ramostear\",\"alias\":\"谭朝红\",\"roles\":[{\"id\":\"1001\",\"name\":\"admin\",\"description\":\"all permissions for this role.\"}]}]";
        logger.info(result.getResponse().getContentAsString());
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    }

    @Test
    public void findAllUserRoles() throws Exception{
        Role role = new Role();
        role.setId("1001");
        role.setName("admin");
        role.setDescription("all permissions for this role.");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        Mockito.when(userService.findUserAllRoles("1001")).thenReturn(roles);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/1001/roles");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[{\"id\":\"1001\",\"name\":\"admin\",\"description\":\"all permissions for this role.\"}]";
       logger.info(result.getResponse().getContentAsString());
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    }

    @Test
    public void addUserRole() throws Exception{
        String JSON = "{\"id\":\"1002\",\"name\":\"editor\",\"description\":\"content editor\"}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/1001")
                .accept(MediaType.APPLICATION_JSON).content(JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals(HttpStatus.CREATED.value(),response.getStatus());
        String expected = "{\"id\":\"1002\",\"name\":\"editor\",\"description\":\"content editor\"}";
        logger.info(result.getResponse().getContentAsString());
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    }
}
