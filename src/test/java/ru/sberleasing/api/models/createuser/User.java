package ru.sberleasing.api.models.createuser;

import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
public class User {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;
}
