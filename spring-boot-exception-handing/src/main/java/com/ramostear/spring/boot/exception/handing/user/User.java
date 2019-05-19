package com.ramostear.spring.boot.exception.handing.user;/**
 * @author and @date : Created by Tan Chaohong on 2019/5/19 0019.
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author ramostear
 * @create-time 2019/5/19 0019-14:02
 * @modify by :
 * @since:
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USER_NAME")
    @NotBlank
    @NotNull
    private String username;

    @Column(name = "AGE")
    @NotNull
    @Max(value = 120,message = "用户年龄不能超过120岁")
    @Min(value = 0,message = "用户年龄最小不能低于0岁")
    private Integer age;

    @Column(name = "HEIGHT")
    @NotNull
    @Max(value = 250,message = "用户身高不能超过250厘米")
    @Min(value = 10,message = "用户身高最矮不能低于10厘米")
    private Integer height;
}
