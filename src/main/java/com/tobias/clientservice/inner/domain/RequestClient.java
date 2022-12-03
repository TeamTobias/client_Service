package com.tobias.clientservice.inner.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class RequestClient {
    private int id;
    private String name;
    private String nickname;
    private String email;
    private Client.Gender gender;
    private Date birth;
    private String phone;
}
