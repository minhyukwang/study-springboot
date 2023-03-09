package com.test.project.demo.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class User {
    private BigDecimal user_id;
    private String username;
    private String password;
    private String session;
    private String session_expire_date;
}
