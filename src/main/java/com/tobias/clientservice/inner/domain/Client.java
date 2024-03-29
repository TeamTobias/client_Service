package com.tobias.clientservice.inner.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class Client {
    public enum Gender{
        MALE, FEMALE
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nickname;
    private String email;
    private Gender gender;
    private Date birth;
    private String phone;

    public static Client createClient(RequestClient requestClient){
        Client client = new Client();
        client.setName(requestClient.getName());
        client.setNickname(requestClient.getNickname());
        client.setEmail(requestClient.getEmail());
        client.setGender(requestClient.getGender());
        client.setBirth(requestClient.getBirth());
        client.setPhone(requestClient.getPhone());
        return client;
    }
}
