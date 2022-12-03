package com.tobias.clientservice.inner.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseClient {
    private int id;
    private String name;
    private String nickname;
    private String email;
    private Client.Gender gender;
    private Date birth;
    private String phone;
}
