package com.xing.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//实体类
public class User {
    private int id;
    private String username;
    private String pwd;


}
